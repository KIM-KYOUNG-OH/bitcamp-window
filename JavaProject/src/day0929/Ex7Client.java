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
	BufferedReader br;//�����κ��� �޼��� �б����� ����
	PrintWriter pw;//������ �޼����� ������ ���� ����
	
	public Ex7Client(String title) {
		// TODO Auto-generated constructor stub
		super(title);
		this.setBounds(700, 100, 400, 500);//������ġx,y,ũ�� w,h
		//this.getContentPane().setBackground(Color.orange);//���������� �ִ� �г��� ���� ����
		this.getContentPane().setBackground(new Color(211,225,208));//���������� �ִ� �г��� ���� ����
		this.setDesign();//������ �ڵ�
		this.setVisible(true);//���̰� �ϱ�
		//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���α׷��� �������ִ� �޼���
		//����� �̺�Ʈ �߻�
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				//������ ���� �ڵ�� 9�� ��������
				pw.write("9,\n");
				pw.flush();
				
				System.out.println("�ý��� �����մϴ�");
				System.exit(0);//�ý��� ����
				super.windowClosing(e);
			}
		});
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("client run");
		//������ ������ �޼����� �о ä��â�� ����ϱ�
		while(true)
		{
			try {
				String line=br.readLine();//������ ���� ���ڿ� �б�
				if(line==null) break;
				//ä��â�� �߰�
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
		//�޼��� �Է��� ���� �Ǵ� ���� ��ư �������
		if(ob==txtMsg || ob==btnSend)
		{
			//������ �޼��� ����
			String sendMessage="2,"+txtMsg.getText()+"\n";
			pw.write(sendMessage);
			pw.flush();
			
			//�Է�â �����
			txtMsg.setText("");
			//��Ŀ��
			txtMsg.requestFocus();
		}
	}
	
	public void setDesign()
	{
		this.setLayout(null);
		JLabel lbl1=new JLabel("�г���");
		lbl1.setBounds(10, 10, 50, 25);
		this.add(lbl1);
		
		txtName=new JTextField();
		txtName.setBounds(70, 10, 80, 24);
		this.add(txtName);
		
		JLabel lbl2=new JLabel("����ip");
		lbl2.setBounds(160, 10, 50, 25);
		this.add(lbl2);
		
		//txtServerIp=new JTextField("192.168.0.12");//���� ���� ������
		txtServerIp=new JTextField("127.0.0.1");//local ip
		txtServerIp.setBounds(220, 10, 90, 24);
		this.add(txtServerIp);
		
		btnConnect=new JButton("����");
		btnConnect.setBounds(320, 10, 60, 25);
		this.add(btnConnect);
		
		//���� �̺�Ʈ
		btnConnect.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name=txtName.getText();//������ �г���
				String ip=txtServerIp.getText();//������ ���� ������
				//â������ �г������� ����
				Ex7Client.this.setTitle(name);
				//������ �����ϱ�
				try {
					socket=new Socket(ip, 7000);	
				
					//io Ŭ���� ����
					try {
						br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
						pw=new PrintWriter(socket.getOutputStream());
						
						//run �޼ҵ� ȣ��
						Thread th=new Thread(Ex7Client.this);
						th.start();
						
						//������ ������ �г��� ������
						String sendMessage="1,"+txtName.getText()+"\n";
						System.out.println(sendMessage);
						pw.write(sendMessage);
						pw.flush();//������ �޼��� ����
						
					} catch (IOException e0) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					System.out.println("�����ּ� ����:"+e1.getMessage());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
				}
			}
		});
		
		//ä��â�� �޼��� �Է��ϴ°� �߰��ϱ�
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
		//�̺�Ʈ
		txtMsg.addActionListener(this);//�Է��� ���� ������ �߻��ϴ� �̺�Ʈ
		btnSend.addActionListener(this);//���� ������ �߻�
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex7Client ex=new Ex7Client("client");
	}

}






