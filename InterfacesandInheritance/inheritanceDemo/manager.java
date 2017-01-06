public class manager extends employee 
{
	int jobGrade;

	public void setJobGrade(int jobGd)
	{
		this.jobGrade = jobGd;
	}

	public manager()
	{
		super();
	}

	public manager(String name, float salary)
	{
		super(name, salary);
	}

	public manager(String name, float salary, int jobGrade)
	{
		super(name, salary);
		this.jobGrade = jobGrade;
	}

	public void showEmployee()
	{
		super.showEmployee();
		System.out.println("employee jobGrade: " + this.jobGrade);
	}
}
