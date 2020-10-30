package day0909;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Ex13InnerFrame extends JFrame{

	public Ex13InnerFrame() {
		// TODO Auto-generated constructor stub
		super("내부클래스연습");
		this.setSize(400, 200);
		this.setLocation(500, 100);
		this.setVisible(true);
		//윈도우 종료 이벤트 추가-익명 내부 클래스 형태로 구현하기
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("종료합니다");
				System.exit(0);
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex13InnerFrame ex=new Ex13InnerFrame();
	}

}
