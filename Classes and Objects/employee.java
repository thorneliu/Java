public enum employee
{
	BOSS(200.0),
	MANAGER(20.0),
	ENGENEER(2.0);

	private final double salary;
	employee(double salary){this.salary = salary;}

	public static void main(String[] args)
	{
		for(employee e : employee.values())
		{
			System.out.printf("employee %s with salary %f%n", e, e.salary);
		}
	}
}
