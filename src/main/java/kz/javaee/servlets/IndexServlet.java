package kz.javaee.servlets;

import kz.javaee.db.DBManager;
import kz.javaee.db.items;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(value = "/index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<items> items = DBManager.getItems();

        PrintWriter out = response.getWriter();
        out.println("<h1>ITEMS LIST</h1>");

        for(items it : items){
            out.print("<h3>"+it.getId()+" "+it.getName()+" "+it.getAmount()+" " + it.getPrice()+"KZT </h3>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
