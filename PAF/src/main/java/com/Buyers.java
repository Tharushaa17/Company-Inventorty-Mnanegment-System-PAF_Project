package com;
import java.sql.PreparedStatement;
import java.sql.*;

public class Buyers {
	

		
		private Connection connect()
		{
			Connection con = null;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/buyers", "root", "");
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			
			return con;
		}
		public String readBuyers(){
			
			
			String output = "";
			
			try{
				
				Connection con = connect();
				
				if (con == null){
					
				return "Error while connecting to the database for reading.";
				}
				
				// Prepare the html table to be displayed
				output = "<table border='1'><tr><th>Id</th> " + "<th>Frist Name</th>"+"<th>Last Name</th>"+ "<th>Username</th>" + "<th>Mobile Nu</th>"+ "<th>Email</th>"+ "<th>Address</th>"+"<th>Password</th>"
						+"<th>Update</th><th>Remove</th></tr>";
				
				String query = "select * from buyerreg";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				// iterate through the rows in the result set
				while (rs.next()){
					
				String id = Integer.toString(rs.getInt("Bid"));
				String FristName = rs.getString("FristName");
				String LastName = rs.getString("LastName");
				String Username = rs.getString("Username");
				String MobileNu = rs.getString("MobileNu");
				String Email = rs.getString("Email");
				String Address = rs.getString("Address");
				String Password = rs.getString("Password");
				
				// Add into the html table
				output += "<tr><td><input id='hidBidUpdate' name='hidBidUpdate' type='hidden' value='" 
					   + id + ">" + FristName + "</td>";
				output += "<td>" + LastName + "</td>";
				output += "<td>" + Username + "</td>";
				output += "<td>" + MobileNu + "</td>";
				output += "<td>" + Email + "</td>";
				output += "<td>" + Address + "</td>";
				output += "<td>" + Password + "</td>";
				
				// buttons
				output += "<td><input name='btnUpdate' type='button' value='Update' class='btnUpdate btn btn-secondary'></td>" 
						+ "<td><input name='btnRemove' type='button' value='Remove' class='btnRemove btn btn-danger' data-id='"
						+ id + "'>" + "</td></tr>";
				}
				
				con.close();
				
					// Complete the html table
					output += "</table>";
				}
				catch (Exception e){
					
				output = "Error while reading the items.";
				System.err.println(e.getMessage());
				
				}
			
				return output;
				
			}
		
		public String insertBuyers(String FristName, String LastName, String Username, String MobileNu, String Email, String Address, String Password){
			
				String output = "";
				try{
					
						Connection con = connect();
						
						if (con == null){
							
						return "Error while connecting to the database for inserting.";
						}
						
						// create a prepared statement
						String query = " insert into buyerreg(`Bid`,`FristName`,`LastName`,`Username`,`MobileNu`,`Email`,`Address`,`Password`)" + " values (?, ?, ?, ?, ?, ?, ?, ?)";
								
						PreparedStatement preparedStmt = con.prepareStatement(query);
								
						// binding values
						preparedStmt.setInt(1, 0);
						preparedStmt.setString(2, FristName);
						preparedStmt.setString(3, LastName);
						preparedStmt.setString(4, Username);
						preparedStmt.setString(5, MobileNu);
						preparedStmt.setString(6, Email);
						preparedStmt.setString(7, Address);
						preparedStmt.setString(8, Password);
								
						// execute the statement
						preparedStmt.execute();
						con.close();
						
						String newBuyers = readBuyers();
						output = "{\"status\":\"success\", \"data\": \"" + newBuyers + "\"}";
						
						}
					catch (Exception e)
					{
							output = "{\"status\":\"error\", \"data\":\"Error while inserting.\"}";
							System.err.println(e.getMessage());
					}
					
					return output;
				}
		
		public String updateBuyer(String id, String FristName, String LastName, String Username, String MobileNu, String Email, String Address, String Password){
			
				String output = "";
				try
				{
					Connection con = connect();
					if (con == null)
					{
						return "Error while connectingm to the database for updating.";
					}
					// create a prepared statement
					String query = "UPDATE buyerreg SET FristName=?,LastName=?,Username=?,MobileNu=?,Email=?,Address=?,Password=? WHERE itemID=?";
								
					PreparedStatement preparedStmt = con.prepareStatement(query);
								
					// binding values
					preparedStmt.setString(1, FristName);
					preparedStmt.setString(2, LastName);
					preparedStmt.setString(3, Username);
					preparedStmt.setString(4, MobileNu);
					preparedStmt.setString(5, Email);
					preparedStmt.setString(6, Address);
					preparedStmt.setString(7, Password);
					
					
				
				// execute the statement
				preparedStmt.execute();
				con.close();
				String newBuyers = readBuyers();
				output = "{\"status\":\"success\", \"data\": \"" + newBuyers + "\"}";
				
				}
				catch (Exception e){
					
				output = "{\"status\":\"error\", \"data\": \"Error while updating.\"}";
		
				System.err.println(e.getMessage());
				}
			return output;
		}
		
		
		public String deleteBuyers(String id){
			
		String output = "";
		
			try{
				
				Connection con = connect();
				if (con == null){
					
				return "Error while connecting to the database for deleting.";
				}
				
				// create a prepared statement
				String query = "delete from buyerreg where Bid=?";
				PreparedStatement preparedStmt = con.prepareStatement(query);
				
				
				// binding values
				preparedStmt.setInt(1, Integer.parseInt(id));
				
				
				// execute the statement
				preparedStmt.execute();
				con.close();
				String newBuyers = readBuyers();
				output = "{\"status\":\"success\", \"data\": \"" + newBuyers + "\"}";
				}
			
			catch (Exception e)
			{
				output = "{\"status\":\"error\", \"data\": \"Error while deleting the item.\"}";
				System.err.println(e.getMessage());
				
			}
		return output;
		}
		
	}


