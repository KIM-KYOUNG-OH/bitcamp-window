package day0911;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Ex1FileWrite {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileWriter fw=null;
		try {
			//fw=new FileWriter("D:/java0901/test1.txt");//파일이 없으면 새로새성,있으면 덮어씀
			fw=new FileWriter("D:/java0901/test1.txt",true);//파일이없으면 새로생성,있으면 기존내용에 추가
			
			fw.write("Hello\n안녕하세요\n"+new Date().toString()+"\n=======");
			System.out.println("파일을 확인하세요");
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
