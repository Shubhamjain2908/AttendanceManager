package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.SQLException;
import db.DBConnector;
import java.sql.ResultSet;

public final class adminHome_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Admin Home</title>\n");
      out.write("        ");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("<nav class=\"navbar navbar-inverse\">\n");
      out.write("  <div class=\"container-fluid\">\n");
      out.write("    <div class=\"navbar-header\">\n");
      out.write("      <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\n");
      out.write("        <span class=\"icon-bar\"></span>\n");
      out.write("        <span class=\"icon-bar\"></span>\n");
      out.write("        <span class=\"icon-bar\"></span>                        \n");
      out.write("      </button>\n");
      out.write("      <a class=\"navbar-brand\" href=\"#\">SJ Attendance Manager</a>\n");
      out.write("    </div>\n");
      out.write("    <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n");
      out.write("      <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                <li><a href=\"#\"><span class=\"glyphicon glyphicon-home\"></span> Home</a></li>\n");
      out.write("                <li><a href=\"#\"><span class=\"glyphicon glyphicon-user\"></span> About</a></li>\n");
      out.write("                <li><a href=\"logout.jsp\"><span class=\"glyphicon glyphicon-log-out\"></span> Logout</a></li>\n");
      out.write("            </ul>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("</nav>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("    </head>\n");
      out.write("    ");

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
    
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container well\">\n");
      out.write("      <ul class=\"nav nav-tabs\">\n");
      out.write("        <li  class=\"active\"><a data-toggle=\"tab\" href=\"#home\">Home</a></li>\n");
      out.write("        <li><a data-toggle=\"tab\" href=\"#viewfaculty\">View Faculty</a></li>\n");
      out.write("        <li><a data-toggle=\"tab\" href=\"#addsubject\">Add Subject</a></li>\n");
      out.write("        <li><a data-toggle=\"tab\" href=\"#tt\">Set Time Table</a></li>\n");
      out.write("        <li><a data-toggle=\"tab\" href=\"#authfaculty\">Authenticate Faculty</a></li>\n");
      out.write("        <li><a data-toggle=\"tab\" href=\"#viewreport\">Attendance Report</a></li>\n");
      out.write("        <li><a data-toggle=\"tab\" href=\"#studentrecord\">View Student Record</a></li>\n");
      out.write("        <li><a data-toggle=\"tab\" href=\"#changepassword\">Change Password</a></li>\n");
      out.write("      </ul><br>\n");
      out.write("    <div class=\"tab-content\">\n");
      out.write("     \t\n");
      out.write("        <div id=\"home\" class=\"tab-pane fade in active\">\n");
      out.write("            <div class=\"span10\">\n");
      out.write("            <center><img src=\"images/attendance_matters.jpg\" alt=\"Online Exam System\" height=\"300px\" width=\"650px\"/>  </center><br>\n");
      out.write("                <p style=\"font-weight: bold;font-size:20px;color:#808080;line-height: 25px;\">\n");
      out.write("                    <bold style=\"color:black;\">SJ Attendance Management System</bold>\n");
      out.write("                    <dl>\n");
      out.write("                        <dt><strong>Features :</strong></dt><br>\n");
      out.write("                        <dd>- Time Saver.</dd>\n");
      out.write("                        <dd>- Help the students to track their attendance.</dd>\n");
      out.write("                        <dd>- Synchronize with your attendance device.</dd>\n");
      out.write("                        <dd>- Mark attendance from your mobile.</dd>\n");
      out.write("                        <dd>- Regularize attendance data.</dd>\n");
      out.write("                        <dd>- Compile attendance in a particular interval.</dd>\n");
      out.write("                        <dd>- Extract ready-made reports.</dd>\n");
      out.write("                        <dd>- View Attendance instantly.</dd>\n");
      out.write("                    </dl>\n");
      out.write("                </p>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div id=\"viewfaculty\" class=\"tab-pane fade\">\n");
      out.write("     ");

            try
            {
            ResultSet rs3=st.executeQuery("Select * from FACULTY");
      
      out.write("\n");
      out.write("        <table class=\"table table-responsive table-bordered table-hover\"  id=\"myTableFaculty\"> \n");
      out.write("          <tbody>\n");
      out.write("            <tr class=\"header\">\n");
      out.write("              <td><strong>Faculty ID :</strong></td>\n");
      out.write("              <td><strong>Name :</strong></td>\n");
      out.write("              <td><strong>Email :</strong></td>\n");
      out.write("              <td><strong>Phone No. :</strong></td>\n");
      out.write("              <td><strong>Account Status :</strong></td>\n");
      out.write("            </tr>\n");
      out.write("        ");
  
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
        
      out.write("          \n");
      out.write("            <tr> \n");
      out.write("              <td>");
      out.print( rs3.getString(1));
      out.write("</td>\n");
      out.write("              <td>");
      out.print( rs3.getString(2));
      out.write("</td>\n");
      out.write("              <td>");
      out.print( rs3.getString(4));
      out.write("</td>\n");
      out.write("              <td>");
      out.print( rs3.getString(3));
      out.write("</td>\n");
      out.write("              <td>");
      out.print( fla);
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("        ");
      }
             }
             catch(SQLException e)
             {
                System.out.println(e);
             } 
        
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("          </table>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div id=\"tt\" class=\"tab-pane fade\">\n");
      out.write("            <form action=\"TimeTable\" method=\"post\">     \n");

    String[] t={"Monday","Tuesday","Wednesday","Thrusday","Friday"};

      out.write("\n");
      out.write("<div class=\"col-lg-2 col-lg-offset-4\">\n");
      out.write("    <select name=\"division\" required>\n");
      out.write("        <option value=\"\">--Select Branch--</option>\n");
      out.write("        <option value=\"IT\">IT</option>\n");
      out.write("        <option value=\"CSE\">CSE</option>\n");
      out.write("        <option value=\"EC\">EC</option>\n");
      out.write("        <option value=\"EI\">EI</option>\n");
      out.write("        <option value=\"CE\">CE</option>\n");
      out.write("        <option value=\"AU\">AU</option>\n");
      out.write("    </select>\n");
      out.write("</div>\n");
      out.write("\t<table class=\"table table-bordered table-responsive\">\n");
      out.write("\t\t<tbody>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td><strong>Time - </strong><br><strong>Days |</strong></td>\n");
      out.write("\t\t\t\t<td><input type=\"text\" value=\"08:30 - 09:25\" name=\"time\" hidden><strong>08:30 - 09:25</strong></td>\n");
      out.write("\t\t\t\t<td><input type=\"text\" value=\"09:30 - 10:25\" name=\"time\" hidden><strong>09:30 - 10:25</strong></td>\n");
      out.write("\t\t\t\t<td><input type=\"text\" value=\"10:30 - 11:20\" name=\"time\" hidden><strong>10:30 - 11:20</strong></td>\n");
      out.write("\t\t\t\t<td><input type=\"text\" value=\"11:25 - 12:15\" name=\"time\" hidden><strong>11:25 - 12:15</strong></td>\n");
      out.write("\t\t\t\t<td><input type=\"text\" value=\"01:15 - 02:05\" name=\"time\" hidden><strong>01:15 - 02:05</strong></td>\n");
      out.write("\t\t\t\t<td><input type=\"text\" value=\"02:10 - 03:00\" name=\"time\" hidden><strong>02:10 - 03:00</strong></td>\n");
      out.write("\t\t\t\t<td><input type=\"text\" value=\"03:05 - 04:00\" name=\"time\" hidden><strong>03:05 - 04:00</strong></td>\n");
      out.write("\t\t\t\t<td><input type=\"text\" value=\"04:05 - 05:00\" name=\"time\" hidden><strong>04:05 - 05:00</strong></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("                        ");

                          for (int i = 0; i <t.length; i++) {
                        
      out.write("\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td><input type=\"text\" value=\"");
      out.print(t[i]);
      out.write("\" name=\"days\" hidden><strong>");
      out.print(t[i]);
      out.write("</strong></td>\n");
      out.write("                                ");

                                  for (int j = 0; j < 8; j++) {
                                
      out.write("\n");
      out.write("                                <td>\n");
      out.write("                                    <select name=\"TTsubject\" required>\n");
      out.write("                                        <option value=\"\">--Select Subject--</option>\n");
      out.write("                                        <option value=\"free\">Free Lecture</option>\n");
      out.write("                                        ");

                                            for (int subc = 0; subc < subcode.size(); subc++) {
                                        
      out.write("\n");
      out.write("                                        <option value=\"");
      out.print(subcode.get(subc));
      out.write('"');
      out.write('>');
      out.print(subcode.get(subc));
      out.write(" : ");
      out.print(subname.get(subc));
      out.write("</option>   \n");
      out.write("                                        ");
            
                                                }
                                        
      out.write("\n");
      out.write("                                    </select><br><br>\n");
      out.write("                                    <select name=\"TTfaculty\" required>\n");
      out.write("                                        <option value=\"\">--Select Faculty--</option>\n");
      out.write("                                        ");

                                            for (int fc = 0; fc < fac.size(); fc++) {
                                        
      out.write("\n");
      out.write("                                        <option value=\"");
      out.print(fac.get(fc));
      out.write('"');
      out.write('>');
      out.print(fac.get(fc));
      out.write(" : ");
      out.print(facname.get(fc));
      out.write("</option>   \n");
      out.write("                                        ");
            
                                                }
                                        
      out.write("\n");
      out.write("                                    </select>\n");
      out.write("                                </td>\n");
      out.write("                                ");

                                    }
                                
      out.write("\n");
      out.write("\t\t\t</tr>\n");
      out.write("                        ");

                            }
                        
      out.write("\n");
      out.write("\t\t</tbody>\n");
      out.write("\t</table>\n");
      out.write("                <div style=\"padding-top: 30px;\">\n");
      out.write("        <button type=\"submit\" class=\"btn btn-warning\" style=\"width:100px;height:50px;margin:auto;display:block\">Save!</button>\n");
      out.write("                </div>\n");
      out.write("            </form>\n");
      out.write("        </div>    \n");
      out.write("            \n");
      out.write("        <div id=\"attendance\" class=\"tab-pane fade\">\n");
      out.write("        \tM2\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div id=\"compiled\" class=\"tab-pane fade\">\n");
      out.write("        \tHome\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("        <div id=\"viewreport\" class=\"tab-pane fade\">\n");
      out.write("        \tHome\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("    </div> \n");
      out.write("  </div><br><br><br>\n");
      out.write("        ");
      out.write("\n");
      out.write("<link rel=\"stylesheet\" href=\"assets/et-line-font-plugin/style.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Montserrat:400,700\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"assets/web/assets/mobirise-icons/mobirise-icons.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic&subset=latin\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"assets/bootstrap-material-design-font/css/material.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"assets/tether/tether.min.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"assets/bootstrap/css/bootstrap.min.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"assets/animate.css/animate.min.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"assets/dropdown/css/style.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"assets/theme/css/style.css\">\n");
      out.write("  <link rel=\"stylesheet\" href=\"assets/mobirise/css/mbr-additional.css\" type=\"text/css\">  \n");
      out.write("  \n");
      out.write("<section class=\"mbr-footer footer4 mbr-section mbr-section-md-padding mbr-parallax-background\" id=\"contacts4-a\" data-rv-view=\"27\" style=\"background-image: url(assets/images/jumbotron.jpg); padding-top: 30px; padding-bottom: 30px;\">\n");
      out.write("    <div class=\"mbr-overlay\" style=\"opacity: 0.8; background-color: rgb(60, 60, 60);\"></div>\n");
      out.write("    <div class=\"container\">\n");
      out.write("        <div class=\"mbr-contacts row\">\n");
      out.write("            <div class=\"col-sm-8\">\n");
      out.write("                <div class=\"row\">\n");
      out.write("                    <div class=\"col-sm-6\">\n");
      out.write("                        <p><strong>Developer</strong><br><em><strong>Shubham Jain</strong><strong><br></strong></em><br>\n");
      out.write("<strong>Contacts</strong><br>\n");
      out.write("Email: shubhamjan2908@gmail.com<br>Mobile: +91- 8871574375<br>Phone: 0731-4095911</p>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"col-sm-6\"><p class=\"mbr-contacts__text\">Address&nbsp;</p><ul class=\"mbr-contacts__list\"><li>31 Greater Vaishali</li><li>452009</li><li>Indore (M.P)</li></ul></div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"col-sm-4\" data-form-type=\"formoid\">\n");
      out.write("                <div data-form-alert=\"true\">\n");
      out.write("                    <div hidden=\"\" data-form-alert-success=\"true\">Thanks for filling out form!</div>\n");
      out.write("                </div>\n");
      out.write("                <form action=\"#\" method=\"post\" data-form-title=\"MESSAGE\">\n");
      out.write("                    <input type=\"hidden\" value=\"eCjEzeYXvMF9KV2gFKra2R4sIVacoDtYQOm7IuJ0Se0DVa2SE154Svh/SU6TBGoSrFKfjef54z4ed1gw2l8vHGy4q+Erz+m80DZw4HtDMAkr4+FKSzetVZjdvF9+gl14\" data-form-email=\"true\">\n");
      out.write("                    \n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label class=\"form-control-label\" for=\"contacts4-a-email\">Email<span class=\"form-asterisk\">*</span></label>\n");
      out.write("                        <input type=\"email\" class=\"form-control input-sm input-inverse\" name=\"email\" required=\"\" data-form-field=\"Email\" id=\"contacts4-a-email\">\n");
      out.write("                    </div>\n");
      out.write("                    \n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <label class=\"form-control-label\" for=\"contacts4-a-message\">Message</label>\n");
      out.write("                        <textarea class=\"form-control input-sm input-inverse\" name=\"message\" data-form-field=\"Message\" rows=\"4\" id=\"contacts4-a-message\"></textarea>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"mbr-buttons mbr-buttons--right btn-inverse\"><button type=\"submit\" class=\"btn btn-sm btn-black\">Contact us</button></div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</section>\n");
      out.write("\n");
      out.write("<footer class=\"mbr-small-footer mbr-section mbr-section-nopadding\" id=\"footer1-b\" data-rv-view=\"36\" style=\"background-color: rgb(50, 50, 50); padding-top: 1.75rem; padding-bottom: 1.75rem;\">\n");
      out.write("    \n");
      out.write("    <div class=\"container text-xs-center\">\n");
      out.write("        <p>Copyright (c) 2018 SJ All Rights Reserved..</p>\n");
      out.write("    </div>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("\n");
      out.write("  <script src=\"assets/web/assets/jquery/jquery.min.js\"></script>\n");
      out.write("  <script src=\"assets/tether/tether.min.js\"></script>\n");
      out.write("  <script src=\"assets/bootstrap/js/bootstrap.min.js\"></script>\n");
      out.write("  <script src=\"assets/viewport-checker/jquery.viewportchecker.js\"></script>\n");
      out.write("  <script src=\"assets/touch-swipe/jquery.touch-swipe.min.js\"></script>\n");
      out.write("  <script src=\"assets/smooth-scroll/smooth-scroll.js\"></script>\n");
      out.write("  <script src=\"assets/jquery-mb-ytplayer/jquery.mb.ytplayer.min.js\"></script>\n");
      out.write("  <script src=\"assets/jarallax/jarallax.js\"></script>\n");
      out.write("  <script src=\"assets/dropdown/js/script.min.js\"></script>\n");
      out.write("  <script src=\"assets/theme/js/script.js\"></script>\n");
      out.write("  <script src=\"assets/formoid/formoid.min.js\"></script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
