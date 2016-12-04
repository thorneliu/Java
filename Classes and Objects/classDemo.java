class boxDemo
{
    public int length;
    public int width;
    public int height;

    public boxDemo(int l, int w, int h)
    {
        //one constructer
        length = l;
        width  = w;
        height = h;
    }

    public boxDemo()
    {
        //Yet one default constructer
        length = 1;
        width  = 1;
        height = 1;
    }

    public void showBox()
    {
        System.out.println("length : " + length);
        System.out.println("width : " + width);
        System.out.println("height : " + height);
    }

    public static void main(String[] args)
    {
        boxDemo box1 = new boxDemo(3,4,5);
        boxDemo box2 = new boxDemo();

        box1.showBox();
        box2.showBox();
    }
}
