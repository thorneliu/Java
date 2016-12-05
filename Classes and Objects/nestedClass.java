class outerClass
{
    int foo = 0;

    public void setFoo(int i){foo = i;}
    public int  getFoo(){return foo;}
    public void showFoo(){System.out.println("foo in outerClass : "+foo);}

    class innerClass
    {
        int bar = 0;
        public innerClass()
        {
            System.out.println("constructing innerClass....");
        }

        public void setbar(){bar = foo * foo;}
        public void showbar(){System.out.println("bar in innerClass : "+bar);}
    }
}

class nestClassDemo
{
    public static void main(String[] args)
    {
        outerClass cfoo = new outerClass();
        outerClass.innerClass cbarInfoo  = cfoo.new innerClass();
        cfoo.setFoo(3);
        cfoo.showFoo();

        cbarInfoo.setbar();
        cbarInfoo.showbar();
    }
}
