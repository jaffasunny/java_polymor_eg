package assignment_02;
import java.util.Scanner; 

public class Main {

	public static void main(String[] args) {
		int number;
		String nameString;
		String idString;
		int salesInt;
		int perHourInt;
		int totalHoursInt;
		Scanner scan = new Scanner(System.in);
		Employee [] arrEmp = new Employee[1];
		
		for(int i=0 ; i<arrEmp.length ; i++) {
			System.out.println("Please confirm your identity");
			System.out.println("Pick the following to confirm");
			System.out.println("Press 1 to receive or make changes to SALES EMPLOYEE "
					+ "\nPress 2 to receive or make changes to HOURLY EMPLOYEE"
					+ "\nPress 3 to receive or make changes to COMMISSION EMPLOYEE");
			
			number = scan.nextInt();
			
			if(number == 1) {
				System.out.println("Enter SE-Name: ");
				nameString = scan.next();
				System.out.println("Enter SE-ID: ");
				idString = scan.next();
				System.out.println("Enter SE-Sales: ");
				salesInt = scan.nextInt();
				arrEmp[i] = new salesEmployee(nameString, idString, salesInt); 
			}
			else if(number == 2) {
				System.out.println("Enter HE-Name: ");
				nameString = scan.next();
				System.out.println("Enter HE-ID: ");
				idString = scan.next();
				System.out.println("Enter HE-PerHr: ");
				perHourInt = scan.nextInt();
				System.out.println("Enter HE-TotalHrs");
				totalHoursInt = scan.nextInt();
				arrEmp[i] = new hourlyEmployee(nameString, idString, perHourInt, totalHoursInt);
			}
			else if (number == 3){
				System.out.println("Enter CE-Name: ");
				nameString = scan.next();
				System.out.println("Enter CE-ID: ");
				idString = scan.next();
				System.out.println("Enter CE-Sales: ");
				salesInt = scan.nextInt();
				arrEmp[i] = new commissionEmployee(nameString, idString, salesInt);
			}
			else {
				System.out.println("You have chosen wrong number :(");
			}
		}
		
		double totalPayment = 0;
//		Iterate to get the required output
		for(int i = 0 ; i < arrEmp.length ; i++) {
			System.out.println(arrEmp[i].toString());
			System.out.println("Earnings: " + arrEmp[i].earnings());
			totalPayment = totalPayment + arrEmp[i].earnings();
			System.out.println("");
		}
		
		System.out.println("Total Payment: " + totalPayment);
	}		
}

class Employee{
	private String name;
	private String id;
	
	public Employee(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public String getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public double earnings() {
		return -1.0;
	}
}

class salesEmployee extends Employee{
	private int sales;
	static int rate = 200;
	
	public salesEmployee(String name,String id,int sales) {
		super(name, id);
		this.sales = sales;
	}
	
	@Override
	public double earnings() {
		// TODO Auto-generated method stub
		return rate ;
	}
	
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	
	public String toString() {
		return "SE_Name: " + super.getName() +
				"\nSE_Id: " + super.getId() ;
	}
}

class hourlyEmployee extends Employee{
	private int perHour;
	private int totalHours;
	
	public hourlyEmployee(String name, String id, int perHour, int totalHours) {
		super(name, id);
		this.perHour = perHour;
		this.totalHours = totalHours;
	}
	
	@Override
	public double earnings() {
		// TODO Auto-generated method stub
		return totalHours*perHour ;
	}
	
	public int getPerHour() {
		return perHour;
	}
	public void setPerHour(int perHour) {
		this.perHour = perHour;
	}
	public int getTotalHours() {
		return totalHours;
	}
	public void setTotalHours(int totalHours) {
		this.totalHours = totalHours;
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		return "HE_Name: " + super.getName() +
				"\nHE_Id: " + super.getId() ;
	}
}

class commissionEmployee extends Employee{
	private int sales;
	
	public commissionEmployee(String name, String id, int sales) {
		super(name, id);
		this.sales = sales;
	}
	
	@Override
	public double earnings() {
		// TODO Auto-generated method stub
		double d_sales = sales;
		return ((d_sales * 10.0) / 100.0);
	}
	
	public int getSales() {
		return sales;
	}
	public void setSales(int sales) {
		this.sales = sales;
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		return "CE_Name: " + super.getName() +
				"\nCE_Id: " + super.getId() ;
	}
}