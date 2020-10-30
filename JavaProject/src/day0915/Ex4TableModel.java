package day0915;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ex4TableModel  extends JFrame{
	DefaultTableModel model;
	JTable table;
	JTextField txtName,txtJava,txtSpring;
	JButton btnAdd,btnDelete;
	
	String []title= {"Name","Java","Spring","Total","Average"};
	final String fileName="D:\\java0901\\sungjuk.txt";
	
	public Ex4TableModel(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 400, 400);//������ġx,y,ũ�� w,h
		//this.getContentPane().setBackground(Color.orange);//���������� �ִ� �г��� ���� ����
		this.getContentPane().setBackground(new Color(211,225,208));//���������� �ִ� �г��� ���� ����
		this.setDesign();//������ �ڵ�		
		this.writeData();//���̺� ���ϳ��� �ҷ�����
		this.setVisible(true);//���̰� �ϱ�
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���α׷��� �������ִ� �޼���
		
		//����� ���̺��� ����Ÿ�� ���Ͽ� ����
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				//��������
				//�� �హ��: model.getRowCount()
				FileWriter fw=null;
				try {
					fw=new FileWriter(fileName);
					for(int i=0;i<model.getRowCount();i++)//�హ��
					{
						//������� ������ ���� ����
						String line="";
						for(int j=0;j<model.getColumnCount();j++)//������
						{
							line+=model.getValueAt(i, j).toString()+",";
						}
						//�� ������ �ĸ��� ����
						line=line.substring(0,line.length()-1);
						//���Ͽ� ����
						fw.write(line+"\n");						
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					try {
						fw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				//�ý��� ����
				System.exit(0);
				super.windowClosing(e);
			}
		});		
	}
	
	//���Ͽ��� ����Ÿ �����ͼ� ���̺� ���
	public void writeData()
	{
		//���Ͽ��� �ҷ�����
		FileReader fr=null;
		BufferedReader br=null;
		
		try {
			fr=new FileReader(fileName);
			br=new BufferedReader(fr);
			while(true)
			{
				//���Ͽ��� ���� �б�
				String line=br.readLine();
				//�ΰ��̸� ����
				if(line==null)
					break;
				//, �� �и�
				String []data=line.split(",");
				//model�� �߰�
				model.addRow(data);				
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(this, "�ҷ��� ������ �����ϴ�");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(br!=null) br.close();
				if(fr!=null) fr.close();
			}catch (IOException e) {
				// TODO: handle exception
			}
		}		
	}
	
	public void setDesign()
	{
		this.setLayout(null);
		//�Է� �ؽ�Ʈ�ʵ�
		JLabel lbl1=new JLabel("Name");
		lbl1.setBounds(10, 20, 50, 30);
		this.add(lbl1);
		
		txtName=new JTextField();
		txtName.setBounds(60, 20, 60, 30);
		this.add(txtName);
		
		JLabel lbl2=new JLabel("Java");
		lbl2.setBounds(130, 20, 50, 30);
		this.add(lbl2);
		
		txtJava=new JTextField();
		txtJava.setBounds(160, 20, 60, 30);
		this.add(txtJava);
		
		JLabel lbl3=new JLabel("Spring");
		lbl3.setBounds(230, 20, 50, 30);
		this.add(lbl3);
		
		txtSpring=new JTextField();
		txtSpring.setBounds(280, 20, 60, 30);
		this.add(txtSpring);
		
		//��ư
		btnAdd=new JButton("����Ÿ�߰�");
		btnAdd.setBounds(30, 60, 100, 30);
		this.add(btnAdd);
		
		btnDelete=new JButton("����Ÿ����");
		btnDelete.setBounds(200, 60, 100, 30);
		this.add(btnDelete);
		
		//���̺�
		model=new DefaultTableModel(title, 0);
		table=new JTable(model);
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(20, 120, 350, 190);
		this.add(jsp);
		
		//�߰� �̺�Ʈ
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name=txtName.getText();
				String java=txtJava.getText();
				String spring=txtSpring.getText();
				
				try {
					int tot=Integer.parseInt(java)+Integer.parseInt(spring);
					double avg=tot/2.0;
					//1.String �迭 Ÿ������ �߰��ϴ� ���
					//��ü ����Ÿ�� String �迭Ÿ������ �����
					//String []data= {name,java,spring,String.valueOf(tot),String.valueOf(avg)};
					//���̺� �𵨿� �߰�
					//model.addRow(data);
					
					//2. Vector Ÿ������ �߰��ϴ� ���
					Vector<String> data=new Vector<String>();
					data.add(name);
					data.add(java);
					data.add(spring);
					data.add(String.valueOf(tot));
					data.add(String.valueOf(avg));
					model.addRow(data);					
					
					//�Է°� �����
					txtName.setText("");
					txtJava.setText("");
					txtSpring.setText("");					
				}catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(Ex4TableModel.this,"������ ���ڰ� �����ֳ׿�");
					return;//�޼��� ����
				}
			}
		});
		
		//���� ��ư �̺�Ʈ
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int selectRow=table.getSelectedRow();//�����ϸ� ���ȣ ��ȯ, ���ϸ� -1 ��ȯ
				System.out.println(selectRow);
				if(selectRow==-1)
				{
					JOptionPane.showMessageDialog(Ex4TableModel.this, "������ ���� �������ּ���");
				}else
				{
					//����
					model.removeRow(selectRow);
				}
				
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex4TableModel("Table ����Ÿ ����");
	}

}





