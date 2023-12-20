package ns.mbt.tutorial;

@javax.servlet.annotation.WebServlet(
    initParams = {
        @javax.servlet.annotation.WebInitParam(name = "saveMetricsEvery", value = MetricSettings.SAVE_METRICS_EVERY_PERIOD),
        @javax.servlet.annotation.WebInitParam(name = "retainMetricsFor", value = MetricSettings.RETAIN_METRICS_FOR_PERIOD) },
    loadOnStartup = 20,
    urlPatterns = { "/admin/metrics/*" })
public class MetricServlet extends ns.mbt.tutorial.base.MetricServletBase {
    private static final long serialVersionUID = 1L;

    public static final boolean DEBUG_METRIC_SERVLET = false;
    public static final boolean TRACE_METRIC_SERVLET = false;

    public static final boolean DEBUG_METRIC_SERVICE = false;
    public static final boolean TRACE_METRIC_SERVICE = false;

    public void init(javax.servlet.ServletConfig config) throws javax.servlet.ServletException {
        // For customization, see also: MetricSettings.
        super.init(config);
    }
}
