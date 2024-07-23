<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
        <%@include file="vendor/head.jsp"%>
    </head>
    <body>
        <%@include file="vendor/navbar.jsp"%>
        <div class="container">
            <div class="row mt-5">
                <div class="col-sm-12">
                    <h1 class="text-center">
                        <%
                            String cookieValue = (String) request.getAttribute("cookieValue");
                            out.print("Your cookie value is: " + cookieValue);
                        %>
                    </h1>
                </div>
            </div>
            <div class="row mt-5">
                <div class="col-sm-6 offset-3">
                    <form action="/setcookie" method="post">
                        <div>
                            <label>COOKIE VALUE : </label>
                            <input type="text" name="cookie_value" class="form-control">
                        </div>
                        <br>
                        <button class="btn btn-success">SET COOKIE</button>
                    </form>
                    <form action="/deletecookie" method="post">
                        <button class="btn btn-danger">DELETE COOKIE</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
