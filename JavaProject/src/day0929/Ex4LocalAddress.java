package day0929;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ex4LocalAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//로칼 컴퓨터에 대한 이름과 아이피를 알아보자
		InetAddress myAddr=null;
		try {
			myAddr=InetAddress.getLocalHost();
			System.out.println("내 컴퓨터의 이름 :"+myAddr.getHostName());
			System.out.println("내 컴퓨터의 ip : "+myAddr.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
}
