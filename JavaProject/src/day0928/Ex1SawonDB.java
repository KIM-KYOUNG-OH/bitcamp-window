package day0928;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Ex1SawonDB  extends JFrame implements ActionListener{
	//��¿� �ʿ��� ������Ʈ
	JComboBox<String> cbSearch;
	JTextField txtSearch;
	JButton btnSearch;
	
	JTable table;
	DefaultTableModel model;
	JLabel lblTitle;
	//dao ����
	SawonDao dao=new SawonDao();
	//list ����
	List<SawonDto> list;
	
	//��ư 3�� �߰�(�߰�,����,����)
	JButton btnAdd,btnDel,btnUpdate;
	
	//�߰���
	AddSawon addFrame=new AddSawon("����߰�");
	//������
	UpdateSawon updateFrame=new UpdateSawon("��������");
	
	public Ex1SawonDB(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 800, 400);//������ġx,y,ũ�� w,h
		//this.getContentPane().setBackground(Color.orange);//���������� �ִ� �г��� ���� ����
		this.getContentPane().setBackground(new Color(211,225,208));//���������� �ִ� �г��� ���� ����
		this.setDesign();//������ �ڵ�
		this.setVisible(true);//���̰� �ϱ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���α׷��� �������ִ� �޼���
	}
	
	public void setDesign()
	{
		this.setLayout(null);
		//table ����
		String []title= {"��ȣ","�̸�","��","����","�μ�","�޿�","����","�Ի���","�ֹι�ȣ"};
		model=new DefaultTableModel(title,0);
		table=new JTable(model);
		JScrollPane sp=new JScrollPane(table);
		sp.setBounds(10,120,770,220);
		this.add(sp);
		
		//���� �� �߰�
		lblTitle=new JLabel("��ü ��� ���", JLabel.CENTER);
		lblTitle.setFont(new Font("", Font.BOLD, 20));
		lblTitle.setBorder(new LineBorder(Color.DARK_GRAY,3));
		lblTitle.setBounds(100, 80, 400, 35);
		this.add(lblTitle);
		
		//��ü ��� ��������
		list=dao.getSearchList();
		this.writeTable();
		
		//combo �߰�
		String []s= {"��ü","�̸��˻�","�μ��˻�"};
		cbSearch=new JComboBox<String>(s);
		cbSearch.setBounds(510, 80, 100, 30);
		this.add(cbSearch);
		
		txtSearch=new JTextField();
		txtSearch.setBounds(615, 80, 80, 30);
		this.add(txtSearch);
		
		//�˻� ��ư�� �̺�Ʈ
		btnSearch=new JButton("�˻�");
		btnSearch.setBounds(700, 80, 70, 30);
		this.add(btnSearch);
		
		//�͸� ���� Ŭ���� ������ �̺�Ʈ
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//������ �޸�ڽ� �ε���
				int idx=cbSearch.getSelectedIndex();
				//���� �÷���
				String col=idx==0?"all":idx==1?"name":"buseo";
				//�˻��ܾ�
				String search=txtSearch.getText();
				//���� �ٽ� ���
				String title=idx==0?"��ü ��� ���":idx==1?"�̸� \""+search+"\" �˻� ���":
					"�μ� \""+search+"\" �˻� ���";
				lblTitle.setText(title);
				//list ���
				list=dao.getSearchList(col, search);
				//���̺� �ٽ� ���
				writeTable();
				//�Է�â �����
				txtSearch.setText("");
			}
		});
		
		//��ư�� �߰�
		btnAdd=new JButton("����߰�");
		btnAdd.setBounds(20, 20, 100, 30);
		this.add(btnAdd);
		
		btnDel=new JButton("�������");
		btnDel.setBounds(140, 20, 100, 30);
		this.add(btnDel);
		
		btnUpdate=new JButton("�������");
		btnUpdate.setBounds(260, 20, 100, 30);
		this.add(btnUpdate);
		
		//��ư�̺�Ʈ
		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
		btnUpdate.addActionListener(this);	
		
		//�߰�,���� �������� ��ư�̺�Ʈ
		addFrame.btnInsert.addActionListener(this);
		updateFrame.btnUpdate.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		if(ob==btnAdd)//�߰���ư
		{
			//�߰� ������ ����
			addFrame.setVisible(true);
		}else if(ob==addFrame.btnInsert)//�߰��������� �߰���ư
		{
			//dto ����
			SawonDto dto=new SawonDto();
			//dto �� �Է°� �ֱ�
			dto.setName(addFrame.txtName.getText());
			dto.setBuseo(addFrame.cbBuseo.getSelectedItem().toString());
			dto.setIpsaday(addFrame.txtIpsa.getText());
			dto.setJuminno(addFrame.txtJumin.getText());
			dto.setPay(Integer.parseInt(addFrame.txtPay.getText()));
			dto.setPaytax(Integer.parseInt(addFrame.lblPayTax.getText()));			
			
			//dao �� insert �޼��� ȣ��
			dao.sawonInsert(dto);
			
			//�Է°� �����
			addFrame.txtName.setText("");
			addFrame.txtPay.setText("");
			addFrame.txtJumin.setText("");
			addFrame.txtIpsa.setText("");
			addFrame.lblPayTax.setText("");
			
			//�߰������� �Ⱥ��̰� �ϱ�
			addFrame.setVisible(false);
			
			//list �� ��ü ����Ÿ ��������
			list=dao.getSearchList();
			
			//���̺� �ٽ� ���
			this.writeTable();
		}else if(ob==btnUpdate)//������ư
		{
			//���̺��� ������ �ε��� ��ȣ�� ��´�
			int idx=table.getSelectedRow();
			//���þ��������(-1) �̸� "���̺��� ������ ����Ÿ�� �������ּ���"
			//��� ���޼��� ����� �޼��� ����
			if(idx==-1)
			{
				JOptionPane.showMessageDialog(this, "���̺��� ������ ����Ÿ�� �������ּ���");
				return;
			}
			//list ���� �ε����� �ش��ϴ� dto�� ��´�
			SawonDto dto=list.get(idx);
			
			//updateFrame �� num ������ dto�� num�� �־��ش�
			updateFrame.num=dto.getNum();
			
			//������ dto�� ����Ÿ�� �������� ������Ʈ�� ������ �־��ش�
			updateFrame.txtName.setText(dto.getName());
			updateFrame.txtJumin.setText(dto.getJuminno());
			updateFrame.txtPay.setText(String.valueOf(dto.getPay()));
			updateFrame.lblPayTax.setText(String.valueOf(dto.getPaytax()));
			updateFrame.cbBuseo.setSelectedItem(dto.getBuseo());
			updateFrame.txtIpsa.setText(dto.getIpsaday());
			
			//������ ���̰� �ϱ�
			updateFrame.setVisible(true);
			
		}else if(ob==updateFrame.btnUpdate)//������������ ������ư
		{
			//dto ����
			SawonDto dto=new SawonDto();
			
			//dto �� ���������κ��� ���� �����ͼ� �־��ش�(num �ʼ�)
			dto.setNum(updateFrame.num);
			dto.setName(updateFrame.txtName.getText());
			dto.setBuseo(updateFrame.cbBuseo.getSelectedItem().toString());
			dto.setIpsaday(updateFrame.txtIpsa.getText());
			dto.setJuminno(updateFrame.txtJumin.getText());
			dto.setPay(Integer.parseInt(updateFrame.txtPay.getText()));
			dto.setPaytax(Integer.parseInt(updateFrame.lblPayTax.getText()));		
			
			//dao �� sawonUpdate ȣ��(�����޼���)
			dao.sawonUpdate(dto);
			
			//������ �Ⱥ��̰� �ϱ�
			updateFrame.setVisible(false);
			
			//list �� ��ü ����Ÿ ��������
			list=dao.getSearchList();
			
			//���̺� �ٽ� ���
			this.writeTable();
			
		}else if(ob==btnDel)//������ư
		{
			//���̺��� ������ �ε��� ��ȣ�� ��´�
			int idx=table.getSelectedRow();
			//���þ��������(-1) �̸� "���̺��� ������ ����Ÿ�� �������ּ���"
			//��� ���޼��� ����� �޼��� ����
			if(idx==-1)
			{
				JOptionPane.showMessageDialog(this, "���̺��� ������ ����Ÿ�� �������ּ���");
				return;
			}
			
			//num�� �������� ������ �ʿ��� num���
			String num=table.getValueAt(idx, 0).toString();
			//System.out.println(num);
			
			//dao �� �����޼��� ȣ��
			dao.sawonDelete(num);
			
			//����Ʈ ��ü �ٽ� ��������
			list=dao.getSearchList();
			
			//���̺� �ٽ� ���
			this.writeTable();
		}
	}
	
	//����Ʈ ����Ÿ�� ���̺� ������ִ� �޼���
	public void writeTable()
	{
		//���� ����Ÿ ����� ���� �߰��� �ؾ� �ϹǷ�
		model.setRowCount(0);
		
		//Vector ���·� ������ ���̺� �𵨿� �߰�
		NumberFormat nf=NumberFormat.getCurrencyInstance();
		for(SawonDto dto:list)
		{
			Vector<String> data=new Vector<String>();
			//{"��ȣ","�̸�","��","����","�μ�","�޿�","����","�Ի���","�ֹι�ȣ"};
			data.add(dto.getNum());
			data.add(dto.getName());
			data.add(dto.getDdi());
			data.add(dto.getGender());
			data.add(dto.getBuseo());
			data.add(nf.format(dto.getPay()));
			data.add(nf.format(dto.getPaytax()));
			data.add(dto.getIpsaday());
			//�ֹι�ȣ 8���ڸ� ������ �������� * �� ���
			String jumin=dto.getJuminno().substring(0,8)+"******";
			data.add(jumin);
			
			//���̺� �߰�
			model.addRow(data);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1SawonDB ex=new Ex1SawonDB("�������");
	}

}







