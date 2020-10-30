package day0928;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Ex1SawonDB  extends JFrame implements ActionListener{
	//출력에 필요한 컴포넌트
	JComboBox<String> cbSearch;
	JTextField txtSearch;
	JButton btnSearch;
	
	JTable table;
	DefaultTableModel model;
	JLabel lblTitle;
	//dao 선언
	SawonDao dao=new SawonDao();
	//list 선언
	List<SawonDto> list;
	
	//버튼 3개 추가(추가,삭제,수정)
	JButton btnAdd,btnDel,btnUpdate;
	
	//추가폼
	AddSawon addFrame=new AddSawon("사원추가");
	//수정폼
	UpdateSawon updateFrame=new UpdateSawon("정보수정");
	
	public Ex1SawonDB(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 800, 400);//시작위치x,y,크기 w,h
		//this.getContentPane().setBackground(Color.orange);//프레임위에 있는 패널의 색상 변경
		this.getContentPane().setBackground(new Color(211,225,208));//프레임위에 있는 패널의 색상 변경
		this.setDesign();//디자인 코드
		this.setVisible(true);//보이게 하기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프로그램을 종료해주는 메서드
	}
	
	public void setDesign()
	{
		this.setLayout(null);
		//table 먼저
		String []title= {"번호","이름","띠","성별","부서","급여","세금","입사일","주민번호"};
		model=new DefaultTableModel(title,0);
		table=new JTable(model);
		JScrollPane sp=new JScrollPane(table);
		sp.setBounds(10,120,770,220);
		this.add(sp);
		
		//제목 라벨 추가
		lblTitle=new JLabel("전체 사원 명단", JLabel.CENTER);
		lblTitle.setFont(new Font("", Font.BOLD, 20));
		lblTitle.setBorder(new LineBorder(Color.DARK_GRAY,3));
		lblTitle.setBounds(100, 80, 400, 35);
		this.add(lblTitle);
		
		//전체 목록 가져오기
		list=dao.getSearchList();
		this.writeTable();
		
		//combo 추가
		String []s= {"전체","이름검색","부서검색"};
		cbSearch=new JComboBox<String>(s);
		cbSearch.setBounds(510, 80, 100, 30);
		this.add(cbSearch);
		
		txtSearch=new JTextField();
		txtSearch.setBounds(615, 80, 80, 30);
		this.add(txtSearch);
		
		//검색 버튼과 이벤트
		btnSearch=new JButton("검색");
		btnSearch.setBounds(700, 80, 70, 30);
		this.add(btnSearch);
		
		//익명 내부 클래스 형태의 이벤트
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//선택한 콤모박스 인덱스
				int idx=cbSearch.getSelectedIndex();
				//보낼 컬럼명
				String col=idx==0?"all":idx==1?"name":"buseo";
				//검색단어
				String search=txtSearch.getText();
				//제목 다시 출력
				String title=idx==0?"전체 사원 명단":idx==1?"이름 \""+search+"\" 검색 결과":
					"부서 \""+search+"\" 검색 결과";
				lblTitle.setText(title);
				//list 얻기
				list=dao.getSearchList(col, search);
				//테이블 다시 출력
				writeTable();
				//입력창 지우기
				txtSearch.setText("");
			}
		});
		
		//버튼들 추가
		btnAdd=new JButton("사원추가");
		btnAdd.setBounds(20, 20, 100, 30);
		this.add(btnAdd);
		
		btnDel=new JButton("사원삭제");
		btnDel.setBounds(140, 20, 100, 30);
		this.add(btnDel);
		
		btnUpdate=new JButton("사원수정");
		btnUpdate.setBounds(260, 20, 100, 30);
		this.add(btnUpdate);
		
		//버튼이벤트
		btnAdd.addActionListener(this);
		btnDel.addActionListener(this);
		btnUpdate.addActionListener(this);	
		
		//추가,수정 프레임의 버튼이벤트
		addFrame.btnInsert.addActionListener(this);
		updateFrame.btnUpdate.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		if(ob==btnAdd)//추가버튼
		{
			//추가 프레임 띄우기
			addFrame.setVisible(true);
		}else if(ob==addFrame.btnInsert)//추가프레임의 추가버튼
		{
			//dto 선언
			SawonDto dto=new SawonDto();
			//dto 에 입력값 넣기
			dto.setName(addFrame.txtName.getText());
			dto.setBuseo(addFrame.cbBuseo.getSelectedItem().toString());
			dto.setIpsaday(addFrame.txtIpsa.getText());
			dto.setJuminno(addFrame.txtJumin.getText());
			dto.setPay(Integer.parseInt(addFrame.txtPay.getText()));
			dto.setPaytax(Integer.parseInt(addFrame.lblPayTax.getText()));			
			
			//dao 의 insert 메서드 호출
			dao.sawonInsert(dto);
			
			//입력값 지우기
			addFrame.txtName.setText("");
			addFrame.txtPay.setText("");
			addFrame.txtJumin.setText("");
			addFrame.txtIpsa.setText("");
			addFrame.lblPayTax.setText("");
			
			//추가프레임 안보이게 하기
			addFrame.setVisible(false);
			
			//list 에 전체 데이타 가져오기
			list=dao.getSearchList();
			
			//테이블 다시 출력
			this.writeTable();
		}else if(ob==btnUpdate)//수정버튼
		{
			//테이블에서 선택한 인덱스 번호를 얻는다
			int idx=table.getSelectedRow();
			//선택안햇을경우(-1) 이면 "테이블에서 수정할 데이타를 선택해주세요"
			//라고 경고메세지 출력후 메서드 종료
			if(idx==-1)
			{
				JOptionPane.showMessageDialog(this, "테이블에서 수정할 데이타를 선택해주세요");
				return;
			}
			//list 에서 인덱스에 해당하는 dto를 얻는다
			SawonDto dto=list.get(idx);
			
			//updateFrame 의 num 변수에 dto의 num을 넣어준다
			updateFrame.num=dto.getNum();
			
			//나머지 dto의 데이타를 수정폼의 컴포넌트에 값으로 넣어준다
			updateFrame.txtName.setText(dto.getName());
			updateFrame.txtJumin.setText(dto.getJuminno());
			updateFrame.txtPay.setText(String.valueOf(dto.getPay()));
			updateFrame.lblPayTax.setText(String.valueOf(dto.getPaytax()));
			updateFrame.cbBuseo.setSelectedItem(dto.getBuseo());
			updateFrame.txtIpsa.setText(dto.getIpsaday());
			
			//수정폼 보이게 하기
			updateFrame.setVisible(true);
			
		}else if(ob==updateFrame.btnUpdate)//수정프레임의 수정버튼
		{
			//dto 선언
			SawonDto dto=new SawonDto();
			
			//dto 에 수정폼으로부터 값을 가져와서 넣어준다(num 필수)
			dto.setNum(updateFrame.num);
			dto.setName(updateFrame.txtName.getText());
			dto.setBuseo(updateFrame.cbBuseo.getSelectedItem().toString());
			dto.setIpsaday(updateFrame.txtIpsa.getText());
			dto.setJuminno(updateFrame.txtJumin.getText());
			dto.setPay(Integer.parseInt(updateFrame.txtPay.getText()));
			dto.setPaytax(Integer.parseInt(updateFrame.lblPayTax.getText()));		
			
			//dao 의 sawonUpdate 호출(수정메서드)
			dao.sawonUpdate(dto);
			
			//수정폼 안보이게 하기
			updateFrame.setVisible(false);
			
			//list 에 전체 데이타 가져오기
			list=dao.getSearchList();
			
			//테이블 다시 출력
			this.writeTable();
			
		}else if(ob==btnDel)//삭제버튼
		{
			//테이블에서 선택한 인덱스 번호를 얻는다
			int idx=table.getSelectedRow();
			//선택안햇을경우(-1) 이면 "테이블에서 수정할 데이타를 선택해주세요"
			//라고 경고메세지 출력후 메서드 종료
			if(idx==-1)
			{
				JOptionPane.showMessageDialog(this, "테이블에서 삭제할 데이타를 선택해주세요");
				return;
			}
			
			//num을 조건으로 삭제시 필요한 num얻기
			String num=table.getValueAt(idx, 0).toString();
			//System.out.println(num);
			
			//dao 의 삭제메서드 호출
			dao.sawonDelete(num);
			
			//리스트 전체 다시 가져오기
			list=dao.getSearchList();
			
			//테이블 다시 출력
			this.writeTable();
		}
	}
	
	//리스트 데이타를 테이블에 출력해주는 메서드
	public void writeTable()
	{
		//기존 데이타 지우고 새로 추가를 해야 하므로
		model.setRowCount(0);
		
		//Vector 형태로 만든후 테이블 모델에 추가
		NumberFormat nf=NumberFormat.getCurrencyInstance();
		for(SawonDto dto:list)
		{
			Vector<String> data=new Vector<String>();
			//{"번호","이름","띠","성별","부서","급여","세금","입사일","주민번호"};
			data.add(dto.getNum());
			data.add(dto.getName());
			data.add(dto.getDdi());
			data.add(dto.getGender());
			data.add(dto.getBuseo());
			data.add(nf.format(dto.getPay()));
			data.add(nf.format(dto.getPaytax()));
			data.add(dto.getIpsaday());
			//주민번호 8글자만 추출후 나머지는 * 로 출력
			String jumin=dto.getJuminno().substring(0,8)+"******";
			data.add(jumin);
			
			//테이블에 추가
			model.addRow(data);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1SawonDB ex=new Ex1SawonDB("사원관리");
	}

}







