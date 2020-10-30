package day0929;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex3ThreadCircle  extends JFrame implements ActionListener{
	JButton btnStart,btnStop;
	boolean bStart=false;//true면 원그리기 반복
	//내부 클래스 선언
	CircleDraw draw=new CircleDraw();
	
	public Ex3ThreadCircle(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 500, 500);//시작위치x,y,크기 w,h
		this.getContentPane().setBackground(Color.white);//프레임위에 있는 패널의 색상 변경
		//this.getContentPane().setBackground(new Color(211,225,208));//프레임위에 있는 패널의 색상 변경
		this.setDesign();//디자인 코드
		this.setVisible(true);//보이게 하기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프로그램을 종료해주는 메서드
	}
	
	public void setDesign()
	{
		this.setLayout(null);
		
		btnStart=new JButton("Start");
		btnStart.setBounds(100, 20, 100, 30);
		btnStart.addActionListener(this);
		
		btnStop=new JButton("Stop");
		btnStop.setBounds(300, 20, 100, 30);
		btnStop.addActionListener(this);
		
		this.add(btnStart);
		this.add(btnStop);
		
		draw.setBounds(0, 60, 500, 400);
		this.add(draw);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		
		Thread th=new Thread(draw);
		if(ob==btnStart)
		{
			bStart=true;
		}else if(ob==btnStop)
		{
			bStart=false;
		}
		th.start();//내부클래스의 run메소드 호출
	}
	
	//원그리는 내부클래스
	class CircleDraw extends Canvas implements Runnable
	{
		int x,y;
		int red,green,blue;
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(bStart)
			{
				x=(int)(Math.random()*500);
				y=(int)(Math.random()*400)+50;
				red=(int)(Math.random()*256);
				green=(int)(Math.random()*256);
				blue=(int)(Math.random()*256);
				
				//this.repaint();//paint 메서드 호출,이전 원이 지워진다
				this.paint(getGraphics());//이전 원 안지워지도록 이렇게 호출해보자
				
				try {
					Thread.sleep(100);//0.1초
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			//super.paint(g);
			
			if(bStart)
			{
				g.setColor(new Color(red,green,blue));
				g.fillOval(x, y, 60, 60);
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3ThreadCircle ex=new Ex3ThreadCircle("스레드연습");
	}

}





