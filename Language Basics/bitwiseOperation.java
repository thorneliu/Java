class bitwiseOperation
{
	public static void main(String[] args)
	{
		int x = 0x1000;
        int y = 0x0001;

		System.out.println("x & y = " + (x & y));
		System.out.println("x | y = " + (x | y));
		System.out.println("x ^ y = " + (x ^ y));
	}
}
