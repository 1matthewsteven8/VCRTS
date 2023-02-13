import java.util.*;

public class VehicleDatabase {
	
	private List <Vehicle>vehiclesCheckedIn = new ArrayList <Vehicle>();
	private List <Vehicle>vehiclesCheckedOut = new ArrayList <Vehicle>();
	private String dateReserved;
	private int timeReserved;
	private int minutesWorking;
	
	public List<Vehicle> getVehiclesCheckedIn()
	{
		return vehiclesCheckedIn;
	}
	
	public void setVehiclesCheckedIn(List<Vehicle> vehiclesCheckedIn)
	{
		this.vehiclesCheckedIn = vehiclesCheckedIn;
	}
	
	public List<Vehicle> getVehiclesCheckedOut()
	{
		return vehiclesCheckedOut;
	}
	
	public void setVehiclesCheckedOut(List<Vehicle> vehiclesCheckedOut)
	{
		this.vehiclesCheckedOut = vehiclesCheckedOut;
	}
	
	public String getDateReserved()
	{
		return dateReserved;
	}
	
	public void setDateReserved(String dateReserved)
	{
		this.dateReserved = dateReserved;
	}
	
	public int getTimeReserved()
	{
		return timeReserved;
	}
	
	public void setTimeReserved(int timeReserved)
	{
		this.timeReserved = timeReserved;
	}
	
	public int getMinutesWorking()
	{
		return minutesWorking;
	}
	
	public void setMinutesWorking(int minutesWorking)
	{
		this.minutesWorking = minutesWorking;
	}
}
