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
	boolean bStart=false;//true�� ���׸��� �ݺ�
	//���� Ŭ���� ����
	CircleDraw draw=new CircleDraw();
	
	public Ex3ThreadCircle(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 500, 500);//������ġx,y,ũ�� w,h
		this.getContentPane().setBackground(Color.white);//���������� �ִ� �г��� ���� ����
		//this.getContentPane().setBackground(new Color(211,225,208));//���������� �ִ� �г��� ���� ����
		this.setDesign();//������ �ڵ�
		this.setVisible(true);//���̰� �ϱ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���α׷��� �������ִ� �޼���
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
		th.start();//����Ŭ������ run�޼ҵ� ȣ��
	}
	
	//���׸��� ����Ŭ����
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
				
				//this.repaint();//paint �޼��� ȣ��,���� ���� ��������
				this.paint(getGraphics());//���� �� ������������ �̷��� ȣ���غ���
				
				try {
					Thread.sleep(100);//0.1��
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
		Ex3ThreadCircle ex=new Ex3ThreadCircle("�����忬��");
	}

}





