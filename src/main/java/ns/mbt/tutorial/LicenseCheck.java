// Note: this class is not intended for customization. It will be overwritten when the OData service is regenerated.

package ns.mbt.tutorial;

@javax.servlet.annotation.WebServlet(
    loadOnStartup = 0,
    urlPatterns = "/license/check")
public class LicenseCheck extends com.sap.cloud.server.odata.ServerLicenseCheck {
    private static final long serialVersionUID = 1L;

    public String getApplication() {
        return "mbttutorial";
    }

    public String getLicenseName() {
        return "mbt_license";
    }
}
