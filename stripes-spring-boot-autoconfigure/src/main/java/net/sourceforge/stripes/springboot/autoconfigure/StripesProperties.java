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

    /** value for: {@code ActionBeanPropertyBinder.Class} */
    private String actionBeanPropertyBinder;

    /** value for: {@code ActionBeanContextFactory.Class} */
    private String actionBeanContextFactory;

    /** value for: {@code ActionBeanContext.Class} */
    private String actionBeanContext;

    /** value for: {@code ActionResolver.Class} */
    private String actionResolver;

    /** value for: {@code ActionResolver.Packages} */
    private String actionResolverPackages;

    /** value for: {@code Configuration.Class} */
    private String configuration;

    /** value for: {@code CoreInterceptor.Classes} */
    private String coreInterceptorClasses;

    /** Configurar o no stripes */
    private String enable;

    /** value for: {@code ExceptionHandler.Class} */
    private String exceptionHandler;

    /** value for: {@code DelegatingExceptionHandler.Packages} */
    private String delegatingExceptionHandlerPackages;

    /** value for: {@code Extension.Packages} */
    private String extensionPackages;

    /** value for: {@code FormatterFactory.Class} */
    private String formatterFactory;

    /** value for: {@code Interceptor.Classes} */
    private String interceptors;

    /** value for: {@code LocalePicker.Class} */
    private String localePicker;

    /** value for: {@code LocalePicker.Locales} */
    private String locales;

    /** value for: {@code LocalizationBundleFactory.Class} */
    private String localizationBundleFactory;

    /** value for: {@code LocalizationBundleFactory.ErrorMessageBundle} */
    private String errorMessageBundle;

    /** value for: {@code LocalizationBundleFactory.FieldNameBundle} */
    private String fieldNameBundle;

    /** value for: {@code MultipartWrapperFactory.Class} */
    private String multipartWrapperFactory;

    /** value for: {@code MultipartWrapper.Class} */
    private String multipartWrapper;

    /** value for: {@code FileUpload.MaximumPostSize} */
    private String fileUploadMaximumPostSize;

    /** value for: {@code PopulationStrategy.Class} */
    private String populationStrategy;

    /** value for: {@code TagErrorRendererFactory.Class} */
    private String tagErrorRendererFactory;

    /** value for: {@code TypeConverterFactory.Class} */
    private String typeConverterFactory;

    /** value for: {@code Stripes.DebugMode} */
    private String debugMode;

    /** value for: {@code Stripes.EncryptionKey} */
    private String encryptionKey;

    /** value for: {@code Stripes.HtmlMode} */
    private String htmlMode;

    /** value for: {@code VFS.Classes} */
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
