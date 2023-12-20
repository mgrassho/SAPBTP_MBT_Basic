// Note: This handler will be overwritten if the service is regenerated.
// To allow customization and avoid overwriting upon service regeneration,
// please delete this comment.

package ns.mbt.tutorial.filter;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import com.sap.cloud.server.odata.http.*;

@WebFilter(filterName = "NoAuthenticationFilter", urlPatterns = { "/*" })
public class NoAuthenticationFilter implements Filter {
    private static double UNAUTHENTICATED_DAYS = 1; // set to zero to enable permanent operation without authentication

    private static String[] AUTHENTICATION_HEADERS = {
        HttpHeader.AUTHORIZATION,
        "ssl_client_cert",
        "x-smp-endusername",
        "X-Client-Credentials",
    };

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest)request;
        HttpServletResponse httpResponse = (HttpServletResponse)response;
        String servletPath = httpRequest.getServletPath();
        if (servletPath.equals("/license/check")) {
            filterChain.doFilter(request, response);
            return;
        }
        double daysRunning = com.sap.cloud.server.odata.core.SystemClock.nanoTime() / 86_400_000_000_000.0;
        if (daysRunning > UNAUTHENTICATED_DAYS && UNAUTHENTICATED_DAYS > 0) {
            String message = String.format("NoAuthenticationFilter: This service has been running for %.5f days without authentication enabled. The configured limit is %.5f days. As a security precaution, no further client access will be permitted. Please customize the UNAUTHENTICATED_DAYS setting and recompile/redeploy this service if it is intended that this service will run permanently (or for a longer period) without authentication.", daysRunning, UNAUTHENTICATED_DAYS);
            ns.mbt.tutorial.MainServlet.getInstance().getLogger().error(message);
            httpResponse.sendError(500);
            return;
        }
        for (String header : AUTHENTICATION_HEADERS) {
            String value = httpRequest.getHeader(header);
            if (value != null) {
                String message = "NoAuthenticationFilter: Request contains header \"" + header + "\" but this service was generated with authentication disabled. The header might have been added by a client or intermediary which expects transport encryption or trust/validation from this service. Please check the documentation for the \"-login\" option (X509).";
                ns.mbt.tutorial.MainServlet.getInstance().getLogger().error(message);
                httpResponse.sendError(400);
                return;
            }
        }
        filterChain.doFilter(request, response);
    }
}
