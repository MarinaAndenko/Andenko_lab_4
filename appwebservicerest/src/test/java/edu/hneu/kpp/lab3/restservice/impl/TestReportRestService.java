package edu.hneu.kpp.lab3.restservice.impl;

import edu.hneu.kpp.lab2.service.WorkerService;
import edu.hneu.kpp.lab3.restservice.WorkerRestService;
import edu.hneu.kpp.labdao.hibernatedao.hibernate.model.Worker;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.List;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class TestReportRestService {

    private static final Integer WORKER_ID = 1;
    private static final String WORKER_NAME = "Author's name";
    private static final String WORKER_POSITION = "Report title";
    private static final int NOT_FOUND_ID = 2;
    private static final int STATUS_OK = 200;
    @Mock
    private WorkerService workerService;
    private Worker worker = new Worker();
    @InjectMocks
    private WorkerRestService workerRestService = new WorkerRestServiceImpl();

    @Before
    public void setUp() throws Exception {
        worker.setId(WORKER_ID);
        worker.setName(WORKER_NAME);
        worker.setPosition(WORKER_POSITION);

        when(workerService.findById(WORKER_ID)).thenReturn(worker);
        when(workerService.findAll()).thenReturn(asList(worker, worker));
    }

    @Test
    public void shouldReturnEntityNull_whenReportNotFound() {
        Response response = workerRestService.getWorker(NOT_FOUND_ID);
        assertNull(response.getEntity());
    }

    @Test
    public void shouldReturnEntityNull_whenGivenIdIsNull() {
        Response response = workerRestService.getWorker(null);
        assertNull(response.getEntity());
    }

    @Test
    public void shouldReturnStatus200OK_whenGetReportCalled() {
        Response response = workerRestService.getWorker(WORKER_ID);
        assertEquals(STATUS_OK, response.getStatus());
    }

    @Test
    public void shouldReturnReportResponseWithReportId_whenGetReportCalled() {
        Response response = workerRestService.getWorker(WORKER_ID);
        Worker worker = response.readEntity(Worker.class);
        assertEquals(WORKER_ID, (Object) worker.getId());
    }

    @Test
    public void shouldReturnReportResponseWithReportAuthor_whenGetReportCalled() {
        Response response = workerRestService.getWorker(WORKER_ID);
        Worker report = response.readEntity(Worker.class);
        assertEquals(WORKER_POSITION, report.getPosition());
    }

    @Test
    public void shouldReturnAllReportsResponse_whenGetReportsCalled() {
        Response response = workerRestService.getWorkers();
        List<Worker> reports = response.readEntity(new GenericType<List<Worker>>() {
        });
        assertEquals(2, reports.size());
    }

    @Test
    public void shouldReturnStatusOk_whenReportWasAddedSuccessfully() {
        Response response = workerRestService.addWorker(worker);
        assertEquals(STATUS_OK, response.getStatus());
    }

    @Test
    public void shouldCallPersist_whenAddReportCalled() {
        workerRestService.addWorker(worker);
        verify(workerService).persist(worker);
    }
}
