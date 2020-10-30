package day0911;

import java.awt.Color;

import javax.swing.JFrame;

public class SwingGibon extends JFrame{
	public SwingGibon(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 300, 300);//시작위치x,y,크기 w,h
		//this.getContentPane().setBackground(Color.orange);//프레임위에 있는 패널의 색상 변경
		this.getContentPane().setBackground(new Color(211,225,208));//프레임위에 있는 패널의 색상 변경
		this.setDesign();//디자인 코드
		this.setVisible(true);//보이게 하기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프로그램을 종료해주는 메서드
	}
	
	public void setDesign()
	{
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingGibon s=new SwingGibon("기본창");
	}

}
