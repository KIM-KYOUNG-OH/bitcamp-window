package day0929;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ex4LocalAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//��Į ��ǻ�Ϳ� ���� �̸��� �����Ǹ� �˾ƺ���
		InetAddress myAddr=null;
		try {
			myAddr=InetAddress.getLocalHost();
			System.out.println("�� ��ǻ���� �̸� :"+myAddr.getHostName());
			System.out.println("�� ��ǻ���� ip : "+myAddr.getHostAddress());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
}
