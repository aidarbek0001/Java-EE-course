package kz.javaee.servlets;

import kz.javaee.db.DBManager;
import kz.javaee.db.items;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(value = "/home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String name = request.getParameter("user_name");
//        String surname = request.getParameter("user_surname");
//        int age = Integer.parseInt(request.getParameter("user_age"));
//        System.out.println("You are " + name + " " + surname + ", " + age + " years old");
//        String result = "You are " + name + " " + surname + ", " + age + " years old";
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.print("<h1 style = 'color:blue; '>"+result+"</h1>");
//        out.print("<img src = 'https://upload.wikimedia.org/wikipedia/en/d/d7/Harry_Potter_character_poster.jpg'>");

        ArrayList<items> items = DBManager.getItems();
        request.setAttribute("tovary", items);
        request.getRequestDispatcher("/home.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String faculty = request.getParameter("faculty_name");
//        String points = request.getParameter("faculty_points");
//        System.out.println(faculty + "GOT " + points + " pts");


    }
}
