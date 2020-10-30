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

public class Ex7ImageMunje  extends JFrame implements ActionListener{
	String imageName="D:\\java0901\\image\\귀여운 아이콘\\c1.png";
	Image image;
	JButton btnLeft,btnRight,btnUp,btnDown;
	//이미지 초기 위치
	int xPos=300;
	int yPos=300;
	//캔바스 내부클래스
	ImageMove im;
	
	public Ex7ImageMunje(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 800, 800);//시작위치x,y,크기 w,h
		//this.getContentPane().setBackground(Color.orange);//프레임위에 있는 패널의 색상 변경
		this.getContentPane().setBackground(new Color(211,225,208));//프레임위에 있는 패널의 색상 변경
		this.setDesign();//디자인 코드
		this.setVisible(true);//보이게 하기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프로그램을 종료해주는 메서드
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();//이벤트가 발생한 오브젝트를 얻음
		if(ob==btnLeft)
			xPos-=20;
		else if(ob==btnRight)
			xPos+=20;
		else if(ob==btnUp)
			yPos-=20;
		else if(ob==btnDown)
			yPos+=20;
		im.repaint();//캔바스 내부클래스가 가진 paint 다시 호출
	}
	
	public void setDesign()
	{
		this.setLayout(null);

		btnLeft=new JButton("왼쪽");
		btnLeft.setBounds(30, 20, 100, 30);
		this.add(btnLeft);
		
		btnRight=new JButton("오른쪽");
		btnRight.setBounds(150, 20, 100, 30);
		this.add(btnRight);
		
		btnUp=new JButton("위");
		btnUp.setBounds(270, 20, 100, 30);
		this.add(btnUp);
		
		btnDown=new JButton("아래");
		btnDown.setBounds(390, 20, 100, 30);
		this.add(btnDown);
		
		image=new ImageIcon(imageName).getImage();
		im=new ImageMove();//내부클래스 생성
		im.setBounds(10, 60, 800, 700);
		this.add(im);
		
		//버튼 이벤트
		btnLeft.addActionListener(this);
		btnRight.addActionListener(this);
		btnUp.addActionListener(this);
		btnDown.addActionListener(this);		
	}

	class ImageMove extends Canvas
	{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			g.drawImage(image, xPos, yPos, 120, 150, this);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex7ImageMunje("이미지이동");
	}

}
