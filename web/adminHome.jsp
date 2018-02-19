<%-- 
    Document   : adminHome
    Created on : Jan 25, 2018, 12:34:46 AM
    Author     : SHUBHAM
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="db.DBConnector"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Home</title>
        <%@include file="header.jsp" %>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <%
        String username=(String)session.getAttribute("id");
        if(username==null || username.trim().equals(""))
        {
            response.sendRedirect("FirstP.jsp");
        }
        Statement st=DBConnector.getStatement();
        ArrayList<String> fac=new ArrayList<>();
        ArrayList<String> facname=new ArrayList<>();
        ArrayList<String> subcode=new ArrayList<>();
        ArrayList<String> subname=new ArrayList<>();
        try
            {
                ResultSet rsub=st.executeQuery("Select * from addsubject");
                while(rsub.next())
                {
                    subcode.add(rsub.getString(1));
                    subname.add(rsub.getString(2));
                }
            }
        catch(Exception e){}
    %>
    <body>
        <div class="container well">
      <ul class="nav nav-tabs">
        <li  class="active"><a data-toggle="tab" href="#home">Home</a></li>
        <li><a data-toggle="tab" href="#viewfaculty">View Faculty</a></li>
        <li><a data-toggle="tab" href="#addsubject">Add Subject</a></li>
        <li><a data-toggle="tab" href="#tt">Set Time Table</a></li>
        <li><a data-toggle="tab" href="#authfaculty">Authenticate Faculty</a></li>
        <li><a data-toggle="tab" href="#viewreport">Attendance Report</a></li>
        <li><a data-toggle="tab" href="#studentrecord">View Student Record</a></li>
        <li><a data-toggle="tab" href="#changepassword">Change Password</a></li>
      </ul><br>
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
        
        <div id="viewfaculty" class="tab-pane fade">
     <%
            try
            {
            ResultSet rs3=st.executeQuery("Select * from FACULTY");
      %>
        <table class="table table-responsive table-bordered table-hover"  id="myTableFaculty"> 
          <tbody>
            <tr class="header">
              <td><strong>Faculty ID :</strong></td>
              <td><strong>Name :</strong></td>
              <td><strong>Email :</strong></td>
              <td><strong>Phone No. :</strong></td>
              <td><strong>Account Status :</strong></td>
            </tr>
        <%  
             String fla="";
             while(rs3.next())
               {
                   fac.add(rs3.getString(1));
                   facname.add(rs3.getString(2));
               int flag=rs3.getInt(9);
               if(flag>0)
               {
                   fla="Active";
               }
               else
               {
                   fla="Deactive";
               }
        %>          
            <tr> 
              <td><%= rs3.getString(1)%></td>
              <td><%= rs3.getString(2)%></td>
              <td><%= rs3.getString(4)%></td>
              <td><%= rs3.getString(3)%></td>
              <td><%= fla%></td>
            </tr>
        <%      }
             }
             catch(SQLException e)
             {
                System.out.println(e);
             } 
        %>
            </tbody>
          </table>
        </div>
        
        <div id="tt" class="tab-pane fade">
            <form action="TimeTable" method="post">     
<%
    String[] t={"Monday","Tuesday","Wednesday","Thrusday","Friday"};
%>
<div class="col-lg-2 col-lg-offset-4">
    <select name="division" required>
        <option value="">--Select Branch--</option>
        <option value="IT">IT</option>
        <option value="CSE">CSE</option>
        <option value="EC">EC</option>
        <option value="EI">EI</option>
        <option value="CE">CE</option>
        <option value="AU">AU</option>
    </select>
</div>
	<table class="table table-bordered table-responsive">
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
                        <%
                          for (int i = 0; i <t.length; i++) {
                        %>
			<tr>
				<td><input type="text" value="<%=t[i]%>" name="days" hidden><strong><%=t[i]%></strong></td>
                                <%
                                  for (int j = 0; j < 8; j++) {
                                %>
                                <td>
                                    <select name="TTsubject" required>
                                        <option value="">--Select Subject--</option>
                                        <option value="free">Free Lecture</option>
                                        <%
                                            for (int subc = 0; subc < subcode.size(); subc++) {
                                        %>
                                        <option value="<%=subcode.get(subc)%>"><%=subcode.get(subc)%> : <%=subname.get(subc)%></option>   
                                        <%            
                                                }
                                        %>
                                    </select><br><br>
                                    <select name="TTfaculty" required>
                                        <option value="">--Select Faculty--</option>
                                        <%
                                            for (int fc = 0; fc < fac.size(); fc++) {
                                        %>
                                        <option value="<%=fac.get(fc)%>"><%=fac.get(fc)%> : <%=facname.get(fc)%></option>   
                                        <%            
                                                }
                                        %>
                                    </select>
                                </td>
                                <%
                                    }
                                %>
			</tr>
                        <%
                            }
                        %>
		</tbody>
	</table>
                <div style="padding-top: 30px;">
        <button type="submit" class="btn btn-warning" style="width:100px;height:50px;margin:auto;display:block">Save!</button>
                </div>
            </form>
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
        
    </div> 
  </div><br><br><br>
        <%@include file="footer.jsp" %>
    </body>
</html>
