package day0910;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ex18FileReader {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr=null;
		BufferedReader br=null;
		try {
			fr=new FileReader("D:/java0901/score.txt");
			br=new BufferedReader(fr);
			
			int count=0;//갯수
			int sum=0;//합계
			
			while(true)
			{
				//한줄씩 읽기
				String line=br.readLine();
				//마지막까지 읽으면 널값 반환
				if(line==null)
					break;
				if(line.length()==0)
					break;
				System.out.println(line);
				sum+=Integer.parseInt(line.trim());//숫자로 바꿔서 더하기
				count++;//갯수 증가
			}
			System.out.println("총갯수="+count);
			System.out.println("합계="+sum);
		} catch (FileNotFoundException e) {
			System.out.println("파일이 없어요:"+e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		System.out.println("** 정상 종료 **");
	}

}
