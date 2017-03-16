public class Cat extends Animal
{
	private String name;

	public Cat(String name){
		System.out.println("new Cat...");
		this.name = name; 
		}

	@Override
	public String toString()
	{
		return this.getClass().getName() + this.name;
	}

	public static void testClassMethod()
	{
		System.out.println("The static method in Cat");
	}

	public void testInstanceMethod()
	{
		System.out.println("The instance method in Cat");
	}

	public static void main(String[] args)
	{
		Cat myCat = new Cat("Jimmy");
		Animal myAnimal = myCat;

		System.out.println("The object's class is " + myCat.getClass().getSimpleName());
		System.out.println("The object's class is " + myAnimal.getClass().getSimpleName());
		System.out.println("The object's toString is " + myCat.toString());

		myCat.testClassMethod();
		myCat.testInstanceMethod();

		myAnimal.testClassMethod();
		myAnimal.testInstanceMethod();
	}
}

