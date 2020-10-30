package day0929;

public class Ex1ThreadTest extends Thread{
	String msg;
	int num;
	public Ex1ThreadTest(int num,String msg) {
		// TODO Auto-generated constructor stub
		this.msg=msg;
		this.num=num;
	}
	
	@Override
	public void run()
	{
		for(int i=1;i<=num;i++)
		{
			System.out.println(i+":"+msg);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1ThreadTest ex1=new Ex1ThreadTest(200, "one");
		Ex1ThreadTest ex2=new Ex1ThreadTest(200, "two");
		Ex1ThreadTest ex3=new Ex1ThreadTest(200, "three");
		ex1.start();
		ex2.start();
		ex3.start();	
	}

}
