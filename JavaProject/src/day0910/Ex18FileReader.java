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
			
			int count=0;//����
			int sum=0;//�հ�
			
			while(true)
			{
				//���پ� �б�
				String line=br.readLine();
				//���������� ������ �ΰ� ��ȯ
				if(line==null)
					break;
				if(line.length()==0)
					break;
				System.out.println(line);
				sum+=Integer.parseInt(line.trim());//���ڷ� �ٲ㼭 ���ϱ�
				count++;//���� ����
			}
			System.out.println("�Ѱ���="+count);
			System.out.println("�հ�="+sum);
		} catch (FileNotFoundException e) {
			System.out.println("������ �����:"+e.getMessage());
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
		
		
		System.out.println("** ���� ���� **");
	}

}
