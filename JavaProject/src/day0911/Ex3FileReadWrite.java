package day0911;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex3FileReadWrite {
	List<Shop> list;
	Scanner sc;
	static final String FILENAME="D:/java0901/shop.txt";
	public Ex3FileReadWrite() {
		// TODO Auto-generated constructor stub
		list=new ArrayList<Shop>();
		sc=new Scanner(System.in);
		
		//������ ������� �о list �� �����ϱ�
		FileReader fr=null;
		BufferedReader br=null;
		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);
			
			//�ݺ������� ������ �б�
			while(true)
			{
				String line=br.readLine();
				if(line==null)
					break;
				//, �� �и��ϱ�
				String []s=line.split(",");
				//Shop �� ����
				Shop shop=new Shop();
				shop.setSang(s[0]);
				shop.setColor(s[1]);
				shop.setCnt(Integer.parseInt(s[2]));
				shop.setPrice(Integer.parseInt(s[3]));
				//list �� �߰�
				list.add(shop);
			}
		} catch (FileNotFoundException e) {		
			System.out.println("�ҷ��� �ڷᰡ �����ϴ�:"+e.getMessage());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(br!=null) br.close();
				if(fr!=null) fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
	}
	
	//�߰�
	public void dataAdd()
	{
		System.out.println("Shop ����Ÿ�� �߰��մϴ�");
		System.out.println("��ǰ��");
		String sang=sc.nextLine();
		System.out.println("����");
		String color=sc.nextLine();
		System.out.println("����");
		int cnt=Integer.parseInt(sc.nextLine());
		System.out.println("����");
		int price=Integer.parseInt(sc.nextLine());
		
		//����Ʈ�� �߰�
		Shop shop=new Shop(sang, color, cnt, price);
		list.add(shop);
		System.out.println("�߰��Ǿ����ϴ�");
	}
	
	//����
	public void dataDel()
	{
		//��ǰ�� �Է��ؼ� ����, ������ "�ش� ��ǰ�� ��Ͽ� �����ϴ�"
		String search;
		boolean find=false;
		System.out.println("������ ��ǰ���� �Է����ּ���");
		search=sc.nextLine();
		for(int i=0;i<list.size();i++)
		{
			Shop s=list.get(i);
			if(s.getSang().equals(search))
			{
				find=true;
				list.remove(i);
				break;
			}
		}
		if(find)
			System.out.println("["+search+"] ��ǰ�� �����߽��ϴ�");
		else
			System.out.println("["+search+"] ��ǰ�� ��Ͽ� �����ϴ�");
		System.out.println();
		
	}
	
	//��ü���
	public void dataAllWrite()
	{
		System.out.println("  ** ��ü ��ǰ ��� **");
		System.out.println();
		System.out.println("��ȣ\t��ǰ��\t����\t����\t����\t�ѱݾ�");
		NumberFormat nf=NumberFormat.getCurrencyInstance();
		for(int i=0;i<list.size();i++)
		{
			Shop s=list.get(i);
			System.out.println(i+1+"\t"+s.getSang()+"\t"+s.getColor()
			+"\t"+s.getCnt()+"��\t"+nf.format(s.getPrice())+"\t"+
				nf.format(s.getCnt()*s.getPrice()));
		}
		System.out.println();
	}
	
	//����� ���Ͽ� ����
	public void fileSave()
	{
		FileWriter fw=null;
		try {
			fw=new FileWriter(FILENAME);
			for(Shop s:list)
			{
				String str=s.getSang()+","+s.getColor()+","+s.getCnt()+","+s.getPrice();
				fw.write(str+"\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fw!=null)
				try {
					fw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	//�޴�
	public int getMenu()
	{
		int n;
		System.out.println("** �޴� **");
		System.out.println("1.����Ÿ�߰�\n2.����Ÿ����\n3.��ü��ǰ���\n4.����");
		System.out.println("�����ϼ���");
		n=Integer.parseInt(sc.nextLine());
		return n;
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex3FileReadWrite ex=new Ex3FileReadWrite();
		Exit:
		while(true)
		{
			switch (ex.getMenu()) {
			case 1://�߰�
				ex.dataAdd();
				break;
			case 2://����
				ex.dataDel();
				break;
			case 3://��ü���
				ex.dataAllWrite();
				break;
			default:
				ex.fileSave();
				System.out.println("** ���� ������ �����մϴ� **");
				break Exit;
			}
		}
		System.out.println("** ���� ���� **");
	}

}








