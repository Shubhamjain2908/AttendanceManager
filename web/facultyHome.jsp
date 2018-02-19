<%-- 
    Document   : facultyHome
    Created on : Jan 25, 2018, 1:15:21 AM
    Author     : SHUBHAM
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="db.DBConnector"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Faculty Home</title>
        <%@include file="header.jsp" %>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <%
        String facultyid=(String)session.getAttribute("id");
        Statement st=DBConnector.getStatement();
        ResultSet rsAA=null;
        String name="",number="",email="",gender="",dob="",address="";
        ArrayList<String> lectureA=new ArrayList<>();
        ArrayList<String> divisionA=new ArrayList<>();
        String dayA[]={"Monday","Tuesday","Wednesday","Thrusday","Friday"};
        String timeA[]={"08:30 - 09:25","09:30 - 10:25","10:30 - 11:20","11:25 - 12:15","01:15 - 02:05","02:10 - 03:00","03:05 - 04:00","04:05 - 05:00"};
        int lc=0;   
        int flag=0;
        try
        {
            ResultSet rs=st.executeQuery("Select * from faculty where facultyid='"+facultyid+"'");
            while(rs.next())
            {
                name=rs.getString(2);
                number=rs.getString(3);
                email=rs.getString(4);
                gender=rs.getString(5);
                dob=rs.getString(6);
                address=rs.getString(7);
                flag=rs.getInt(9);
            }
            
                for (int i = 0; i < dayA.length; i++) 
                {
                    String dayAA=dayA[i];
                    for (int j = 0; j < timeA.length; j++) 
                    {
                        String timeAA=timeA[j];
                        String query="SELECT lecture,division FROM facultytt WHERE days='"+dayAA+"' AND time='"+timeAA+"' AND facultyid = '"+facultyid+"';"; 
                        rsAA=st.executeQuery(query);
                        if(rsAA.next())
                        {
                            lectureA.add(rsAA.getString(1));
                            divisionA.add(rsAA.getString(2));
                        }
                        else
                        {
                            lectureA.add("free");
                            divisionA.add("free");
                        }
                    }
                }
                for (int k = 0; k < lectureA.size(); k++) 
                {
                    System.out.println(lectureA.get(k) + " " +divisionA.get(k));
                }
        }
        catch(Exception e)
        {
            System.out.println(e);
        } 
    %>
   <body>
        <div class="container well">
      <ul class="nav nav-tabs">
        <li  class="active"><a data-toggle="tab" href="#home">Home</a></li>
        <li><a data-toggle="tab" href="#profile">Profile</a></li>
        <li><a data-toggle="tab" href="#tt">Time Table</a></li>
        <li><a data-toggle="tab" href="#attendance">Attendance</a></li>
        <li><a data-toggle="tab" href="#compiled">Compile Attendance</a></li>
        <li><a data-toggle="tab" href="#viewreport">Attendance Report</a></li>
        <li><a data-toggle="tab" href="#changepassword">Change Password</a></li>
      </ul><br>
      <%
          if(flag==0)
          {
            out.print("<font color='red' m>");
            out.print("<Marquee><h4>Not an Authorised Faculty!</h4></Marquee>");
            out.print("</font>");
          }
      %>
    <div class="tab-content">
     	<div id="home" class="tab-pane fade in active">
        	<div class="span10">
          <center><img src="images/attendance_matters.jpg" alt="Online Exam System" height="300px" width="650px"/>  </center><br>
        <p style="font-weight: bold;font-size:20px;color:#808080;line-height: 25px;">
            <bold style="color:black;">SJ Attendance Management System</bold>
                <dl>
                    <dt><strong>Features :</strong></dt><br>
                    <dd>- Time Saver.</dd>
                    <dd>- Help the students to track their attendance.</dd>
                    <dd>- Synchronize with your attendance device.</dd>
                    <dd>- Mark attendance from your mobile.</dd>
                    <dd>- Regularize attendance data.</dd>
                    <dd>- Compile attendance in a particular interval.</dd>
                    <dd>- Extract ready-made reports.</dd>
                    <dd>- View Attendance instantly.</dd>
                </dl>
        </p>
     </div>
        </div>
        <div id="profile" class="tab-pane fade">
            <div class="col-lg-5 col-lg-offset-3">
            <form action="EditData" method="post">
                <table class="table table-responsive table-inverse">
                    <tbody>
                        <tr>
                            <td><strong>Name</strong></td>
                            <td><%=name%></td>
                        </tr>
                        <tr>
                            <td><strong>ID</strong></td>
                            <td><%=facultyid%></td>
                        </tr>
                        <tr>
                            <td><strong>Phone Number</strong></td>
                            <td><%=number%></td>
                        </tr>
                        <tr>
                            <td><strong>Email</strong></td>
                            <td><%=email%></td>
                        </tr>
                        <tr>
                            <td><strong>DOB</strong></td>
                            <td><%=dob%></td>
                        </tr>
                        <tr>
                            <td><strong>Gender</strong></td>
                            <td><%=gender%></td>
                        </tr>
                        <tr>
                            <td><strong>Address</strong></td>
                            <td><%=address%></td>
                        </tr>
                    </tbody>
                </table><br>
                <a href="#" data-toggle="modal" data-target="#editModal">Edit your profile</a>
                <input hidden type="text" value="facultyProfileEdit" name="about"/>
                <input hidden type="text" value="<%=facultyid%>" name="id"/>
                <div id="editModal" class="modal fade" role="dialog">
                    <div class="modal-dialog">

                      <!-- Modal content-->
                      <div class="modal-content">

                        <div class="modal-header">
                          <button type="button" class="close" data-dismiss="modal">&times;</button>
                          <h4 class="modal-title">Edit</h4>
                        </div>

                        <div class="modal-body">
                            <table class="table table-striped table-hover">
                                <tbody>
                                    <tr>
                                        <td>Name :</td>
                                        <td><%=name%></td>
                                    </tr>
                                    <tr>
                                        <td>Email :</td>
                                        <td><input type="email" name="email" class="form-control" value="<%=email%>" placeholder="Email..."/></td>
                                    </tr>
                                    <tr>
                                        <td>Mobile Number :</td>
                                        <td><input type="number" name="number" max="9999999999" class="form-control" value="<%=number%>" placeholder="10 digit number"/></td>
                                    </tr>
                                    <tr>
                                        <td>DOB :</td>
                                        <td><input type="date" name="dob" class="form-control" value="<%=dob%>" placeholder="Date of Birth"/></td>
                                    </tr>
                                    <tr>
                                        <td>Address :</td>
                                        <td><textarea type="Address" name="address" class="form-control" placeholder="Full Address"><%=address%></textarea></td>
                                    </tr>
                                    <tr>
                                        <td><button type="reset" value="res" name="res" class="btn btn-info "><span class="glyphicon glyphicon-adjust"></span> Reset</button></td>
                                        <td><button type="submit" value="res" name="sub" class="btn btn-success "><span class="glyphicon glyphicon-edit"></span> Submit</button></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                        <div class="modal-footer">
                            <button type="button" class="btn btn-default btn-block" data-dismiss="modal"><span class="glyphicon glyphicon-cloud"></span> Close</button>
                        </div>

                      </div>

                    </div>
                </div>
            </form>
           </div>
        </div>
<%
    if(flag>0){
%>       

        <div id="tt" class="tab-pane fade">
            <div >
                <form>
                    <table class="table table-responsive table-bordered">
                        <tbody>
                            <tbody>
			<tr>
                            <td><strong>Time - </strong><br><strong>Days |</strong></td>
                            <td><input type="text" value="08:30 - 09:25" name="time" hidden><strong>08:30 - 09:25</strong></td>
                            <td><input type="text" value="09:30 - 10:25" name="time" hidden><strong>09:30 - 10:25</strong></td>
                            <td><input type="text" value="10:30 - 11:20" name="time" hidden><strong>10:30 - 11:20</strong></td>
                            <td><input type="text" value="11:25 - 12:15" name="time" hidden><strong>11:25 - 12:15</strong></td>
                            <td><input type="text" value="01:15 - 02:05" name="time" hidden><strong>01:15 - 02:05</strong></td>
                            <td><input type="text" value="02:10 - 03:00" name="time" hidden><strong>02:10 - 03:00</strong></td>
                            <td><input type="text" value="03:05 - 04:00" name="time" hidden><strong>03:05 - 04:00</strong></td>
                            <td><input type="text" value="04:05 - 05:00" name="time" hidden><strong>04:05 - 05:00</strong></td>
			</tr>
                        <% for (int l = 0; l < dayA.length; l++) 
                        {
                        %>
                        <tr>
                            <td><Strong><%=dayA[l]%></strong></td>
                            <%for (int l1 = 0; l1 < 8; l1++) 
                            {
                            %>
                            <td>
                                <%=lectureA.get(lc)%><br>
                                &nbsp;&nbsp;&nbsp;&nbsp;(<%=divisionA.get(lc)%>)
                            </td>
                            <%
                                lc++; 
                            }
                            %>
                        </tr>

                        <%    
                        }
                        %>
                        </tbody>
                    </table>
                </form>
            </div>
        </div>

        <div id="attendance" class="tab-pane fade">
        	M2
        </div>

        <div id="compiled" class="tab-pane fade">
        	Home
        </div>

        <div id="viewreport" class="tab-pane fade">
        	Home
        </div>

<%
    }
%>        
    </div> 
  </div><br><br><br>
        <%@include file="footer.jsp" %>
    </body>
</html>
