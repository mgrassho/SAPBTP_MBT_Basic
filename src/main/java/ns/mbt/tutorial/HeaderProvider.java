// This class can be used to customize HTTP headers (e.g. authentication headers) for outgoing requests.

package ns.mbt.tutorial;

import com.sap.cloud.server.odata.*;
import com.sap.cloud.server.odata.http.*;

public class HeaderProvider extends ns.mbt.tutorial.base.HeaderProviderBase {
    // Use a thread local instance if the backend system requires each client to have a different security session.
    // If any instance variables are added to this class, then use a thread local instance or 'synchronized' access.

    public static final boolean THREAD_LOCAL_INSTANCE = false; // See above: change this to true if needed.

    private static ThreadLocal<HeaderProvider> instance = THREAD_LOCAL_INSTANCE ? new ThreadLocal<HeaderProvider>() : null;

    private static HeaderProvider singleton = THREAD_LOCAL_INSTANCE ? null : new HeaderProvider();

    public static HeaderProvider getInstance() {
        if (THREAD_LOCAL_INSTANCE) {
            HeaderProvider provider = instance.get();
            if (provider == null) instance.set(provider = new HeaderProvider());
            return provider;
        }
        else {
            return singleton;
        }
    }

    public static StringSet initPropagate() {
        StringSet propagate = ns.mbt.tutorial.base.HeaderProviderBase.initPropagate();
        // propagate.add("repeatability-*"); // enable if backend supports repeatability
        return propagate;
    }

    @Override public void onTenantOpen(HttpDestination destination, HttpRequest request) {
        super.onTenantOpen(destination, request);
    }

    @Override public void addHttpHeaders(HttpDestination destination, org.apache.http.HttpRequest request, HttpHeaders headers) {
        super.addHttpHeaders(destination, request, headers);
    }

    @Override public void addAuthorization(HttpDestination destination, org.apache.http.HttpRequest request, HttpHeaders headers) {
        super.addAuthorization(destination, request, headers);
    }

    @Override public void addConnectivity(HttpDestination destination, org.apache.http.HttpRequest request, HttpHeaders headers) {
        super.addConnectivity(destination, request, headers);
    }

    @Override public void onHttpResponse(HttpDestination destination, org.apache.http.HttpResponse response, HttpHeaders headers) {
        super.onHttpResponse(destination, response, headers);
    }

    @Override public boolean shouldPropagate(HttpDestination destination, String header, boolean override) {
        return super.shouldPropagate(destination, header, override);
    }
}
