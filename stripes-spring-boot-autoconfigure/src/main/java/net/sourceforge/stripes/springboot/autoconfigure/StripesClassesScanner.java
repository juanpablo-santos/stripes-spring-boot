package net.sourceforge.stripes.springboot.autoconfigure;

import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import net.sourceforge.stripes.util.Log;


/**
 * Stripes related classes locator.
 * 
 * @author Juan Pablo Santos Rodríguez
 */
class StripesClassesScanner < T > extends ClassPathScanningCandidateComponentProvider {

    private static final Log LOG = Log.getInstance( StripesClassesScanner.class );

    /** Default constructor */
    StripesClassesScanner() {
        super( false );
    }

    public Collection< Class< ? extends T > > findComponentClasses( final String basePackage ) {
        final List< Class< ? extends T > > classes = new ArrayList< Class< ? extends T > >();
        for( final BeanDefinition candidate : findCandidateComponents( ( basePackage == null ) ? "" : basePackage ) ) {
            try {
                @SuppressWarnings( "unchecked" )
                final Class< ? extends T > cls = ( Class< ? extends T > )ClassUtils.resolveClassName( candidate.getBeanClassName(),
                                                                                                      ClassUtils.getDefaultClassLoader() );
                classes.add( cls );
            } catch( final Throwable ex ) {
                LOG.error( ex.getMessage() );
            }
        }
        return classes;
    }

    /**
     * {@inheritDoc}
     * 
     * <p>Overwrites parent method in order to locate Stripes related classes. Spring related classes are not parsed in order to avoid weird errors
     * (cfr. with https://github.com/spring-projects/spring-boot/issues/3850#issuecomment-136296412). Also if a class cannot be introspected for whatever
     * reason, instead of rethrowing an exception, it's simply logged. Also candidate component index is not queried, Stripes classes are not indexed anyway.
     */
    public Set<BeanDefinition> findCandidateComponents( final String basePackage ) {
        Set<BeanDefinition> candidates = new LinkedHashSet<>();
        try {
            String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + resolveBasePackage(basePackage) + "/**/*.class";
            Resource[] resources = ( (ResourcePatternResolver)getResourceLoader()).getResources(packageSearchPath);
            Arrays.asList( resources )
                  .stream()
                  .filter( r -> !r.getDescription().contains( "org/springframework" ) && r.isReadable() ) // don't scan spring classes -> https://github.com/spring-projects/spring-boot/issues/3850#issuecomment-136296412
                  .forEach( r -> {
                      try {
                          MetadataReader metadataReader = getMetadataReaderFactory().getMetadataReader( r );
                          if( isCandidateComponent( metadataReader ) ) {
                              ScannedGenericBeanDefinition sbd = new ScannedGenericBeanDefinition( metadataReader );
                              sbd.setResource( r );
                              sbd.setSource( r );
                              if( isCandidateComponent( sbd ) ) {
                                  LOG.debug( "Identified candidate component class: " + r );
                                  candidates.add( sbd );
                              } else {
                                  LOG.debug( "Ignored because not a concrete top-level class: " + r );
                              }
                          } else {
                              LOG.trace( "Ignored because not matching any filter: " + r );
                          }
                      } catch( Throwable ex ) {
                          LOG.info( "Failed to read candidate component class: [" + r + "]. As we are looking for Stripes related classes, this is " +
                                    "usually dismissable. If you want to know what happened reading " + r + ", please set to TRACE the " +
                                    "net.sourceforge.stripes.springboot.autoconfigure logger" );
                          LOG.trace( "Ignored because not matching any filter: " + r, ex );
                      }
                  } );
        } catch( IOException ex ) {
            throw new BeanDefinitionStoreException( "I/O failure during classpath scanning", ex );
        }
        return candidates;
    }

    String toPackagesWithoutStripesClasses( final Collection< Class< ? extends T > > classes ) {
        final Set< String > packages = new HashSet< String >();
        for( final Class< ? extends T > clase : classes ) {
            if( !fromStripesLibrary( clase ) ) {
                packages.add( clase.getPackage().getName() );
            }
        }

        return StringUtils.collectionToCommaDelimitedString( packages );
    }

    public String selectFirstConcreteConfigurationClass( final Collection< Class< ? extends T > > classes ) {
        for( final Class< ? extends T > clase : classes ) {
            if( !fromStripesLibrary( clase ) && !Modifier.isAbstract( clase.getModifiers() ) && !clase.isInterface() ) {
                return clase.getName();
            }
        }
        return null;
    }

    String toPackages( final Collection< Class< ? extends T > > classes ) {
        final Set< String > packages = new HashSet< String >();
        for( final Class< ? extends T > clase : classes ) {
            packages.add( clase.getPackage().getName() );
        }

        return StringUtils.collectionToCommaDelimitedString( packages );
    }

    boolean fromStripesLibrary( final Class< ? extends T > clazz ) {
        return clazz.getPackage().getName().startsWith( "net.sourceforge.stripes" ) &&
               !clazz.getPackage().getName().startsWith( "net.sourceforge.stripes.examples" );
    }

}
