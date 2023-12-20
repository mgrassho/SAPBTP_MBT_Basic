package ns.mbt.tutorial;

@javax.servlet.annotation.WebServlet(
    loadOnStartup = 10,
    urlPatterns = "/*")
public class MainServlet extends ns.mbt.tutorial.base.MainServletBase {
    private static final long serialVersionUID = 1L;

    private static volatile MainServlet singleton = null;

    public void init(javax.servlet.ServletConfig config) throws javax.servlet.ServletException {
        // For customization, see also: LogSettings, ProviderSettings, TestSettings.
        singleton = this;
        try {
            super.init(config);
        }
        catch (Throwable error) {
            initFailed(error);
        }
    }

    public static MainServlet getInstance() {
        // Note: if calling this from another servlet, ensure the other servlet's loadOnStartup is > 10.
        if (singleton == null) throw new IllegalStateException("MainServlet is not yet initialized!");
        return singleton;
    }

    protected void service(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
        throws javax.servlet.ServletException, java.io.IOException
    {
        try {
            super.service(request, response);
        }
        catch (Error error) {
            // Attempt to log fatal errors, such as java.lang.OutOfMemoryError.
            com.sap.cloud.server.odata.core.ThreadSleep.forSeconds(60); // This may increase the chance of successful logging if error is transient.
            error.printStackTrace();
            com.sap.cloud.server.odata.core.DebugConsole.error("FATAL ERROR", new RuntimeException(error), true);
            com.sap.cloud.server.odata.core.DebugConsole.flush();
            throw error; // Web container (e.g. Tomcat) might not catch this; client might never receive a response. That's why we do the logging.
        }
    }
}
