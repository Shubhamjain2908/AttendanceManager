<%-- 
    Document   : Register
    Created on : Jan 25, 2018, 12:01:42 AM
    Author     : SHUBHAM
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Sign Up form</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" href="assets/css/form-elements.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">

    </head>

    <body>
        <script type="text/javascript">
		function al() 
                {
                    var enrollment=document.getElementById('enrollment').value;
                    var res=enrollment.slice(0,4);
                    var branch=enrollment.slice(4,6);
                    var year=enrollment.slice(6,8);
                    var ending= parseInt(year) + 4;
                    document.getElementById('branch').value=branch;
                    document.getElementById('sess').value="20"+year + " - 20" + ending;
                    if(parseInt(res) == 0812)
                    {
                        document.getElementById("college").value = 'MITM'; 
                    }
                    else if(parseInt(res) == 0827)
                    {
                        document.getElementById("college").value = 'MIST'; 
                    }
                    else
                    {
                        document.getElementById("college").value = 'Other College'; 
                    }
		}
	</script>
        <!-- Top content -->
        <div class="top-content">

            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                            <h1><strong>Registration</strong></h1>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                            <div class="form-top">
                                <div class="form-top-left">
                                    <h3>SignUp to Portal</h3>
                                </div>
                                <div class="form-top-right">
                                    <i class="fa fa-lock"></i>
                                </div>
                            </div>
                            <div class="form-bottom">
                                <form role="form" name="regS" action="Checker" method="post" class="login-form">
                                    <div class="form-group">
                                        <div class="selectContainer">
                                        <select class="form-control" name="user" required>
                                            <option value="">--Select User--</option>
                                            <option value="facultyRegistration">Faculty</option>
                                            <option value="studentRegistration">Student</option>
                                        </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="name">Name</label>
                                        <input type="text" name="name" placeholder="Full Name..." class="name form-control" id="name" required>
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="enrollment">Enrollment No</label>
                                        <input type="text" name="id" maxlength="12" placeholder="Enrollment No..." class="enrollment form-control" id="enrollment" required onkeyup="al();">
                                    </div>
                                    <div id="studentcheck"><strong></strong></div>
                                    <div class="form-group">
                                        <label class="sr-only" for="email">E-mail</label>
                                        <input type="email" name="email" placeholder="E-mail ID..." class="email form-control" id="email">
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="pno">Phone Number</label>
                                        <input type="tel" name="number" maxlength="10" required placeholder="Phone No..." class="pno form-control" id="pno">
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="dob">Date</label>
                                        <input type="date" name="dob" pattern="\d{1,2}/\d{1,2}/\d{4}" required placeholder="DOB..." class="date form-control" id="date">
                                    </div>
                                    <div class="form-group">
                                        <div class="selectContainer">
                                        <select class="form-control" name="sex" required>
                                            <option value="">--Select Gender--</option>
                                            <option value="Male">Male</option>
                                            <option value="Female">Female</option>
                                            <option value="Others">Others</option>
                                        </select>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="selectContainer">
                                            <label class="sr-only" for="branch">Branch</label>
                                            <input hidden type="text" name="branch" placeholder="Branch..." class="name form-control" id="branch" required>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                       <div class="selectContainer">
                                            <label class="sr-only" for="sess">Session</label>
                                            <input hidden type="text" name="sess" placeholder="Session..." class="name form-control" id="sess" required>
                                        </div> 
                                    </div>
                                    <div class="form-group">
                                       <div class="selectContainer">
                                            <label class="sr-only" for="college">College</label>
                                            <input hidden type="text" name="college" placeholder="College..." class="name form-control" id="college" required>
                                        </div> 
                                    </div>
                                    <div class="form-group">
                                       <div class="selectContainer">
                                            <label class="sr-only" for="address">Address</label>
                                            <textarea type="text" name="address" placeholder="Enter your complete Address..." class="name form-control" id="address"></textarea>
                                        </div> 
                                    </div>
                                    <div class="form-group">
                                        <label class="sr-only" for="password">Password</label>
                                        <input type="password" name="password" required placeholder="Password..." class="password form-control" id="password">
                                    </div>
                                    <button type="submit" class="btn">Sign Up!</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>    
        </div>

        <!-- Javascript -->
        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/scripts.js"></script>
    </body>

</html>
