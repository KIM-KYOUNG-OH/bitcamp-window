package day0924;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javax.swing.table.DefaultTableModel;

import day0923.PersonDao;
import day0923.PersonDto;

public class Ex1PersonFrame  extends JFrame implements ActionListener{
	//db처리 클래스 선언
	PersonDao dao=new PersonDao();
	//입력에 필요한 컴포넌트
	JTextField txtName,txtJava,txtSpring,txtHeight,txtBirth;
	JComboBox<String> cbBlood;
	//필요한 버튼
	JButton btnAdd,btnDel,btnUpdate,btnSearch,btnAll;
	//출력에 필요한 컴포넌트
	JTable table;
	DefaultTableModel model;

	public Ex1PersonFrame(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 600, 500);//시작위치x,y,크기 w,h
		//this.getContentPane().setBackground(Color.orange);//프레임위에 있는 패널의 색상 변경
		this.getContentPane().setBackground(new Color(211,225,208));//프레임위에 있는 패널의 색상 변경
		this.setDesign();//디자인 코드
		this.setVisible(true);//보이게 하기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프로그램을 종료해주는 메서드
	}

	public void setDesign()
	{
		//레이아웃 없애기
		this.setLayout(null);

		//이름
		JLabel lbl1=new JLabel("이름");
		lbl1.setBounds(10, 10, 50, 25);
		this.add(lbl1);

		txtName=new JTextField();
		txtName.setBounds(60, 10, 60, 25);
		this.add(txtName);

		//자바점수
		JLabel lbl2=new JLabel("Java");
		lbl2.setBounds(140, 10, 50, 25);
		this.add(lbl2);

		txtJava=new JTextField();
		txtJava.setBounds(190, 10, 60, 25);
		this.add(txtJava);

		//스프링점수
		JLabel lbl3=new JLabel("Spring");
		lbl3.setBounds(270, 10, 50, 25);
		this.add(lbl3);

		txtSpring=new JTextField();
		txtSpring.setBounds(330, 10, 60, 25);
		this.add(txtSpring);

		//혈액형
		JLabel lbl4=new JLabel("혈액형");
		lbl4.setBounds(10, 50, 50, 25);
		this.add(lbl4);

		String []blood= {"A","B","O","AB"};
		cbBlood=new JComboBox<String>(blood);
		cbBlood.setBounds(60, 50, 60, 25);
		this.add(cbBlood);

		//키
		JLabel lbl5=new JLabel("키");
		lbl5.setBounds(140, 50, 50, 25);
		this.add(lbl5);

		txtHeight=new JTextField();
		txtHeight.setBounds(190, 50, 60, 25);
		this.add(txtHeight);

		//생년월일
		JLabel lbl6=new JLabel("생년월일");
		lbl6.setBounds(270, 50, 60, 25);
		this.add(lbl6);

		txtBirth=new JTextField();
		txtBirth.setBounds(330, 50, 80, 25);
		this.add(txtBirth);

		//버튼들 추가
		//추가버튼
		btnAdd=new JButton("추가");
		btnAdd.setBounds(10, 100, 80, 30);
		this.add(btnAdd);

		//삭제버튼
		btnDel=new JButton("삭제");
		btnDel.setBounds(100, 100, 80, 30);
		this.add(btnDel);

		//수정버튼
		btnUpdate=new JButton("수정");
		btnUpdate.setBounds(190, 100, 80, 30);
		this.add(btnUpdate);
		
		//검색버튼
		btnSearch=new JButton("검색");
		btnSearch.setBounds(280, 100, 80, 30);
		this.add(btnSearch);
		
		//전체버튼
		btnAll=new JButton("전체보기");
		btnAll.setBounds(370, 100, 90, 30);
		this.add(btnAll);
		
		//테이블 생성
		String []title= {"번호","이름","혈액형","자바","스프링","키","생년월일"};
		model=new DefaultTableModel(title, 0);
		table=new JTable(model);
		JScrollPane jsp=new JScrollPane(table);
		jsp.setBounds(10, 160, 560, 290);
		this.add(jsp);		
		//데이타 추가하는 메서드 호출
		writeTable();
		
		//버튼에 이벤트 추가하기
		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnSearch.addActionListener(this);
		btnAll.addActionListener(this);		
	}

	//db 의 데이타를 테이블에 출력해주는 메서드
	public void writeTable()
	{
		//기존 테이블의 데이타를 모두 지운후 다시 가져온다
		model.setRowCount(0);
		//db 전체 데이타 가져오기
		List<PersonDto> list=dao.getAllPersons();
		//table은 배열이나 벡터형태로만 추가할수 있다		
		for(PersonDto dto:list)
		{
			Vector<String> data=new Vector<String>();
			data.add(String.valueOf(dto.getNum()));
			data.add(dto.getName());
			data.add(dto.getBlood());
			data.add(String.valueOf(dto.getJava()));
			data.add(String.valueOf(dto.getSpring()));
			data.add(String.valueOf(dto.getHeight()));
			data.add(String.valueOf(dto.getBirthday()));
			
			//table 에 추가(추가함수는 model 이 갖구있다)
			model.addRow(data);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		if(ob==btnAdd)
		{
			//입력안한 항목이 하나라도 있으면 메서도 종료
			String name=txtName.getText();
			String java=txtJava.getText();
			String spring=txtSpring.getText();
			String height=txtHeight.getText();
			String birth=txtBirth.getText();
			String blood=cbBlood.getSelectedItem().toString().toLowerCase();
			
			if(name.length()==0 || java.length()==0 || 
					spring.length()==0 || height.length()==0 || birth.length()==0)
			{
				JOptionPane.showMessageDialog(this, "입력안한 항목이 있습니다.확인하세요");
				return;
			}
			
			//dto 선언후 입력값 dto에 넣기
			//주의: 형변환을 잘해야해요
			//날짜만 먼저 date 타입으로 변경
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			Date birthday=null;
			try {
				birthday=sdf.parse(birth);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			PersonDto dto=new PersonDto();
			dto.setName(name);
			dto.setBlood(blood);
			dto.setJava(Integer.parseInt(java));
			dto.setSpring(Integer.parseInt(spring));
			dto.setHeight(Double.parseDouble(height));
			dto.setBirthday(birthday);
			
			//dao 의 insert 메서드 호출
			dao.personInsert(dto);
			
			//다시 테이블 출력
			this.writeTable();
			
			//입력값 지우기
			txtName.setText("");
			txtJava.setText("");
			txtSpring.setText("");
			txtHeight.setText("");
			txtBirth.setText("");		
			
		}else if(ob==btnDel)
		{
			String name=JOptionPane.showInputDialog("삭제할 이름을 입력해주세요");
			System.out.println(name);
			//dao 의 삭제 메서드 호출,int 값 반환(변수 n)
			int n=dao.personDelete(name);
			
			//n이 0 이면 경고 메세지 "xxx 님은 명단에 없습니다"
			//0이 아니면 "xxx 님 데이타가 삭제되었습니다" 
			if(n==0)
				JOptionPane.showMessageDialog(this, name+"님은 명단에 없습니다");
			else
			{
				JOptionPane.showMessageDialog(this, name+"님 데이타가 삭제되었습니다");
				//테이블 다시 출력
				this.writeTable();
			}	
			
		}else if(ob==btnUpdate)
		{
			//모든 입력은 JOptionPane.showInputDialog 이용
			//num,name,java,spring,blood 입력을 받아서
			String num=JOptionPane.showInputDialog("수정할 번호를 입력해주세요");
			if(num==null) return;//취소 누르면 종료
			String name=JOptionPane.showInputDialog("수정할 이름을 입력해주세요");
			String java=JOptionPane.showInputDialog("자바점수를 입력해주세요");
			String spring=JOptionPane.showInputDialog("스프링점수를 입력해주세요");
			String blood=JOptionPane.showInputDialog("수정할 혈액형을 입력해주세요");
			
			//dto로 묶어서
			PersonDto dto=new PersonDto();
			dto.setNum(Integer.parseInt(num));
			dto.setName(name);
			dto.setBlood(blood);
			dto.setJava(Integer.parseInt(java));
			dto.setSpring(Integer.parseInt(spring));
			
			//수정 메서드 호출
			int n=dao.personUpdate(dto);
			
			//0이면 "해당 번호가 존재하지 않습니다"
			//1이면 "수정되었습니다" 메세지 출력후 테이블 다시 출력
			if(n==0)
				JOptionPane.showMessageDialog(this, "해당 번호가 존재하지 않습니다");
			else
			{
				JOptionPane.showMessageDialog(this, "수정되었습니다");
				this.writeTable();
			}
		}else if(ob==btnSearch)
		{
			//혈액형 입력
			String blood=JOptionPane.showInputDialog("조회할 혈액형을 입력해주세요");
			if(blood==null) return;//취소 누르면 메서드 종료
			//혈액형이 대한 리스트 가져오기
			List<PersonDto> list=dao.getBloodSearch(blood);
			//테이블의 데이타 삭제
			model.setRowCount(0);
			//리스트 목록 테이블에 출력
			//이번에는 배열로 만들어서 추가할께요			
			for(PersonDto dto:list)
			{
				String []data= {String.valueOf(dto.getNum()),
						dto.getName(),dto.getBlood(),String.valueOf(dto.getJava()),
						String.valueOf(dto.getSpring()),String.valueOf(dto.getHeight()),
						String.valueOf(dto.getBirthday())};
				//테이블에 추가(model이 추가 메서드 가지고 있음)
				model.addRow(data);
			}
		}else if(ob==btnAll)
		{
			writeTable();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1PersonFrame ex=new Ex1PersonFrame("person관리");
	}

}


