package day0916;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ex2PhotoInfoSave  extends JFrame implements ActionListener{
	MyPhoto myPhoto;//����Ŭ����
	JButton btnPhoto,btnSave,btnOpen;
	JTextField txtName,txtAge;
	JComboBox<String> comboBlood;
	Image photoImage;
	String imageName;//���Ͽ� ������ �̹�����
	
	public Ex2PhotoInfoSave(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 400, 400);//������ġx,y,ũ�� w,h
		this.getContentPane().setBackground(Color.white);//���������� �ִ� �г��� ���� ����
		//this.getContentPane().setBackground(new Color(211,225,208));//���������� �ִ� �г��� ���� ����
		this.setDesign();//������ �ڵ�
		this.setVisible(true);//���̰� �ϱ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���α׷��� �������ִ� �޼���
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		if(ob==btnPhoto)//������������ ��ư
		{
			//FileDialog �̿��ؼ� ������ �������� ���� ����ǵ��� �غ�����
			FileDialog dlg=new FileDialog(this, "������������", FileDialog.LOAD);
			dlg.setVisible(true);
			//��Ұ� �ƴѰ�� ���� ���
			if(dlg.getDirectory()!=null)
			{
				imageName=dlg.getDirectory()+dlg.getFile();
				//Image����
				photoImage=new ImageIcon(imageName).getImage();
				//paint �޼��� ȣ��
				myPhoto.repaint();
			}
			
		}else if(ob==btnSave)//���� ����
		{
			//�Է��� �̸�.txt �� �����ϱ�(java0901 ������)
			//�Է�üũ-�̸��̳� ���̸� �Է¾��ϸ� ���޼����� �޼��� ����
			String name=txtName.getText().trim();//trim():���� ��������
			String blood=comboBlood.getSelectedItem().toString();
			String age=txtAge.getText();
			if(name.length()==0)
			{
				JOptionPane.showMessageDialog(this, "�̸��� �Է����ּ���");
				txtName.requestFocus();
				return;
			}
			if(age.length()==0)
			{
				JOptionPane.showMessageDialog(this, "���̸� �Է����ּ���");
				txtAge.requestFocus();
				return;
			}
			
			//���Ͽ� ���ٿ� �����Ѱ���
			//�̹�����(ù��),�̸�(2��°��),������(3��°��),����(4��°��)�� ����
			FileWriter fw=null;
			try {
				fw=new FileWriter("D:\\java0901\\"+name+".txt");
				//����
				fw.write(imageName+"\n");
				fw.write(name+"\n");
				fw.write(blood+"\n");
				fw.write(age+"\n");				
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
			
			//�̹����� ó�� �̹����� �ʱ�ȭ. �̸��� ���̴� �����, 
			//�������� �ٽ� 1��°���� �ʱ�ȭ			
			photoImage=new ImageIcon("D:\\java0901\\image\\�Ϳ��� ������\\c1.png").getImage();
			myPhoto.repaint();
			txtName.setText("");
			txtAge.setText("");
			comboBlood.setSelectedIndex(0);
			
		}else if(ob==btnOpen)//���� ��������
		{
			//�ش� �̸����� �� ������ �ҷ����� �� ����Ÿ�� 
			//����,�̸�,������,���̰� ����ǵ��� �Ѵ�
			FileReader fr=null;
			BufferedReader br=null;
			FileDialog dlg=new FileDialog(this,"���Ͽ���",FileDialog.LOAD);
			dlg.setVisible(true);
			if(dlg.getDirectory()!=null)
			{
				String fileName=dlg.getDirectory()+dlg.getFile();
				try {
					fr=new FileReader(fileName);
					br=new BufferedReader(fr);
					//1��° ����Ÿ�� ������
					imageName=br.readLine();//������
					photoImage=new ImageIcon(imageName).getImage();
					myPhoto.repaint();
					
					//2��° ����Ÿ�� �̸�
					String name=br.readLine();
					txtName.setText(name);
					
					//3��°-������
					String blood=br.readLine();
					comboBlood.setSelectedItem(blood);
					
					//4��°-����
					String age=br.readLine();
					txtAge.setText(age);
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
		}
	}
	
	//������ ����� ĵ�ٽ�����Ŭ����
	class MyPhoto extends Canvas
	{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			g.drawImage(photoImage, 10, 2, 110, 130, this);		
		}
	}
	
	public void setDesign()
	{
		this.setLayout(null);
		//���� ��ư
		btnPhoto=new JButton("������������");
		btnPhoto.setBounds(20, 20, 120, 25);
		this.add(btnPhoto);
		btnPhoto.addActionListener(this);
		
		//���� ���
		//�ӽû��� �ϴ� ����ϱ�
		photoImage=new ImageIcon("D:\\java0901\\image\\�Ϳ��� ������\\c1.png").getImage();
		myPhoto=new MyPhoto();//���� Ŭ���� ����
		myPhoto.setBounds(20, 50, 120, 150);
		this.add(myPhoto);
		
		//���� �������� �̸�,������ ���� �Է�
		JLabel lbl1=new JLabel("�̸�");
		lbl1.setBounds(190, 30, 50, 25);
		this.add(lbl1);
		
		JLabel lbl2=new JLabel("������");
		lbl2.setBounds(190, 80, 50, 25);
		this.add(lbl2);
		
		JLabel lbl3=new JLabel("����");
		lbl3.setBounds(190, 130, 50, 25);
		this.add(lbl3);
		
		txtName=new JTextField();
		txtName.setBounds(260, 30, 60, 25);
		this.add(txtName);
		
		String []blood= {"A","B","O","AB"};
		comboBlood=new JComboBox<String>(blood);
		comboBlood.setBounds(260, 80, 80, 25);
		this.add(comboBlood);
		
		txtAge=new JTextField();
		txtAge.setBounds(260, 130, 60, 25);
		this.add(txtAge);
		
		//��ư 2��
		btnSave=new JButton("����������");
		btnSave.setBounds(50, 230, 130, 50);
		btnSave.setBackground(Color.red);
		btnSave.setForeground(Color.yellow);
		btnSave.addActionListener(this);//�̺�Ʈ
		this.add(btnSave);
		
		btnOpen=new JButton("��������������");
		btnOpen.setBounds(200, 230, 150, 50);
		btnOpen.setBackground(Color.orange);
		btnOpen.setForeground(Color.blue);
		btnOpen.addActionListener(this);//�̺�Ʈ
		this.add(btnOpen);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex2PhotoInfoSave("����������");
	}

}











