package day0904;

import java.util.Scanner;

public class Ex3Rank {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int inwon;//�ο��� �Է��Ͽ� �ο�����ŭ �迭 �Ҵ�
		String []name;
		int [] java,jsp;
		int [] rank;
	    int [] tot;
		
		/*
		 * �ο����� �Է��Ͽ� �� �ο�����ŭ ��ü �迭 �Ҵ�
		 * �̸��� �ΰ����� ������ �Է��� ������ ����� ������ ����ϱ�
		 * �����
		 * ��ȣ �̸� java jsp ���� ���
		 * 
		 */
	    
//	    //1. �ο��� �Է�
//	    System.out.println("�ο����� �Է��ϼ���");
//	    inwon=Integer.parseInt(sc.nextLine());
//	    //2. �迭 �Ҵ�
//	    name=new String[inwon];
//	    java=new int[inwon];
//	    jsp=new int[inwon];
//	    tot=new int[inwon];
//	    rank=new int[inwon];
//	    
//	    //3. ����Ÿ �Է�,�������
//	    for(int i=0;i<inwon;i++)
//	    {
//	    	System.out.println("�̸� �Է�");
//	    	name[i]=sc.nextLine();
//	    	System.out.println("java �� jsp ������ �Է��ϼ���");
//	    	java[i]=Integer.parseInt(sc.nextLine());
//	    	jsp[i]=Integer.parseInt(sc.nextLine());
//	    	//���� ���ϱ�
//	    	tot[i]=java[i]+jsp[i];
//	    }
//	    //4. ���
//	    for(int i=0;i<inwon;i++)
//	    {
//	    	rank[i]=1;
//	    	for(int j=0;j<inwon;j++)
//	    	{
//	    		if(tot[i]<tot[j])
//	    			rank[i]++;
//	    	}
//	    }
//	    //5. ���
//	    System.out.println("��ȣ\t�̸�\tjava\tjsp\t����\t���");
//	    for(int i=0;i<inwon;i++)
//	    {
//	    	System.out.println(i+1+"\t"+name[i]+"\t"+java[i]+"\t"+
//	    				jsp[i]+"\t"+tot[i]+"\t"+rank[i]);
//	    }
	    
	    
	  //1. �ο��� �Է�
	    System.out.println("�ο����� �Է��ϼ���");
	    inwon=sc.nextInt();
	    //2. �迭 �Ҵ�
	    name=new String[inwon];
	    java=new int[inwon];
	    jsp=new int[inwon];
	    tot=new int[inwon];
	    rank=new int[inwon];
	    
	    //3. ����Ÿ �Է�,�������
	    for(int i=0;i<inwon;i++)
	    {
	    	//���� ó��
	    	sc.nextLine();
	    	System.out.println("�̸� �Է�");
	    	name[i]=sc.nextLine();
	    	System.out.println("java �� jsp ������ �Է��ϼ���");
	    	java[i]=sc.nextInt();
	    	jsp[i]=sc.nextInt();
	    	//���� ���ϱ�
	    	tot[i]=java[i]+jsp[i];
	    }
	    //4. ���
	    for(int i=0;i<inwon;i++)
	    {
	    	rank[i]=1;
	    	for(int j=0;j<inwon;j++)
	    	{
	    		if(tot[i]<tot[j])
	    			rank[i]++;
	    	}
	    }
	    //5. ���
	    System.out.println("��ȣ\t�̸�\tjava\tjsp\t����\t���");
	    for(int i=0;i<inwon;i++)
	    {
	    	System.out.println(i+1+"\t"+name[i]+"\t"+java[i]+"\t"+
	    				jsp[i]+"\t"+tot[i]+"\t"+rank[i]);
	    }
	}

}








