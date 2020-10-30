package day0914;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex8FileMunje extends JFrame{
	JTextField txtName,txtHp;
	JTextArea area;
	JButton btnOpen,btnSave,btnDelete;
	final String fileName="D:\\java0901\\info.txt";
	
	public Ex8FileMunje(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 440, 400);//������ġx,y,ũ�� w,h
		//this.getContentPane().setBackground(Color.orange);//���������� �ִ� �г��� ���� ����
		this.getContentPane().setBackground(new Color(211,225,208));//���������� �ִ� �г��� ���� ����
		this.setDesign();//������ �ڵ�
		this.setVisible(true);//���̰� �ϱ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���α׷��� �������ִ� �޼���
	}
	
	public void setDesign()
	{
		this.setLayout(null);
		JLabel lblName=new JLabel("�̸�");
		lblName.setBounds(20, 20, 60, 30);
		this.add(lblName);
		
		txtName=new JTextField();
		txtName.setBounds(90, 20, 70, 30);
		this.add(txtName);
		
		JLabel lblHp=new JLabel("�ڵ���");
		lblHp.setBounds(170, 20, 60, 30);
		this.add(lblHp);
		
		txtHp=new JTextField();
		txtHp.setBounds(240, 20, 100, 30);
		this.add(txtHp);
		
		//��ư�� �߰�
		btnOpen=new JButton("��ü�ҷ�����");
		btnOpen.setBounds(10, 70, 130, 30);
		this.add(btnOpen);
		btnOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//area �� ���� ���� �����
				area.setText("");
				//���Ͽ��� ����Ÿ ��������
				FileReader fr=null;
				BufferedReader br=null;
				
				try {
					fr=new FileReader(fileName);
					br=new BufferedReader(fr);
					//���پ� �о area �� �߰�
					while(true)
					{
						String line=br.readLine();
						if(line==null)
							break;
						area.append(line+"\n");
					}
				} catch (FileNotFoundException e1) {
					area.setText("������ �������� �ʽ��ϴ�.\n����Ÿ ������ �ҷ�������");					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					try {
						if(br!=null) br.close();
						if(fr!=null) fr.close();
					}catch (IOException e1) {
						// TODO: handle exception
					}
				}
			}
		});
		
		
		btnSave=new JButton("���Ͽ��߰�");
		btnSave.setBounds(150, 70, 130, 30);
		this.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//�Էµ���Ÿ �б�
				String name=txtName.getText();
				String hp=txtHp.getText();
				if(name.length()==0 || hp.length()==0)
				{
					JOptionPane.showMessageDialog(Ex8FileMunje.this,
							"����Ÿ�� �Է����ּ���");
					return;//�޼��� ����
				}
				FileWriter fw=null;
				try {
					fw=new FileWriter(fileName, true);//true:append�߰� ���
					//�Էµ���Ÿ �߰�
					fw.write("�̸�:"+name+"\n");
					fw.write("�ڵ���:"+hp+"\n");
					fw.write("=================\n");
					//����Ÿ �ʱ�ȭ
					area.setText("���Ͽ� ����Ÿ�� �߰��߽��ϴ�");
					txtName.setText("");
					txtHp.setText("");
					txtName.requestFocus();//��Ŀ�� ������
					
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
				
			}
		});
		
		btnDelete=new JButton("���ϻ���");
		btnDelete.setBounds(290, 70, 130, 30);
		this.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				File file=new File(fileName);
				if(file.exists())
				{
					file.delete();//����
					area.setText("������ �����Ǿ����ϴ�");
				}else {
					area.setText("������ �������� �ʽ��ϴ�");
				}
			}
		});
		
		//area �߰�
		area=new JTextArea();
		JScrollPane jsp=new JScrollPane(area);
		jsp.setBounds(10, 110, 400, 250);
		this.add(jsp);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex8FileMunje("��������¹���");
	}

}






