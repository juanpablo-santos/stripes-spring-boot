package net.sourceforge.stripes.springboot.autoconfigure;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.JarInputStream;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.util.ResourceUtils;

import net.sourceforge.stripes.vfs.DefaultVFS;


/**
 * VFS responsible of locating Stripes' classes inside a Spring Boot application. It's basically taken+adapted from the one at the
 * MyBatis project.
 *
 * @author Juan Pablo Santos Rodríguez
 */
public class SpringBootVFS extends DefaultVFS {

    private final ResourcePatternResolver resourceResolver;

    public SpringBootVFS() {
        this.resourceResolver = new PathMatchingResourcePatternResolver( getClass().getClassLoader() );
    }

    /**
     * {@inheritDoc}
     *
     * @see net.sourceforge.stripes.vfs.DefaultVFS#findJarForResource(java.net.URL)
     */
    @Override
    protected URL findJarForResource( final URL url ) throws MalformedURLException {
        if( url == null ) {
            return null;
        }
        final URL jar = ResourceUtils.extractJarFileURL( url );
        return ( isJar( jar ) ) ? jar : null;
    }

    /**
     * {@inheritDoc}
     *
     * @see net.sourceforge.stripes.vfs.DefaultVFS#isJar(java.net.URL)
     */
    @Override
    protected boolean isJar( final URL url ) {
        return url.getPath().toLowerCase().endsWith( ResourceUtils.JAR_FILE_EXTENSION ) || url.getPath().toLowerCase().endsWith( ".war" );
    }

    /**
     * {@inheritDoc}
     *
     * List the names of the entries in the given {@link JarInputStream} that begin with the specified {@code path}.
     * Entries will match with or without a leading slash.
     *
     * @param jar The JAR input stream
     * @param path The leading path to match
     * @return The names of all the matching entries
     * @throws IOException If I/O errors occur
     */
    @Override
    protected List< String > listResources( final JarInputStream jar, final String path ) throws IOException {
        final Resource[] resources = resourceResolver.getResources( ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + path + "/**/*.class" );
        final List< String > resourcePaths = new ArrayList< String >();
        for( final Resource resource : resources ) {
            resourcePaths.add( preserveSubpackageName( resource.getURI(), path ) );
        }
        return resourcePaths;
    }

    private String preserveSubpackageName( final URI uri, final String rootPath ) {
        final String uriStr = uri.toString();
        final int start = uriStr.indexOf( rootPath );
        return uriStr.substring( start );
    }

}
