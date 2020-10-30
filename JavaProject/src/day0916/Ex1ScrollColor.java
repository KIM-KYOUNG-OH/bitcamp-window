package day0916;

import java.awt.Color;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.border.LineBorder;

public class Ex1ScrollColor  extends JFrame{
	JScrollBar sbRed,sbGreen,sbBlue;
	JLabel lblRed,lblGreen,lblBlue;
	int red=223,green=196,blue=219;
	JLabel lblColor;

	public Ex1ScrollColor(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 500, 300);//시작위치x,y,크기 w,h
		this.getContentPane().setBackground(Color.white);//프레임위에 있는 패널의 색상 변경
		//this.getContentPane().setBackground(new Color(211,225,208));//프레임위에 있는 패널의 색상 변경
		this.setDesign();//디자인 코드
		this.setVisible(true);//보이게 하기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프로그램을 종료해주는 메서드
	}

	public void setDesign()
	{
		this.setLayout(null);
		//앞에 제목 부분
		JLabel lbl1=new JLabel("Red");
		lbl1.setBounds(10, 20, 40, 20);
		this.add(lbl1);

		JLabel lbl2=new JLabel("Green");
		lbl2.setBounds(10, 100, 40, 20);
		this.add(lbl2);

		JLabel lbl3=new JLabel("Blue");
		lbl3.setBounds(10, 180, 40, 20);
		this.add(lbl3);

		//스크롤바 부분
		sbRed=new JScrollBar(JScrollBar.HORIZONTAL, red, 1, 0, 256);
		sbRed.setBounds(70, 20, 200, 20);
		this.add(sbRed);

		sbGreen=new JScrollBar(JScrollBar.HORIZONTAL, green, 1, 0, 256);
		sbGreen.setBounds(70, 100, 200, 20);
		this.add(sbGreen);

		sbBlue=new JScrollBar(JScrollBar.HORIZONTAL, blue, 1, 0, 256);
		sbBlue.setBounds(70, 180, 200, 20);
		this.add(sbBlue);

		//라벨-숫자 출력부분
		lblRed=new JLabel(String.valueOf(red),JLabel.CENTER);
		lblRed.setBounds(280, 20, 40, 20);
		lblRed.setBorder(new LineBorder(Color.red));
		this.add(lblRed);

		lblGreen=new JLabel(String.valueOf(green),JLabel.CENTER);
		lblGreen.setBounds(280, 100, 40, 20);
		lblGreen.setBorder(new LineBorder(Color.green));
		this.add(lblGreen);

		lblBlue=new JLabel(String.valueOf(blue),JLabel.CENTER);
		lblBlue.setBounds(280, 180, 40, 20);
		lblBlue.setBorder(new LineBorder(Color.blue));
		this.add(lblBlue);

		//색상 라벨 부분
		lblColor=new JLabel();
		lblColor.setOpaque(true);//불투명모드로
		lblColor.setBackground(new Color(red,green,blue));
		lblColor.setBounds(340, 20, 130, 180);
		this.add(lblColor);

		//red 스크롤바 이벤트
		sbRed.addAdjustmentListener(new AdjustmentListener() {

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				// TODO Auto-generated method stub
				//스크롤된 레드값을 red변수에 저장
				red=sbRed.getValue();//스크롤하는 현재값으로 반환
				//라벨에 출력
				lblRed.setText(String.valueOf(red));
				//칼라 클래스 생성후 라벨의 배경색 변경
				Color color=new Color(red,green,blue);
				lblColor.setBackground(color);
			}
		});

		//green
		sbGreen.addAdjustmentListener(new AdjustmentListener() {

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				// TODO Auto-generated method stub
				//스크롤된 레드값을 red변수에 저장
				green=sbGreen.getValue();//스크롤하는 현재값으로 반환
				//라벨에 출력
				lblGreen.setText(String.valueOf(green));
				//칼라 클래스 생성후 라벨의 배경색 변경
				Color color=new Color(red,green,blue);
				lblColor.setBackground(color);
			}
		});
		//blue
		sbBlue.addAdjustmentListener(new AdjustmentListener() {

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				// TODO Auto-generated method stub
				//스크롤된 레드값을 red변수에 저장
				blue=sbBlue.getValue();//스크롤하는 현재값으로 반환
				//라벨에 출력
				lblBlue.setText(String.valueOf(blue));
				//칼라 클래스 생성후 라벨의 배경색 변경
				Color color=new Color(red,green,blue);
				lblColor.setBackground(color);
			}
		});

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex1ScrollColor("색상표");
	}

}






