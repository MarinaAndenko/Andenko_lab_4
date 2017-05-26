package edu.hneu.kpp.koval.worker;

import edu.hneu.kpp.koval.model.WorkerModel;
import edu.hneu.kpp.lab2.service.WorkerService;
import edu.hneu.kpp.labdao.hibernatedao.hibernate.model.Worker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WorkerCreateServlet extends HttpServlet {

    protected void processGetRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/worker/Create.jsp").forward(request, response);
    }

    protected void processPostRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Map<String, String[]> parameters = request.getParameterMap();
        HttpSession session = request.getSession(false);
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd");

            String name = parameters.get("name")[0];
            String position = parameters.get("position")[0];
            String department = parameters.get("department")[0];
            Date startDate = formatter.parse(parameters.get("start")[0]);
            Date endDate =  formatter.parse(parameters.get("end")[0]);

            Worker worker = new Worker(name, position, department, startDate, endDate);
            new WorkerService().persist(worker);
            WorkerModel workerView = new WorkerModel(worker);

            session.setAttribute("report", workerView);
            response.sendRedirect(request.getContextPath() + "/worker/Success.jsp");
        } catch (NullPointerException | NumberFormatException ex) {
            Logger.getLogger(WorkerCreateServlet.class.getName()).log(Level.SEVERE, null, ex);
            session.setAttribute("error", "Input Error. "
                    + "Check please again your input");
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        } catch (Exception ex) {
            Logger.getLogger(WorkerCreateServlet.class.getName()).log(Level.SEVERE, null, ex);
            session.setAttribute("error", "Connection Problem");
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processPostRequest(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processGetRequest(request, response);
    }
}
