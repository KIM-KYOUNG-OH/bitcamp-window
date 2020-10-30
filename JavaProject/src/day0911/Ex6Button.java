package day0911;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex6Button extends JFrame implements ActionListener{
	JButton btn1,btn2,btn3;
	
	public Ex6Button(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 300, 300);//������ġx,y,ũ�� w,h
		//this.getContentPane().setBackground(Color.orange);//���������� �ִ� �г��� ���� ����
		//this.getContentPane().setBackground(new Color(211,225,208));//���������� �ִ� �г��� ���� ����
		this.setDesign();//������ �ڵ�
		this.setVisible(true);//���̰� �ϱ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���α׷��� �������ִ� �޼���
	}
	
	public void setDesign()
	{
		this.setLayout(null);
		btn1=new JButton("��ư1");
		btn1.setBounds(30, 20, 100, 30);
		this.add(btn1);
		
		btn2=new JButton("��ư2");
		btn2.setBounds(30, 70, 100, 30);
		this.add(btn2);
		
		btn3=new JButton("��ư3");
		btn3.setBounds(30, 120, 100, 30);
		this.add(btn3);		
		
		//��ư3���� �̺�Ʈ �߰�
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
	}	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();//�̺�Ʈ�� �߻��� ������Ʈ�� ��ȯ
		if(ob==btn1)
		{
			System.out.println("��ư1");
			this.getContentPane().setBackground(Color.magenta);
		}else if(ob==btn2)
		{
			System.out.println("��ư2");
			this.getContentPane().setBackground(Color.blue);
		}else {
			System.out.println("��ư3");
			this.getContentPane().setBackground(Color.orange);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex6Button("��ư����3");
	}

}








