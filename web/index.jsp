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
    <ul class="tab-group">
        <li class="tab active"><a href="#signup">Person</a></li>
        <li class="tab"><a href="#login">Company</a></li>
    </ul>
    <div class="tab-content">
        <div id="signup">
            <h1>User Registration</h1>

            <form action="RedirectServlet" method="post">

                <button type="submit" class="button button-block" name="page" value="registration.jsp">
                   New
                </button>
            </form>

            <form action="RedirectServlet" method="post">
                <button type="submit" class="button button-block" name="page" value="Search.jsp">
                    Search & Edit
                </button>
            </form>
        </div>

        <div id="login">
            <h1>Company</h1>

            <form action="RedirectServlet" method="post">
                <button type="submit" class="button button-block" name="page" value="registration.jsp">
                    New
                </button>
            </form>

            <form action="RedirectServlet" method="post">
                <button type="submit" class="button button-block" name="page" value="Search.jsp">
                    Search & Edit
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

