package day0914;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Ex1Button extends JFrame implements ActionListener{
	JTextField txtNum1,txtNum2;
	JButton []btn=new JButton[4];
	String []title= {"+","-","*","/"};
	JLabel lblResult;
	
	public Ex1Button(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 300, 300);//������ġx,y,ũ�� w,h
		//this.getContentPane().setBackground(Color.orange);//���������� �ִ� �г��� ���� ����
		this.getContentPane().setBackground(new Color(211,225,208));//���������� �ִ� �г��� ���� ����
		this.setDesign();//������ �ڵ�
		this.setVisible(true);//���̰� �ϱ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���α׷��� �������ִ� �޼���
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();//�̺�Ʈ�� �߻��� ������Ʈ
		//�� ���� �б�
		String n1,n2;
		n1=txtNum1.getText();
		n2=txtNum2.getText();
		//System.out.println(n1+","+n2);
		try {
			//���ڰ� ����������� �̼����� �߻��Ѵ�
			int num1=Integer.parseInt(n1);
			int num2=Integer.parseInt(n2);
			String msg="";
			if(ob==btn[0])//���ϱ� ��ư
				msg=num1+"+"+num2+"="+(num1+num2);
			else if(ob==btn[1])//���� ��ư
				msg=num1+"-"+num2+"="+(num1-num2);
			else if(ob==btn[2])//���ϱ� ��ư
				msg=num1+"*"+num2+"="+(num1*num2);
			else if(ob==btn[3])//������ ��ư
				msg=num1+"/"+num2+"="+((double)num1/num2);
			
			//�󺧿� ����� ���
			lblResult.setText(msg);
			//�Է°� �ʱ�ȭ
			//txtNum1.setText("");
			//txtNum2.setText("");
		}catch(NumberFormatException e1)
		{
			JOptionPane.showMessageDialog(this, "���ڷ� �Է����ּ���:"+e1.getMessage());
		}
	}
	
	public void setDesign()
	{
		//���̾ƿ��� ��ȿȭ
		this.setLayout(null);
		
		//�ؽ�Ʈ�ʵ� ����
		txtNum1=new JTextField();
		txtNum1.setBounds(30, 30, 80, 30);
		this.add(txtNum1);
		
		txtNum2=new JTextField();
		txtNum2.setBounds(130, 30, 80, 30);
		this.add(txtNum2);
		
		//��ư �迭
		int xPos=10;
		for(int i=0;i<btn.length;i++)
		{
			//��ư ����
			btn[i]=new JButton(title[i]);
			//��ư ��ġ�� ũ�� ����
			btn[i].setBounds(xPos, 80, 60, 30);
			//�����ӿ� �߰�
			this.add(btn[i]);
			xPos+=70;
			//��ư �̺�Ʈ �߻�
			btn[i].addActionListener(this);
		}
		
		//��
		lblResult=new JLabel();
		lblResult.setBorder(new TitledBorder("Result"));
		lblResult.setBounds(30, 150, 230, 60);
		this.add(lblResult);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex1Button("��ư����");
	}

}










