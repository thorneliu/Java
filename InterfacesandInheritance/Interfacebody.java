public interface Interface1
{
	void doSomething(int i);  //abstract method
	default defaultOne(int i)
	{
		//you must provide an implementation for default methods
		System.out.println("This is a default method, the implementers can not implement it.");

	} //default method
	static staticOne(int i);  //static method 
}

public class InterfaceBodyDemo implements Interface1
{
	void doSomething(int i) {System.out.println("doSomething");}
}
