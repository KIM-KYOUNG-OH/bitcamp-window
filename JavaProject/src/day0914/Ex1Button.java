package day0914;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class Ex1Button extends JFrame implements ActionListener{
	JTextField txtNum1,txtNum2;
	JButton []btn=new JButton[4];
	String []title= {"+","-","*","/"};
	JLabel lblResult;
	
	public Ex1Button(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 300, 300);//시작위치x,y,크기 w,h
		//this.getContentPane().setBackground(Color.orange);//프레임위에 있는 패널의 색상 변경
		this.getContentPane().setBackground(new Color(211,225,208));//프레임위에 있는 패널의 색상 변경
		this.setDesign();//디자인 코드
		this.setVisible(true);//보이게 하기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프로그램을 종료해주는 메서드
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();//이벤트가 발생한 오브젝트
		//두 숫자 읽기
		String n1,n2;
		n1=txtNum1.getText();
		n2=txtNum2.getText();
		//System.out.println(n1+","+n2);
		try {
			//문자가 섞여있을경우 이셉션이 발생한다
			int num1=Integer.parseInt(n1);
			int num2=Integer.parseInt(n2);
			String msg="";
			if(ob==btn[0])//더하기 버튼
				msg=num1+"+"+num2+"="+(num1+num2);
			else if(ob==btn[1])//빼기 버튼
				msg=num1+"-"+num2+"="+(num1-num2);
			else if(ob==btn[2])//곱하기 버튼
				msg=num1+"*"+num2+"="+(num1*num2);
			else if(ob==btn[3])//나누기 버튼
				msg=num1+"/"+num2+"="+((double)num1/num2);
			
			//라벨에 결과값 출력
			lblResult.setText(msg);
			//입력값 초기화
			//txtNum1.setText("");
			//txtNum2.setText("");
		}catch(NumberFormatException e1)
		{
			JOptionPane.showMessageDialog(this, "숫자로 입력해주세요:"+e1.getMessage());
		}
	}
	
	public void setDesign()
	{
		//레이아웃은 무효화
		this.setLayout(null);
		
		//텍스트필드 생성
		txtNum1=new JTextField();
		txtNum1.setBounds(30, 30, 80, 30);
		this.add(txtNum1);
		
		txtNum2=new JTextField();
		txtNum2.setBounds(130, 30, 80, 30);
		this.add(txtNum2);
		
		//버튼 배열
		int xPos=10;
		for(int i=0;i<btn.length;i++)
		{
			//버튼 생성
			btn[i]=new JButton(title[i]);
			//버튼 위치및 크기 지정
			btn[i].setBounds(xPos, 80, 60, 30);
			//프레임에 추가
			this.add(btn[i]);
			xPos+=70;
			//버튼 이벤트 발생
			btn[i].addActionListener(this);
		}
		
		//라벨
		lblResult=new JLabel();
		lblResult.setBorder(new TitledBorder("Result"));
		lblResult.setBounds(30, 150, 230, 60);
		this.add(lblResult);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex1Button("버튼복습");
	}

}










