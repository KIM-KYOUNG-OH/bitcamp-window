package day0924;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class AddStudent  extends JFrame{
	JTextField txtName,txtAddr,txtHp;
	JComboBox<Integer> cbBirth;
	JButton btnPhoto,btnAdd;
	JLabel lblPhoto;
	
	public AddStudent(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(900, 100, 300, 350);//시작위치x,y,크기 w,h
		this.getContentPane().setBackground(Color.white);//프레임위에 있는 패널의 색상 변경
		//this.getContentPane().setBackground(new Color(211,225,208));//프레임위에 있는 패널의 색상 변경
		this.setDesign();//디자인 코드
		//this.setVisible(true);//보이게 하기
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프로그램을 종료해주는 메서드
	}
	
	public void setDesign()
	{
		this.setLayout(null);
		
		JLabel lbl1=new JLabel("Name");
		lbl1.setBounds(30, 20, 50, 30);
		this.add(lbl1);
		
		JLabel lbl2=new JLabel("Photo");
		lbl2.setBounds(30, 60, 50, 30);
		this.add(lbl2);
		
		lblPhoto=new JLabel();
		lblPhoto.setBounds(30, 100, 200, 25);
		lblPhoto.setBorder(new LineBorder(Color.gray));
		this.add(lblPhoto);
		
		JLabel lbl3=new JLabel("Hp");
		lbl3.setBounds(30, 140, 50, 30);
		this.add(lbl3);
		
		JLabel lbl4=new JLabel("Addr");
		lbl4.setBounds(30, 180, 50, 30);
		this.add(lbl4);
		
		JLabel lbl5=new JLabel("Birth Year");
		lbl5.setBounds(30, 220, 100, 30);
		this.add(lbl5);
		
		txtName=new JTextField();
		txtName.setBounds(130, 20, 70, 25);
		this.add(txtName);
		
		btnPhoto=new JButton("Photo");
		btnPhoto.setBounds(130, 60, 70, 25);
		this.add(btnPhoto);
		//버튼 이벤트
		btnPhoto.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//사진 경로 가져와서 lblPhoto 에 출력
				FileDialog dlg=new FileDialog(AddStudent.this, "사진 가져오기", FileDialog.LOAD);
				dlg.setVisible(true);
				//취소 누르면 종료
				if(dlg.getDirectory()==null)
					return;
				String fileName=dlg.getDirectory()+dlg.getFile();
				lblPhoto.setText(fileName);
			}
		});
		
		txtHp=new JTextField();
		txtHp.setBounds(130, 140, 100, 25);
		this.add(txtHp);
		
		txtAddr=new JTextField();
		txtAddr.setBounds(130, 180, 100, 25);
		this.add(txtAddr);
		
		cbBirth=new JComboBox<Integer>();
		int curr=new Date().getYear()+1900;
		for(int i=curr;i>=1950;i--)
		{
			cbBirth.addItem(i);
		}
		cbBirth.setBounds(130, 220, 70, 25);
		this.add(cbBirth);
		
		btnAdd=new JButton("DB Add");
		btnAdd.setBounds(90, 260, 100, 25);
		this.add(btnAdd);
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		AddStudent add=new AddStudent("add");
//	}

}







