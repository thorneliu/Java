public class genericsMethod{
	public static  <T extends Number> void showT(T t){
		System.out.println(t);
		System.out.println(t.getClass());
	}

	public static void main(String[] args){
		showT(10);
		showT(10.1);
		showT(10e3);
	}
}
