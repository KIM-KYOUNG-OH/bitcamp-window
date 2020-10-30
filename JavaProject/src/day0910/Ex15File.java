package day0910;

import java.io.File;

public class Ex15File {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="D:/java0901/";
		File file1=new File(path+"memo.txt");
		File file2=new File(path+"ppt");
		File file3=new File(path+"hello.txt");
		
		System.out.println(file1.isDirectory());//false
		System.out.println(file2.isDirectory());//true
		System.out.println(file1.isFile());//true
		System.out.println(file2.isFile());//false
		System.out.println("memo.txt �� "+file1.length()+" Byte");
		
		System.out.println(file1.exists());//�����ϸ� true
		System.out.println(file3.exists());//�������� �����Ƿ� false
		System.out.println(file1.getAbsolutePath());//������
		System.out.println(file2.getAbsolutePath());//������
		System.out.println(file1.getName());//���ϸ� ���
		System.out.println(file1.canExecute());//true
		System.out.println(file1.canRead());//true
		System.out.println(file1.canWrite());//true
		
		System.out.println("ppt�� ���� ���丮��� ����� ����϶�");
		if(file2.isDirectory())
		{
			String []list=file2.list();
			for(String a:list)
				System.out.println(a);
		}
		
		System.out.println("���� �����ϱ�");
		if(file1.exists())
		{
			file1.delete();
			System.out.println("����1 �� �����߽��ϴ�");
			
		}else {
			System.out.println("���� 1�� �������� �ʽ��ϴ�");
		}
		
		if(file3.exists())
		{
			file1.delete();
			System.out.println("����3 �� �����߽��ϴ�");
			
		}else {
			System.out.println("���� 3�� �������� �ʽ��ϴ�");
		}

	}

}
