package day0914;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex3SwingImage extends JFrame{
	//이미지 경로 3개
	String imageName1="D:\\java0901\\image\\연예인사진\\5.JPG";
	String imageName2="D:\\java0901\\image\\연예인사진\\26.JPG";
	String imageName3="D:\\java0901\\image\\연예인사진\\13.JPG";

	Image image;
	JButton btn1,btn2,btn3;
	MyImage myImage;

	public Ex3SwingImage(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 500, 600);//시작위치x,y,크기 w,h
		this.getContentPane().setBackground(Color.white);//프레임위에 있는 패널의 색상 변경
		//this.getContentPane().setBackground(new Color(211,225,208));//프레임위에 있는 패널의 색상 변경
		this.setDesign();//디자인 코드
		this.setVisible(true);//보이게 하기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프로그램을 종료해주는 메서드
	}

	public void setDesign()
	{
		this.setLayout(null);
		btn1=new JButton("김태희");
		btn1.setBounds(20, 20, 100, 30);
		this.add(btn1);

		btn2=new JButton("산토리니");
		btn2.setBounds(140, 20, 100, 30);
		this.add(btn2);

		btn3=new JButton("박보영");
		btn3.setBounds(260, 20, 100, 30);
		this.add(btn3);

		//기본이미지(김태희) 로 생성
		image=new ImageIcon(imageName1).getImage();

		//캔바스 생성
		myImage=new MyImage();
		myImage.setBounds(0, 60, 500, 500);
		this.add(myImage);

		//버튼2이벤트
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//이미지 다시 생성
				image=new ImageIcon(imageName2).getImage();
				//캔바스의 paint 다시 호출
				myImage.repaint();//paint 메서드를 강제 호출
			}
		});

		//버튼1이벤트
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//이미지 다시 생성
				image=new ImageIcon(imageName1).getImage();
				//캔바스의 paint 다시 호출
				myImage.repaint();//paint 메서드를 강제 호출
			}
		});

		//버튼3이벤트
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//이미지 다시 생성
				image=new ImageIcon(imageName3).getImage();
				//캔바스의 paint 다시 호출
				myImage.repaint();//paint 메서드를 강제 호출
			}
		});
	}

	//내부클래스
	class MyImage extends Canvas
	{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			//System.out.println("paint");
			g.drawImage(image, 50, 20, 350, 430, this);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex3SwingImage("이미지변경");
	}

}







