package day0914;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Ex2SwingImage extends JFrame{
	public Ex2SwingImage(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 500, 500);//시작위치x,y,크기 w,h
		this.getContentPane().setBackground(Color.white);//프레임위에 있는 패널의 색상 변경
		//this.getContentPane().setBackground(new Color(211,225,208));//프레임위에 있는 패널의 색상 변경
		this.setDesign();//디자인 코드
		this.setVisible(true);//보이게 하기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프로그램을 종료해주는 메서드
	}
	
	//처음 시작시 또는 프레임 크기 변경시에 자동호출되는 메서드
	//만약 강제로 호출하려면 repaint()
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		System.out.println("paint");
		//색상 변경
		g.setColor(Color.magenta);
		g.drawOval(50, 50, 100, 150);//테두리선만 있는 타원
		g.fillOval(200, 50, 100, 150);//채우기를 한 타원
		
		//사각형
		g.setColor(Color.green);
		g.drawRect(50, 200, 100, 100);
		g.fillRect(200, 200, 100, 100);
		
		//이미지는 Image타입으로 얻어서 출력
		//Image 타입으로 생성하는 방법 2가지
		Image image1=Toolkit.getDefaultToolkit().getImage("D:\\java0901\\image\\쇼핑몰사진\\9.jpg");
		Image image2=new ImageIcon("D:\\java0901\\image\\연예인사진\\1.JPG").getImage();
		
		//이미지 출력
		g.drawImage(image1, 30, 350, 150, 150, this);//image,x,y,width,height
		g.drawImage(image2, 300, 50, 200, 300, this);
	}
	
	
	public void setDesign()
	{
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex2SwingImage("이미지출력");
	}

}
