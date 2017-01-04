class rangeforDemo
{
	public static void main(String[] args)
	{
		Integer[] array = {1,2,3,4,5,6};
		for(Integer item : array)
		{
			item = item * 2; //doubled?
		}

		for(int item : array)
		{
			System.out.println("element i:" + item);
		}
	}
}
