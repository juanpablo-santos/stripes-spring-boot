package net.sourceforge.stripes.springboot.autoconfigure;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.test.context.junit4.SpringRunner;

import net.sourceforge.stripes.controller.StripesFilter;


/**
 * {@link StripesAutoConfiguration} associated unit tests.
 */
@RunWith( SpringRunner.class )
@SpringBootTest( classes=StripesAutoConfiguration.class )
public class StripesAutoConfigurationTest {

	@Autowired 
	@Qualifier( "stripesFilter" ) 
	FilterRegistrationBean< StripesFilter > stripesFilter;
	
	/** Ensures {@link StripesAutoConfiguration} loads everything ok. */
	@Test
	public void shoudlCheckAutoConfiguration() {
		Assert.assertNotNull( stripesFilter );
		Assert.assertEquals( "net.sourceforge.stripes.examples.springboot.actionbeans", stripesFilter.getInitParameters().get( "ActionResolver.Packages" ) );
	}

}
