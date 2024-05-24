package restapi.pkg1;

public class AppointmentModel {
	private String name;
	private String salary;
	private String location;
	private String date;
	private String email;
	
	AppointmentModel(String name, String salary, String location, String date, String email){
		this.name = name;
		this.salary = salary;
		this.location = location;
		this.date = date;
		this.email = email;
	}
	
	public String[] getData() {
		String[] arr1 = new String[5];
		arr1[0] = name;
		arr1[1] = salary;
		arr1[2] = location;
		arr1[3] = date;
		arr1[4] = email;
		
		return arr1;
	}
}
