package day0911;

import java.awt.Color;

import javax.swing.JFrame;

public class SwingGibon extends JFrame{
	public SwingGibon(String title) {
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
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingGibon s=new SwingGibon("�⺻â");
	}

}
