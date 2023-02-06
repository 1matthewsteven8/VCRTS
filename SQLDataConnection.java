import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLDataConnection {
    // Connect to your database.
    // Replace database, username, and password with your credentials
	
	public static Connection connectSQL() throws SQLException {
		 String url = "jdbc:mysql://localhost:3306/vehicularcloud"; //ensure database is the same name as on your server
		    String username = "root";
		    String password = ""; //individuals password here

		    System.out.println("Connecting to database ... vehicular cloud");
		    Connection connection = DriverManager.getConnection(url, username, password);
		    System.out.println("Database connected!");
		        
			     if(connection == null) {
			    	 throw new IllegalStateException("Cannot connect the database!");
			     }
				return connection;
	}
	/* (COMMENTED OUT DUE TO REMOVAL OF THE TABLES)
	//insert Client textFile into SQL client Table in schema Vehicular Cloud
	public static void insertClientSQL(Client client) {
	  try(Connection connection = connectSQL();){
	    
	        PreparedStatement pstat = connection.prepareStatement("INSERT INTO clients(firstName, lastName, phoneNum, email, username, password) VALUES (?,?,?,?,?,?)");
	     
	                pstat.setString(1, client.getFirstName());
	                pstat.setString(2, client.getLastName());
	                pstat.setString(3, client.getPhoneNumber());
	                pstat.setString(4, client.getEmail());
	                pstat.setString(5, client.getUsername());
	                pstat.setString(6, client.getPassword());
	                pstat.addBatch();
	            	
	            pstat.executeBatch();
	    		}
	        catch(SQLException e) {
	        System.out.println(e);
	        }
	  //System.out.println("Client Upload Succesful");
	}
	
	//insert vehicleOwner textFile into SQL vehicle Owner Table in schema Vehicular Cloud
	public static void insertVehicleOwnerSQL(VehicleOwner owner) {
		  try(Connection connection = connectSQL();){
		    
		        PreparedStatement pstat = connection.prepareStatement("INSERT INTO vehicleowner(firstName, lastName, phoneNum, email, username, password) VALUES (?,?,?,?,?,?)");
		           
		                pstat.setString(1, owner.getFirstName());
		                pstat.setString(2, owner.getLastName());
		                pstat.setString(3, owner.getPhoneNumber());
		                pstat.setString(4, owner.getEmail());
		                pstat.setString(5, owner.getUsername());
		                pstat.setString(6, owner.getPassword());
		                pstat.addBatch();
		            	
		            pstat.executeBatch();
		    		}
		        catch(SQLException e) {
		        System.out.println(e);
		        }
		  System.out.println("Vehicle Owner Upload Succesful");
		}
	
	//insert CloudController textFile into SQL CloudController Table in schema Vehicular Cloud
	public static void insertCloudControllerSQL(CloudController admin) {
		  try(Connection connection = connectSQL();){
		    
		        PreparedStatement pstat = connection.prepareStatement("INSERT INTO cloudcontroller(firstName, lastName, phoneNum, email, username, password) VALUES (?,?,?,?,?,?)");
		           
		                pstat.setString(1, admin.getFirstName());
		                pstat.setString(2, admin.getLastName());
		                pstat.setString(3, admin.getPhoneNumber());
		                pstat.setString(4, admin.getEmail());
		                pstat.setString(5, admin.getUserName());
		                pstat.setString(6, admin.getPassword());
		                pstat.addBatch();
		            	
		            pstat.executeBatch();
		    		}
		        catch(SQLException e) {
		        System.out.println(e);
		        }
		  System.out.println("Cloud Controller Upload Succesful");
		}
	*/
	//insert CarInfo textFile into SQL CloudController Table in schema Vehicular Cloud
	public static void insertVehicleSQL(Vehicle vehicle) {
		  try(Connection connection = connectSQL();)
		  {
			  PreparedStatement pstat = connection.prepareStatement("INSERT INTO vehicle(vehiclevin, vehicleYear, vehicleMake, vehicleModel, vehicleColor, vehicleAvailable, vehicleDamageNotes, username) VALUES (?,?,?,?,?,?,?,?)");
		
				  pstat.setString(1, vehicle.getVehicleVIN());
				  pstat.setString(2, vehicle.getVehicleYear());
				  pstat.setString(3, vehicle.getVehicleMake());
				  pstat.setString(4, vehicle.getVehicleModel());
				  pstat.setString(5, vehicle.getVehicleColor());
				  pstat.setString(6, vehicle.getVehicleAvailable());
				  pstat.setString(7, vehicle.getVehicleDamageNotes());
				  pstat.setString(8, vehicle.getUsername()); // <---- going to need to implement a method that sets username with constructor, shouldn't be too complicated
				  pstat.addBatch();

			  pstat.executeBatch();
		  }
		  catch(SQLException e)
		  {
			  System.out.println(e);
		  }
		  System.out.println("Vehicle Upload Succesful");
	}
	
	//insert JobInfo textFile into SQL CloudController Table in schema Vehicular Cloud (NOT DONE YET)
	public static void insertJobSQL(Job job) {
		  try(Connection connection = connectSQL();)
		  {
			  PreparedStatement pstat = connection.prepareStatement("INSERT INTO job(jobID, jobDuration, jobName, jobInfo, username) VALUES (?,?,?,?,?)");
			  
				  pstat.setString(1, job.getJobInfo());
				  pstat.setLong(2, job.getJobDuration());
				  pstat.setString(3, job.getJobName());
				  pstat.setString(4, job.getJobInfo());
				  pstat.setString(5, job.getUsername()); // <---- going to need to implement a method that sets username with constructor, shouldn't be too complicated
				  pstat.addBatch();
			  
			  pstat.executeBatch();
		  }
		  catch(SQLException e)
		  {
			  System.out.println(e);
		  }
		 // System.out.println("Job Upload Successful");
	}
	
}
