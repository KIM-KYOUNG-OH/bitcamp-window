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
		
		//파일이 있을경우 읽어서 list 에 저장하기
		FileReader fr=null;
		BufferedReader br=null;
		try {
			fr=new FileReader(FILENAME);
			br=new BufferedReader(fr);
			
			//반복문으로 여려줄 읽기
			while(true)
			{
				String line=br.readLine();
				if(line==null)
					break;
				//, 로 분리하기
				String []s=line.split(",");
				//Shop 에 저장
				Shop shop=new Shop();
				shop.setSang(s[0]);
				shop.setColor(s[1]);
				shop.setCnt(Integer.parseInt(s[2]));
				shop.setPrice(Integer.parseInt(s[3]));
				//list 에 추가
				list.add(shop);
			}
		} catch (FileNotFoundException e) {		
			System.out.println("불러올 자료가 없습니다:"+e.getMessage());
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
	
	//추가
	public void dataAdd()
	{
		System.out.println("Shop 데이타를 추가합니다");
		System.out.println("상품명");
		String sang=sc.nextLine();
		System.out.println("색상");
		String color=sc.nextLine();
		System.out.println("수량");
		int cnt=Integer.parseInt(sc.nextLine());
		System.out.println("가격");
		int price=Integer.parseInt(sc.nextLine());
		
		//리스트에 추가
		Shop shop=new Shop(sang, color, cnt, price);
		list.add(shop);
		System.out.println("추가되었습니다");
	}
	
	//삭제
	public void dataDel()
	{
		//상품명 입력해서 삭제, 없으면 "해당 상품은 목록에 없습니다"
		String search;
		boolean find=false;
		System.out.println("삭제할 상품명을 입력해주세요");
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
			System.out.println("["+search+"] 상품을 삭제했습니다");
		else
			System.out.println("["+search+"] 상품은 목록에 없습니다");
		System.out.println();
		
	}
	
	//전체출력
	public void dataAllWrite()
	{
		System.out.println("  ** 전체 상품 출력 **");
		System.out.println();
		System.out.println("번호\t상품명\t색상\t갯수\t가격\t총금액");
		NumberFormat nf=NumberFormat.getCurrencyInstance();
		for(int i=0;i<list.size();i++)
		{
			Shop s=list.get(i);
			System.out.println(i+1+"\t"+s.getSang()+"\t"+s.getColor()
			+"\t"+s.getCnt()+"개\t"+nf.format(s.getPrice())+"\t"+
				nf.format(s.getCnt()*s.getPrice()));
		}
		System.out.println();
	}
	
	//종료시 파일에 저장
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
	
	//메뉴
	public int getMenu()
	{
		int n;
		System.out.println("** 메뉴 **");
		System.out.println("1.데이타추가\n2.데이타삭제\n3.전체상품출력\n4.종료");
		System.out.println("선택하세요");
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
			case 1://추가
				ex.dataAdd();
				break;
			case 2://삭제
				ex.dataDel();
				break;
			case 3://전체출력
				ex.dataAllWrite();
				break;
			default:
				ex.fileSave();
				System.out.println("** 파일 저장후 종료합니다 **");
				break Exit;
			}
		}
		System.out.println("** 정상 종료 **");
	}

}








