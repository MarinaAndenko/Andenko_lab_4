package edu.hneu.kpp.lab3.restservice.impl;

import edu.hneu.kpp.lab2.service.WorkerService;
import edu.hneu.kpp.lab3.restservice.WorkerRestService;
import edu.hneu.kpp.labdao.hibernatedao.hibernate.model.Worker;

import javax.ws.rs.core.Response;
import java.util.Objects;

public class WorkerRestServiceImpl implements WorkerRestService {

    private WorkerService workerService;

    public Response getWorkers() {
        return Response.ok(workerService.findAll()).build();
    }

    public Response getWorker(Integer id) {
        if (Objects.isNull(id))
            return Response.status(Response.Status.BAD_REQUEST).build();
        return Response.ok(workerService.findById(id)).build();
    }

    public Response addWorker(Worker worker) {
        workerService.persist(worker);
        return Response.ok().build();
    }

    public Response editWorker(Worker worker) {
        workerService.update(worker);
        return Response.ok().build();
    }

    public Response deleteWorker(Integer id) {
        if (Objects.isNull(id))
            return Response.status(Response.Status.BAD_REQUEST).build();
        workerService.delete(id);
        return Response.ok().build();
    }
}
