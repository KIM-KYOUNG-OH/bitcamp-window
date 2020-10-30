package day0915;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex3Table  extends JFrame{
	
	JTable table;
	JLabel lblSelect;
	
	//���̺� ����� ����
	String []title= {"�̸�","����","������"};
	//���̺� ����� ����Ÿ
	String [][]data= {
			{"��ȣ��","34��","O��"},
			{"�ӿ���","26��","AB��"},
			{"������","33��","B��"}
	};
	
	public Ex3Table(String title) {
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
		this.setLayout(null);
		table=new JTable(data, title);
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(20, 20, 250, 100);
		this.add(jsp);
		
		lblSelect=new JLabel("��������°�");
		lblSelect.setBounds(10, 170, 200, 50);
		this.add(lblSelect);
		
		//���̺� ���콺 Ŭ���� �̺�Ʈ
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//������ ���ȣ ���ϱ�
				int row=table.getSelectedRow();
				String name=table.getValueAt(row, 0).toString();
				String age=(String)table.getValueAt(row, 1);
				String blood=table.getValueAt(row, 2).toString();
				
				lblSelect.setText("Name:"+name+",Age:"+age+",Blood:"+blood);
				super.mouseClicked(e);
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex3Table("���̺���");
	}

}





