package kz.javaee.servlets;

import kz.javaee.db.Countries;
import kz.javaee.db.DBManager;
import kz.javaee.db.items;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = 0L;
        try {
            id = Long.parseLong(request.getParameter("id"));
        } catch (Exception e) {

        }
        items item = DBManager.getItem(id);

        if (item != null) {
            request.setAttribute("item", item);

            ArrayList<Countries> countries = DBManager.getCountries();
            request.setAttribute("countries", countries);

            request.getRequestDispatcher("/edit.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/404.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = Long.parseLong(request.getParameter("id"));
        String name = request.getParameter("name");
        int amount = Integer.parseInt(request.getParameter("amount"));
        int price = Integer.parseInt(request.getParameter("price"));
        Long countryId = Long.parseLong(request.getParameter("manufacturer_id"));

        String redirect = "/";

        Countries cnt = DBManager.getCountry(countryId);
        if (cnt != null) {
            items item = DBManager.getItem(id);
            if (item != null) {
                item.setName(name);
                item.setAmount(amount);
                item.setPrice(price);
                item.setManufacturer(cnt);

                if (DBManager.saveItem(item)) {
                    redirect = "/edit?=" + id + "&success";
                } else {
                    redirect = "/edit?=" + id + "&error";
                }
            }
        }
        response.sendRedirect(redirect);
    }
}
