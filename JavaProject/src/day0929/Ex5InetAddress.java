package day0929;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ex5InetAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InetAddress []naverInet=null;
		try {
			naverInet=InetAddress.getAllByName("www.naver.com");
			System.out.println("Naver Server Ip �˾ƺ���");
			for(InetAddress in:naverInet)
			{
				System.out.println("���̹� ��ǻ�� �̸� :"+in.getHostName());
				System.out.println("���̹� ��ǻ�� ���� ip : "+in.getHostAddress());
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		InetAddress []googleInet=null;
		try {
			googleInet=InetAddress.getAllByName("www.google.com");
			System.out.println("Naver Server Ip �˾ƺ���");
			for(InetAddress in:googleInet)
			{
				System.out.println("���� ��ǻ�� �̸� :"+in.getHostName());
				System.out.println("���� ��ǻ�� ���� ip : "+in.getHostAddress());
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
