<%--<%@ include file="index.jsp" %>--%>

<%@page import="customers.Person" %>
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
    <div>


        <div id="peron">
            <h1>Person</h1>

            <form action="RedirectServlet" method="post">
                <% Person person = (Person) request.getAttribute("person");
                %>
                <div class="top-row">
                    <div class="field-wrap">
                        <label> <span class="active"></span>
                            FirstName
                        </label>
                        <input type="text" value=<%= person.getFirstName()%> required name="FirstName" disabled
                               autocomplete="on"/>
                    </div>
                    <div class="field-wrap">
                        <label> <span class="active"></span>
                            LastName
                        </label>
                        <input type="text" value=<%= person.getLastName()%>  required name="LastName" disabled
                               autocomplete="on"/>
                    </div>

                </div>
                <div class="top-row">
                    <div class="field-wrap">
                        <label> <span class="active"></span>
                            CustomerNumber
                        </label>
                        <input type="text" value=<%= person.getCustomerNumber()%> required name="CustomerNumber"
                               disabled autocomplete="off"/>
                    </div>
                    <div class="field-wrap">
                        <label> <span class="active"></span>
                            NationalCode
                        </label>
                        <input type="text" value=<%= person.getNationalCode()%>  required name="NationalCode" disabled
                               autocomplete="on"/>
                    </div>
                </div>

                <div class="top-row">
                    <div class="field-wrap">
                        <label> <span class="active"></span>
                            registrationDate
                        </label>
                        <input type="text" value=<%= person.getFatherName()  %> name="FatherName" disabled required
                               autocomplete="off"/>
                    </div>
                    <div class="field-wrap">
                        <label> <span class="active"></span>
                            Birthday
                        </label>
                        <input type="text" value=<%= person.getBirthday() %>  name="Birthday" required disabled
                               autocomplete="on"/>
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
