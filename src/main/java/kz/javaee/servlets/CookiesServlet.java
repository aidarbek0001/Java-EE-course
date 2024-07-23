package kz.javaee.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(value = "/cookies")
public class CookiesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie cookies[] = request.getCookies();
        String myCookieValue = "No Cookie Data";

        if (cookies!=null){
            for (Cookie c:cookies){
                if(c.getName().equals("my_cookie_value")){
                    myCookieValue = c.getValue();
                    break;
                }
            }
        }

        request.setAttribute("cookieValue", myCookieValue);
        request.getRequestDispatcher("/cookies.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
