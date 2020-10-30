package day0911;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class Ex8ButtonArray extends JFrame implements ActionListener{
	JButton []btn=new JButton[7];
	JLabel lblColor;
	String []btnTitle= {"Red","Blue","Green","Magenta","Yellow","Orange","Pink"};
	Color []color= {Color.red,Color.blue,Color.green,Color.magenta,Color.yellow,
			Color.orange,Color.pink};
	
	public Ex8ButtonArray(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 400, 400);//������ġx,y,ũ�� w,h
		//this.getContentPane().setBackground(Color.orange);//���������� �ִ� �г��� ���� ����
		this.getContentPane().setBackground(new Color(211,225,208));//���������� �ִ� �г��� ���� ����
		this.setDesign();//������ �ڵ�
		this.setVisible(true);//���̰� �ϱ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���α׷��� �������ִ� �޼���
	}
	
	public void setDesign()
	{
		int yPos=20;
		//���̾ƿ� ��ȿȭ
		this.setLayout(null);
		//7���� ��ư ���� �� �̺�Ʈ
		
		for(int i=0;i<btn.length;i++)
		{
			//��ư ����
			btn[i]=new JButton(btnTitle[i]);
			//��ġ,ũ�� ����
			btn[i].setBounds(20, yPos, 100, 30);
			//���ڻ��� �ش� �������� ����
			btn[i].setForeground(color[i]);
			//�����ӿ� �߰�
			this.add(btn[i]);
			yPos+=40;
			final int idx=i;
			//�̺�Ʈ �߰�-����Ŭ���������� ����
			btn[i].addActionListener(this);		
		}
		
		//�� �߰�
		lblColor=new JLabel();
		lblColor.setBounds(150, 20, 210, 270);
		lblColor.setBorder(new LineBorder(Color.DARK_GRAY));
		lblColor.setOpaque(true);
		this.add(lblColor);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//�̺�Ʈ�� �߻��� ������Ʈ�� ����
		Object ob=e.getSource();
		for(int i=0;i<btn.length;i++)
		{
			if(ob==btn[i])
				lblColor.setBackground(color[i]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex8ButtonArray("��ư�迭");
	}

}













