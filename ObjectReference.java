public class ObjectReference {
	private int count;

	public void setCount(int i){this.count = i;}
	public int getCount(){return count;}

	public static void main(String[] args){
		ObjectReference obj1 = new ObjectReference();
		ObjectReference obj2 = obj1;

		obj1.setCount(100);

		System.out.println("Obj1 count: " + obj1.getCount());
		System.out.println("Obj2 count: " + obj2.getCount());
	}
}
