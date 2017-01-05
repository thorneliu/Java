interface fooi
{
	void foo(); //abstract
	default void bar()
	{
		System.out.println("default method bar in interface foo...");
	}
}

class c1 implements fooi
{
	public void foo()
	{
		System.out.println("implemented method foo in class c111111...");
	}
	
	//do nothing with the default method in interface foo
}

class c2 implements fooi
{
	public void foo()
	{
		System.out.println("implemented method foo in class c222222...");
	}
	
	//redelcare the default method, makes it abstract //abstract public void bar();
}

class c3 implements fooi
{
	public void foo()
	{
		System.out.println("implemented method foo in class c333333...");
	}
	
	//redefine the default method, makes it abstract
	public void bar()
	{
		System.out.println("overrided bar in class c333333...");
	}

	public void x()
	{
		System.out.println("class c333333 has its own method x() hahhaha ...");
	}
}

public class defaultDemo
{
	public static void main(String[] args)
	{
		c1 _a = new c1();
		c2 _b = new c2();
		c3 _c = new c3();

		_a.foo();_a.bar();
		_b.foo();_b.bar();
		_c.foo();_c.bar();_c.x();
	}
}
