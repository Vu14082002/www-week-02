<%@ page import="java.util.List" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.stream.Collectors" %>
<div id="gototop"></div>
<header id="header">
</header>
<!--
Navigation Bar Section
-->
<%
    String path = request.getContextPath();
    boolean home=path.contains("home")?true:false;
    boolean list=path.contains("list")?true:false;
    boolean grid = path.contains("grid") ? true : false;
%>
<div class="navbar">
    <div class="navbar-inner">
        <div class="container">
            <div class="nav-collapse" style="display: flex;justify-content: space-between;">
                <ul class="nav">
                    <li class=" <%=home?"active":" "%>"><a href="<%=request.getContextPath()+"/home"%>">Home </a></li>
                    <li class=" <%=list?"active":" "%>"><a href="<%=request.getContextPath()+"/list"%>">List View</a></li>
                    <li class=" <%=grid?"active":" "%>"><a href="<%=request.getContextPath()+"/grid"%>">Grid
                        View</a></li>
                </ul>
                <div>
                    <form action="#" class="navbar-search pull-left">
                        <input type="text" placeholder="Search" class="search-query span2">
                    </form>
                    <ul class="nav pull-right">
                        <li class="dropdown">
                            <a data-toggle="dropdown" href="#"><span class="icon-lock"></span> Login <b
                                    class="caret"></b></a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>