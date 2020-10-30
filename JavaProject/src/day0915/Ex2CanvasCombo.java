package day0915;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ex2CanvasCombo  extends JFrame implements ActionListener{
	
	String []title= {"선","원","사각형","이미지","문자열"};
	JComboBox<String> combo;
	SelectDraw draw;
	int idx=4;//초기값은 문자열
	String imageName="D:\\java0901\\image\\귀여운 아이콘\\c7.png";
	Image image;
	Color fcolor;
	int x,y;
	
	public Ex2CanvasCombo(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 400, 500);//시작위치x,y,크기 w,h
		//this.getContentPane().setBackground(Color.orange);//프레임위에 있는 패널의 색상 변경
		this.getContentPane().setBackground(new Color(211,225,208));//프레임위에 있는 패널의 색상 변경
		this.setDesign();//디자인 코드
		this.setVisible(true);//보이게 하기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프로그램을 종료해주는 메서드
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//선택한 인덱스를 멤버변수 idx에 저장
		idx=combo.getSelectedIndex();
		//캔바스의 paint 메서드 호출
		draw.repaint();
	}
	
	//랜덤한 색상과 위치를 구해주는 메서드
	public void changeColorAndPosition()
	{
		int r=(int)(Math.random()*256);//0~255
		int gr=(int)(Math.random()*256);//0~255
		int b=(int)(Math.random()*256);//0~255
		//위치도 랜덤하게
		x=(int)(Math.random()*300);//0~299
		y=(int)(Math.random()*300)+50;//50~349
		
		fcolor=new Color(r, gr, b);
	}
	
	//캔바스 내부 클래스
	class SelectDraw extends Canvas
	{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			
			switch (idx) {
			case 0://선		
				for(int i=1;i<=30;i++)
				{
					changeColorAndPosition();
					g.setColor(fcolor);//선색 변경
					g.drawLine(x, y, x+200,y);
				}
				break;
			case 1://원	
				for(int i=1;i<=30;i++)
				{
					changeColorAndPosition();
					g.setColor(fcolor);//원채우기색상 변경
					g.fillOval(x, y, 50, 50);
				}
				break;
			case 2://사각형
				for(int i=1;i<=30;i++)
				{
					changeColorAndPosition();
					g.setColor(fcolor);//사각형채우기색상 변a경
					g.fillRect(x, y, 50, 50);
				}
				break;
			case 3://이미지
				image=new ImageIcon(imageName).getImage();
				for(int i=1;i<=5;i++)
				{
					changeColorAndPosition();
					g.drawImage(image, x, y, 100, 150, this);
				}
				break;
			case 4://문자열
			{
				changeColorAndPosition();//랜덤하게 색상및 위치구하기
				g.setColor(fcolor);//글자색 변경
				g.setFont(new Font("Comic Sans MS",Font.BOLD,22));//글꼴 변경
				g.drawString("Happy Day", x, y);//캔바스에 문자열 출력
				break;
			}
			}
		}
	}
	
	public void setDesign()
	{
		this.setLayout(null);
		JLabel lbl=new JLabel("Select ComboBox");
		lbl.setBounds(10, 10, 150, 30);
		this.add(lbl);
		
		combo=new JComboBox<String>(title);
		combo.setSelectedIndex(idx);//초기값 선택
		combo.setBounds(180, 10, 100, 30);
		this.add(combo);
		combo.addActionListener(this);//이벤트
		
		//캔바스 추가
		draw=new SelectDraw();
		draw.setBounds(0, 80, 400, 400);
		this.add(draw);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex2CanvasCombo("그래픽 선택");
	}

}




