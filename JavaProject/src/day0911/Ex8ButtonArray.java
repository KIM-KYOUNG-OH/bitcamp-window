package day0911;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class Ex8ButtonArray extends JFrame implements ActionListener{
	JButton []btn=new JButton[7];
	JLabel lblColor;
	String []btnTitle= {"Red","Blue","Green","Magenta","Yellow","Orange","Pink"};
	Color []color= {Color.red,Color.blue,Color.green,Color.magenta,Color.yellow,
			Color.orange,Color.pink};
	
	public Ex8ButtonArray(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 400, 400);//시작위치x,y,크기 w,h
		//this.getContentPane().setBackground(Color.orange);//프레임위에 있는 패널의 색상 변경
		this.getContentPane().setBackground(new Color(211,225,208));//프레임위에 있는 패널의 색상 변경
		this.setDesign();//디자인 코드
		this.setVisible(true);//보이게 하기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프로그램을 종료해주는 메서드
	}
	
	public void setDesign()
	{
		int yPos=20;
		//레이아웃 무효화
		this.setLayout(null);
		//7개의 버튼 생성 및 이벤트
		
		for(int i=0;i<btn.length;i++)
		{
			//버튼 생성
			btn[i]=new JButton(btnTitle[i]);
			//위치,크기 지정
			btn[i].setBounds(20, yPos, 100, 30);
			//글자색을 해당 색상으로 변경
			btn[i].setForeground(color[i]);
			//프레임에 추가
			this.add(btn[i]);
			yPos+=40;
			final int idx=i;
			//이벤트 추가-현재클래스내에서 구현
			btn[i].addActionListener(this);		
		}
		
		//라벨 추가
		lblColor=new JLabel();
		lblColor.setBounds(150, 20, 210, 270);
		lblColor.setBorder(new LineBorder(Color.DARK_GRAY));
		lblColor.setOpaque(true);
		this.add(lblColor);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//이벤트가 발생한 오브젝트를 얻음
		Object ob=e.getSource();
		for(int i=0;i<btn.length;i++)
		{
			if(ob==btn[i])
				lblColor.setBackground(color[i]);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex8ButtonArray("버튼배열");
	}

}













