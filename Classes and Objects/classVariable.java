class foo
{
    static int instanceCount;

    public foo()
    {
        instanceCount++;
    }
    
    public void showCount()
    {
        System.out.println("Instance Count: " + instanceCount);
    }

    public static int getCount()
    {
        return instanceCount;
    }
}

class classVariableDemo
{
    public static void main(String[] args)
    {
        foo foo1 = new foo();
        foo1.showCount();

        foo foo2 = new foo();
        foo1.showCount();
        foo2.showCount();

        foo foo3 = new foo();
        foo3.showCount();

        int i = foo3.getCount();
    }
}
