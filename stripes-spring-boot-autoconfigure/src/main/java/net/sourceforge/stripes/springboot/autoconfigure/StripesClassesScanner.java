package net.sourceforge.stripes.springboot.autoconfigure;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.util.ClassUtils;
import org.springframework.util.StringUtils;

import net.sourceforge.stripes.util.Log;


/**
 *
 * @author Juan Pablo Santos Rodríguez
 */
class StripesClassesScanner < T > extends ClassPathScanningCandidateComponentProvider {

    private static final Log LOG = Log.getInstance( StripesClassesScanner.class );

    /** Default constructor */
    StripesClassesScanner() {
        super( false );
    }

    Collection< Class< ? extends T > > findComponentClasses( String basePackage ) {
        basePackage = basePackage == null ? "" : basePackage;
        final List< Class< ? extends T > > classes = new ArrayList< Class< ? extends T > >();
        for( final BeanDefinition candidate : findCandidateComponents( basePackage ) ) {
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

    String toPackagesWithoutStripesClasses( final Collection< Class< ? extends T > > classes ) {
        final Set< String > packages = new HashSet< String >();
        for( final Class< ? extends T > clase : classes ) {
            if( !fromStripesLibrary( clase ) ) {
                packages.add( clase.getPackage().getName() );
            }
        }

        return StringUtils.collectionToCommaDelimitedString( packages );
    }

    String toPackages( final Collection< Class< ? extends T > > classes ) {
        final Set< String > packages = new HashSet< String >();
        for( final Class< ? extends T > clase : classes ) {
            packages.add( clase.getPackage().getName() );
        }

        return StringUtils.collectionToCommaDelimitedString( packages );
    }

    boolean fromStripesLibrary( final Class< ? extends T > clase ) {
        return clase.getPackage().getName().startsWith( "net.sourceforge.stripes" ) &&
               !clase.getPackage().getName().startsWith( "net.sourceforge.stripes.examples" );
    }

}
