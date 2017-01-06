public class employeeDemo
{
	public static void main(String[] args)
	{
		employee e1 = new employee("Jim", 100.0f);
		manager  e2 = new manager("Tom", 200.0f, 10);

		e1.showEmployee();
		e2.showEmployee();
	}
}
