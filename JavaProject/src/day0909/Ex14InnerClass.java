package day0909;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Ex14InnerClass extends JFrame{
	public Ex14InnerClass() {
		// TODO Auto-generated constructor stub
		super("내부클래스연습");
		this.setSize(400, 200);
		this.setLocation(500, 100);
		this.setVisible(true);
		//윈도우 이벤트 추가
		this.addWindowListener(new WindowClose());
	}
	
	//내부 클래스 구현
	class WindowClose extends WindowAdapter
	{
		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("종료합니다");
			System.exit(0);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex14InnerClass ex=new Ex14InnerClass();
	}

}
