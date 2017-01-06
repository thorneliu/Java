public class employee
{
	//the employee has three fields
	int    id;
	int    jobGrade;
	int    jobTitle;
	String name;
	float  salary;

	public static int employeeCount = 0;

	public employee()
	{
		this.id     = employeeCount;
		this.name   = "unknown";
		this.salary = 0.0f;
		employeeCount++;
	}

	public employee(String name, float salary)
	{
		this.id = employeeCount;
		this.name = name;
		this.salary = salary;
		employeeCount++;
	}

	public void showEmployee()
	{
		System.out.println("employee id     : " + this.id);
		System.out.println("employee name   : " + this.name);
		System.out.println("employee salary : " + this.salary);
	}
}
