package day0929;

public class Ex2RunnableTest implements Runnable{
	String msg;
	int num;
	
	public Ex2RunnableTest(int num,String msg) {
		// TODO Auto-generated constructor stub
		this.num=num;
		this.msg=msg;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<=num;i++)
		{
			System.out.println(i+":"+msg);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2RunnableTest ex1=new Ex2RunnableTest(200, "one");
		Ex2RunnableTest ex2=new Ex2RunnableTest(200, "two");
		Ex2RunnableTest ex3=new Ex2RunnableTest(200, "three");
		Thread th1=new Thread(ex1);
		Thread th2=new Thread(ex2);
		Thread th3=new Thread(ex3);
		
		//run 메소드 호출..여러개의 스레드가 스레드 스케줄러에 의해서 권한이 돌아가면서 실행되는걸 확인할수있다
		th1.start();
		th2.start();
		th3.start();		
	}

}
