package application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities_enum.WorkerLevel;

public class Application {

	public static void main(String[] args) throws ParseException {
	    Scanner sc = new Scanner(System.in);
		
	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
	    
		System.out.println("Enter department's name: ");
		String nameDepartment = sc.next();
		System.out.print("Enter worker data:");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Name: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(nameDepartment));
		
		System.out.println("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n;i++) {
			System.out.print("Enter contract" + i + "# data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next()); // read as string
			System.out.print("Value per hour:");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duration (hours): ");
			int hours = sc.nextInt();
			HourContract contracts = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contracts);			
			
		}
		System.out.println("Enter month and year to calculate income (MM/YYYY): ");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name:" + worker.getName());
		System.out.println("Department: " + worker.getDepartment().getName());
		System.out.println("Income for" + monthAndYear + " : " + worker.income(year, month));
		
		 sc.close();

	}

}
