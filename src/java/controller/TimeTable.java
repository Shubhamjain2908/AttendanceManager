/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dto.DTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Authtenticator;

/**
 *
 * @author SHUBHAM
 */
public class TimeTable extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        response.sendRedirect("adminHome.jsp");
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        String division=request.getParameter("division");
        String[] time=request.getParameterValues("time");
        String[] days=request.getParameterValues("days");
        String[] subject=request.getParameterValues("TTsubject");
        String[] faculty=request.getParameterValues("TTfaculty");
        int k=0;
        
        DTO dto=new DTO();
        System.gc();
        
        Authtenticator t=new Authtenticator();
        
        for (int i = 0; i < days.length; i++) 
        {
            String d=days[i];
            
            System.out.println("Day "+ d);
            for (int j = 0; j < time.length; j++) 
            {
                String t1=time[j];
                String n1=subject[k];
                String f1=faculty[k];
                System.out.println("Time " + t1 +" - Subject "+ n1 + " - Faculty "+f1);
                
                dto.setDays(d);
                dto.setTime(t1);
                dto.setLecture(n1);
                dto.setFacultyid(f1);
                dto.setDivision(division);
                
                boolean isT=t.isFacultyTT(dto);
                
                if(isT)
                {
                    System.out.println("Inserting...");
                }
                k++;
            }
        }
        
        response.sendRedirect("adminHome.jsp");
    }
}