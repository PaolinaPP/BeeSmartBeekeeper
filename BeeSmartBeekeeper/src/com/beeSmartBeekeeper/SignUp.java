package com.beeSmartBeekeeper;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;





@WebServlet(name="SignUp",  urlPatterns={"/signup"})
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String town=request.getParameter("town");
		String beehiveId=request.getParameter("beehiveid");
		String password=request.getParameter("password");
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
		try {
			java.sql.PreparedStatement st= conn.prepareStatement("INSERT INTO owners(name, town, email,pass) values(?,?,?,?) ");
			st.setString(1,name);
			st.setString(2, town);
			st.setString(3, email);
			st.setString(4,password);
			st.executeUpdate();
			
			PreparedStatement st1= null;
			// conn.Connection();
			st1 =  conn.prepareStatement("SELECT owners.id FROM owners WHERE name=? AND town=? AND email=? AND password=? ");
	        ResultSet rs = st1.executeQuery();
	        st.setString(1,name);
			st.setString(2, town);
			st.setString(3, email);
			st.setString(4,password);
			//st1.executeUpdate();
			int id = 0;
	        while (rs.next()) {
	            id = rs.getInt(1);
	        }
		    st1.executeUpdate();
			
	        java.sql.PreparedStatement st2= conn.prepareStatement("INSERT INTO beehouses(arduinoId, ownerId) values(?,?) ");
			st2.setString(1,beehiveId);
			st2.setInt(2, id);
			st2.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
