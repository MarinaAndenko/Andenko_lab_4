package edu.hneu.kpp.koval.worker;

import edu.hneu.kpp.koval.model.WorkerModel;
import edu.hneu.kpp.lab2.service.WorkerService;
import edu.hneu.kpp.labdao.hibernatedao.hibernate.model.Worker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WorkerIndexServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Worker> workers = new WorkerService().findAll();
            final List<WorkerModel> workersView = new ArrayList<WorkerModel>();
            workers.forEach(new Consumer<Worker>() {
                @Override
                public void accept(Worker worker) {
                    workersView.add(new WorkerModel(worker));
                }
            });
            request.setAttribute("workers", workersView);
            getServletContext().getRequestDispatcher("/worker/Index.jsp").forward(request, response);
        } catch (/* SQL */Exception ex) {
            Logger.getLogger(WorkerIndexServlet.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("error", "DB Connection Problems");
            getServletContext().getRequestDispatcher("/error.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
