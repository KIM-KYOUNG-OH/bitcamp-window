package day0915;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex3Table  extends JFrame{
	
	JTable table;
	JLabel lblSelect;
	
	//테이블에 출력할 제목
	String []title= {"이름","나이","혈액형"};
	//테이블에 출력할 데이타
	String [][]data= {
			{"강호동","34세","O형"},
			{"임영웅","26세","AB형"},
			{"이지연","33세","B형"}
	};
	
	public Ex3Table(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 300, 300);//시작위치x,y,크기 w,h
		//this.getContentPane().setBackground(Color.orange);//프레임위에 있는 패널의 색상 변경
		this.getContentPane().setBackground(new Color(211,225,208));//프레임위에 있는 패널의 색상 변경
		this.setDesign();//디자인 코드
		this.setVisible(true);//보이게 하기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프로그램을 종료해주는 메서드
	}
	
	public void setDesign()
	{ 
		this.setLayout(null);
		table=new JTable(data, title);
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(20, 20, 250, 100);
		this.add(jsp);
		
		lblSelect=new JLabel("결과나오는곳");
		lblSelect.setBounds(10, 170, 200, 50);
		this.add(lblSelect);
		
		//테이블에 마우스 클릭시 이벤트
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//선택한 행번호 구하기
				int row=table.getSelectedRow();
				String name=table.getValueAt(row, 0).toString();
				String age=(String)table.getValueAt(row, 1);
				String blood=table.getValueAt(row, 2).toString();
				
				lblSelect.setText("Name:"+name+",Age:"+age+",Blood:"+blood);
				super.mouseClicked(e);
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex3Table("테이블연습");
	}

}





