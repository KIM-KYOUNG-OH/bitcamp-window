package day0909;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class Ex12InnerFrame extends JFrame {

	public Ex12InnerFrame() {
		// TODO Auto-generated constructor stub
		super("내부클래스연습");
		this.setLocation(600, 100);
		this.setSize(400, 200);//너비,높이
		this.setVisible(true);//보이게 하기		
		
		//윈도우 이벤트
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("windowOpened");
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("windowIconified");
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("windowDeiconified");
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("windowDeactivated");
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("windowClosing");
				//실제 종료 코드
				System.exit(0);//종료
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("windowClosed");
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				System.out.println("windowActivated");
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex12InnerFrame ex=new Ex12InnerFrame();
	}
}
