<%@include file="user.jsp"%>
<nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #8b72e7">
    <a class="navbar-brand" href="/">E-SHOP</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <%
                if (ONLINE){
            %>
            <li class="nav-item">
                <a class="nav-link" href="/profile"><%=currentUser.getFullName()%></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/additem">Add Item</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/cookies">Cookies Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/sessions">Sessions Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/logout">Logout</a>
            </li>
            <%
                }else {
            %>
            <li class="nav-item">
                <a class="nav-link" href="/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/login">Login</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="/register">Register</a>
            </li>
            <%
                }
            %>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-light my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>