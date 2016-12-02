interface foo
{
	void fooMethod();
}

interface bar
{
	void barMethod();
}

class Father
{
	int i;
	void func(){};
}

class interfaceDemo extends Father
	implements foo, bar
{
	public void fooMethod()
	{
		System.out.println("Implemented method foo....");
	}
	
	public void barMethod()
	{
		System.out.println("Implemented method bar....");
	}

	public static void main(String[] args)
	{
		interfaceDemo demo = new interfaceDemo();
		demo.fooMethod();
		demo.barMethod();
	}
}
