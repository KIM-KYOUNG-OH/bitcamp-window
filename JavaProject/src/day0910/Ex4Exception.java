package day0910;

import java.io.FileWriter;
import java.io.IOException;

public class Ex4Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//���Ͽ� ����
		FileWriter fw=null;
		String fileName="D:\\java0901\\work\\memo.txt";
		try {
			fw=new FileWriter(fileName);
			fw.write("���Ͽ� �����߾��");	
			System.out.println("����Ȯ��");
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
