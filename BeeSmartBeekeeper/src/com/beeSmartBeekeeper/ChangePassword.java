package com.beeSmartBeekeeper;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import com.beeSmartBeekeeper.passwordHashing.SHA256;
import com.beeSmartBeekeeper.servlets.session.LoginServlet;
import com.mysql.jdbc.PreparedStatement;

@WebServlet("/changePassword")

public class ChangePassword extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ChangePassword(){
		

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=(String) request.getSession().getAttribute("http.proxyPassword");
		String oldPwd = request.getParameter("password");
		String newPwd1=request.getParameter("newPassword1");
		String newPwd2=request.getParameter("newPassword2");
		@SuppressWarnings("unused")
		String name="";
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}
		java.sql.Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/beesmartbeekeeper?autoReconnect=true&useSSL=false","root", "123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String selectSQL = "SELECT id,pass,name FROM owners WHERE email=?";
		PreparedStatement st1 = null;
		try {
			st1 = (PreparedStatement) conn.prepareStatement(selectSQL);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			System.out.println("selectSQL");
			e1.printStackTrace();
		}
		try {
			st1.setString(1, user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("set 1");
			e.printStackTrace();
		}
		String password="";
		ResultSet rs = null;
		try {
			rs = st1.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				password = rs.getString("pass");
				name=rs.getString("name");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SHA256 owner=new SHA256(newPwd1);
		String newHashedPassword="";
		
		SHA256 newOwner=new SHA256(oldPwd);
		String hashedPassword ="";
		try {
			
			hashedPassword = newOwner.secureAndVerifyPassword();
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(password.equals(hashedPassword)){
			
		
		if(newPwd1.equals(newPwd2)){
			
			try {
				
				newHashedPassword = owner.secureAndVerifyPassword();
			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		if(newHashedPassword.equals(hashedPassword)){
			String updateSQL = "UPDATE owners SET pass=? WHERE email=? AND pass=?";
			PreparedStatement st2 = null;
			
				try {
					st2 = (PreparedStatement) conn.prepareStatement(updateSQL);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("uupdate sql");
					e.printStackTrace();
				}
			
				try {
					st2.setString(1,newHashedPassword);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("set 1");
					e.printStackTrace();
				}
			
				try {
					st2.setString(2, user);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("set 2");
					e.printStackTrace();
				}
			
				try {
					st2.setString(3, hashedPassword);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("set 3");
					e.printStackTrace();
				}
			
		}else{
			System.setProperty("file.encoding","UTF-8");
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/changePassword.html");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>Wrong password or not equal passwords.</font>");
			rd.include(request, response);
		}
	

}}
