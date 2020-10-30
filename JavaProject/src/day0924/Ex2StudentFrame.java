package day0924;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

public class Ex2StudentFrame  extends JFrame implements ActionListener{
	JButton btnInsert;
	AddStudent addFrame=new AddStudent("정보추가");
	//dao 선언
	StudentDao dao=new StudentDao();

	//이름목록을 출력할 List(awt)
	List lstNames;
	//전체 데이타를 가져올 List(util)
	java.util.List<StudentDto> list=new ArrayList<StudentDto>();

	//목록 클릭시 데이타 출력시키기 위한 변수 선언
	DrawPhoto drawPhoto=new DrawPhoto();
	JLabel lblName,lblHp,lblAddr,lblAge,lblWriteDay;
	Image photoImage;

	//삭제
	JButton btnDelete;

	//수정
	JButton btnUpdate;
	UpdateStudent updateFrame=new UpdateStudent("정보수정");
	
	//사진 모아보기
	JButton btnPhotoView;

	public Ex2StudentFrame(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 500, 500);//시작위치x,y,크기 w,h
		//this.getContentPane().setBackground(Color.orange);//프레임위에 있는 패널의 색상 변경
		this.getContentPane().setBackground(new Color(211,225,208));//프레임위에 있는 패널의 색상 변경
		this.setDesign();//디자인 코드
		this.setVisible(true);//보이게 하기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프로그램을 종료해주는 메서드
	}

	public void setDesign()
	{
		this.setLayout(null);
		//추가 버튼
		btnInsert=new JButton("학생정보추가");
		btnInsert.setBounds(10, 10, 130, 25);
		this.add(btnInsert);
		//이벤트
		btnInsert.addActionListener(this);
		//추가폼의 add 버튼이벤트
		addFrame.btnAdd.addActionListener(this);

		//awt.List 추가
		lstNames=new List();
		JScrollPane jsp=new JScrollPane(lstNames);
		jsp.setBounds(10, 100, 130, 300);
		this.add(jsp);
		this.writeNames();

		//학생 데이타 출력하기 위한 컴포넌트들 배치하기
		photoImage=new ImageIcon("D:\\java0901\\image\\귀여운 아이콘\\c1.png").getImage();//테스트용이미지
		drawPhoto.setBounds(180, 100, 120, 140);
		this.add(drawPhoto);

		//이름
		lblName=new JLabel("이름 : xxxx");
		lblName.setBounds(180, 270, 200, 30);
		this.add(lblName);

		//핸드폰
		lblHp=new JLabel("핸드폰 : xxxx");
		lblHp.setBounds(180, 300, 200, 30);
		this.add(lblHp);

		//주소
		lblAddr=new JLabel("주  소 : xxxx");
		lblAddr.setBounds(180, 330, 200, 30);
		this.add(lblAddr);

		//나이
		lblAge=new JLabel("나  이 : xxxx");
		lblAge.setBounds(180, 360, 200, 30);
		this.add(lblAge);

		//등록일
		lblWriteDay=new JLabel("등록일 : xxxxxxxxx",JLabel.CENTER);
		lblWriteDay.setBounds(150, 50, 250, 30);
		lblWriteDay.setBorder(new LineBorder(Color.gray,2));
		this.add(lblWriteDay);

		//목록 클릭시
		lstNames.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				//선택한 인덱스 얻기
				int idx=lstNames.getSelectedIndex();
				//System.out.println(idx);
				//idx 번지의 dto를 list 에서 꺼낸다
				StudentDto dto=list.get(idx);
				//이미지 얻기
				photoImage=new ImageIcon(dto.getPhoto()).getImage();
				//내부클래스의 paint 메서드 호출
				drawPhoto.repaint();

				//이름,핸드폰,주소,나이,등록시간 출력
				//조건:나이에서 현재년도 얻을때 Calendar 사용해보기
				//등록시간은 yyyy-MM-dd HH:mm 형식으로 출력하기
				lblName.setText("이  름 : "+dto.getName());
				lblHp.setText("핸드폰 : "+dto.getHp());
				lblAddr.setText("주  소 : "+dto.getAddr());

				//나이 계산
				//현재 년도
				Calendar cal=Calendar.getInstance();
				int currYear=cal.get(Calendar.YEAR);
				int age=currYear-dto.getBirthyear()+1;
				lblAge.setText("나  이  : "+String.valueOf(age)+" 세");

				//동록일
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");

				//TimeZone tz=TimeZone.getTimeZone("America/New_York");
				//sdf.setTimeZone(tz);
				lblWriteDay.setText("등록일 : "+sdf.format(dto.getWriteday()));				
			}
		});	

		//삭제 버튼 추가
		btnDelete=new JButton("학생정보삭제");
		btnDelete.setBounds(150, 10, 130, 25);
		btnDelete.addActionListener(this);//이벤트
		this.add(btnDelete);

		//수정 버튼 추가
		btnUpdate=new JButton("학생정보수정");
		btnUpdate.setBounds(290, 10, 130, 25);
		btnUpdate.addActionListener(this);//이벤트
		updateFrame.btnUpdate.addActionListener(this);//수정폼에 있는 수정버튼
		this.add(btnUpdate);
		
		//사진 모아보기
		btnPhotoView=new JButton("사진 모아보기");
		btnPhotoView.setBounds(250, 400, 200, 30);
		this.add(btnPhotoView);
		btnPhotoView.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				PhotoAllViewFrame photo=new PhotoAllViewFrame("사진모아보기");
				for(StudentDto dto:list)
				{
					photo.photoList.add(dto.getPhoto());//사진명만 추가
				}
				photo.setVisible(true);
			}
		});
	}

	//list 에 이름 출력하기 위한 메서드
	public void writeNames()
	{
		//기존 목록창의 이름들 모두 삭제후 불러오기
		lstNames.removeAll();
		//db에서 데이타 가져오기
		list=dao.getAllDatas();
		//목록에 추가
		for(StudentDto dto:list)
		{
			lstNames.add(dto.getName());
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		if(ob==btnInsert)//db추가 버튼
		{
			addFrame.setVisible(true);
		}else if(ob==addFrame.btnAdd)//추가프레임의 추가버튼
		{
			//addFrame 에서 입력한 값 가져오기
			String name=addFrame.txtName.getText();
			String photo=addFrame.lblPhoto.getText();
			String hp=addFrame.txtHp.getText();
			String addr=addFrame.txtAddr.getText();
			String birth=addFrame.cbBirth.getSelectedItem().toString();
			if(name.length()==0 || photo.length()==0 || hp.length()==0||addr.length()==0)
			{
				JOptionPane.showMessageDialog(this, "입력안한 항목이 있습니다");
				return;//메서드 종료
			}

			//dto선언후 값 넣어주기
			StudentDto dto=new StudentDto();
			dto.setName(name);
			dto.setAddr(addr);
			dto.setHp(hp);
			dto.setPhoto(photo);
			dto.setBirthyear(Integer.parseInt(birth));

			//insert 메서드 호출하기
			dao.studentInsert(dto);
			//목록 다시 출력
			this.writeNames();

			//입력값 초기화하기
			addFrame.txtName.setText("");
			addFrame.txtHp.setText("");
			addFrame.txtAddr.setText("");
			addFrame.lblPhoto.setText("");

			//추가프레임 안보이게 처리하기
			addFrame.setVisible(false);
		}else if(ob==btnDelete)//삭제버튼
		{
			//목록에서 선택한 인덱스
			int idx=lstNames.getSelectedIndex();			
			//아이템
			String item=lstNames.getSelectedItem();			
			System.out.println(idx+","+item);//-1,null

			//선택안햇을경우 -1,null 둘중 어떤조건을 써도 상관없음
			if(idx==-1)
			{
				JOptionPane.showMessageDialog(this, "삭제할 이름을 목록에서 선택하세요");
				return;//메서드 종료				
			}

			//삭제 메서드 호출
			dao.studentDelete(item);
			//목록 다시 출력
			this.writeNames();
		}else if(ob==btnUpdate)//학생정보수정버튼
		{
			//목록에서 선택한 인덱스를 얻는다
			int idx=lstNames.getSelectedIndex();
			//idx가 -1이면 "경고" 메세지후 메서드종료
			if(idx==-1)
			{
				JOptionPane.showMessageDialog(this, "수정할 이름을 선택해주세요");
				return;
			} 
			//list 에서 idx에 있는 dto 꺼내기
			StudentDto dto=list.get(idx);		
			//dto 의 정보를 수정폼의 num 변수및 텍스트,라벨에 출력시키기(년도는 콤보박스임)
			updateFrame.num=dto.getNum();
			updateFrame.txtName.setText(dto.getName());
			updateFrame.txtHp.setText(dto.getHp());
			updateFrame.txtAddr.setText(dto.getAddr());
			updateFrame.lblPhoto.setText(dto.getPhoto());
			updateFrame.cbBirth.setSelectedItem(dto.getBirthyear());
			//수정폼 보이게 하기
			updateFrame.setVisible(true);
					
		}else if(ob==updateFrame.btnUpdate)//수정폼의 수정버튼
		{
			//수정폼에서 데이타 읽어서 dto에 담기(num 포함)
			StudentDto dto=new StudentDto();
			dto.setNum(updateFrame.num);
			dto.setName(updateFrame.txtName.getText());
			dto.setHp(updateFrame.txtHp.getText());
			dto.setAddr(updateFrame.txtAddr.getText());
			dto.setPhoto(updateFrame.lblPhoto.getText());
			dto.setBirthyear(Integer.parseInt(updateFrame.cbBirth.getSelectedItem().toString()));
			
			//dao 의 수정 메서드 호출
			dao.studentUpdate(dto);
			
			//수정폼은 안보이게 처리
			updateFrame.setVisible(false);
			
			//목록 다시 출력하는 메서드 호출
			this.writeNames();
		}
	}

	//이미지 출력하기 의한 내부 클래스
	class DrawPhoto extends Canvas
	{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			//이미지 출력
			g.drawImage(photoImage, 0, 0, 120, 140, this);//위치는 나중에 조정하기
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex2StudentFrame ex=new Ex2StudentFrame("학생관리");
	}

}








