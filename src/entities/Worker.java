package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities_enum.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel leve;
	private double baseSalary;
	
	private Department department;
	private List<HourContract> contracts = new ArrayList<>();
	
	public Worker() {
		
	}

	public Worker(String name, WorkerLevel level, double baseSalary, Department department) {
		this.name = name;
		this.leve = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLeve() {
		return leve;
	}

	public void setLeve(WorkerLevel leve) {
		this.leve = leve;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<HourContract> getContract() {
		return contracts;
	}

	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public double income(int year, int month) {
		Calendar cal = Calendar.getInstance();
		double sum = baseSalary;
		for(HourContract c: contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH); // month begin with 0
			if(year == c_year && month == c_month) {
				sum += c.totalValue();
			}
						
		}
		return sum;
	}
}
