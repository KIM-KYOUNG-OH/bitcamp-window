package day0909;

interface WindowEvent
{
	public void windowClose();
	public void windowIcon();
	public void windowOpen();
}

public class Ex11InnerClass {

	//WindowEvent �� �͸� ���� Ŭ���� ���·� �����Ͻÿ�
	//�������� win
	WindowEvent win=new WindowEvent() {
		
		@Override
		public void windowOpen() {
			// TODO Auto-generated method stub
			System.out.println("������ ����");
		}
		
		@Override
		public void windowIcon() {
			// TODO Auto-generated method stub
			System.out.println("������ ������ȭ");
		}
		
		@Override
		public void windowClose() {
			// TODO Auto-generated method stub
			System.out.println("������ �ݱ�");
		}
	};
	
	//WindowEvent �� �����ϴ� ����Ŭ���� SubWindow �� �����Ͻÿ�
	class SubWindow implements WindowEvent
	{
		@Override
		public void windowOpen() {
			// TODO Auto-generated method stub
			System.out.println("������ ����");
		}
		
		@Override
		public void windowIcon() {
			// TODO Auto-generated method stub
			System.out.println("������ ������ȭ");
		}
		
		@Override
		public void windowClose() {
			// TODO Auto-generated method stub
			System.out.println("������ �ݱ�");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex11InnerClass ex=new Ex11InnerClass();
		//�͸� ����ũ���� ������ �޼ҵ� ȣ��
		ex.win.windowClose();
		ex.win.windowIcon();
		ex.win.windowClose();
		System.out.println();
		//SubWindow ����Ŭ���� ������ �޼ҵ� ȣ��
		Ex11InnerClass.SubWindow sub=ex.new SubWindow();
		sub.windowClose();
		sub.windowIcon();
		sub.windowOpen();
	}

}






