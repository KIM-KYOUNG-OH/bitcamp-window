package day0914;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//������ ���� �����
public class Ex6FileMemo extends JFrame implements ActionListener{
	JButton btnSave,btnOpen;
	String fileName;
	JTextArea area;
	
	public Ex6FileMemo(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 400, 400);//������ġx,y,ũ�� w,h
		//this.getContentPane().setBackground(Color.orange);//���������� �ִ� �г��� ���� ����
		this.getContentPane().setBackground(new Color(211,225,208));//���������� �ִ� �г��� ���� ����
		this.setDesign();//������ �ڵ�
		this.setVisible(true);//���̰� �ϱ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���α׷��� �������ִ� �޼���
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		if(ob==btnOpen)//�ҷ�����
		{
			FileDialog dlg=new FileDialog(this,"���Ͽ���",FileDialog.LOAD);
			dlg.setVisible(true);
			if(dlg.getDirectory()!=null)//��Ҹ� ������ �������
			{
				fileName=dlg.getDirectory()+dlg.getFile();
				FileReader fr=null;
				BufferedReader br=null;
				try {
					fr=new FileReader(fileName);
					br=new BufferedReader(fr);
					//���� �޸����� ���� �����
					area.setText("");
					while(true)
					{
						//�����б�
						String line=br.readLine();
						if(line==null || line.length()==0)
							break;
						//area �� �߰�
						area.append(line+"\n");
					}
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
					}catch(IOException e1) {}
				}
			}
			
		}else if(ob==btnSave)//�����ϱ�
		{
			FileDialog dlg=new FileDialog(this, "��������", FileDialog.SAVE);
			dlg.setVisible(true);
			//��� ������ null �� ��ȯ
			String dir=dlg.getDirectory();//������ ���丮
			String file=dlg.getFile();//������ ���ϸ�
			//System.out.println(dir);//��� ������ null �� ���
			//System.out.println(file);
			if(dir!=null)//��Ҹ� ������ �ʾ��� ��쿡�� ����
			{
				fileName=dir+file;//������� ���ϸ�
				//������ ����
				String content=area.getText();
				//���Ͽ� ����
				FileWriter fw=null;
				try {
					fw=new FileWriter(fileName);
					//���� ����
					fw.write(content);
					area.setText(fileName+" ����Ϸ�!!!");
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
		}
	}
	
	public void setDesign()
	{
		this.setLayout(null);
		btnSave=new JButton("��������");
		btnSave.setBounds(50, 30, 100, 30);
		this.add(btnSave);
		
		btnOpen=new JButton("���Ͽ���");
		btnOpen.setBounds(170, 30, 100, 30);
		this.add(btnOpen);
		
		area=new JTextArea();
		JScrollPane jsp=new JScrollPane(area);		
		jsp.setBounds(10, 80, 350, 250);
		this.add(jsp);//��ũ���� �ʿ��� ������Ʈ �߰��ϴ� ���
		
		//��ư�̺�Ʈ �߰�
		btnSave.addActionListener(this);
		btnOpen.addActionListener(this);		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex6FileMemo("���ܸ޸�");
	}

}





