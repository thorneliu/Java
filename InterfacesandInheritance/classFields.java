class classFields 
{
	public static double PI = 3.14159; // static means a class feilds

	public void setPI(double _PI) {PI = _PI;}

	public static void main(String[] args)
	{
		System.out.println("classFields PI :" + PI);
		classFields c1 = new classFields();
		classFields c2 = new classFields();

		c1.setPI(3.0);
		System.out.println("classFields PI :" + PI);

		c2.setPI(4.0);
		System.out.println("classFields PI :" + PI);

		//c1.setPI() and c2.setPI(), they are change the same object in this class
	}
}
