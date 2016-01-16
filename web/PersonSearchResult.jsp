<%@ page import="customers.Person" %>
<%@ page import="java.util.List" %>
<%--<%@ include file="index.jsp" %>--%>
<%@page language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<jsp:useBean class="servlet.PersonLoadServlet"
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
<div class="form">
    <ul>
        <!--<li class="tab active" ><a href="#Company">Company</a></li>-->

    </ul>
    <div>
        <div id="Person">


            <div class="field-wrap">
                <button type="" name="type" class="button button-block" disabled>
                    Person Search
                </button>
            </div>
            <!--<div  id="companyTbl">-->
            <table width="100%" cellpadding="5"
                   border="1" cellspacing="0">
                <tr class="header">
                    <td>CustomerNumber</td>
                    <td>FirstName</td>
                    <td>Lastname</td>
                    <td>NationalId</td>
                    <td>Birthday</td>
                    <td>Edit</td>
                    <td>Delete</td>

                </tr>
                <%
                    List<Person> personList = (List<Person>) request.getAttribute("personsList");
                    if (personList != null)
                        for (Person person : personList) {
                %>

                    <tr class="myRow">
                        <td><%= person.getCustomerNumber()%>
                        </td>
                        <td><%= person.getFirstName()%>
                        </td>
                        <td><%= person.getLastName()%>
                        </td>
                        <td><%= person.getNationalCode()%>
                        </td>
                        <td><%= person.getBirthday()%>
                        </td>
                        <td>
                            <form action="PersonLoadServlet" method="post">

                                <button type="submit" name="CustomerNumber" value=<%= person.getCustomerNumber()%>>
                                    <img src="css/edit.png" style="width:20px;height:20px;">
                                </button>

                            </form>

                        </td>

                        <td>

                            <form action="PersonDeleteServlet" method="post">
                                <button type="submit" name="CustomerNumber" value=<%= person.getCustomerNumber()%>>
                                    <img src="css/delete.png" style="width:20px;height:20px;" >
                                </button>
                            </form>

                        </td>
                    </tr>

                <% }%>
            </table>
            <!--</div>-->

        </div>
    </div>
</div>
<!-- tab-content -->

</div>
<!-- /form -->
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

<script src="js/index.js"></script>


</body>
</html>
