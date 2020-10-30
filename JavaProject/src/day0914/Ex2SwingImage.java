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
		this.setBounds(700, 100, 500, 500);//������ġx,y,ũ�� w,h
		this.getContentPane().setBackground(Color.white);//���������� �ִ� �г��� ���� ����
		//this.getContentPane().setBackground(new Color(211,225,208));//���������� �ִ� �г��� ���� ����
		this.setDesign();//������ �ڵ�
		this.setVisible(true);//���̰� �ϱ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���α׷��� �������ִ� �޼���
	}
	
	//ó�� ���۽� �Ǵ� ������ ũ�� ����ÿ� �ڵ�ȣ��Ǵ� �޼���
	//���� ������ ȣ���Ϸ��� repaint()
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		System.out.println("paint");
		//���� ����
		g.setColor(Color.magenta);
		g.drawOval(50, 50, 100, 150);//�׵θ����� �ִ� Ÿ��
		g.fillOval(200, 50, 100, 150);//ä��⸦ �� Ÿ��
		
		//�簢��
		g.setColor(Color.green);
		g.drawRect(50, 200, 100, 100);
		g.fillRect(200, 200, 100, 100);
		
		//�̹����� ImageŸ������ �� ���
		//Image Ÿ������ �����ϴ� ��� 2����
		Image image1=Toolkit.getDefaultToolkit().getImage("D:\\java0901\\image\\���θ�����\\9.jpg");
		Image image2=new ImageIcon("D:\\java0901\\image\\�����λ���\\1.JPG").getImage();
		
		//�̹��� ���
		g.drawImage(image1, 30, 350, 150, 150, this);//image,x,y,width,height
		g.drawImage(image2, 300, 50, 200, 300, this);
	}
	
	
	public void setDesign()
	{
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex2SwingImage("�̹������");
	}

}
