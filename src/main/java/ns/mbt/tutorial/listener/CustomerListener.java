// Note: This listener will be overwritten if the service is regenerated.
// To allow customization and avoid overwriting upon service regeneration,
// please delete this comment.

package ns.mbt.tutorial.listener;

import com.sap.cloud.server.odata.*;

public class CustomerListener extends com.sap.cloud.server.odata.DefaultEntityListener {
    private ns.mbt.tutorial.MainServlet servlet;
    private ns.mbt.tutorial.proxy.NsMbtTutorialService service;

    public CustomerListener(ns.mbt.tutorial.MainServlet servlet, ns.mbt.tutorial.proxy.NsMbtTutorialService service) {
        super();
        this.servlet = servlet;
        this.service = service;
        allowUnused(this.servlet);
        allowUnused(this.service);
    }

    @Override public void beforeQuery(DataQuery query) {
        allowUnused(query);
    }

    public void beforeSave(EntityValue entityValue) {
        // Shared code for beforeCreate / beforeUpdate.
        ns.mbt.tutorial.proxy.Customer entity = (ns.mbt.tutorial.proxy.Customer)entityValue;
        allowUnused(entity);
    }

    @Override public void beforeCreate(EntityValue entityValue) {
        ns.mbt.tutorial.proxy.Customer entity = (ns.mbt.tutorial.proxy.Customer)entityValue;
        allowUnused(entity);
        beforeSave(entity);
    }

    @Override public void beforeUpdate(EntityValue entityValue) {
        ns.mbt.tutorial.proxy.Customer entity = (ns.mbt.tutorial.proxy.Customer)entityValue;
        allowUnused(entity);
        beforeSave(entity);
    }

    @Override public void beforeDelete(EntityValue entityValue) {
        ns.mbt.tutorial.proxy.Customer entity = (ns.mbt.tutorial.proxy.Customer)entityValue;
        allowUnused(entity);
    }

    public void afterSave(EntityValue entityValue) {
        // Shared code for afterCreate / afterUpdate.
        ns.mbt.tutorial.proxy.Customer entity = (ns.mbt.tutorial.proxy.Customer)entityValue;
        allowUnused(entity);
    }

    @Override public void afterCreate(EntityValue entityValue) {
        ns.mbt.tutorial.proxy.Customer entity = (ns.mbt.tutorial.proxy.Customer)entityValue;
        allowUnused(entity);
        afterSave(entity);
    }

    @Override public void afterUpdate(EntityValue entityValue) {
        ns.mbt.tutorial.proxy.Customer entity = (ns.mbt.tutorial.proxy.Customer)entityValue;
        allowUnused(entity);
        afterSave(entity);
    }

    @Override public void afterDelete(EntityValue entityValue) {
        ns.mbt.tutorial.proxy.Customer entity = (ns.mbt.tutorial.proxy.Customer)entityValue;
        allowUnused(entity);
    }
}
