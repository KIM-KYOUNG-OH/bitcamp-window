package day0914;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class Ex4RadioButton extends JFrame{
	JLabel lblmessage;
	JRadioButton []rb=new JRadioButton[5];
	String []title= {"����","�Ķ�","�ʷ�","��ȫ","������"};
	Color []fcolor= {Color.red,Color.blue,Color.green,Color.pink,Color.orange};

	JRadioButton []rbSize=new JRadioButton[3];
	String []sizeTitle= {"����ũ��(�۰�)","����ũ��(�߰�)","����ũ��(ũ��)"};
	int size=15;

	public Ex4RadioButton(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 500, 300);//������ġx,y,ũ�� w,h
		//this.getContentPane().setBackground(Color.orange);//���������� �ִ� �г��� ���� ����
		this.getContentPane().setBackground(new Color(211,225,208));//���������� �ִ� �г��� ���� ����
		this.setDesign();//������ �ڵ�
		this.setVisible(true);//���̰� �ϱ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���α׷��� �������ִ� �޼���
	}

	public void setDesign()
	{
		this.setLayout(null);
		int xPos=30;
		//RadioButton �� �׷�ȭ�ϱ� ���� ���� ����-�߰��� ������ư�� �׷�ȭ
		ButtonGroup bg=new ButtonGroup();
		for(int i=0;i<rb.length;i++)
		{
			rb[i]=new JRadioButton(title[i],i==1?true:false);//1�� �ε����� true�� ����
			rb[i].setBounds(xPos,50, 80, 30);
			//�̺�Ʈ �߰�
			rb[i].addActionListener(new RadioClick());
			//������ �������
			rb[i].setOpaque(false);
			this.add(rb[i]);//�����ӿ� �߰�
			bg.add(rb[i]);//��ư�׷쿡 �߰�(�׷�ȭ�� ���ؼ�)
			xPos+=80;
		}

		ButtonGroup bg2=new ButtonGroup();
		int xPos2=30;
		for(int i=0;i<rbSize.length;i++)
		{
			rbSize[i]=new JRadioButton(sizeTitle[i],i==1?true:false);//1�� �ε����� true�� ����
			rbSize[i].setBounds(xPos2,90, 120, 30);
			//�̺�Ʈ �߰�
			rbSize[i].addActionListener(new RadioClick2());
			//������ �������
			rbSize[i].setOpaque(false);
			this.add(rbSize[i]);//�����ӿ� �߰�
			bg2.add(rbSize[i]);//��ư�׷쿡 �߰�(�׷�ȭ�� ���ؼ�)
			xPos2+=130;
		}

		//�� �߰�
		lblmessage=new JLabel("Have a Nice Day!!", JLabel.CENTER);
		lblmessage.setBorder(new LineBorder(Color.pink,5));
		//���ڻ� �ʱⰪ�� �Ķ�������
		lblmessage.setForeground(fcolor[1]);
		//�۲� �⺻ ������
		lblmessage.setFont(new Font("Comic Sans MS", Font.BOLD, size));
		lblmessage.setBounds(40, 150, 400, 60);
		this.add(lblmessage);
	}

	//������ư �̺�Ʈ
	class RadioClick implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object ob=e.getSource();//�̺�Ʈ�� �߻��� ������Ʈ
			for(int i=0;i<rb.length;i++)
			{
				//������ ������ư�� ob�� ������ i��° ������ ���ڻ����� ����
				if(ob==rb[i])
					lblmessage.setForeground(fcolor[i]);
			}
		}
	}

	//������ư �̺�Ʈ
	class RadioClick2 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object ob=e.getSource();//�̺�Ʈ�� �߻��� ������Ʈ
			if(ob==rbSize[0])
				size=10;
			else if(ob==rbSize[1])
				size=15;
			else if(ob==rbSize[2])
				size=20;
			lblmessage.setFont(new Font("Comic Sans MS", Font.BOLD, size));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex4RadioButton("RadioButton����");
	}

}









