package net.sourceforge.stripes.util;

import net.sourceforge.stripes.util.Log;


/**
 * Utility queries over {@link ClassLoader}s.
 *
 * @author Juan Pablo Santos Rodríguez
 */
public class ClassLoaderUtils {

    private static final Log LOG = Log.getInstance( ClassLoaderUtils.class );

    /**
     * Verifies if a given class exists on classpath.
     *
     * @param className class to verify.
     * @return {@code true} if exists, {@code false} otherwise.
     */
    public boolean isPresent( final String className ) {
        try {
            new ClassLoaderWrapper().locateClassWithName( className, this.getClass().getClassLoader() );
        } catch( final ClassNotFoundException e ) {
            LOG.warn( className + " not found on classpaths" );
            return false;
        }
        return true;
    }

}
