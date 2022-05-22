package net.sourceforge.stripes.springboot.autoconfigure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import net.sourceforge.stripes.controller.StripesFilter;


/**
 * {@link StripesAutoConfiguration} associated unit tests.
 */
@ExtendWith( SpringExtension.class )
@SpringBootTest( classes=StripesAutoConfiguration.class )
public class StripesAutoConfigurationTest {

	@Autowired 
	@Qualifier( "stripesFilter" ) 
	FilterRegistrationBean< StripesFilter > stripesFilter;
	
	/** Ensures {@link StripesAutoConfiguration} loads everything ok. */
	@Test
	public void shoudlCheckAutoConfiguration() {
		Assertions.assertNotNull( stripesFilter );
		Assertions.assertEquals( "net.sourceforge.stripes.examples.springboot.actionbeans", stripesFilter.getInitParameters().get( "ActionResolver.Packages" ) );
	}

}
