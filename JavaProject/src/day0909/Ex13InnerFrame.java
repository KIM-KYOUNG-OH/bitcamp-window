package day0909;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Ex13InnerFrame extends JFrame{

	public Ex13InnerFrame() {
		// TODO Auto-generated constructor stub
		super("����Ŭ��������");
		this.setSize(400, 200);
		this.setLocation(500, 100);
		this.setVisible(true);
		//������ ���� �̺�Ʈ �߰�-�͸� ���� Ŭ���� ���·� �����ϱ�
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("�����մϴ�");
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex13InnerFrame ex=new Ex13InnerFrame();
	}

}
