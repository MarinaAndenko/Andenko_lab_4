package edu.hneu.kpp.lab3.restservice;

import edu.hneu.kpp.labdao.hibernatedao.hibernate.model.Worker;

import javax.jws.WebService;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@WebService(name = "cxfRestWorkerService")
public interface WorkerRestService {
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/")
    Response getWorkers();

    @GET
    @Produces(value = {MediaType.APPLICATION_JSON})
    @Path("/{id}")
    Response getWorker(@PathParam("id") Integer id);

    @POST
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/add")
    Response addWorker(Worker worker);

    @PUT
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/edit")
    Response editWorker(Worker worker);

    @DELETE
    @Produces({ MediaType.APPLICATION_JSON })
    @Path("/delete/{id}")
    Response deleteWorker(@PathParam("id") Integer id);
}
