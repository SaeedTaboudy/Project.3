<%@ page import="customers.Company" %>
<%@ page import="customers.Person" %>
<%@ page import="java.util.List" %>
<%--<%@ include file="index.jsp" %>--%>
<%@page language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<jsp:useBean class="servlet.SearchServlet"
             scope="page" id="search">
</jsp:useBean>--%>
<head>
    <meta charset="UTF-8">
    <title>User Registration</title>
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="css/normalize.css">
    <link rel="stylesheet" href="css/style.css">

</head>
<html>
    <body>
        <div class="form">
            <ul class="tab-group">
                <li class="tab active" id="showTab"><a href="#Person">Person</a></li>
                <li class="tab"><a href="#Company">Company</a></li>
            </ul>
            <div class="tab-content">
                <div id="Person">
                    <h1>Registration</h1>

                    <form action="SearchServlet" method="post">
                        <div class="top-row">
                            <div class="field-wrap">
                                <label>
                                    NationaCode<span class="req">*</span>
                                </label>
                                <input type="text" name="NationalCode" autocomplete="off" size="10" maxlength="10"/>
                            </div>
                            <div class="field-wrap">
                                <label>
                                    CustomerNumber<span class="req">*</span>
                                </label>
                                <input type="text" name="CustomerNumber" autocomplete="off"/>
                            </div>
                        </div>
                        <div class="top-row">
                            <div class="field-wrap">
                                <label>
                                    FirstName<span class="req">*</span>
                                </label>
                                <input type="text" name="FirstName" autocomplete="off"/>
                            </div>
                            <div class="field-wrap">
                                <label>
                                    LastName<span class="req">*</span>
                                </label>
                                <input type="text" name="LastName" autocomplete="off"/>
                            </div>
                        </div>
                        <div class="field-wrap">
                            <button type="submit" name="type" value="person" class="button button-block">
                                search
                            </button>
                        </div>

                    </form>
                </div>

                <div id="Company">
                    <h1>Company</h1>
                                  
                    <form action="SearchServlet" method="post">
                        <div class="top-row">
                            <div class="field-wrap">
                                <label>
                                    Name<span class="req">*</span>
                                </label>
                                <input type="text" name="Name" autocomplete="off"/>
                            </div>

                            <div class="field-wrap">
                                <label>
                                    economicCode<span class="req">*</span>
                                </label>
                                <input type="text" name="EconomicCode" autocomplete="off"/>
                            </div>
                        </div>
                        <div class="top-row">
                            <div class="field-wrap">
                                <label>
                                    CustomerNumber<span class="req">*</span>
                                </label>
                                <input type="text" name="CustomerNumber" autocomplete="off"/>
                            </div>
                            <div class="field-wrap">
                                <label>
                                    registrationDate<span class="req">*</span>
                                </label>
                                <input type="text" name="RegistrationDate" autocomplete="off"/>
                            </div>
                        </div>
                        <button type="submit"  name="type" value="company"  class="button button-block">
                            Search
                        </button>
                    
                </div>
                    </form>
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
