package day0911;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Ex1FileWrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWriter fw=null;
		try {
			//fw=new FileWriter("D:/java0901/test1.txt");//������ ������ ���λ���,������ ���
			fw=new FileWriter("D:/java0901/test1.txt",true);//�����̾����� ���λ���,������ �������뿡 �߰�
			
			fw.write("Hello\n�ȳ��ϼ���\n"+new Date().toString()+"\n=======");
			System.out.println("������ Ȯ���ϼ���");
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
