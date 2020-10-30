package day0914;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

//간단한 파일 입출력
public class Ex6FileMemo extends JFrame implements ActionListener{
	JButton btnSave,btnOpen;
	String fileName;
	JTextArea area;
	
	public Ex6FileMemo(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 400, 400);//시작위치x,y,크기 w,h
		//this.getContentPane().setBackground(Color.orange);//프레임위에 있는 패널의 색상 변경
		this.getContentPane().setBackground(new Color(211,225,208));//프레임위에 있는 패널의 색상 변경
		this.setDesign();//디자인 코드
		this.setVisible(true);//보이게 하기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프로그램을 종료해주는 메서드
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		if(ob==btnOpen)//불러오기
		{
			FileDialog dlg=new FileDialog(this,"파일열기",FileDialog.LOAD);
			dlg.setVisible(true);
			if(dlg.getDirectory()!=null)//취소를 누르지 않은경우
			{
				fileName=dlg.getDirectory()+dlg.getFile();
				FileReader fr=null;
				BufferedReader br=null;
				try {
					fr=new FileReader(fileName);
					br=new BufferedReader(fr);
					//현재 메모장의 내용 지우기
					area.setText("");
					while(true)
					{
						//한줄읽기
						String line=br.readLine();
						if(line==null || line.length()==0)
							break;
						//area 에 추가
						area.append(line+"\n");
					}
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
					}catch(IOException e1) {}
				}
			}
			
		}else if(ob==btnSave)//저장하기
		{
			FileDialog dlg=new FileDialog(this, "파일저장", FileDialog.SAVE);
			dlg.setVisible(true);
			//취소 누르면 null 값 반환
			String dir=dlg.getDirectory();//선택한 디렉토리
			String file=dlg.getFile();//선택한 파일명
			//System.out.println(dir);//취소 누르면 null 값 출력
			//System.out.println(file);
			if(dir!=null)//취소를 누르지 않았을 경우에만 저장
			{
				fileName=dir+file;//경로포함 파일명
				//저장할 내용
				String content=area.getText();
				//파일에 저장
				FileWriter fw=null;
				try {
					fw=new FileWriter(fileName);
					//내용 저장
					fw.write(content);
					area.setText(fileName+" 저장완료!!!");
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
		}
	}
	
	public void setDesign()
	{
		this.setLayout(null);
		btnSave=new JButton("파일저장");
		btnSave.setBounds(50, 30, 100, 30);
		this.add(btnSave);
		
		btnOpen=new JButton("파일열기");
		btnOpen.setBounds(170, 30, 100, 30);
		this.add(btnOpen);
		
		area=new JTextArea();
		JScrollPane jsp=new JScrollPane(area);		
		jsp.setBounds(10, 80, 350, 250);
		this.add(jsp);//스크롤이 필요한 컴포넌트 추가하는 방법
		
		//버튼이벤트 추가
		btnSave.addActionListener(this);
		btnOpen.addActionListener(this);		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex6FileMemo("간단메모");
	}

}





