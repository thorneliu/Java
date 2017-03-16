public class IntegerDemo
{
	public static void main(String[] args)
	{
		Integer i = 1000;
		System.out.println("Integer MAX VALUE: " + i.MAX_VALUE);
		System.out.println("Integer MIN VALUE: " + i.MIN_VALUE);

		System.out.println("Integer i converted to primitive type value: " + i.intValue());
		System.out.format("Integer i converted to primitive type value = %d%n",  i.intValue());

		System.out.format("Math.E value = %16f%n",  Math.E);
	}
}
