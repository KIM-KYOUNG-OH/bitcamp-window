package day0914;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

//����:5���� ������ư(�迭) �� �����Ҷ����� �̹��� �����ϱ�
//�̹����� �ڱ� �������....(Ex3�� �ణ �����ؼ� �ϼ���)

public class Ex5RadioImage extends JFrame{
	JRadioButton []rb=new JRadioButton[5];
	DrawImage draw=new DrawImage();
	String []title= {"������","����","���丮��","�̳���","������"};
	
	String imageName1="D:\\java0901\\image\\�����λ���\\31.JPG";
	String imageName2="D:\\java0901\\image\\�����λ���\\4.JPG";
	String imageName3="D:\\java0901\\image\\�����λ���\\26.JPG";
	String imageName4="D:\\java0901\\image\\�����λ���\\23.JPG";
	String imageName5="D:\\java0901\\image\\�����λ���\\24.JPG";
	
	Image image;
	
	public Ex5RadioImage(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 500, 600);//������ġx,y,ũ�� w,h
		this.getContentPane().setBackground(Color.white);//���������� �ִ� �г��� ���� ����
		//this.getContentPane().setBackground(new Color(211,225,208));//���������� �ִ� �г��� ���� ����
		this.setDesign();//������ �ڵ�
		this.setVisible(true);//���̰� �ϱ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���α׷��� �������ִ� �޼���
	}
	
	//�̹����� �׸��� ���� ����Ŭ����
	class DrawImage extends Canvas
	{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			g.drawImage(image, 60, 30, 300, 400, this);
		}
	}
	
	public void setDesign()
	{
		this.setLayout(null);
		//������ư
		ButtonGroup bg=new ButtonGroup();
		int xPos=20;
		for(int i=0;i<rb.length;i++)
		{
			rb[i]=new JRadioButton(title[i], i==2?true:false);
			rb[i].setBounds(xPos, 30, 80, 30);
			rb[i].setOpaque(false);
			this.add(rb[i]);
			bg.add(rb[i]);
			xPos+=80;
			final int idx=i;
			
			//�͸���Ŭ������ �̺�Ʈ
			rb[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					//i��° �̹��� ����
					switch (idx) {
					case 0:
						image=new ImageIcon(imageName1).getImage();
						break;
					case 1:
						image=new ImageIcon(imageName2).getImage();
						break;
					case 2:
						image=new ImageIcon(imageName3).getImage();
						break;
					case 3:
						image=new ImageIcon(imageName4).getImage();
						break;
					case 4:
						image=new ImageIcon(imageName5).getImage();
						break;
					}
					//ĵ�ٽ� paint ȣ��
					draw.repaint();
				}
			});
		}
		
		//DrawImage �߰�
		//�ʱ� �̹���-���丮��
		image=new ImageIcon(imageName3).getImage();
		draw.setBounds(0, 100, 500, 500);
		this.add(draw);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex5RadioImage("�̹�������");
	}

}











