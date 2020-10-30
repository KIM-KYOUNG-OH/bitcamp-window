package day0915;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class Ex1Choice extends JFrame{
	Choice choice;
	JComboBox<String> combo;
	
	String []title= {"����","�Ķ�","�ʷ�","��ȫ","������","����"};
	Color []color= {Color.red,Color.blue,Color.green,Color.pink,Color.orange,Color.black};
	
	JLabel lblMessage;
	
	public Ex1Choice(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(1500, 100, 300, 300);//������ġx,y,ũ�� w,h
		//this.getContentPane().setBackground(Color.orange);//���������� �ִ� �г��� ���� ����
		this.getContentPane().setBackground(new Color(211,225,208));//���������� �ִ� �г��� ���� ����
		this.setDesign();//������ �ڵ�
		this.setVisible(true);//���̰� �ϱ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���α׷��� �������ִ� �޼���
	}
	
	public void setDesign()
	{
		this.setLayout(null);
		choice=new Choice();
		for(String t:title)
			choice.add(t);
		//�ʱⰪ ����
		choice.select(5);//black����
		choice.setBounds(20, 20, 80, 30);
		this.add(choice);
		
		combo=new JComboBox<String>(title);
		combo.setBounds(130, 20, 100, 30);
		this.add(combo);
		
		//label
		lblMessage=new JLabel("Choice & JComboBox",JLabel.CENTER);
		lblMessage.setBorder(new LineBorder(Color.gray,3));
		lblMessage.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		lblMessage.setBounds(20, 150, 250, 50);
		this.add(lblMessage);	
		
		//choice �̺�Ʈ
		choice.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				int idx=choice.getSelectedIndex();
				String item=choice.getSelectedItem();
				//���ڻ� ����
				lblMessage.setForeground(color[idx]);
				//�޼��� ���
				//lblMessage.setText("index :"+idx+" select");
				System.out.println(item);
			}
		});
		
		//combo �̺�Ʈ
//		combo.addItemListener(new ItemListener() {
//			
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				// TODO Auto-generated method stub
//				int idx=combo.getSelectedIndex();
//				lblMessage.setForeground(color[idx]);
//				System.out.println(idx);//2�� ���
//			}
//		});
		
		combo.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int idx=combo.getSelectedIndex();
				lblMessage.setForeground(color[idx]);
				System.out.println(idx);
			}
		});
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex1Choice("choice������Ʈ");
	}

}










