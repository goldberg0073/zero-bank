package MenteringClass;

public class Salaried_Employees extends Employees{
	
	
	
//public Salaried_Employees(String name,double age,String address,double salary,String job,double bonus,double deduction) {
//	
//	
//	super(name,age,address,salary,job,bonus,deduction);
//	bonus=bonus;
//	deduction=deduction;
//	
//	}
	
	double bonus;
	double deduction;
	
	public Salaried_Employees() {
		
	}
	
	public Salaried_Employees(String name,double age,String address,double salary,String job,double bonus,double deduction) {
		super(name,age,address,salary,job);
		this.bonus=bonus;
		this.deduction=deduction;
		
		
	}
	
	@Override
	public double getSalary() {
		System.out.print("The salary for this month ");
		return Salary+bonus-deduction;
	}
	
}
