package testNG;

public class StvsNS {

	public static void main(String[] args) {
		StvsNS.add(10, 20);//classname.methodname
		StvsNS s=new StvsNS();//create object
		s.mul(10, 20);//reference .methodname
	}
	
	public  static void add(int a,int b) {
		System.out.println(a+b);
	}
	public void mul(int a,int b) {
		System.out.println(a*b);
	}
}
