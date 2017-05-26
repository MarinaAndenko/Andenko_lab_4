package edu.hneu.kpp.koval.worker;

import edu.hneu.kpp.lab2.service.WorkerService;
import edu.hneu.kpp.labdao.hibernatedao.hibernate.model.Worker;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WorkerEditServlet extends HttpServlet {

    protected void processGetRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int workerID = Integer.parseInt(request.getParameter("id"));
        Worker worker = new WorkerService().findById(workerID);
        request.setAttribute("worker", worker);

        getServletContext().getRequestDispatcher("/worker/Edit.jsp").forward(request, response);
    }

    protected void processPostRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Map<String, String[]> parameters = request.getParameterMap();
        HttpSession session = request.getSession(false);
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-M-dd");
            WorkerService ws = new WorkerService();
            Worker worker = ws.findById(Integer.parseInt(request.getParameter("id")));

            worker.setName(parameters.get("name")[0]);
            worker.setPosition(parameters.get("position")[0]);
            worker.setDepartment(parameters.get("department")[0]);
            worker.setStartHoliday(new SimpleDateFormat("yyyy-M-dd").parse(parameters.get("start")[0]));
            worker.setEndHoliday(new SimpleDateFormat("yyyy-M-dd").parse(parameters.get("end")[0]));

            ws.update(worker);
            response.sendRedirect(request.getContextPath()+"/worker");
        } catch (NullPointerException | NumberFormatException ex) {
            Logger.getLogger(WorkerEditServlet.class.getName()).log(Level.SEVERE, null, ex);
            session.setAttribute("error", "Input Error.");
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        } catch (/* SQL */Exception ex) {
            Logger.getLogger(WorkerEditServlet.class.getName()).log(Level.SEVERE, null, ex);
            session.setAttribute("error", "DB Connection");
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processGetRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processPostRequest(request, response);
    }
}
