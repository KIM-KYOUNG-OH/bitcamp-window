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
	String imageName="D:\\java0901\\image\\�Ϳ��� ������\\c1.png";
	Image image;
	JButton btnLeft,btnRight,btnUp,btnDown;
	//�̹��� �ʱ� ��ġ
	int xPos=300;
	int yPos=300;
	//ĵ�ٽ� ����Ŭ����
	ImageMove im;
	
	public Ex7ImageMunje(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 800, 800);//������ġx,y,ũ�� w,h
		//this.getContentPane().setBackground(Color.orange);//���������� �ִ� �г��� ���� ����
		this.getContentPane().setBackground(new Color(211,225,208));//���������� �ִ� �г��� ���� ����
		this.setDesign();//������ �ڵ�
		this.setVisible(true);//���̰� �ϱ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���α׷��� �������ִ� �޼���
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();//�̺�Ʈ�� �߻��� ������Ʈ�� ����
		if(ob==btnLeft)
			xPos-=20;
		else if(ob==btnRight)
			xPos+=20;
		else if(ob==btnUp)
			yPos-=20;
		else if(ob==btnDown)
			yPos+=20;
		im.repaint();//ĵ�ٽ� ����Ŭ������ ���� paint �ٽ� ȣ��
	}
	
	public void setDesign()
	{
		this.setLayout(null);

		btnLeft=new JButton("����");
		btnLeft.setBounds(30, 20, 100, 30);
		this.add(btnLeft);
		
		btnRight=new JButton("������");
		btnRight.setBounds(150, 20, 100, 30);
		this.add(btnRight);
		
		btnUp=new JButton("��");
		btnUp.setBounds(270, 20, 100, 30);
		this.add(btnUp);
		
		btnDown=new JButton("�Ʒ�");
		btnDown.setBounds(390, 20, 100, 30);
		this.add(btnDown);
		
		image=new ImageIcon(imageName).getImage();
		im=new ImageMove();//����Ŭ���� ����
		im.setBounds(10, 60, 800, 700);
		this.add(im);
		
		//��ư �̺�Ʈ
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
		new Ex7ImageMunje("�̹����̵�");
	}

}
