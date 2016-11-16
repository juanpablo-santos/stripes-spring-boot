# Spring Boot extension for Stripes framework

## Usage

* Git clone + `mvn clean install`

* Include `net.sourceforge.stripes:stripes-spring-boot-starter` dependency on your Spring Boot project and you're ready to go! This dependency will take care of setting up the Stripes filters.

## Configuration

This extension also enables support for `stripes.*` namespace on the `application.properties` file, through the `StripesProperties` class. Although it is possible to start your Stripes application without having to set any custom properties, most probably you would like to look at:
* `stripes.action-resolver-packages`: if not set, Spring Boot will look for actionbean packages on the whole classpath.
* `stripes.exception-handler`: if not set, Spring Boot will look for the first implementation of `ExceptionHandler` (besides `net.sourceforge.stripes.exception.DefaultExceptionHandler`) on the whole classpath and will use that. If there aren't found any ExceptionHandlers, `net.sourceforge.stripes.exception.DefaultExceptionHandler` will be used.
* `stripes.interceptors`: if you would like to define any.
* `stripes.custom-conf.WHATEVER`: any other filter configuration value that you might need for your Stripes extension are supported through the `stripes.custom-conf` sub-namespace.
* `stripes.enabled`: set to false to bypass this module's configuration.

## Running the sample

* Git clone + `mvn clean install`
* `cd stripes-spring-boot-sample`
* `mvn spring-boot:run` or `java -jar target/stripes-spring-boot-sample-1.0.0.jar`
* browse http://localhost:8080/index.jsp

## Other caveats

* this starter module manually deactivates Spring MVC, by defining String-type beans with ids `DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME`, `DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_BEAN_NAME` and `conventionErrorViewResolver`.
* if it is not set, the `Extension.Packages` (`stripes.extension.packages`) is set to `net.sourceforge.stripes.integration.spring`. We're already using Spring Boot so it kinda makes sense to have Spring support activated on the Stripes application.
* to enforce same encryption key if running several application instances set the `stripes.encryption-key` property at build time. Look at the sample (pom.xml, application.properties) to see how to do this.
