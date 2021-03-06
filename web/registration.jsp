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
            <h1>Registration</h1>

            <form action="RegistrationServlet" method="post">
                <div class="field-wrap">
                    <label>
                        NationaCode<span class="req">*</span>
                    </label>
                    <input type="text" name="nationalCode" required autocomplete="off" size="10" maxlength="10"/>
                </div>
                <div class="top-row">
                    <div class="field-wrap">
                        <label>
                            FirstName<span class="req">*</span>
                        </label>
                        <input type="text" name="firstName" required autocomplete="off"/>
                    </div>
                    <div class="field-wrap">
                        <label>
                            LastName<span class="req">*</span>
                        </label>
                        <input type="text" name="lastName" required autocomplete="off"/>
                    </div>
                </div>
                <div class="top-row">
                    <div class="field-wrap">
                        <label>
                            FatherName<span class="req">*</span>
                        </label>
                        <input type="text" name="fatherName" required autocomplete="off"/>
                    </div>
                    <div class="field-wrap">
                        <label>
                            Birthday<span class="req">*</span>
                        </label>
                        <input type="text" name="birthday" align="right" autocomplete="off">
                    </div>

                </div>
                <button type="submit" class="button button-block">
                    Submit
                </button>
            </form>
        </div>

        <div id="login">
            <h1>Company</h1>

            <form action="CompanyRegistration" method="post">
                <div class="top-row">
                    <div class="field-wrap">
                        <label>
                            Name<span class="req">*</span>
                        </label>
                        <input type="text" name="name" required autocomplete="on"/>
                    </div>

                    <div class="field-wrap">
                        <label>
                            economicCode<span class="req">*</span>
                        </label>
                        <input type="text" name="economicCode" required autocomplete="on"/>
                    </div>
                </div>
                <div class="field-wrap">
                    <label>
                        registrationDate<span class="req">*</span>
                    </label>
                    <input type="text" name="registrationDate" required autocomplete="off"/>
                </div>

                <button type="submit" class="button button-block">
                    Submit
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
