/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.DBConnector;
import dto.DTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author SHUBHAM
 */
public class Authtenticator 
{
    Statement st=DBConnector.getStatement();

/***************************************************************************************************/    
    public boolean isAdminLogin(DTO d)
    {
        String id=d.getId();
        String password=d.getPassword();
        String tablePassword="";
        try
        {
            ResultSet rs=st.executeQuery("Select password from admin where id='"+id+"'");
            while(rs.next())
            {
                tablePassword=rs.getString(1);
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        if(id!=null && password!=null && !id.trim().equals("") && !password.trim().equals("") && password.equals(tablePassword)) 
        {
            return true;
        }
        return false;
    }
    
    public boolean isFacultyLogin(DTO d)
    {
        String id=d.getId();
        String password=d.getPassword();
        String tablePassword="";
        try
        {
            ResultSet rs=st.executeQuery("Select password from faculty where facultyid='"+id+"'");
            while(rs.next())
            {
                tablePassword=rs.getString(1);
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        if(id!=null && password!=null && !id.trim().equals("") && !password.trim().equals("") && password.equals(tablePassword)) 
        {
            return true;
        }
        return false;
    }
    
    public boolean isStudentLogin(DTO d)
    {
        String id=d.getId();
        String password=d.getPassword();
        String tablePassword="";
        try
        {
            ResultSet rs=st.executeQuery("Select password from student where enrollment='"+id+"'");
            while(rs.next())
            {
                tablePassword=rs.getString(1);
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        if(id!=null && password!=null && !id.trim().equals("") && !password.trim().equals("") && password.equals(tablePassword)) 
        {
            return true;
        }
        return false;
    }
    
    public boolean isStudentRegistered(DTO d)
    {
        String name=d.getName();
        String password=d.getPassword();
        String enrollment = d.getId();
        String email=d.getEmail();
        String gender=d.getGender();
        String number=d.getNumber();
        String dob=d.getDob();
        String branch=d.getBranch().toUpperCase();
        String division=d.getDivision();
        String session=d.getSession();
        String address=d.getAddress();
        try
        {
            int i=st.executeUpdate("insert into student values('"+enrollment+"','"+name+"','"+number+"','"+email+"','"+gender+"','"+dob+"','"+address+"','"+branch+"','"+session+"','"+division+"','"+password+"')");
            if(i>0)
            {
                return true;
            }
            else
            {
                System.out.println("Registration Failed...");
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return false;
    }
    
    public boolean isFacultyRegistered(DTO d)
    {
        String name=d.getName();
        String password=d.getPassword();
        String facultyid = d.getId();
        String email=d.getEmail();
        String gender=d.getGender();
        String number=d.getNumber();
        String dob=d.getDob();
        String address=d.getAddress();
        try
        {
            int i=st.executeUpdate("insert into faculty values('"+facultyid+"','"+name+"','"+number+"','"+email+"','"+gender+"','"+dob+"','"+address+"','"+password+"','0','0')");
            if(i>0)
            {
                return true;
            }
            else
            {
                System.out.println("Registration Failed...");
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return false;
    }
    
    
/***************************************************************************************************/
    
    public boolean isFacultyTT(DTO d)
    {
        String facultyid=d.getFacultyid();
        String day=d.getDays();
        String time=d.getTime();
        String lecture=d.getLecture();
        String division=d.getDivision();
        long id=0;
        
        try
        {
            ResultSet rs1=st.executeQuery("select id from facultytt order by id DESC limit 1 ");
            if(rs1.next())
                id=rs1.getLong(1)+1;             
            else
                id=1;
            int i=st.executeUpdate("insert into facultytt values ('"+id+"','"+facultyid+"','"+day+"','"+time+"','"+lecture+"','"+division+"')");
            if(i>0)
            {
                System.out.println("I");
                return true;
            }
        }
        catch(SQLException e)
        {
            System.out.println(e);
        }
        return false;
    }
    
/***************************************************************************************************/
    
    public boolean isAttend(DTO d)
    {
        String enrollment=d.getEnrollment();
        String date=d.getStartingDate();
        String lecture=d.getLecture();
        String status=d.getStatus();
        String faculty=d.getFacultyid();
        long id=0;
        
        try
        {
            ResultSet rs1=st.executeQuery("select id from attendence order by id DESC limit 1 ");
            if(rs1.next())
                id=rs1.getLong(1)+1;             
            else
                id=1;
            int i=st.executeUpdate("insert into attendence values('"+id+"','"+enrollment+"','"+lecture+"','"+date+"','"+status+"','"+faculty+"')");
            if(i>0)
            {
                return true;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
    
/***************************************************************************************************/
    
    public boolean isCompiled(DTO d)
    {
        String enrollment=d.getEnrollment();
        String startingdate=d.getStartingDate();
        String endingdate=d.getEndingDate();
        String percentage=d.getPercentage();
        long id=0;
        
        try
        {
            ResultSet rs1=st.executeQuery("select id from compiled order by id DESC limit 1 ");
            if(rs1.next())
                id=rs1.getLong(1)+1;             
            else
                id=1;
            int i=st.executeUpdate("insert into compiled  values('"+id+"','"+enrollment+"','"+startingdate+"','"+endingdate+"','"+percentage+"')");
            if(i>0)
            {
                return true;
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
    
/***************************************************************************************************/

/***************************************************************************************************/    
    public boolean isProfileEdit(DTO d)
    {
        String about=d.getAbout();
        String id=d.getId();
        String email=d.getEmail();
        String number=d.getNumber();
        String dob=d.getDob();
        String address=d.getAddress();
        int i=0;
        try
        {
            if(about.equals("facultyProfileEdit"))
            {
                i=st.executeUpdate("Update faculty set email='"+email+"', number='"+number+"', dob='"+dob+"', address='"+address+"' where facultyid='"+id+"' ");
            }
            
            if(about.equals("studentProfileEdit"))
            {
                i=st.executeUpdate("Update student set email='"+email+"', number='"+number+"', dob='"+dob+"', address='"+address+"' where enrollment='"+id+"'");
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        if(i>0)
        {
            return true;
        }
        return false;
    }
}
