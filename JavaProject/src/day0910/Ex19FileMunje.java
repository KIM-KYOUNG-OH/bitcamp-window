package day0910;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Ex19FileMunje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileReader fr=null;
		BufferedReader br=null;
		
		try {
			fr=new FileReader("D:/java0901/student.txt");
			br=new BufferedReader(fr);
			
			System.out.println("\t**���� �б�**");
			System.out.println("�̸�\t������\tJava\tHtml\t�հ�\t���");
			System.out.println("------------------------------------------------------");
			while(true)
			{
				String line=br.readLine();
				if(line==null || line.length()==0)
					break;
				StringTokenizer st=new StringTokenizer(line,",");
				String name=st.nextToken();
				String blood=st.nextToken();
				int java=Integer.parseInt(st.nextToken());
				int html=Integer.parseInt(st.nextToken());
				int tot=java+html;
				double avg=tot/2.0;
				System.out.println(name+"\t"+blood+"��\t"+java+"\t"+html+"\t"+tot+"\t"+avg);				
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("������ �����:"+e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("** �������� **");		
	}

}
