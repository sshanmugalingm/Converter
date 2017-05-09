package au.com.fx.converter.commons.enums;

/**
 * An Enum to Illustrate the different types of conversions available and their respective handlers.
 *
 * @author senthurshanmugalingm.
 */
public enum ConversionType {
    UNITY("unityRateConversionHandler"),
    DIRECT("directRateConversionHandler"),
    INVERSE("invertRateConversionHandler"),
    CROSSCURRENCY("crossRateConversionHandler");

    private String handlerName;

    ConversionType(String handlerName) {
        this.handlerName = handlerName;
    }

    /**
     * Use to get the Handler name for a given Conversion Type.
     * @return  the handler name
     *
     * */
    public java.lang.String getHandlerName() {
        return handlerName;
    }
}
