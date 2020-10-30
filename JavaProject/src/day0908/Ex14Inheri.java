package day0908;

import javax.swing.JFrame;

public class Ex14Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//JFrame 생성(타이틀 전송)-창제목은 상속공부
		JFrame frame=new JFrame("상속공부");
		//사이즈 지정 : setSize  - 가로 300,세로 300
		frame.setSize(300, 300);
		//시작위치지정 : setLocation  - x 300 y 100
		frame.setLocation(300, 100);
		//보이게 하기 : setVisible
		frame.setVisible(true);
		
	}

}
