class arrayDemo
{
	public static void main(String[] args)
	{
		int[] iarray; //declare an array
		iarray = new int[10]; // allocate mem for this iarray?
	
		for (int i = 0; i != 10; i++)
		{
			iarray[i] = i * 100;
		}

		for (int i = 0; i != 10; i++)
		{
			System.out.println("Element " + i + ":" + iarray[i]);
		}
	}
}
