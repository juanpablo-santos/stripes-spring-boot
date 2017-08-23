package net.sourceforge.stripes.springboot.autoconfigure;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;


/**
 * Stripes Configuration Properties
 *
 * @author Juan Pablo Santos Rodríguez
 */
@ConfigurationProperties(prefix = StripesProperties.STRIPES_PREFIX )
public class StripesProperties {

    public static final String STRIPES_PREFIX = "stripes";

    /** The FQN of a class that implements ActionBeanPropertyBinder. */
    private String actionBeanPropertyBinder;

    /** The FQN of a class that implements ActionBeanContextFactory */
    private String actionBeanContextFactory;

    /** The FQN of a class which extends ActionBeanContext */
    private String actionBeanContext;

    /** The FQN of a class that implements ActionResolver */
    private String actionResolver;

    /** A comma-separated list of package roots where your ActionBean classes are. Stripes auto-discovers your ActionBeans at runtime by scanning those
        packages and their subpackages. This saves you from having to enumerate all your ActionBeans somewhere and maintaining that when you add, change,
        or remove ActionBeans. */
    private String actionResolverPackages;

    /** The fully qualified name of a class that implements Configuration */
    private String configuration;

    /** Interceptors that are loaded by Stripes, regardless to Interceptor.Class param. Those are loaded before Interceptors' one, if any */
    private String coreInterceptorClasses;

    /** Flag to enable, or not, Stripes configuration */
    private String enable;

    /** The FQN of a class that implements ExceptionHandler */
    private String exceptionHandler;

    /** A comma separated list of package roots where your ExceptionHandlers are. Stripes will also search the packages specified in Extension. Packages
       for ExceptionHandlers so this parameter usually is not necessary. */
    private String delegatingExceptionHandlerPackages;

    /** A list of packages that will be searched for Stripes extensions. Examples of extensions include interceptors, formatters, type converters, exception
       handlers, object post-processors (release 1.6. and later) and custom implementations of ActionResolver, ActionBeanContext, ActionBeanContextFactory,
       FormatterFactory, LocalePicker, LocalizationBundleFactory, MultipartWrapperFactory, PopulationStrategy, TagErrorRendererFactory, TypeConverterFactory
       and ObjectFactory (release 1.6 and later). Most applications can simply set the Extension.Packages, ActionResolver.Packages and Stripes.EncryptionKey
       parameters and be done. */
    private String extensionPackages;

    /** The FQN of a class that implements FormatterFactory */
    private String formatterFactory;

    /** The comma-separated list of fully qualified class names of Interceptor classes to use. The list may contain additional whitespace. Entries higher
        up the list will be invoked before entries lower down. */
    private String interceptors;

    /** The FQN of a class that implements LocalePicker */
    private String localePicker;

    /** A comma separated list of locales that the system supports. Each locale can be one to three segments long (e.g. en or en-us or en-us-mac). Either
       hypens or underscores can be used to separate the segments. In addition each locale can optinally include a character encoding to use with that
       locale. The character encoding is specified by appending :encoding to the locale, e.g. en_US:UTF-8 */
    private String locales;

    /** The FQN of a class that implements LocalizationBundleFactory */
    private String localizationBundleFactory;

    /** The name of a resource bundle. This may by any kind of resource bundle, but will typically be a property resource bundle, in which case the
        resource files should be available in the classpath. */
    private String errorMessageBundle;

    /** The name of a resource bundle. This may by any kind of resource bundle, but will typically be a property resource bundle, in which case the
        resource files should be available in the classpath. */
    private String fieldNameBundle;

    /** The FQN of a class that implements MultipartWrapperFactory */
    private String multipartWrapperFactory;

    /** The fully qualified name of the class, implementing MultipartWrapper. */
    private String multipartWrapper;

    /** The maximum HTTP Post size, in bytes, that will be accepted by the server. Note that this is not the maximum file size, but the combined size of
        all files in a single upload plus any other form fields and headers. In practical terms, this should be slightly larger (say 20-50k) than the maximum
        file size you want to handle, in order to allow for a reasonable amount of other data to come in the same request. The number is assumed to be in
        bytes unless a k/kb/m/mb/g/gb suffix is applied. */
    private String fileUploadMaximumPostSize;

    /** The FQN of a class that implements PopulationStrategy */
    private String populationStrategy;

    /** The FQN of a class that implements TagErrorRendererFactory */
    private String tagErrorRendererFactory;

    /** The FQN of a class that implements TypeConverterFactory */
    private String typeConverterFactory;

    /** A boolean flag that turns debug mode off or on. This should only be set to true during development. Currently, debug mode only turns off encryption,
        allowing a developer to read values that would otherwise be encrypted before being written to the client.
        WARNING: Do not turn on debug mode in a production server. When encryption is disabled, you risk exposing resources that are normally protected, such
        as those under /WEB-INF. */
    private String debugMode;

    /** A (preferably very long, very random) string that is used as the encryption key when Stripes encrypts values before sending them to the client. If
        no encryption key is specified, then a random one is generated each time the application is initialized. When a random key is used, encrypted values
        do not survive across application reloads. */
    private String encryptionKey;

    /** The type of HTML tags Stripes should generate. Options are html or xhtml */
    private String htmlMode;

    /** The comma-separated list of fully qualified class names of VFS implementations to use in addition to the built-in implementations shipped with
        Stripes. The list may contain additional whitespace. The implementations are tried in the order they are specified and before any built-ins. */
    private String vfsClasses;

    /** placeholder for custom configuration */
    private Map< String, String > customConf = new HashMap< String, String >();

    /**
     * getter.
     *
     * @return the field: actionResolver.
     */
    public String getActionResolver() {
        return actionResolver;
    }

    /**
     * setter.
     *
     * @param actionResolver the field: actionResolver.
     */
    public void setActionResolver( final String actionResolver ) {
        this.actionResolver = actionResolver;
    }

    /**
     * getter.
     *
     * @return the field: actionBeanPropertyBinder.
     */
    public String getActionBeanPropertyBinder() {
        return actionBeanPropertyBinder;
    }

    /**
     * setter.
     *
     * @param actionBeanPropertyBinder the field: actionBeanPropertyBinder.
     */
    public void setActionBeanPropertyBinder( final String actionBeanPropertyBinder ) {
        this.actionBeanPropertyBinder = actionBeanPropertyBinder;
    }

    /**
     * getter.
     *
     * @return the field: actionBeanContextFactory.
     */
    public String getActionBeanContextFactory() {
        return actionBeanContextFactory;
    }

    /**
     * setter.
     *
     * @param actionBeanContextFactory the field: actionBeanContextFactory.
     */
    public void setActionBeanContextFactory( final String actionBeanContextFactory ) {
        this.actionBeanContextFactory = actionBeanContextFactory;
    }

    /**
     * getter.
     *
     * @return the field: actionResolverPackages.
     */
    public String getActionResolverPackages() {
        return actionResolverPackages;
    }

    /**
     * setter.
     *
     * @param actionResolverPackages the field: actionResolverPackages.
     */
    public void setActionResolverPackages( final String actionResolverPackages ) {
        this.actionResolverPackages = actionResolverPackages;
    }

    /**
     * getter.
     *
     * @return the field: configuration.
     */
    public String getConfiguration() {
        return configuration;
    }

    /**
     * setter.
     *
     * @param configuration the field: configuration.
     */
    public void setConfiguration( final String configuration ) {
        this.configuration = configuration;
    }

    /**
     * getter.
     *
     * @return the field: coreInterceptorClasses.
     */
    public String getCoreInterceptorClasses() {
        return coreInterceptorClasses;
    }

    /**
     * setter.
     *
     * @param coreInterceptorClasses the field: coreInterceptorClasses.
     */
    public void setCoreInterceptorClasses( final String coreInterceptorClasses ) {
        this.coreInterceptorClasses = coreInterceptorClasses;
    }

    /**
     * getter.
     *
     * @return the field: exceptionHandler.
     */
    public String getExceptionHandler() {
        return exceptionHandler;
    }

    /**
     * setter.
     *
     * @param exceptionHandler the field: exceptionHandler.
     */
    public void setExceptionHandler( final String exceptionHandler ) {
        this.exceptionHandler = exceptionHandler;
    }

    /**
     * getter.
     *
     * @return the field: extensionPackages.
     */
    public String getExtensionPackages() {
        return extensionPackages;
    }

    /**
     * setter.
     *
     * @param extensionPackages the field: extensionPackages.
     */
    public void setExtensionPackages( final String extensionPackages ) {
        this.extensionPackages = extensionPackages;
    }

    /**
     * getter.
     *
     * @return the field: formatterFactory.
     */
    public String getFormatterFactory() {
        return formatterFactory;
    }

    /**
     * setter.
     *
     * @param formatterFactory the field: formatterFactory.
     */
    public void setFormatterFactory( final String formatterFactory ) {
        this.formatterFactory = formatterFactory;
    }

    /**
     * getter.
     *
     * @return the field: errorMessageBundle.
     */
    public String getErrorMessageBundle() {
        return errorMessageBundle;
    }

    /**
     * setter.
     *
     * @param errorMessageBundle the field: errorMessageBundle.
     */
    public void setErrorMessageBundle( final String errorMessageBundle ) {
        this.errorMessageBundle = errorMessageBundle;
    }

    /**
     * getter.
     *
     * @return the field: fieldNameBundle.
     */
    public String getFieldNameBundle() {
        return fieldNameBundle;
    }

    /**
     * setter.
     *
     * @param fieldNameBundle the field: fieldNameBundle.
     */
    public void setFieldNameBundle( final String fieldNameBundle ) {
        this.fieldNameBundle = fieldNameBundle;
    }

    /**
     * getter.
     *
     * @return the field: interceptors.
     */
    public String getInterceptors() {
        return interceptors;
    }

    /**
     * setter.
     *
     * @param interceptors the field: interceptors.
     */
    public void setInterceptors( final String interceptors ) {
        this.interceptors = interceptors;
    }

    /**
     * getter.
     *
     * @return the field: localePicker.
     */
    public String getLocalePicker() {
        return localePicker;
    }

    /**
     * setter.
     *
     * @param localePicker the field: localePicker.
     */
    public void setLocalePicker( final String localePicker ) {
        this.localePicker = localePicker;
    }


    /**
     * getter.
     *
     * @return the field: locales.
     */
    public String getLocales() {
        return locales;
    }


    /**
     * setter.
     *
     * @param locales the field: locales.
     */
    public void setLocales( final String locales ) {
        this.locales = locales;
    }

    /**
     * getter.
     *
     * @return the field: localizationBundleFactory.
     */
    public String getLocalizationBundleFactory() {
        return localizationBundleFactory;
    }

    /**
     * setter.
     *
     * @param localizationBundleFactory the field: localizationBundleFactory.
     */
    public void setLocalizationBundleFactory( final String localizationBundleFactory ) {
        this.localizationBundleFactory = localizationBundleFactory;
    }

    /**
     * getter.
     *
     * @return the field: multipartWrapperFactory.
     */
    public String getMultipartWrapperFactory() {
        return multipartWrapperFactory;
    }

    /**
     * setter.
     *
     * @param multipartWrapperFactory the field: multipartWrapperFactory.
     */
    public void setMultipartWrapperFactory( final String multipartWrapperFactory ) {
        this.multipartWrapperFactory = multipartWrapperFactory;
    }

    /**
     * getter.
     *
     * @return the field: populationStrategy.
     */
    public String getPopulationStrategy() {
        return populationStrategy;
    }

    /**
     * setter.
     *
     * @param populationStrategy the field: populationStrategy.
     */
    public void setPopulationStrategy( final String populationStrategy ) {
        this.populationStrategy = populationStrategy;
    }

    /**
     * getter.
     *
     * @return the field: tagErrorRendererFactory.
     */
    public String getTagErrorRendererFactory() {
        return tagErrorRendererFactory;
    }

    /**
     * setter.
     *
     * @param tagErrorRendererFactory the field: tagErrorRendererFactory.
     */
    public void setTagErrorRendererFactory( final String tagErrorRendererFactory ) {
        this.tagErrorRendererFactory = tagErrorRendererFactory;
    }

    /**
     * getter.
     *
     * @return the field: typeConverterFactory.
     */
    public String getTypeConverterFactory() {
        return typeConverterFactory;
    }

    /**
     * setter.
     *
     * @param typeConverterFactory the field: typeConverterFactory.
     */
    public void setTypeConverterFactory( final String typeConverterFactory ) {
        this.typeConverterFactory = typeConverterFactory;
    }

    /**
     * getter.
     *
     * @return the field: debugMode.
     */
    public String getDebugMode() {
        return debugMode;
    }

    /**
     * setter.
     *
     * @param debugMode the field: debugMode.
     */
    public void setDebugMode( final String debugMode ) {
        this.debugMode = debugMode;
    }

    /**
     * getter.
     *
     * @return the field: encryptionKey.
     */
    public String getEncryptionKey() {
        return encryptionKey;
    }

    /**
     * setter.
     *
     * @param encryptionKey the field: encryptionKey.
     */
    public void setEncryptionKey( final String encryptionKey ) {
        this.encryptionKey = encryptionKey;
    }

    /**
     * getter.
     *
     * @return the field: htmlMode.
     */
    public String getHtmlMode() {
        return htmlMode;
    }

    /**
     * setter.
     *
     * @param htmlMode the field: htmlMode.
     */
    public void setHtmlMode( final String htmlMode ) {
        this.htmlMode = htmlMode;
    }

    /**
     * getter.
     *
     * @return the field: vfsClasses.
     */
    public String getVfsClasses() {
        return vfsClasses;
    }

    /**
     * setter.
     *
     * @param vfsClasses the field: vfsClasses.
     */
    public void setVfsClasses( final String vfsClasses ) {
        this.vfsClasses = vfsClasses;
    }

    /**
     * getter.
     *
     * @return the field: actionBeanContext.
     */
    public String getActionBeanContext() {
        return actionBeanContext;
    }

    /**
     * setter.
     *
     * @param actionBeanContext the field: actionBeanContext.
     */
    public void setActionBeanContext( final String actionBeanContext ) {
        this.actionBeanContext = actionBeanContext;
    }

    /**
     * getter.
     *
     * @return the field: delegatingExceptionHandlerPackages.
     */
    public String getDelegatingExceptionHandlerPackages() {
        return delegatingExceptionHandlerPackages;
    }

    /**
     * setter.
     *
     * @param delegatingExceptionHandlerPackages the field: delegatingExceptionHandlerPackages.
     */
    public void setDelegatingExceptionHandlerPackages( final String delegatingExceptionHandlerPackages ) {
        this.delegatingExceptionHandlerPackages = delegatingExceptionHandlerPackages;
    }

    /**
     * getter.
     *
     * @return the field: multipartWrapper.
     */
    public String getMultipartWrapper() {
        return multipartWrapper;
    }

    /**
     * setter.
     *
     * @param multipartWrapper the field: multipartWrapper.
     */
    public void setMultipartWrapper( final String multipartWrapper ) {
        this.multipartWrapper = multipartWrapper;
    }

    /**
     * getter.
     *
     * @return the field: fileUploadMaximumPostSize.
     */
    public String getFileUploadMaximumPostSize() {
        return fileUploadMaximumPostSize;
    }

    /**
     * setter.
     *
     * @param fileUploadMaximumPostSize the field: fileUploadMaximumPostSize.
     */
    public void setFileUploadMaximumPostSize( final String fileUploadMaximumPostSize ) {
        this.fileUploadMaximumPostSize = fileUploadMaximumPostSize;
    }

    /**
     * getter.
     *
     * @return the field: customConf.
     */
    public Map< String, String > getCustomConf() {
        return customConf;
    }

    /**
     * setter.
     *
     * @param customConf the field: customConf.
     */
    public void setCustomConf( final Map< String, String > customConf ) {
        this.customConf = customConf;
    }

    /**
     * getter.
     *
     * @return the field: enable.
     */
    public String getEnable() {
        return enable;
    }

    /**
     * setter.
     *
     * @param enable the field: enable.
     */
    public void setEnable( final String enable ) {
        this.enable = enable;
    }

}
