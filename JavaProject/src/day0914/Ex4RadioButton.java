package day0914;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;

public class Ex4RadioButton extends JFrame{
	JLabel lblmessage;
	JRadioButton []rb=new JRadioButton[5];
	String []title= {"빨강","파랑","초록","분홍","오렌지"};
	Color []fcolor= {Color.red,Color.blue,Color.green,Color.pink,Color.orange};

	JRadioButton []rbSize=new JRadioButton[3];
	String []sizeTitle= {"글자크기(작게)","글자크기(중간)","글자크기(크게)"};
	int size=15;

	public Ex4RadioButton(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 500, 300);//시작위치x,y,크기 w,h
		//this.getContentPane().setBackground(Color.orange);//프레임위에 있는 패널의 색상 변경
		this.getContentPane().setBackground(new Color(211,225,208));//프레임위에 있는 패널의 색상 변경
		this.setDesign();//디자인 코드
		this.setVisible(true);//보이게 하기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프로그램을 종료해주는 메서드
	}

	public void setDesign()
	{
		this.setLayout(null);
		int xPos=30;
		//RadioButton 을 그룹화하기 위한 변수 선언-추가한 라디오버튼은 그룹화
		ButtonGroup bg=new ButtonGroup();
		for(int i=0;i<rb.length;i++)
		{
			rb[i]=new JRadioButton(title[i],i==1?true:false);//1번 인덱스를 true로 지정
			rb[i].setBounds(xPos,50, 80, 30);
			//이벤트 추가
			rb[i].addActionListener(new RadioClick());
			//배경색을 투명모드로
			rb[i].setOpaque(false);
			this.add(rb[i]);//프레임에 추가
			bg.add(rb[i]);//버튼그룹에 추가(그룹화를 위해서)
			xPos+=80;
		}

		ButtonGroup bg2=new ButtonGroup();
		int xPos2=30;
		for(int i=0;i<rbSize.length;i++)
		{
			rbSize[i]=new JRadioButton(sizeTitle[i],i==1?true:false);//1번 인덱스를 true로 지정
			rbSize[i].setBounds(xPos2,90, 120, 30);
			//이벤트 추가
			rbSize[i].addActionListener(new RadioClick2());
			//배경색을 투명모드로
			rbSize[i].setOpaque(false);
			this.add(rbSize[i]);//프레임에 추가
			bg2.add(rbSize[i]);//버튼그룹에 추가(그룹화를 위해서)
			xPos2+=130;
		}

		//라벨 추가
		lblmessage=new JLabel("Have a Nice Day!!", JLabel.CENTER);
		lblmessage.setBorder(new LineBorder(Color.pink,5));
		//글자색 초기값을 파랑색으로
		lblmessage.setForeground(fcolor[1]);
		//글꼴 기본 사이즈
		lblmessage.setFont(new Font("Comic Sans MS", Font.BOLD, size));
		lblmessage.setBounds(40, 150, 400, 60);
		this.add(lblmessage);
	}

	//라디오버튼 이벤트
	class RadioClick implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object ob=e.getSource();//이벤트가 발생한 오브젝트
			for(int i=0;i<rb.length;i++)
			{
				//선택한 라디오버튼이 ob와 같으면 i번째 색상을 글자색으로 지정
				if(ob==rb[i])
					lblmessage.setForeground(fcolor[i]);
			}
		}
	}

	//라디오버튼 이벤트
	class RadioClick2 implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Object ob=e.getSource();//이벤트가 발생한 오브젝트
			if(ob==rbSize[0])
				size=10;
			else if(ob==rbSize[1])
				size=15;
			else if(ob==rbSize[2])
				size=20;
			lblmessage.setFont(new Font("Comic Sans MS", Font.BOLD, size));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex4RadioButton("RadioButton연습");
	}

}









