class fooClass
{
	int i = 0;

	void seti(int newValue){i = newValue;}
	int geti(){return i;}
}

class childFooClass extends fooClass
{
	int newMember = 0;
	int newMethod(){return i*i;}
}

class fooClassDemo
{
	public static  void main(String[] args)
	{
		fooClass foo = new fooClass();
		foo.seti(3);
		System.out.println("i :" + foo.geti());

		//try childFooClass
		childFooClass cfoo = new childFooClass();
		cfoo.seti(9);
		System.out.println("cfoo.newMethod() = " + cfoo.newMethod());
	}
}
