package au.com.fx.converter.commons.enums;

/**
 * Created by senthurshanmugalingm on 4/05/2017.
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

    public java.lang.String getHandlerName() {
        return handlerName;
    }
}
