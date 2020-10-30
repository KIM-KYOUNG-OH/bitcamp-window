package day0924;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import day0923.PersonDao;
import day0923.PersonDto;

public class Ex1PersonFrame  extends JFrame implements ActionListener{
	//dbó�� Ŭ���� ����
	PersonDao dao=new PersonDao();
	//�Է¿� �ʿ��� ������Ʈ
	JTextField txtName,txtJava,txtSpring,txtHeight,txtBirth;
	JComboBox<String> cbBlood;
	//�ʿ��� ��ư
	JButton btnAdd,btnDel,btnUpdate,btnSearch,btnAll;
	//��¿� �ʿ��� ������Ʈ
	JTable table;
	DefaultTableModel model;

	public Ex1PersonFrame(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 600, 500);//������ġx,y,ũ�� w,h
		//this.getContentPane().setBackground(Color.orange);//���������� �ִ� �г��� ���� ����
		this.getContentPane().setBackground(new Color(211,225,208));//���������� �ִ� �г��� ���� ����
		this.setDesign();//������ �ڵ�
		this.setVisible(true);//���̰� �ϱ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���α׷��� �������ִ� �޼���
	}

	public void setDesign()
	{
		//���̾ƿ� ���ֱ�
		this.setLayout(null);

		//�̸�
		JLabel lbl1=new JLabel("�̸�");
		lbl1.setBounds(10, 10, 50, 25);
		this.add(lbl1);

		txtName=new JTextField();
		txtName.setBounds(60, 10, 60, 25);
		this.add(txtName);

		//�ڹ�����
		JLabel lbl2=new JLabel("Java");
		lbl2.setBounds(140, 10, 50, 25);
		this.add(lbl2);

		txtJava=new JTextField();
		txtJava.setBounds(190, 10, 60, 25);
		this.add(txtJava);

		//����������
		JLabel lbl3=new JLabel("Spring");
		lbl3.setBounds(270, 10, 50, 25);
		this.add(lbl3);

		txtSpring=new JTextField();
		txtSpring.setBounds(330, 10, 60, 25);
		this.add(txtSpring);

		//������
		JLabel lbl4=new JLabel("������");
		lbl4.setBounds(10, 50, 50, 25);
		this.add(lbl4);

		String []blood= {"A","B","O","AB"};
		cbBlood=new JComboBox<String>(blood);
		cbBlood.setBounds(60, 50, 60, 25);
		this.add(cbBlood);

		//Ű
		JLabel lbl5=new JLabel("Ű");
		lbl5.setBounds(140, 50, 50, 25);
		this.add(lbl5);

		txtHeight=new JTextField();
		txtHeight.setBounds(190, 50, 60, 25);
		this.add(txtHeight);

		//�������
		JLabel lbl6=new JLabel("�������");
		lbl6.setBounds(270, 50, 60, 25);
		this.add(lbl6);

		txtBirth=new JTextField();
		txtBirth.setBounds(330, 50, 80, 25);
		this.add(txtBirth);

		//��ư�� �߰�
		//�߰���ư
		btnAdd=new JButton("�߰�");
		btnAdd.setBounds(10, 100, 80, 30);
		this.add(btnAdd);

		//������ư
		btnDel=new JButton("����");
		btnDel.setBounds(100, 100, 80, 30);
		this.add(btnDel);

		//������ư
		btnUpdate=new JButton("����");
		btnUpdate.setBounds(190, 100, 80, 30);
		this.add(btnUpdate);
		
		//�˻���ư
		btnSearch=new JButton("�˻�");
		btnSearch.setBounds(280, 100, 80, 30);
		this.add(btnSearch);
		
		//��ü��ư
		btnAll=new JButton("��ü����");
		btnAll.setBounds(370, 100, 90, 30);
		this.add(btnAll);
		
		//���̺� ����
		String []title= {"��ȣ","�̸�","������","�ڹ�","������","Ű","�������"};
		model=new DefaultTableModel(title, 0);
		table=new JTable(model);
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(10, 160, 560, 290);
		this.add(jsp);		
		//����Ÿ �߰��ϴ� �޼��� ȣ��
		writeTable();
		
		//��ư�� �̺�Ʈ �߰��ϱ�
		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnSearch.addActionListener(this);
		btnAll.addActionListener(this);		
	}

	//db �� ����Ÿ�� ���̺� ������ִ� �޼���
	public void writeTable()
	{
		//���� ���̺��� ����Ÿ�� ��� ������ �ٽ� �����´�
		model.setRowCount(0);
		//db ��ü ����Ÿ ��������
		List<PersonDto> list=dao.getAllPersons();
		//table�� �迭�̳� �������·θ� �߰��Ҽ� �ִ�		
		for(PersonDto dto:list)
		{
			Vector<String> data=new Vector<String>();
			data.add(String.valueOf(dto.getNum()));
			data.add(dto.getName());
			data.add(dto.getBlood());
			data.add(String.valueOf(dto.getJava()));
			data.add(String.valueOf(dto.getSpring()));
			data.add(String.valueOf(dto.getHeight()));
			data.add(String.valueOf(dto.getBirthday()));
			
			//table �� �߰�(�߰��Լ��� model �� �����ִ�)
			model.addRow(data);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		if(ob==btnAdd)
		{
			//�Է¾��� �׸��� �ϳ��� ������ �޼��� ����
			String name=txtName.getText();
			String java=txtJava.getText();
			String spring=txtSpring.getText();
			String height=txtHeight.getText();
			String birth=txtBirth.getText();
			String blood=cbBlood.getSelectedItem().toString().toLowerCase();
			
			if(name.length()==0 || java.length()==0 || 
					spring.length()==0 || height.length()==0 || birth.length()==0)
			{
				JOptionPane.showMessageDialog(this, "�Է¾��� �׸��� �ֽ��ϴ�.Ȯ���ϼ���");
				return;
			}
			
			//dto ������ �Է°� dto�� �ֱ�
			//����: ����ȯ�� ���ؾ��ؿ�
			//��¥�� ���� date Ÿ������ ����
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date birthday=null;
			try {
				birthday=sdf.parse(birth);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			PersonDto dto=new PersonDto();
			dto.setName(name);
			dto.setBlood(blood);
			dto.setJava(Integer.parseInt(java));
			dto.setSpring(Integer.parseInt(spring));
			dto.setHeight(Double.parseDouble(height));
			dto.setBirthday(birthday);
			
			//dao �� insert �޼��� ȣ��
			dao.personInsert(dto);
			
			//�ٽ� ���̺� ���
			this.writeTable();
			
			//�Է°� �����
			txtName.setText("");
			txtJava.setText("");
			txtSpring.setText("");
			txtHeight.setText("");
			txtBirth.setText("");		
			
		}else if(ob==btnDel)
		{
			String name=JOptionPane.showInputDialog("������ �̸��� �Է����ּ���");
			System.out.println(name);
			//dao �� ���� �޼��� ȣ��,int �� ��ȯ(���� n)
			int n=dao.personDelete(name);
			
			//n�� 0 �̸� ��� �޼��� "xxx ���� ��ܿ� �����ϴ�"
			//0�� �ƴϸ� "xxx �� ����Ÿ�� �����Ǿ����ϴ�" 
			if(n==0)
				JOptionPane.showMessageDialog(this, name+"���� ��ܿ� �����ϴ�");
			else
			{
				JOptionPane.showMessageDialog(this, name+"�� ����Ÿ�� �����Ǿ����ϴ�");
				//���̺� �ٽ� ���
				this.writeTable();
			}	
			
		}else if(ob==btnUpdate)
		{
			//��� �Է��� JOptionPane.showInputDialog �̿�
			//num,name,java,spring,blood �Է��� �޾Ƽ�
			String num=JOptionPane.showInputDialog("������ ��ȣ�� �Է����ּ���");
			if(num==null) return;//��� ������ ����
			String name=JOptionPane.showInputDialog("������ �̸��� �Է����ּ���");
			String java=JOptionPane.showInputDialog("�ڹ������� �Է����ּ���");
			String spring=JOptionPane.showInputDialog("������������ �Է����ּ���");
			String blood=JOptionPane.showInputDialog("������ �������� �Է����ּ���");
			
			//dto�� ���
			PersonDto dto=new PersonDto();
			dto.setNum(Integer.parseInt(num));
			dto.setName(name);
			dto.setBlood(blood);
			dto.setJava(Integer.parseInt(java));
			dto.setSpring(Integer.parseInt(spring));
			
			//���� �޼��� ȣ��
			int n=dao.personUpdate(dto);
			
			//0�̸� "�ش� ��ȣ�� �������� �ʽ��ϴ�"
			//1�̸� "�����Ǿ����ϴ�" �޼��� ����� ���̺� �ٽ� ���
			if(n==0)
				JOptionPane.showMessageDialog(this, "�ش� ��ȣ�� �������� �ʽ��ϴ�");
			else
			{
				JOptionPane.showMessageDialog(this, "�����Ǿ����ϴ�");
				this.writeTable();
			}
		}else if(ob==btnSearch)
		{
			//������ �Է�
			String blood=JOptionPane.showInputDialog("��ȸ�� �������� �Է����ּ���");
			if(blood==null) return;//��� ������ �޼��� ����
			//�������� ���� ����Ʈ ��������
			List<PersonDto> list=dao.getBloodSearch(blood);
			//���̺��� ����Ÿ ����
			model.setRowCount(0);
			//����Ʈ ��� ���̺� ���
			//�̹����� �迭�� ���� �߰��Ҳ���			
			for(PersonDto dto:list)
			{
				String []data= {String.valueOf(dto.getNum()),
						dto.getName(),dto.getBlood(),String.valueOf(dto.getJava()),
						String.valueOf(dto.getSpring()),String.valueOf(dto.getHeight()),
						String.valueOf(dto.getBirthday())};
				//���̺� �߰�(model�� �߰� �޼��� ������ ����)
				model.addRow(data);
			}
		}else if(ob==btnAll)
		{
			writeTable();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1PersonFrame ex=new Ex1PersonFrame("person����");
	}

}


