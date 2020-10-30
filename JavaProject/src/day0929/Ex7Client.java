package day0929;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex7Client  extends JFrame implements Runnable,ActionListener{
	JTextField txtName,txtServerIp,txtMsg;;
	JTextArea area;
	JButton btnConnect,btnSend;
	
	Socket socket;
	BufferedReader br;//서버로부터 메세지 읽기위한 변수
	PrintWriter pw;//서버로 메세지를 보내기 위한 변수
	
	public Ex7Client(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 400, 500);//시작위치x,y,크기 w,h
		//this.getContentPane().setBackground(Color.orange);//프레임위에 있는 패널의 색상 변경
		this.getContentPane().setBackground(new Color(211,225,208));//프레임위에 있는 패널의 색상 변경
		this.setDesign();//디자인 코드
		this.setVisible(true);//보이게 하기
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프로그램을 종료해주는 메서드
		//종료시 이벤트 발생
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				//서버로 종료 코드로 9를 보내보자
				pw.write("9,\n");
				pw.flush();
				
				System.out.println("시스템 종료합니다");
				System.exit(0);//시스템 종료
				super.windowClosing(e);
			}
		});
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("client run");
		//서버가 보내는 메세지를 읽어서 채팅창에 출력하기
		while(true)
		{
			try {
				String line=br.readLine();//서버가 보낸 문자열 읽기
				if(line==null) break;
				//채팅창에 추가
				area.append(line+"\n");				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob=e.getSource();
		//메세지 입력후 엔터 또는 전송 버튼 누를경우
		if(ob==txtMsg || ob==btnSend)
		{
			//서버에 메세지 전송
			String sendMessage="2,"+txtMsg.getText()+"\n";
			pw.write(sendMessage);
			pw.flush();
			
			//입력창 지우기
			txtMsg.setText("");
			//포커스
			txtMsg.requestFocus();
		}
	}
	
	public void setDesign()
	{
		this.setLayout(null);
		JLabel lbl1=new JLabel("닉네임");
		lbl1.setBounds(10, 10, 50, 25);
		this.add(lbl1);
		
		txtName=new JTextField();
		txtName.setBounds(70, 10, 80, 24);
		this.add(txtName);
		
		JLabel lbl2=new JLabel("서버ip");
		lbl2.setBounds(160, 10, 50, 25);
		this.add(lbl2);
		
		//txtServerIp=new JTextField("192.168.0.12");//각자 본인 아이피
		txtServerIp=new JTextField("127.0.0.1");//local ip
		txtServerIp.setBounds(220, 10, 90, 24);
		this.add(txtServerIp);
		
		btnConnect=new JButton("접속");
		btnConnect.setBounds(320, 10, 60, 25);
		this.add(btnConnect);
		
		//접속 이벤트
		btnConnect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name=txtName.getText();//접속한 닉네임
				String ip=txtServerIp.getText();//접속할 서버 아이피
				//창제목을 닉네임으로 변경
				Ex7Client.this.setTitle(name);
				//서버에 접속하기
				try {
					socket=new Socket(ip, 7000);	
				
					//io 클래스 생성
					try {
						br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
						pw=new PrintWriter(socket.getOutputStream());
						
						//run 메소드 호출
						Thread th=new Thread(Ex7Client.this);
						th.start();
						
						//서버로 접속한 닉네임 보내기
						String sendMessage="1,"+txtName.getText()+"\n";
						System.out.println(sendMessage);
						pw.write(sendMessage);
						pw.flush();//서버로 메세지 전송
						
					} catch (IOException e0) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					System.out.println("서버주소 오류:"+e1.getMessage());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
			}
		});
		
		//채팅창과 메세지 입력하는곳 추가하기
		area=new JTextArea();	
		JScrollPane sp=new JScrollPane(area);
		sp.setBounds(10, 50, 360, 350);
		this.add(sp);
		
		txtMsg=new JTextField();
		txtMsg.setBounds(10, 410, 300, 25);	
		this.add(txtMsg);
		
		btnSend=new JButton("send");
		btnSend.setBounds(310, 410, 70, 25);
		this.add(btnSend);
		//이벤트
		txtMsg.addActionListener(this);//입력후 엔터 누르면 발생하는 이벤트
		btnSend.addActionListener(this);//전송 누르면 발생
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex7Client ex=new Ex7Client("client");
	}

}






