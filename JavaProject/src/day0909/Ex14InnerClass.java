package day0909;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Ex14InnerClass extends JFrame{
	public Ex14InnerClass() {
		// TODO Auto-generated constructor stub
		super("����Ŭ��������");
		this.setSize(400, 200);
		this.setLocation(500, 100);
		this.setVisible(true);
		//������ �̺�Ʈ �߰�
		this.addWindowListener(new WindowClose());
	}
	
	//���� Ŭ���� ����
	class WindowClose extends WindowAdapter
	{
		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("�����մϴ�");
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex14InnerClass ex=new Ex14InnerClass();
	}

}
