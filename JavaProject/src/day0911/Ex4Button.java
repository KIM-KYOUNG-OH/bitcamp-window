package day0911;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex4Button extends JFrame{
	Icon icon1=new ImageIcon("D:\\java0901\\image\\swingimage\\img10.gif");
	Icon icon2=new ImageIcon("D:\\java0901\\image\\swingimage\\LEFT.GIF");
	Icon icon3=new ImageIcon("D:\\java0901\\image\\swingimage\\leftDown.gif");
	JButton btn1,btn2;
	
	public Ex4Button(String title) {
		// TODO Auto-generated constructor stub 
		super(title);
		this.setBounds(700, 100, 300, 300);//������ġx,y,ũ�� w,h
		//this.getContentPane().setBackground(Color.orange);//���������� �ִ� �г��� ���� ����
		this.getContentPane().setBackground(new Color(211,225,208));//���������� �ִ� �г��� ���� ����
		this.setDesign();//������ �ڵ�
		this.setVisible(true);//���̰� �ϱ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���α׷��� �������ִ� �޼���
	}
	
	public void setDesign()
	{
		//Frame�� �⺻�� BorderLayout �̴�(������������ ��ġ�Ǵ� ���̾ƿ� ����̴�)
		btn1=new JButton("My Button",icon1);
		//�����ӿ� �߰�
		//this.add(btn1);//�������� �⺻�� BorderLayout �̶� ��ġ�� �������� ������ ��ü������ ����
		this.add("North",btn1);//���ڿ�,������Ʈ
		
		//btn2=new JButton("My Button2");
		btn2=new JButton(icon2);
		//���ý� �̹����� icon3�� ����ǵ��� �޼��� ã�ƺ�����
		//btn2.setPressedIcon(icon3);//Ŭ���� ������ ����
		btn2.setRolloverIcon(icon3);//���콺 �ѿ����� ������ ����
		this.add(btn2,BorderLayout.SOUTH);//������Ʈ,���
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4Button ex=new Ex4Button("��ư����");
	}

}






