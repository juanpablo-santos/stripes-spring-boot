package net.sourceforge.stripes.examples.springboot.exec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import net.sourceforge.stripes.springboot.autoconfigure.StripesAutoConfiguration;


/**
 * Stripes' Spring Boot Sample Runner.
 *
 * @author Juan Pablo Santos Rodríguez
 */
@Import( { StripesAutoConfiguration.class } )
@SpringBootApplication
public class StripesSampleBootApplication {

    /**
     * Stripes' Spring Boot Sample Runner entry point.
     *
     * @param args command-line arguments.
     */
    public static void main( final String[] args ) {
        final SpringApplication app = new SpringApplication( StripesSampleBootApplication.class );
        app.run();
    }

}
