package day0909;

interface WindowEvent
{
	public void windowClose();
	public void windowIcon();
	public void windowOpen();
}

public class Ex11InnerClass {

	//WindowEvent 를 익명 내부 클래스 형태로 구현하시오
	//변수명은 win
	WindowEvent win=new WindowEvent() {
		
		@Override
		public void windowOpen() {
			// TODO Auto-generated method stub
			System.out.println("윈도우 오픈");
		}
		
		@Override
		public void windowIcon() {
			// TODO Auto-generated method stub
			System.out.println("윈도우 아이콘화");
		}
		
		@Override
		public void windowClose() {
			// TODO Auto-generated method stub
			System.out.println("윈도우 닫기");
		}
	};
	
	//WindowEvent 를 구현하는 내부클래스 SubWindow 를 구현하시오
	class SubWindow implements WindowEvent
	{
		@Override
		public void windowOpen() {
			// TODO Auto-generated method stub
			System.out.println("윈도우 오픈");
		}
		
		@Override
		public void windowIcon() {
			// TODO Auto-generated method stub
			System.out.println("윈도우 아이콘화");
		}
		
		@Override
		public void windowClose() {
			// TODO Auto-generated method stub
			System.out.println("윈도우 닫기");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex11InnerClass ex=new Ex11InnerClass();
		//익명 내부크래스 선언후 메소드 호출
		ex.win.windowClose();
		ex.win.windowIcon();
		ex.win.windowClose();
		System.out.println();
		//SubWindow 내부클래스 선언후 메소드 호출
		Ex11InnerClass.SubWindow sub=ex.new SubWindow();
		sub.windowClose();
		sub.windowIcon();
		sub.windowOpen();
	}

}






