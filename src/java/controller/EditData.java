/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.DTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Authtenticator;

/**
 *
 * @author SHUBHAM
 */
public class EditData extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.sendRedirect("FirstP.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        PrintWriter out = response.getWriter();
        String about=request.getParameter("about");
        DTO d=new DTO();
        d.setAbout(about);
        Authtenticator a=new Authtenticator();
        
        if(about.equals("facultyProfileEdit") || about.equals("studentProfileEdit"))
        {
            String facultyid=request.getParameter("id");
            String email=request.getParameter("email");
            String number=request.getParameter("number");
            String dob=request.getParameter("dob");
            String address=request.getParameter("address");
            
            d.setId(facultyid);
            d.setEmail(email);
            d.setNumber(number);
            d.setDob(dob);
            d.setAddress(address);
            
            boolean edited= a.isProfileEdit(d);
            
            if(edited)
            {
                System.out.println("Edited");
                if(about.equals("facultyProfileEdit") )
                {
                    response.sendRedirect("facultyHome.jsp");
                }
                if(about.equals("studentProfileEdit") )
                {
                    response.sendRedirect("studentHome.jsp");
                }
            }
            else
            {
                response.sendRedirect("FirstP.jsp");
            }
        }
    }
    
}