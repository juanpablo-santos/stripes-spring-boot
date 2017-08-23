# Spring Boot extension for Stripes framework

## Usage

* Git clone + `mvn clean install`

* Include `net.sourceforge.stripes:stripes-spring-boot-starter` dependency on your Spring Boot project and you're ready to go! This dependency will take care of setting up the Stripes filters.

## Configuration

This extension also enables support for `stripes.*` namespace on the `application.properties` file, through the [`net.sourceforge.stripes.springboot.autoconfigure.StripesProperties`](stripes-spring-boot-autoconfigure/src/main/java/net/sourceforge/stripes/springboot/autoconfigure/StripesProperties.java) class. Namely, there is a `stripes.*` property for each of the Stripes [configuration parameters](https://stripesframework.atlassian.net/wiki/spaces/STRIPES/pages/492126/Configuration+Reference), plus support for custom parameters and a flag to bypass this module's configuration.

Although it is possible to start your Stripes application without having to set any custom properties, most probably you would like to look at:
* `stripes.action-resolver-packages`: if not set, Spring Boot will look for actionbean packages by scanning the whole classpath. This operation "just works", but it slows down the application's startup time.
* `stripes.extension-packages`: defaults to `net.sourceforge.stripes.integration.spring` (as we are already using Spring / Spring Boot, it seems a reasonable default), change if needed.
* `stripes.encryption-key`: if you would like to use an encryption key which survives application reloads.
* `stripes.custom-conf.WHATEVER`: any other filter configuration value that you might need for your Stripes extension are supported through the `stripes.custom-conf` sub-namespace, i.e., `stripes.custom-conf.WHATEVER=MY_CUSTOM_VALUE` will be set as an configuration parameter of Stripes filter with key `WHATEVER` and value `MY_CUSTOM_VALUE`.
* `stripes.enabled`: set to false to bypass this module's configuration.

## Running the sample

* Git clone + `mvn clean install`
* `cd stripes-spring-boot-sample`
* `mvn spring-boot:run` or `java -jar target/stripes-spring-boot-sample-1.0.0.jar`
* Browse http://localhost:8080/index.jsp

## Other caveats

* This starter module manually deactivates Spring MVC, by defining String-type beans with ids `DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME`, `DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME` and `conventionErrorViewResolver`.
* If running several application instances, set the `stripes.encryption-key` property at build time to enforce the use of the same encryption key. Look at the sample (`stripes-spring-boot-sample/pom.xml`, `stripes-spring-boot-sample/src/main/resources/application.properties`) to see how to do this.
