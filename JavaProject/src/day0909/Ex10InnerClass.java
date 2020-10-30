package day0909;

abstract class Hello
{
	abstract public void showMessage();
}

public class Ex10InnerClass {
	Hello hello1=new Hello() {
		
		@Override
		public void showMessage() {
			// TODO Auto-generated method stub
			System.out.println("버튼 이벤트를 처리했어요");
		}
	};
	
	Hello hello2=new Hello() {
		
		@Override
		public void showMessage() {
			// TODO Auto-generated method stub
			System.out.println("데이타 처리를 했어요");
		}
	};
	
	class SubHello extends Hello
	{
		@Override
		public void showMessage() {
			// TODO Auto-generated method stub
			System.out.println("이미지 처리를 했어요");
		}
	}
	
	public void write()
	{
		SubHello s=new SubHello();
		s.showMessage();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex10InnerClass ex=new Ex10InnerClass();
		ex.hello1.showMessage();
		ex.hello2.showMessage();
		ex.write();
		
		Ex10InnerClass.SubHello h=ex.new SubHello();
		h.showMessage();
	}

}
