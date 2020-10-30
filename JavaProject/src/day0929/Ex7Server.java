package day0929;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Ex7Server  extends JFrame implements Runnable{
	
	JTextArea area;
	ServerSocket serverSocket;
	//접속하는 클라이언트들을 저장할 벡터 선언
	Vector<ChatClient> list=new Vector<ChatClient>();
	
	public Ex7Server(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 500, 500);//시작위치x,y,크기 w,h
		//this.getContentPane().setBackground(Color.orange);//프레임위에 있는 패널의 색상 변경
		this.getContentPane().setBackground(new Color(211,225,208));//프레임위에 있는 패널의 색상 변경
		this.setDesign();//디자인 코드
		this.setVisible(true);//보이게 하기
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//프로그램을 종료해주는 메서드
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("run 1");
		//서버 소켓 생성
		try {
			serverSocket=new ServerSocket(7000);
			area.append("서버 소켓 생성 성공\n");
		} catch (IOException e) {
			area.append("서버 소켓 생성 실패\n"+e.getMessage());
		}
		
		while(true)
		{
			//접속하는 클라이언트 허용하기
			try {
				Socket socket=serverSocket.accept();
				InetAddress inet=socket.getInetAddress();
				area.append("접속한 ip:"+inet.getHostAddress()+"\n");
				
				//접속한 클라이언트를 벡터에 추가하기
				ChatClient client=new ChatClient(socket);
				list.add(client);//벡터에 클라이언트 정보 추가
				client.start();//각 클라이언트가 가진 run 메소드를 호출(각 클라이언트는 스레드)
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	//클라이언트 내부 클래스
	class ChatClient extends Thread
	{
		String nickName;
		Socket socket;
		BufferedReader br;
		PrintWriter pw;
		
		public ChatClient(Socket socket) {
			// TODO Auto-generated constructor stub
			this.socket=socket;
			try {
				br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw=new PrintWriter(socket.getOutputStream());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			System.out.println("run 2");
			while(true)
			{
				//각 클라이언트가 보낸 메세지를 읽는다
				try {
					String msg=br.readLine();
					//클라이언트는 보낼때 처음 접속한이후는 "1,닉네임" 이런형태로 보내고
					//메세지는 "2,메세지" 이런형태로 보내도록 프로그래밍
					if(msg==null) break;
					String []data=msg.split(",");
					if(data[0].equals("1"))
					{
						//닉네임을 멤버변수에 일단 저장
						nickName=data[1];
						//System.out.println("nickName:"+nickName);
						//각 클라이언트에 보낼 메세지
						String sendMessage=nickName+" 님이 입장하였습니다\n";
						//서버창에도 메세지 출력
						area.append(sendMessage+"\n");
						//모든 클라이언트에 보내야한다
						for(ChatClient cc:list)
						{
							cc.pw.write(sendMessage);
							cc.pw.flush();//캐시에 저장되어있는 메세지를 네트워크를 통해서 비로소 보낸다
						}
					}else if(data[0].equals("2"))
					{
						String sendMessage=nickName+">>"+data[1]+"\n";
						//서버창에도 메세지 출력
						area.append(sendMessage+"\n");
						//모든 클라이언트에 보내야한다
						for(ChatClient cc:list)
						{
							cc.pw.write(sendMessage);
							cc.pw.flush();//캐시에 저장되어있는 메세지를 네트워크를 통해서 비로소 보낸다
						}
					}else if(data[0].equals("9"))
					{
						//목록에서 해당 닉네임을 찾아서 지우기
						for(int i=0;i<list.size();i++)
						{
							ChatClient cc=list.get(i);
							if(nickName.equals(cc.nickName))
							{
								//삭제
								list.remove(i);
								break;
							}
						}
						String sendMessage=nickName+"님이 퇴장했습니다\n";
						//서버창에도 메세지 출력
						area.append(sendMessage+"\n");
						//모든 클라이언트에 보내야한다
						for(ChatClient cc:list)
						{
							cc.pw.write(sendMessage);
							cc.pw.flush();//캐시에 저장되어있는 메세지를 네트워크를 통해서 비로소 보낸다
						}
						
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
				
			}
		}
	}
	public void setDesign()
	{
		area=new JTextArea();
		JScrollPane sp=new JScrollPane(area);
		this.add(area);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex7Server server=new Ex7Server("서버");
		Thread th=new Thread(server);
		th.start();
	}
}











