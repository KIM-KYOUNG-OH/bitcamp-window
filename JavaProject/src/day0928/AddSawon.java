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
		this.setBounds(900, 100, 300, 350);//시작위치x,y,크기 w,h
		this.getContentPane().setBackground(Color.white);//프레임위에 있는 패널의 색상 변경
		//this.getContentPane().setBackground(new Color(211,225,208));//프레임위에 있는 패널의 색상 변경
		this.setDesign();//디자인 코드
	//	this.setVisible(true);//보이게 하기
	//	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프로그램을 종료해주는 메서드
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
		
		String []buseo= {"교육부","홍보부","관리부"};
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
		
		//pay 입력시 자동으로 paytax 에 3프로 계산헤서 넣기
		txtPay.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				super.keyReleased(e);
				String pay=txtPay.getText();
				//System.out.println(pay); 
				try {
					int tax=(int)(Integer.parseInt(pay)*0.03);
					//라벨에 출력
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
		
		//추가 버튼
		btnInsert=new JButton("DB에 사원추가");
		btnInsert.setBounds(60, 260, 150, 30);
		this.add(btnInsert);
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		AddSawon add=new AddSawon("add");
//	}

}







