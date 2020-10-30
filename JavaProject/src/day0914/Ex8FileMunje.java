package day0914;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex8FileMunje extends JFrame{
	JTextField txtName,txtHp;
	JTextArea area;
	JButton btnOpen,btnSave,btnDelete;
	final String fileName="D:\\java0901\\info.txt";
	
	public Ex8FileMunje(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 440, 400);//시작위치x,y,크기 w,h
		//this.getContentPane().setBackground(Color.orange);//프레임위에 있는 패널의 색상 변경
		this.getContentPane().setBackground(new Color(211,225,208));//프레임위에 있는 패널의 색상 변경
		this.setDesign();//디자인 코드
		this.setVisible(true);//보이게 하기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프로그램을 종료해주는 메서드
	}
	
	public void setDesign()
	{
		this.setLayout(null);
		JLabel lblName=new JLabel("이름");
		lblName.setBounds(20, 20, 60, 30);
		this.add(lblName);
		
		txtName=new JTextField();
		txtName.setBounds(90, 20, 70, 30);
		this.add(txtName);
		
		JLabel lblHp=new JLabel("핸드폰");
		lblHp.setBounds(170, 20, 60, 30);
		this.add(lblHp);
		
		txtHp=new JTextField();
		txtHp.setBounds(240, 20, 100, 30);
		this.add(txtHp);
		
		//버튼들 추가
		btnOpen=new JButton("전체불러오기");
		btnOpen.setBounds(10, 70, 130, 30);
		this.add(btnOpen);
		btnOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//area 의 기존 내용 지우기
				area.setText("");
				//파일에서 데이타 가져오기
				FileReader fr=null;
				BufferedReader br=null;
				
				try {
					fr=new FileReader(fileName);
					br=new BufferedReader(fr);
					//한줄씩 읽어서 area 에 추가
					while(true)
					{
						String line=br.readLine();
						if(line==null)
							break;
						area.append(line+"\n");
					}
				} catch (FileNotFoundException e1) {
					area.setText("파일이 존재하지 않습니다.\n데이타 저장후 불러오세요");					
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
		});
		
		
		btnSave=new JButton("파일에추가");
		btnSave.setBounds(150, 70, 130, 30);
		this.add(btnSave);
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//입력데이타 읽기
				String name=txtName.getText();
				String hp=txtHp.getText();
				if(name.length()==0 || hp.length()==0)
				{
					JOptionPane.showMessageDialog(Ex8FileMunje.this,
							"데이타를 입력해주세요");
					return;//메서드 종료
				}
				FileWriter fw=null;
				try {
					fw=new FileWriter(fileName, true);//true:append추가 모드
					//입력데이타 추가
					fw.write("이름:"+name+"\n");
					fw.write("핸드폰:"+hp+"\n");
					fw.write("=================\n");
					//데이타 초기화
					area.setText("파일에 데이타를 추가했습니다");
					txtName.setText("");
					txtHp.setText("");
					txtName.requestFocus();//포커스 보내기
					
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
				
			}
		});
		
		btnDelete=new JButton("파일삭제");
		btnDelete.setBounds(290, 70, 130, 30);
		this.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				File file=new File(fileName);
				if(file.exists())
				{
					file.delete();//삭제
					area.setText("파일이 삭제되었습니다");
				}else {
					area.setText("파일이 존재하지 않습니다");
				}
			}
		});
		
		//area 추가
		area=new JTextArea();
		JScrollPane jsp=new JScrollPane(area);
		jsp.setBounds(10, 110, 400, 250);
		this.add(jsp);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex8FileMunje("파일입출력문제");
	}

}






