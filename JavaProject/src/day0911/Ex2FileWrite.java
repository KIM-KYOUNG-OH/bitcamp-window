package day0911;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ex2FileWrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String name,hp;
		FileWriter fw=null;
		try {
			fw=new FileWriter("D:/java0901/info.txt",true);
			while(true)
			{
				System.out.println("�̸��� �Է��ϼ���");
				name=sc.nextLine();
				if(name.equals("��"))
					break;
				fw.write("�̸�:"+name+"\n");
				System.out.println("�ڵ�����ȣ�� �Է��ϼ���");
				hp=sc.nextLine();
				fw.write("�ڵ���:"+hp+"\n");
				fw.write("=================\n");
			}
			System.out.println("info.txt ������ Ȯ���ϼ���");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}



