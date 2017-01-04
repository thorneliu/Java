class flowControl
{
	public static void printStr(int aNumber)
	{
		if (aNumber >= 0)
			if (aNumber == 0)
				System.out.println("first string");
			else 
				System.out.println("second string");

		System.out.println("third string");
	}

	public static void main(String[] args)
	{
		int[] iarray; //declare an array
		iarray = new int[10]; // allocate mem for this iarray?
	
		for (int i = 0; i != 10; i++)
		{
			iarray[i] = i * 2;
		}
		
		for(int i = 0; i != 10; i++)
		{
			if(iarray[i] < 10)
				System.out.println("Element < 10 is :" + iarray[i]);
			else
				System.out.println("Element >= 10 is :" + iarray[i]);
		}

		int[] copytoarary = new int[16];
		System.arraycopy(iarray, 0, copytoarary, 11, 3);

		for (int i = 0; i != 16; i++)
		{
			System.out.println("Element " + i + ":" + copytoarary[i]);
		}

		char[] cArray = {'a', 'b', 'c', 'd'};
		System.out.println(new String(cArray));

		printStr(3);
	}
}
