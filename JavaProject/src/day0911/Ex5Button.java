package day0911;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class Ex5Button extends JFrame{
	Icon icon1=new ImageIcon("D:\\java0901\\image\\swingimage\\img10.gif");
	Icon icon2=new ImageIcon("D:\\java0901\\image\\swingimage\\LEFT.GIF");
	Icon icon3=new ImageIcon("D:\\java0901\\image\\swingimage\\RIGHT.GIF");
	JButton btn1,btn2,btn3;
	JLabel lblMsg;
	
	public Ex5Button(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 300, 300);//������ġx,y,ũ�� w,h
		this.getContentPane().setBackground(Color.pink);//���������� �ִ� �г��� ���� ����
		//this.getContentPane().setBackground(new Color(211,225,208));//���������� �ִ� �г��� ���� ����
		this.setDesign();//������ �ڵ�
		this.setVisible(true);//���̰� �ϱ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���α׷��� �������ִ� �޼���
	}
	
	public void setDesign()
	{
		//�⺻���̾ƿ��� ��ȿȭ
		this.setLayout(null);
		btn1=new JButton(icon2);//��ư ����
		btn1.setBounds(30, 50, 100, 100);//��ġ,ũ�� ����
		this.add(btn1);//�����ӿ� �߰�
		btn2=new JButton(icon3);//��ư ����
		btn2.setBounds(140, 50, 100, 100);//��ġ,ũ�� ����
		this.add(btn2);//�����ӿ� �߰�
		
		//�� ����
		lblMsg=new JLabel("Result", icon1, JLabel.CENTER);
		lblMsg.setBounds(20, 170, 250, 60);
		//border ����
		//lblMsg.setBorder(new TitledBorder("Result Area"));
		lblMsg.setBorder(new LineBorder(Color.red,2));
		//������ ���� ����
		lblMsg.setOpaque(true);
		lblMsg.setBackground(Color.green);
		lblMsg.setFont(new Font("Comic Sans MS",Font.BOLD|Font.ITALIC,20));
		this.add(lblMsg);
		
		//��ư1 �̺�Ʈ(�͸� ���� Ŭ����)
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				lblMsg.setText("Left Button Clicked!!");
			}
		});
		//��ư2 �̺�Ʈ (����Ŭ����)
		btn2.addActionListener(new MyButton());
	}
	
	class MyButton implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			lblMsg.setText("Right Button Clicked!!");
		}		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex5Button("��ư����2");
	}

}






