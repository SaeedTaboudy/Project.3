<%--<%@ include file="index.jsp" %>--%>

<%@page import="customers.Company" %>
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
        <!--        <li class="tab active"><a href="#signup">Person</a></li>
                <li class="tab"><a href="#login">Company</a></li>-->
    </ul>
    <div>


        <div id="company">
            <h1>Company</h1>

            <form action="RedirectServlet" method="post">
                <% Company company = (Company) request.getAttribute("company");
                %>
                <div class="top-row">
                    <div class="field-wrap">
                        <label> <span class="active"></span>
                            Name
                        </label>
                        <input type="text" value=<%= company.getName()%> name="Name" disabled/>
                    </div>
                    <div class="field-wrap">
                        <label> <span class="active"></span>
                            CustomerNumber
                        </label>
                        <input type="text" value=<%= company.getCustomerNumber() %> name="CustomerNumber" disabled/>
                    </div>

                </div>
                <div class="top-row">
                    <div class="field-wrap">
                        <label> <span class="active"></span>
                            registrationDate
                        </label>
                        <input type="text" value=<%= company.getRegistrationDate()%> required name="RegistrationDate"
                               disabled/>
                    </div>
                    <div class="field-wrap">
                        <label> <span class="active"></span>
                            EconomicCode
                        </label>
                        <input type="text" value=<%= company.getEconomicCode()%>  name="EconomicCode" disabled/>
                    </div>
                </div>
                <button type="submit" class="button button-block" name="page" value="index.jsp">
                    Back
                </button>
            </form>
        </div>

    </div>
    <!-- tab-content -->

</div>
<!-- /form -->
<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

<script src="js/index.js"></script>


</body>
</html>
