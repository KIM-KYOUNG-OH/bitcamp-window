package day0929;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ex5InetAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InetAddress []naverInet=null;
		try {
			naverInet=InetAddress.getAllByName("www.naver.com");
			System.out.println("Naver Server Ip 알아보기");
			for(InetAddress in:naverInet)
			{
				System.out.println("네이버 컴퓨터 이름 :"+in.getHostName());
				System.out.println("네이버 컴퓨터 서버 ip : "+in.getHostAddress());
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		InetAddress []googleInet=null;
		try {
			googleInet=InetAddress.getAllByName("www.google.com");
			System.out.println("Naver Server Ip 알아보기");
			for(InetAddress in:googleInet)
			{
				System.out.println("구글 컴퓨터 이름 :"+in.getHostName());
				System.out.println("구글 컴퓨터 서버 ip : "+in.getHostAddress());
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
