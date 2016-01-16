<%--<%@ include file="index.jsp" %>--%>

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
        <div id="signup">
            <h1>Error Page</h1>

            <form action="RedirectServlet" method="post">
                   <hr> <%= request.getParameter("message") %> </h2>
                <button type="submit" class="button button-block" name="page" value="registration.jsp">
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

