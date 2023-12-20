// Note: This handler will be overwritten if the service is regenerated.
// To allow customization and avoid overwriting upon service regeneration,
// please delete this comment.

package ns.mbt.tutorial.handler;

import com.sap.cloud.server.odata.*;
import com.sap.cloud.server.odata.json.*;

public class UserHandler extends com.sap.cloud.server.odata.http.HttpEntityHandler {
    private ns.mbt.tutorial.MainServlet servlet;
    private ns.mbt.tutorial.proxy.NsMbtTutorialService service;

    private static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UserHandler.class);

    private final EntityType ENTITY_TYPE = ns.mbt.tutorial.proxy.NsMbtTutorialServiceMetadata.document.getEntityType("ns.mbt.tutorial.User");
    private final Property entity_UserID = ENTITY_TYPE.getProperty("UserID");
    private final Property entity_Name = ENTITY_TYPE.getProperty("Name");
    private final Property entity_Email = ENTITY_TYPE.getProperty("Email");
    
    public UserHandler(ns.mbt.tutorial.MainServlet servlet, ns.mbt.tutorial.proxy.NsMbtTutorialService service) {
        super(servlet, service, logger);
        this.servlet = servlet;
        this.service = service;
        allowUnused(this.servlet);
        allowUnused(this.service);
        setDestination(com.sap.cloud.server.odata.http.HttpDestination.lookup("mbttutorial"));
    }

    @Override public DataValue executeQuery(DataQuery query) {
        return service.executeQuery(query).getResult();
    }

    @Override public DataValue loadAll(DataQuery query) {
        EntityValueList result = new EntityValueList().withItemType(ENTITY_TYPE);
        ns.mbt.tutorial.proxy.User entity = new ns.mbt.tutorial.proxy.User();
        org.apache.http.client.methods.HttpUriRequest request;
        org.apache.http.client.methods.CloseableHttpResponse response = null;
        CharStream stream = null;
        boolean ok = false;
        try {
            request = get("/users");
            ns.mbt.tutorial.HeaderProvider.getInstance().addHttpHeaders(getDestination(), request);
            DataContext context = dataContext();
            response = execute(request, JSON);
            checkStatus(response);
            stream = charStream(response);
            JsonArray output = jsonArray(stream);
            int count = output.length();
            for (int index = 0; index < count; index++) {
                JsonObject output2 = output.getObject(index);
                entity.setDataValue(entity_Email, fieldValue(output2, "email", entity_Email, context));
                entity.setDataValue(entity_UserID, fieldValue(output2, "id", entity_UserID, context));
                entity.setDataValue(entity_Name, fieldValue(output2, "name", entity_Name, context));
                result.add(entity);
                entity = new ns.mbt.tutorial.proxy.User();
            }
            ok = true;
        }
        finally {
            close(ok, stream, response);
        }
        return result;
    }

    @Override public void createEntity(EntityValue entityValue) {
        ns.mbt.tutorial.proxy.User entity = (ns.mbt.tutorial.proxy.User)entityValue;
        throw DataServiceException.createEntityNotImplemented(entity);
    }

    @Override public void updateEntity(EntityValue entityValue) {
        ns.mbt.tutorial.proxy.User entity = (ns.mbt.tutorial.proxy.User)entityValue;
        throw DataServiceException.updateEntityNotImplemented(entity);
    }

    @Override public void deleteEntity(EntityValue entityValue) {
        ns.mbt.tutorial.proxy.User entity = (ns.mbt.tutorial.proxy.User)entityValue;
        throw DataServiceException.deleteEntityNotImplemented(entity);
    }

    @Override public void refreshCache(EntitySet entitySet, boolean inDownload, boolean force) {
        super.refreshCache(entitySet, inDownload, force);
    }
}
