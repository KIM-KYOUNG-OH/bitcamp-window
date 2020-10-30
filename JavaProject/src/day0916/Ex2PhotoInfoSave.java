package day0916;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ex2PhotoInfoSave  extends JFrame implements ActionListener{
	MyPhoto myPhoto;//내부클래스
	JButton btnPhoto,btnSave,btnOpen;
	JTextField txtName,txtAge;
	JComboBox<String> comboBlood;
	Image photoImage;
	String imageName;//파일에 저장할 이미지명
	
	public Ex2PhotoInfoSave(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 400, 400);//시작위치x,y,크기 w,h
		this.getContentPane().setBackground(Color.white);//프레임위에 있는 패널의 색상 변경
		//this.getContentPane().setBackground(new Color(211,225,208));//프레임위에 있는 패널의 색상 변경
		this.setDesign();//디자인 코드
		this.setVisible(true);//보이게 하기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프로그램을 종료해주는 메서드
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		if(ob==btnPhoto)//사진가져오기 버튼
		{
			//FileDialog 이용해서 사진을 가져오면 사진 변경되도록 해보세요
			FileDialog dlg=new FileDialog(this, "사진가져오기", FileDialog.LOAD);
			dlg.setVisible(true);
			//취소가 아닌경우 사진 출력
			if(dlg.getDirectory()!=null)
			{
				imageName=dlg.getDirectory()+dlg.getFile();
				//Image생성
				photoImage=new ImageIcon(imageName).getImage();
				//paint 메서드 호출
				myPhoto.repaint();
			}
			
		}else if(ob==btnSave)//정보 저장
		{
			//입력한 이름.txt 로 저장하기(java0901 폴더에)
			//입력체크-이름이나 나이를 입력안하면 경고메세지후 메서드 종료
			String name=txtName.getText().trim();//trim():양쪽 공백제거
			String blood=comboBlood.getSelectedItem().toString();
			String age=txtAge.getText();
			if(name.length()==0)
			{
				JOptionPane.showMessageDialog(this, "이름을 입력해주세요");
				txtName.requestFocus();
				return;
			}
			if(age.length()==0)
			{
				JOptionPane.showMessageDialog(this, "나이를 입력해주세요");
				txtAge.requestFocus();
				return;
			}
			
			//파일에 한줄에 정보한개씩
			//이미지명(첫줄),이름(2번째줄),혈액형(3번째줄),나이(4번째줄)에 저장
			FileWriter fw=null;
			try {
				fw=new FileWriter("D:\\java0901\\"+name+".txt");
				//저장
				fw.write(imageName+"\n");
				fw.write(name+"\n");
				fw.write(blood+"\n");
				fw.write(age+"\n");				
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally {
				try {
					fw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			//이미지는 처음 이미지로 초기화. 이름과 나이는 지우고, 
			//혈액형은 다시 1번째꺼로 초기화			
			photoImage=new ImageIcon("D:\\java0901\\image\\귀여운 아이콘\\c1.png").getImage();
			myPhoto.repaint();
			txtName.setText("");
			txtAge.setText("");
			comboBlood.setSelectedIndex(0);
			
		}else if(ob==btnOpen)//정보 가져오기
		{
			//해당 이름으로 된 파일을 불러오면 그 데이타로 
			//사진,이름,혈액형,나이가 변경되도록 한다
			FileReader fr=null;
			BufferedReader br=null;
			FileDialog dlg=new FileDialog(this,"파일열기",FileDialog.LOAD);
			dlg.setVisible(true);
			if(dlg.getDirectory()!=null)
			{
				String fileName=dlg.getDirectory()+dlg.getFile();
				try {
					fr=new FileReader(fileName);
					br=new BufferedReader(fr);
					//1번째 데이타는 사진명
					imageName=br.readLine();//사진명
					photoImage=new ImageIcon(imageName).getImage();
					myPhoto.repaint();
					
					//2번째 데이타는 이름
					String name=br.readLine();
					txtName.setText(name);
					
					//3번째-혈액형
					String blood=br.readLine();
					comboBlood.setSelectedItem(blood);
					
					//4번째-나이
					String age=br.readLine();
					txtAge.setText(age);
					
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}finally {
					try {
						if(br!=null) br.close();
						if(fr!=null) fr.close();
					}catch (IOException e1) {
						// TODO: handle exception
					}
				}
			}
		}
	}
	
	//사진을 출력할 캔바스내부클래스
	class MyPhoto extends Canvas
	{
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			g.drawImage(photoImage, 10, 2, 110, 130, this);		
		}
	}
	
	public void setDesign()
	{
		this.setLayout(null);
		//사진 버튼
		btnPhoto=new JButton("사진가져오기");
		btnPhoto.setBounds(20, 20, 120, 25);
		this.add(btnPhoto);
		btnPhoto.addActionListener(this);
		
		//사진 출력
		//임시사진 일단 출력하기
		photoImage=new ImageIcon("D:\\java0901\\image\\귀여운 아이콘\\c1.png").getImage();
		myPhoto=new MyPhoto();//내부 클래스 생성
		myPhoto.setBounds(20, 50, 120, 150);
		this.add(myPhoto);
		
		//사진 우측으로 이름,혈액형 나이 입력
		JLabel lbl1=new JLabel("이름");
		lbl1.setBounds(190, 30, 50, 25);
		this.add(lbl1);
		
		JLabel lbl2=new JLabel("혈액형");
		lbl2.setBounds(190, 80, 50, 25);
		this.add(lbl2);
		
		JLabel lbl3=new JLabel("나이");
		lbl3.setBounds(190, 130, 50, 25);
		this.add(lbl3);
		
		txtName=new JTextField();
		txtName.setBounds(260, 30, 60, 25);
		this.add(txtName);
		
		String []blood= {"A","B","O","AB"};
		comboBlood=new JComboBox<String>(blood);
		comboBlood.setBounds(260, 80, 80, 25);
		this.add(comboBlood);
		
		txtAge=new JTextField();
		txtAge.setBounds(260, 130, 60, 25);
		this.add(txtAge);
		
		//버튼 2개
		btnSave=new JButton("고객정보저장");
		btnSave.setBounds(50, 230, 130, 50);
		btnSave.setBackground(Color.red);
		btnSave.setForeground(Color.yellow);
		btnSave.addActionListener(this);//이벤트
		this.add(btnSave);
		
		btnOpen=new JButton("고객정보가져오기");
		btnOpen.setBounds(200, 230, 150, 50);
		btnOpen.setBackground(Color.orange);
		btnOpen.setForeground(Color.blue);
		btnOpen.addActionListener(this);//이벤트
		this.add(btnOpen);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex2PhotoInfoSave("고객정보관리");
	}

}











