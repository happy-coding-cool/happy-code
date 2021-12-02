package cool.happycoding.code.ws.client;

/**
 * description
 *
 * @author lanlanhappy 2021/11/27 9:21 下午
 */
public enum SoapVersion {

    /**
     * soap 1.1
     */
    SOAP_11("SOAP 1.1 Protocol"),
    /**
     * soap 1.2
     */
    SOAP_12("SOAP 1.2 Protocol"),
    /**
     * soap dynamic
     */
    SOAP_DY("Dynamic Protocol");

    String protocol;

    SoapVersion(String protocol){
        this.protocol = protocol;
    }

    public String getProtocol() {
        return protocol;
    }
}
