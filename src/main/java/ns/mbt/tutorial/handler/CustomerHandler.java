// Note: This handler will be overwritten if the service is regenerated.
// To allow customization and avoid overwriting upon service regeneration,
// please delete this comment.

package ns.mbt.tutorial.handler;

import com.sap.cloud.server.odata.*;

public class CustomerHandler extends com.sap.cloud.server.odata.DefaultEntityHandler {
    private ns.mbt.tutorial.MainServlet servlet;
    private ns.mbt.tutorial.proxy.NsMbtTutorialService service;

    public CustomerHandler(ns.mbt.tutorial.MainServlet servlet, ns.mbt.tutorial.proxy.NsMbtTutorialService service) {
        super(servlet, service);
        this.servlet = servlet;
        this.service = service;
        allowUnused(this.servlet);
        allowUnused(this.service);
    }

    @Override public DataValue executeQuery(DataQuery query) {
        return service.executeQuery(query).getResult();
    }

    @Override public void createEntity(EntityValue entityValue) {
        ns.mbt.tutorial.proxy.Customer entity = (ns.mbt.tutorial.proxy.Customer)entityValue;
        service.createEntity(entity);
    }

    @Override public void updateEntity(EntityValue entityValue) {
        ns.mbt.tutorial.proxy.Customer entity = (ns.mbt.tutorial.proxy.Customer)entityValue;
        entity.setMustBeModified(true);
        service.updateEntity(entity);
    }

    @Override public void deleteEntity(EntityValue entityValue) {
        ns.mbt.tutorial.proxy.Customer entity = (ns.mbt.tutorial.proxy.Customer)entityValue;
        service.deleteEntity(entity);
    }
}
