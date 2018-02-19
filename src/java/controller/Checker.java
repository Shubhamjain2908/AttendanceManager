/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.DTO;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Authtenticator;

/**
 *
 * @author SHUBHAM
 */
public class Checker extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.sendRedirect("FirstP.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String user=request.getParameter("user");
        String id=request.getParameter("id");
        String password=request.getParameter("password");
        String generatedPassword="";
        
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e)
        {
            System.out.println(e);
        }
        
        DTO d=new DTO();
        System.gc();
        d.setId(id);
        d.setPassword(generatedPassword);
        
        Authtenticator a=new Authtenticator();
        System.gc();
/******************************************************************************************************/        
        //Admin Login
        if (user.equals("adminLogin")) 
        {
            boolean aL=a.isAdminLogin(d);
            if(aL)
            {
                HttpSession session=request.getSession(true);
                session.setAttribute("id",id);
                RequestDispatcher rd=request.getRequestDispatcher("adminHome.jsp");
                rd.forward(request, response);
            }
            else
            {
                response.sendRedirect("FirstP.jsp");
            }
        }
        
        //Faculty Login
        if (user.equals("facultyLogin")) 
        {
            boolean fL=a.isFacultyLogin(d);
            if(fL)
            {
                HttpSession session=request.getSession(true);
                session.setAttribute("id",id);
                RequestDispatcher rd=request.getRequestDispatcher("facultyHome.jsp");
                rd.forward(request, response);
            }
            else
            {
                response.sendRedirect("FirstP.jsp");
            }
        }
        
        //Student Login
        if (user.equals("studentLogin")) 
        {
            boolean sL=a.isStudentLogin(d);
            if(sL)
            {
                HttpSession session=request.getSession(true);
                session.setAttribute("id",id);
                RequestDispatcher rd=request.getRequestDispatcher("studentHome.jsp");
                rd.forward(request, response);
            }
            else
            {
                response.sendRedirect("FirstP.jsp");
            }
        }
        
        //Student Registration
        if(user.equals("studentRegistration"))
        {
            //String enrollment=request.getParameter("enrollment");
            String name=request.getParameter("name");
            String email=request.getParameter("email");
            String number=request.getParameter("number");
            String dob=request.getParameter("dob");
            String gender=request.getParameter("sex");
            String branch=request.getParameter("branch");
            String sess = request.getParameter("sess");
            String division = request.getParameter("division");
            String address=request.getParameter("address");
            
            //d.setEnrollment(enrollment);
            d.setName(name);
            d.setEmail(email);
            d.setNumber(number);
            d.setDob(dob);
            d.setGender(gender);
            d.setBranch(branch);
            d.setSession(sess);
            d.setDivision(division);
            d.setAddress(address);
            
            boolean sr=a.isStudentRegistered(d);
            
            if(sr)
            {
                System.out.println("Registration Successfull");
                HttpSession session=request.getSession(true);
                session.setAttribute("id",id);
                RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                rd.forward(request, response);
            }
            else
            {
                response.sendRedirect("FirstP.jsp");
            }
        }
        
        //Faculty Registration
        if(user.equals("facultyRegistration"))
        {
            //String facultyid=request.getParameter("facultyid");
            String name=request.getParameter("name");
            String email=request.getParameter("email");
            String number=request.getParameter("number");
            String dob=request.getParameter("dob");
            String gender=request.getParameter("sex");
            String address=request.getParameter("address");
            
            //d.setEnrollment(facultyid);
            d.setName(name);
            d.setEmail(email);
            d.setNumber(number);
            d.setDob(dob);
            d.setGender(gender);
            d.setAddress(address);
            
            boolean fr=a.isFacultyRegistered(d);
            
            if(fr)
            {
                HttpSession session=request.getSession(true);
                RequestDispatcher rd=request.getRequestDispatcher("facultyHome.jsp");
                rd.forward(request, response);
                System.out.println("Registration Successfull");
            }
            else
            {
                response.sendRedirect("FirstP.jsp");
            }
        }
        
        if(user.equals("facultyTT"))
        {
            String facultyid=request.getParameter("facultyid");
            String day=request.getParameter("day");
            String time=request.getParameter("time");
            String lecture=request.getParameter("lecture");
            String division=request.getParameter("division");
            
            d.setFacultyid(facultyid);
            d.setDays(day);
            d.setTime(time);
            d.setLecture(lecture);
            d.setDivision(division);
            
            boolean ftt=a.isFacultyTT(d);
            
            if(ftt)
            {
                System.out.println("Time Table");
            }
            else
            {
                response.sendRedirect("FirstP.jsp");
            }
        }
        
        if(user.equals("attend"))
        {
            String enrollment=request.getParameter("enrollment");
            String date=request.getParameter("date");
            String lecture=request.getParameter("lecture");
            String status=request.getParameter("status");
            String faculty=request.getParameter("facultyid");
            
            d.setEnrollment(enrollment);
            d.setStartingDate(date);
            d.setLecture(lecture);
            d.setStatus(status);
            d.setFacultyid(faculty);
            
            boolean attend=a.isAttend(d);
            
            if(attend)
            {
                System.out.println("Attendence taken Successfully");
            }
            else
            {
                response.sendRedirect("FirstP.jsp");
            }
        }
        
        if(user.equals("compiled"))
        {
            String enrollment=request.getParameter("enrollment");
            String startingdate=request.getParameter("startingdate");
            String endingdate=request.getParameter("endingdate");
            String percentage=request.getParameter("percentage");
            
            d.setEnrollment(enrollment);
            d.setStartingDate(startingdate);
            d.setEndingDate(endingdate);
            d.setPercentage(percentage);
            
            boolean compiled=a.isCompiled(d);
            
            if(compiled)
            {
                System.out.println("Compiled Successfully");
            }
            else
            {
                response.sendRedirect("FirstP.jsp");
            }
        }
        
/******************************************************************************************************/    
    }   
}