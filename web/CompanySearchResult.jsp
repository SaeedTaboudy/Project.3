<%@ page import="customers.Company" %>
<%@ page import="customers.Person" %>
<%@ page import="java.util.List" %>
<%--<%@ include file="index.jsp" %>--%>
<%@page language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<jsp:useBean class="servlet.CompanyLoadServlet"
             scope="page" id="search">
</jsp:useBean>--%>
<head>
    <meta charset="UTF-8">
    <title>Sign-Up/Login Form</title>
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/style.css">

</head>
<html>
    <body>
        <div class="form" >
            <ul  >

            </ul>
            <div >
                <!--<form>-->
                <div id="Company">
                    <div class="field-wrap">
                        <button type="" name="type" class="button button-block" disabled>
                            Company Search
                        </button>
                    </div>


                    <table  width="100%" cellpadding="5"
                            border="1" cellspacing="0">
                        <tr class="header">
                            <td>CustomerNumber</td>
                            <td>Name</td>
                            <td>EconomicNum</td>
                            <td>RegDate</td>
                            <td>Edit</td>


                        </tr>
                        <%
                            List<Company> companyList = (List<Company>) request.getAttribute("companyList");
                            if (companyList != null)
                                for (Company company : companyList) {
                        %>

                        <tr>
                            <td><%= company.getCustomerNumber()%>
                            </td>
                            <td><%= company.getName()%>
                            </td>
                            <td><%= company.getEconomicCode()%>
                            </td>
                            <td><%= company.getRegistrationDate()%>
                            </td>
                            <td>

                                <form action="CompanyLoadServlet" method="post">
                                    <button type="submit" name="CustomerNumber" value=<%= company.getCustomerNumber()%> >
                                        <img src="css/edit.png"  style="width:20px;height:20px;"
                                    </button>
                                </form>

                            </td>
                            <td>

                                <form action="CompanyDeleteServlet" method="post">
                                    <button type="submit" name="CustomerNumber" value=<%= company.getCustomerNumber()%> >
                                        <img src="css/delete.png"  style="width:20px;height:20px;"
                                    </button>
                                </form>

                            </td>
                        </tr>
                        <% }%>
                    </table>
                </div>
            </div>
            <!--</form>-->
        </div>
        <!-- tab-content -->


        <!-- /form -->
        <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

        <script src="js/index.js"></script>


    </body>
</html>
