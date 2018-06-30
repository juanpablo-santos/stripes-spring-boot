package net.sourceforge.stripes.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import net.sourceforge.stripes.util.Log;


/**
 * <p>Code taken from MyBatis, with a few slight modifications:<ul>
 *   <li>constructor is made public.</li>
 *   <li>added some log traces on catch blocks to avoid warnings on Sonar and similar tools.</li>
 *   <li>java 8 iterating on {@link #getResources( String, ClassLoader )}</li>
 * </ul>
 * </p>
 * A class to wrap access to multiple class loaders making them work as one
 *
 * @author Clinton Begin
 * @see https://github.com/mybatis/mybatis-3/blob/master/src/main/java/org/apache/ibatis/io/ClassLoaderWrapper.java
 */
public class ClassLoaderWrapper {

    private static final Log LOG = Log.getInstance( ClassLoaderUtils.class );

    ClassLoader defaultClassLoader;
    ClassLoader systemClassLoader;

    public ClassLoaderWrapper() {
        try {
            systemClassLoader = ClassLoader.getSystemClassLoader();
        } catch( final SecurityException ignored ) {
            // AccessControlException on Google App Engine
            LOG.trace( ignored.getMessage(), ignored );
        }
    }

    /**
     * Get a resource as a URL using the current class path
     *
     * @param resource - the resource to locate
     * @return the resource or null
     */
    public URL getResourceAsURL( final String resource ) {
        return getResourceAsURL( resource, getClassLoaders( null ) );
    }

    /**
     * Get a resource as a URL using the current class path
     *
     * @param resource - the resource to locate
     * @return the resource or null
     */
    public Set< URI > getResourcesAsURI( final String resource ) {
        return getResourcesAsURI( resource, getClassLoaders( null ) );
    }

    /**
     * Get a resource from the classpath, starting with a specific class loader
     *
     * @param resource - the resource to find
     * @param classLoader - the first classloader to try
     * @return the stream or null
     */
    public URL getResourceAsURL( final String resource, final ClassLoader classLoader ) {
        return getResourceAsURL( resource, getClassLoaders( classLoader ) );
    }

    /**
     * Get a resource from the classpath, starting with a specific class loader
     *
     * @param resource - the resource to find
     * @param classLoader - the first classloader to try
     * @return the stream or null
     */
    public Set< URI > getResourcesAsURI( final String resource, final ClassLoader classLoader ) {
        return getResourcesAsURI( resource, getClassLoaders( classLoader ) );
    }

    /**
     * Get a resource from the classpath
     *
     * @param resource - the resource to find
     * @return the stream or null
     */
    public InputStream getResourceAsStream( final String resource ) {
        return getResourceAsStream( resource, getClassLoaders( null ) );
    }

    /**
     * Get a resource from the classpath, starting with a specific class loader
     *
     * @param resource - the resource to find
     * @param classLoader - the first class loader to try
     * @return the stream or null
     */
    public InputStream getResourceAsStream( final String resource, final ClassLoader classLoader ) {
        return getResourceAsStream( resource, getClassLoaders( classLoader ) );
    }

    /**
     * Find a class on the classpath (or die trying)
     *
     * @param name - the class to look for
     * @return - the class
     * @throws ClassNotFoundException Duh.
     */
    public Class< ? > classForName( final String name ) throws ClassNotFoundException {
        return classForName( name, true, getClassLoaders( null ) );
    }

    /**
     * Find a class on the classpath, starting with a specific classloader (or die trying)
     *
     * @param name - the class to look for
     * @param classLoader - the first classloader to try
     * @return - the class
     * @throws ClassNotFoundException Duh.
     */
    public Class< ? > classForName( final String name, final ClassLoader classLoader ) throws ClassNotFoundException {
        return classForName( name, true, getClassLoaders( classLoader ) );
    }

    /**
     * Find a class on the classpath, starting with a specific classloader (or die trying)
     *
     * @param name - the class to look for
     * @param cl - first {@link ClassLoader} to look into
     * @return - the class
     * @throws ClassNotFoundException Duh.
     */
    public Class< ? > locateClassWithName( final String name, final ClassLoader cl ) throws ClassNotFoundException {
        return classForName( name, false, getClassLoaders( cl ) );
    }

    /**
     * Try to get a resource from a group of classloaders
     *
     * @param resource - the resource to get
     * @param classLoader - the classloaders to examine
     * @return the resource or null
     */
    InputStream getResourceAsStream( final String resource, final ClassLoader[] classLoader ) {
        for( final ClassLoader cl : classLoader ) {
            if( null != cl ) {

                // try to find the resource as passed
                InputStream returnValue = cl.getResourceAsStream( resource );

                // now, some class loaders want this leading "/", so we'll add it and try again if
                // we didn't find the resource
                if( null == returnValue ) {
                    returnValue = cl.getResourceAsStream( "/" + resource );
                }

                if( null != returnValue ) {
                    return returnValue;
                }
            }
        }
        return null;
    }

    /**
     * Get a resource as a URL using the current class path
     *
     * @param resource - the resource to locate
     * @param classLoader - the class loaders to examine
     * @return the resource or null
     */
    URL getResourceAsURL( final String resource, final ClassLoader[] classLoader ) {
        URL url;
        for( final ClassLoader cl : classLoader ) {
            if( null != cl ) {
                // look for the resource as passed in...
                url = cl.getResource( resource );

                // ...but some class loaders want this leading "/", so we'll add it
                // and try again if we didn't find the resource
                if( null == url ) {
                    url = cl.getResource( "/" + resource );
                }

                // "It's always in the last place I look for it!"
                // ... because only an idiot would keep looking for it after finding it, so stop
                // looking already.
                if( null != url ) {
                    return url;
                }
            }
        }

        // didn't find it anywhere.
        return null;
    }

    Set< URI > getResourcesAsURI( final String resource, final ClassLoader[] classLoader ) {
        final Set< URI > resources = new HashSet<>();
        for( final ClassLoader cl : classLoader ) {
            if( cl != null ) {
                // look for the resource as passed in...
                Set< URI > uris = getResources( resource, cl );

                // ...but some class loaders want this leading "/", so we'll add it
                // and try again if we didn't find the resource
                if( uris == null ) {
                    uris = getResources( "/" + resource, cl );
                }

                // "It's always in the last place I look for it!"
                // ... because only an idiot would keep looking for it after finding it, so stop looking already.
                if( uris != null ) {
                    resources.addAll( uris );
                }
            }
        }
        return resources;
    }

    private Set< URI > getResources( final String resource, final ClassLoader cl ) {
        try {
            return new HashSet< >(
                Collections.list( cl.getResources( resource ) )
                           .stream()
                           .map( url -> {
                                     try {
                                         return url != null ? url.toURI() : null;
                                     } catch( final URISyntaxException e ) {
                                         LOG.error( e.getMessage(), e );
                                         return null;
                                     }
                                 } )
                           .collect( Collectors.toList() ) );
        } catch( final IOException e ) {
            LOG.error( e.getMessage(), e );
        }
        return null;
    }

    /**
     * Attempt to load a class from a group of classloaders
     *
     * @param name - the class to load
     * @param init - initialize class when loading or not, see {@code @see} note below.
     * @param classLoader - the group of classloaders to examine
     * @return the class
     * @throws ClassNotFoundException - Remember the wisdom of Judge Smails: Well, the world needs ditch diggers, too.
     * @see http://stackoverflow.com/a/3466596
     */
    Class< ? > classForName( final String name, final boolean init, final ClassLoader[] classLoader ) throws ClassNotFoundException {
        for( final ClassLoader cl : classLoader ) {
            if( null != cl ) {
                try {
                    final Class< ? > c = Class.forName( name, init, cl );
                    if( null != c ) {
                        return c;
                    }
                } catch( final ClassNotFoundException e ) {
                    // we'll ignore this until all classloaders fail to locate the class
                    LOG.trace( name + " not found on " + cl, e );
                }
            }
        }

        throw new ClassNotFoundException( "Cannot find class: " + name );
    }

    ClassLoader[] getClassLoaders( final ClassLoader classLoader ) {
        return new ClassLoader[] { classLoader,
                                   defaultClassLoader,
                                   Thread.currentThread().getContextClassLoader(),
                                   getClass().getClassLoader(),
                                   systemClassLoader };
    }

}
