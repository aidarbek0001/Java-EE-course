package kz.javaee.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/setsession")
public class SetSessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sessValue = request.getParameter("session_value");

        HttpSession session = request.getSession();
        session.setAttribute("my_sess_value", sessValue);

        response.sendRedirect("/sessions");

    }
}
