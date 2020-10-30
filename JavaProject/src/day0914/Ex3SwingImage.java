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
	//�̹��� ��� 3��
	String imageName1="D:\\java0901\\image\\�����λ���\\5.JPG";
	String imageName2="D:\\java0901\\image\\�����λ���\\26.JPG";
	String imageName3="D:\\java0901\\image\\�����λ���\\13.JPG";

	Image image;
	JButton btn1,btn2,btn3;
	MyImage myImage;

	public Ex3SwingImage(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 500, 600);//������ġx,y,ũ�� w,h
		this.getContentPane().setBackground(Color.white);//���������� �ִ� �г��� ���� ����
		//this.getContentPane().setBackground(new Color(211,225,208));//���������� �ִ� �г��� ���� ����
		this.setDesign();//������ �ڵ�
		this.setVisible(true);//���̰� �ϱ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���α׷��� �������ִ� �޼���
	}

	public void setDesign()
	{
		this.setLayout(null);
		btn1=new JButton("������");
		btn1.setBounds(20, 20, 100, 30);
		this.add(btn1);

		btn2=new JButton("���丮��");
		btn2.setBounds(140, 20, 100, 30);
		this.add(btn2);

		btn3=new JButton("�ں���");
		btn3.setBounds(260, 20, 100, 30);
		this.add(btn3);

		//�⺻�̹���(������) �� ����
		image=new ImageIcon(imageName1).getImage();

		//ĵ�ٽ� ����
		myImage=new MyImage();
		myImage.setBounds(0, 60, 500, 500);
		this.add(myImage);

		//��ư2�̺�Ʈ
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//�̹��� �ٽ� ����
				image=new ImageIcon(imageName2).getImage();
				//ĵ�ٽ��� paint �ٽ� ȣ��
				myImage.repaint();//paint �޼��带 ���� ȣ��
			}
		});

		//��ư1�̺�Ʈ
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//�̹��� �ٽ� ����
				image=new ImageIcon(imageName1).getImage();
				//ĵ�ٽ��� paint �ٽ� ȣ��
				myImage.repaint();//paint �޼��带 ���� ȣ��
			}
		});

		//��ư3�̺�Ʈ
		btn3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//�̹��� �ٽ� ����
				image=new ImageIcon(imageName3).getImage();
				//ĵ�ٽ��� paint �ٽ� ȣ��
				myImage.repaint();//paint �޼��带 ���� ȣ��
			}
		});
	}

	//����Ŭ����
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
		new Ex3SwingImage("�̹�������");
	}

}







