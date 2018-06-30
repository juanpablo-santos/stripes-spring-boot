package net.sourceforge.stripes.springboot.autoconfigure;

import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.ServletContext;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.web.context.ServletContextAware;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.config.Configuration;
import net.sourceforge.stripes.controller.AnnotatedClassActionResolver;
import net.sourceforge.stripes.controller.StripesFilter;
import net.sourceforge.stripes.controller.UrlBinding;
import net.sourceforge.stripes.util.Log;
import net.sourceforge.stripes.util.ClassLoaderUtils;


/**
 * Actuator endpoint to expose Stripes' URL Bindings and configuration.
 *
 * @author Juan Pablo Santos Rodríguez
 */
@Endpoint( id="stripes" )
public class StripesEndpoint implements ServletContextAware {

    private static final Log LOG = Log.getInstance( StripesEndpoint.class );

    private final Map< String, Object > stripesUrlBindings = new TreeMap<>();
    private final FilterRegistrationBean< StripesFilter > stripesFilter;
    private boolean scannedConfiguration = false;
    private ServletContext servletContext = null;

    public StripesEndpoint( final FilterRegistrationBean< StripesFilter > stripesFilter ) {
        this.stripesFilter = stripesFilter;
    }

    /**
     * {@inheritDoc}
     *
     * @see org.springframework.web.context.ServletContextAware#setServletContext(javax.servlet.ServletContext)
     */
    @Override
    public void setServletContext( final ServletContext servletContext ) {
        this.servletContext = servletContext;
    }

    @ReadOperation
    public Map< String, Map< String, ? > > invoke() {
        final Map< String, Map< String, ? > > stripes = new TreeMap<>();
        if( !scannedConfiguration && servletContext != null && stripesPresentOnClassPath() ) {
            final StripesFilter sf = ( StripesFilter )servletContext.getAttribute( StripesFilter.class.getName() );
            if ( sf != null ) {
                configure( sf.getInstanceConfiguration() );
                scannedConfiguration = true;
                LOG.info( "Stripes Filter configuration readed" );
            } else {
                LOG.warn( "Stripes Filter not yet initialized" );
            }
        }
        stripes.put( "configuration", stripesFilter != null ? stripesFilter.getInitParameters() : new TreeMap<>() );
        stripes.put( "urls", stripesUrlBindings );
        return stripes;
    }

    boolean stripesPresentOnClassPath() {
        return new ClassLoaderUtils().isPresent( "net.sourceforge.stripes.controller.StripesFilter" );
    }

    /**
     * Retrieves Stripes' urls bindings from Stripes' filter configuration.
     *
     * @param stripesFilterConfiguation Stripes' filter configuration.
     */
    public void configure( final Configuration stripesFilterConfiguation ) {
        if( stripesFilterConfiguation != null && stripesFilterConfiguation.getActionResolver() instanceof AnnotatedClassActionResolver ) {
            final AnnotatedClassActionResolver acar = ( AnnotatedClassActionResolver )stripesFilterConfiguation.getActionResolver();
            final Map< String, Class< ? extends ActionBean > > stripesOriginalUrlBindings = acar.getUrlBindingFactory().getPathMap();
            for( final Map.Entry< String, Class< ? extends ActionBean > > entry : stripesOriginalUrlBindings.entrySet() ) {
                final UrlBinding urlBinding = acar.getUrlBindingFactory().getBinding( entry.getKey() );
                if( !Modifier.isAbstract( entry.getValue().getModifiers() ) ) {
                    final Map< String, String > map = new LinkedHashMap<>(); // mimic Spring MVC endpoint
                    final String path = entry.getKey().endsWith( "/" ) ? substringBeforeLast( entry.getKey(), "/" ) : entry.getKey();
                    map.put( "actionbean", urlBinding.getBeanType().getCanonicalName() != null ? urlBinding.getBeanType().getCanonicalName() :
                                                                                                 urlBinding.getBeanType().getName() );
                    if( urlBinding.getParameters() != null && !urlBinding.getParameters().isEmpty() ) {
                        map.put( "parameters", urlBinding.getParameters().toString() );
                    }
                    if( urlBinding.getSuffix() != null ) {
                        map.put( "suffix", urlBinding.getSuffix() );
                    }

                    stripesUrlBindings.put( "[" + path + "]", map );
                } else {
                    LOG.info( entry.getValue() + " is abstract, ignored" );
                }
            }
        }
    }

    /**
     * Retrieves the substring from the last occurrence of another string. Should be part of StringUtil or use something from commons-lang3.
     *
     * @param str string from which we want the substring.
     * @param separator last occurrence to check to.
     * @return substring from the last occurrence of another string or original string if there are no occurrences or there is a null or empty string anywhere.
     */
    String substringBeforeLast( final String str, final String separator ) {
        if( str == null || separator == null || str.length() == 0 || separator.length() == 0 ) {
            return str;
        }
        final int pos = str.lastIndexOf( separator );
        if( pos == -1 ) {
            return str;
        }
        return str.substring(0, pos);
    }

}
