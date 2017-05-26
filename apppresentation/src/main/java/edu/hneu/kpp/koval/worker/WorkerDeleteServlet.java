package edu.hneu.kpp.koval.worker;

import edu.hneu.kpp.koval.model.WorkerModel;
import edu.hneu.kpp.lab2.service.WorkerService;
import edu.hneu.kpp.labdao.hibernatedao.hibernate.model.Worker;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;
import java.sql.SQLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WorkerDeleteServlet extends HttpServlet {
    protected void processGetRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int workerId = Integer.parseInt(request.getParameter("id"));
        Worker report = new WorkerService().findById(workerId);
        WorkerModel model = new WorkerModel(report);
        request.setAttribute("worker", model);
        getServletContext().getRequestDispatcher("/worker/Delete.jsp").forward(request, response);
    }

    protected void processPostRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Map<String, String[]> parameters = request.getParameterMap();
        HttpSession session = request.getSession(false);
        try {
            new WorkerService().delete(Integer.parseInt(request.getParameter("id")));
            response.sendRedirect(request.getContextPath()+"/worker");
        } catch (NullPointerException | NumberFormatException ex) {
            Logger.getLogger(WorkerDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
            session.setAttribute("error", "Input Error");
            response.sendRedirect(request.getContextPath()+"/error.jsp");
        } catch (/* SQL */Exception ex) {
            Logger.getLogger(WorkerDeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
            session.setAttribute("error", "DB Connection Problems");
            response.sendRedirect(request.getContextPath()+"/error.jsp");
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
