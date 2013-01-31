package pro.softcom.fuel.ws;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import pro.softcom.fuel.domain.Refill;
import pro.softcom.fuel.service.RefillService;


/**
 * WebService Endpoint for all refill action.
 *
 * @author  Patrick Retornaz
 */
@Path("/refill")
public class RefillEndpoint {

    private static final Logger log = LoggerFactory.getLogger(RefillEndpoint.class);

    @Inject
    private RefillService refillService;

    /**
     * PUT endpoint for refills. URL format is : '/refill/{timestamp}/{tankerId}/{machineId}?{liters}. Returned HTTP
     * 401 if the refill is created.
     *
     * @param   tankerId   string representing the tanker truck
     * @param   machineId  string representing the target machine
     * @param   liters     number of liters
     * @param   timestamp  timestamp in milliseconds. (1000*UNIX_TIMESTAMP)
     *
     * @return  The HTTP status "CREATED" 401 if everything went good.
     */
    @PUT
    @Path("{timestamp}/{tankerId}/{machineId}")
    public Response refill(@PathParam("tankerId") String tankerId, @PathParam("machineId") String machineId,
        @QueryParam("liters") long liters, @PathParam("timestamp") long timestamp) {

        if (log.isDebugEnabled()) {
            log.debug("Received PUT request for resource [" + timestamp + "/" + tankerId + "/" + machineId
                + "?liters=" + liters + "]");
        }

        Date date = new Date(timestamp);
        refillService.saveRefill(tankerId, machineId, liters, date);

        return Response.status(Response.Status.CREATED).build();
    }

    /**
     * GET endpoint that returns all the saved refills. Produces JSON.
     *
     * @return  JSON object that represents all the refills.
     */
    @GET
    @Path("all")
    @Produces({ "application/json" })
    public List<Refill> getAllRefill() {
        return refillService.getAllRefill();
    }

}
