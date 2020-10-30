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
	//�����ϴ� Ŭ���̾�Ʈ���� ������ ���� ����
	Vector<ChatClient> list=new Vector<ChatClient>();
	
	public Ex7Server(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 500, 500);//������ġx,y,ũ�� w,h
		//this.getContentPane().setBackground(Color.orange);//���������� �ִ� �г��� ���� ����
		this.getContentPane().setBackground(new Color(211,225,208));//���������� �ִ� �г��� ���� ����
		this.setDesign();//������ �ڵ�
		this.setVisible(true);//���̰� �ϱ�
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���α׷��� �������ִ� �޼���
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("run 1");
		//���� ���� ����
		try {
			serverSocket=new ServerSocket(7000);
			area.append("���� ���� ���� ����\n");
		} catch (IOException e) {
			area.append("���� ���� ���� ����\n"+e.getMessage());
		}
		
		while(true)
		{
			//�����ϴ� Ŭ���̾�Ʈ ����ϱ�
			try {
				Socket socket=serverSocket.accept();
				InetAddress inet=socket.getInetAddress();
				area.append("������ ip:"+inet.getHostAddress()+"\n");
				
				//������ Ŭ���̾�Ʈ�� ���Ϳ� �߰��ϱ�
				ChatClient client=new ChatClient(socket);
				list.add(client);//���Ϳ� Ŭ���̾�Ʈ ���� �߰�
				client.start();//�� Ŭ���̾�Ʈ�� ���� run �޼ҵ带 ȣ��(�� Ŭ���̾�Ʈ�� ������)
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	//Ŭ���̾�Ʈ ���� Ŭ����
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
				//�� Ŭ���̾�Ʈ�� ���� �޼����� �д´�
				try {
					String msg=br.readLine();
					//Ŭ���̾�Ʈ�� ������ ó�� ���������Ĵ� "1,�г���" �̷����·� ������
					//�޼����� "2,�޼���" �̷����·� �������� ���α׷���
					if(msg==null) break;
					String []data=msg.split(",");
					if(data[0].equals("1"))
					{
						//�г����� ��������� �ϴ� ����
						nickName=data[1];
						//System.out.println("nickName:"+nickName);
						//�� Ŭ���̾�Ʈ�� ���� �޼���
						String sendMessage=nickName+" ���� �����Ͽ����ϴ�\n";
						//����â���� �޼��� ���
						area.append(sendMessage+"\n");
						//��� Ŭ���̾�Ʈ�� �������Ѵ�
						for(ChatClient cc:list)
						{
							cc.pw.write(sendMessage);
							cc.pw.flush();//ĳ�ÿ� ����Ǿ��ִ� �޼����� ��Ʈ��ũ�� ���ؼ� ��μ� ������
						}
					}else if(data[0].equals("2"))
					{
						String sendMessage=nickName+">>"+data[1]+"\n";
						//����â���� �޼��� ���
						area.append(sendMessage+"\n");
						//��� Ŭ���̾�Ʈ�� �������Ѵ�
						for(ChatClient cc:list)
						{
							cc.pw.write(sendMessage);
							cc.pw.flush();//ĳ�ÿ� ����Ǿ��ִ� �޼����� ��Ʈ��ũ�� ���ؼ� ��μ� ������
						}
					}else if(data[0].equals("9"))
					{
						//��Ͽ��� �ش� �г����� ã�Ƽ� �����
						for(int i=0;i<list.size();i++)
						{
							ChatClient cc=list.get(i);
							if(nickName.equals(cc.nickName))
							{
								//����
								list.remove(i);
								break;
							}
						}
						String sendMessage=nickName+"���� �����߽��ϴ�\n";
						//����â���� �޼��� ���
						area.append(sendMessage+"\n");
						//��� Ŭ���̾�Ʈ�� �������Ѵ�
						for(ChatClient cc:list)
						{
							cc.pw.write(sendMessage);
							cc.pw.flush();//ĳ�ÿ� ����Ǿ��ִ� �޼����� ��Ʈ��ũ�� ���ؼ� ��μ� ������
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
		Ex7Server server=new Ex7Server("����");
		Thread th=new Thread(server);
		th.start();
	}
}











