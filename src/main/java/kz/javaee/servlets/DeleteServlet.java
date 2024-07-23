package kz.javaee.servlets;

import kz.javaee.db.DBManager;
import kz.javaee.db.items;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/delete")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        items item = DBManager.getItem(id);

        if(item!=null){

            if(DBManager.deleteItem(item)){
                response.sendRedirect("/");
            }else {
                response.sendRedirect("/edit?="+id+"&error");
            }
        }else {
            response.sendRedirect("/");
        }
    }
}
