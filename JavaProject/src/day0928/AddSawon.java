package day0928;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class AddSawon  extends JFrame{
	JTextField txtName,txtJumin,txtIpsa,txtPay;
	JComboBox<String> cbBuseo;
	JButton btnInsert;
	JLabel lblPayTax;
	
	public AddSawon(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(900, 100, 300, 350);//������ġx,y,ũ�� w,h
		this.getContentPane().setBackground(Color.white);//���������� �ִ� �г��� ���� ����
		//this.getContentPane().setBackground(new Color(211,225,208));//���������� �ִ� �г��� ���� ����
		this.setDesign();//������ �ڵ�
	//	this.setVisible(true);//���̰� �ϱ�
	//	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���α׷��� �������ִ� �޼���
	}
	
	public void setDesign()
	{
		this.setLayout(null);
		
		JLabel lbl1=new JLabel("Name");
		lbl1.setBounds(30, 20, 50, 30);
		this.add(lbl1);
		
		JLabel lbl2=new JLabel("Buseo");
		lbl2.setBounds(30, 60, 50, 30);
		this.add(lbl2);
			
		JLabel lbl3=new JLabel("Jumin No");
		lbl3.setBounds(30, 100, 80, 30);
		this.add(lbl3);
		
		JLabel lbl4=new JLabel("Ipsaday");
		lbl4.setBounds(30, 140, 80, 30);
		this.add(lbl4);
		
		JLabel lbl5=new JLabel("Pay");
		lbl5.setBounds(30, 180, 100, 30);
		this.add(lbl5);
		
		JLabel lbl6=new JLabel("Paytax");
		lbl6.setBounds(30, 220, 100, 30);
		this.add(lbl6);
		
		txtName=new JTextField();
		txtName.setBounds(150, 20, 100, 25);
		this.add(txtName);
		
		String []buseo= {"������","ȫ����","������"};
		cbBuseo=new JComboBox<String>(buseo);
		cbBuseo.setBounds(150, 60, 100, 25);
		this.add(cbBuseo);
		
		txtJumin=new JTextField();
		txtJumin.setBounds(150, 100, 100, 25);
		this.add(txtJumin);
		
		txtIpsa=new JTextField();
		txtIpsa.setBounds(150, 140, 100, 25);
		this.add(txtIpsa);
		
		txtPay=new JTextField();
		txtPay.setBounds(150, 180, 100, 25);
		this.add(txtPay);
		
		//pay �Է½� �ڵ����� paytax �� 3���� ����켭 �ֱ�
		txtPay.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);
				String pay=txtPay.getText();
				//System.out.println(pay); 
				try {
					int tax=(int)(Integer.parseInt(pay)*0.03);
					//�󺧿� ���
					lblPayTax.setText(String.valueOf(tax));
				}catch(NumberFormatException e1) {
					txtPay.setText("");
					lblPayTax.setText("0");
				}
			}
		});
		
		lblPayTax=new JLabel("0");
		lblPayTax.setBorder(new LineBorder(Color.gray));
		lblPayTax.setBounds(150, 220, 100, 25);
		this.add(lblPayTax);
		
		//�߰� ��ư
		btnInsert=new JButton("DB�� ����߰�");
		btnInsert.setBounds(60, 260, 150, 30);
		this.add(btnInsert);
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		AddSawon add=new AddSawon("add");
//	}

}







