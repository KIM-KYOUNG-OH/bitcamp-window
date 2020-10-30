package day0923;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Ex4PersonModel {
	PersonDao dao=new PersonDao();
	Scanner sc=new Scanner(System.in);
	
	//메뉴 선택 메서드
	public int getMenu()
	{
		int n;
		System.out.println("\t\t**메뉴**");
		System.out.println("1.추가  2.삭제  3.수정  4.검색  5.전체출력  6.종료");
		n=Integer.parseInt(sc.nextLine());
		return n;
	}
	//출력 메서드
	public void writeAll()
	{
		System.out.println("** 출력합니다 **");
		//dao 로부터 리스트 목록을 받아온다
		List<PersonDto> list=dao.getAllPersons();
		System.out.println("번호\t이름\t혈액형\t자바\t스프링\t키\t생년월일");
		System.out.println("----------------------------------------------------------");
		for(PersonDto dto:list)
		{
			System.out.println(dto.getNum()+"\t"+dto.getName()+"\t"+dto.getBlood().toUpperCase()
			+"형\t"+dto.getJava()+"\t"+dto.getSpring()+"\t"+dto.getHeight()+"\t"+dto.getBirthday());
		}
	}
	//입력 메서드
	public void dataAdd()
	{
		System.out.println("** 데이타를 추가합니다 **");
		String name,blood;
		int java,spring;
		double height;
		System.out.println("이름입력");
		name=sc.nextLine();
		System.out.println("혈액형 입력(소문자로)");
		blood=sc.nextLine();
		System.out.println("자바점수입력");
		java=sc.nextInt();
		System.out.println("스프링점수입력");
		spring=sc.nextInt();
		System.out.println("키 입력");
		height=sc.nextDouble();
		System.out.println("날짜입력(yyyy-mm-dd 형식으로 입력)");
		sc.nextLine();//버퍼의 엔터처리
		String birth=sc.nextLine();
		//문자열을 util.Date 로 변환하는방법
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date birthday=null;
		try {
			birthday=sdf.parse(birth);
		} catch (ParseException e) {
			System.out.println("날짜 형식으로 입력해주세요");
		}
		
		//입력한 데이타를 dto 에 넣기
		PersonDto dto=new PersonDto();
		dto.setName(name);
		dto.setBlood(blood);
		dto.setJava(java);
		dto.setSpring(spring);
		dto.setHeight(height);
		dto.setBirthday(birthday);
		
		//db insert 메서드 호출
		dao.personInsert(dto);
		System.out.println("추가되었습니다");
	}
	//수정메서드
	public void dataUpdate()
	{
		System.out.println("** 데이타를 수정합니다 **");
		//num,name,blood,java,spring
		//입력후 dto로 묶어서 메서드로 보내기
		String name,blood;
		int num,java,spring;
		
		System.out.println("수정할 num값");
		num=Integer.parseInt(sc.nextLine());		
		System.out.println("이름입력");
		name=sc.nextLine();
		System.out.println("혈액형 입력(소문자로)");
		blood=sc.nextLine();
		System.out.println("자바점수입력");
		java=Integer.parseInt(sc.nextLine());
		System.out.println("스프링점수입력");
		spring=Integer.parseInt(sc.nextLine());
		
		//dto 로 묶기
		PersonDto dto=new PersonDto();
		dto.setNum(num);
		dto.setName(name);
		dto.setBlood(blood);
		dto.setJava(java);
		dto.setSpring(spring);
		
		//dao 메서드 호출
		int n=dao.personUpdate(dto);
		
		//n이 0이면 "해당 번호는 없습니다", 그 이외 "수정햇습니다
		if(n==0)
			System.out.println("해당 번호는 없습니다");
		else
			System.out.println("수정했습니다");
	}
	//삭제메서드
	public void dataDelete()
	{
		System.out.println("** 데이타를삭제합니다 **");
		//이름 입력
		String name="";
		System.out.println("삭제할 이름 입력");
		name=sc.nextLine();
		
		//dao 의 delete 메서드 호출
		int n=dao.personDelete(name);
		
		//n이 0이면 "xxx 님은 명단에 없습니다"
		//0아니면 "x명의 데이타를 삭제했습니다"
		if(n==0)
			System.out.println(name+"님은 명단에 없습니다");
		else
			System.out.println(n+"명의 데이타를 삭제했습니다");
	}
	//검색 메서드
	public void dataSearch()
	{
		System.out.println("** 데이타를 검색합니다 **");
		String blood;		
		//혈액형 입력
		System.out.println("검색할 혈액형 입력");
		blood=sc.nextLine();
		
		//dao 의 메서드 호출(반환타입은 List)
		List<PersonDto> list=dao.getBloodSearch(blood);
		
		//list 를 반복문을 이용해서 출력
		//제목으로  ** B형 명단 ** 
		//이름,자바,스프링,키,생년월일(이름의 오름차순 출력)
		System.out.println("\t\t**"+blood.toUpperCase()+" 형 명단**");
		System.out.println();
		System.out.println("이름\t자바\t스프링\t키\t생년월일");
		System.out.println("--------------------------------------------------");
		for(PersonDto dto:list)
		{
			System.out.println(dto.getName()+"\t"+dto.getJava()+"\t"+dto.getSpring()+"\t"+
					dto.getHeight()+"\t"+dto.getBirthday());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex4PersonModel ex=new Ex4PersonModel();
		while(true)
		{
			switch(ex.getMenu())
			{
			case 1://추가
				ex.dataAdd();
				break;
			case 2://삭제
				ex.dataDelete();
				break;
			case 3://수정
				ex.dataUpdate();
				break;
			case 4://검색
				ex.dataSearch();
				break;
			case 5://전체출력
				ex.writeAll();
				break;
			default:
				System.out.println("** 시스템을 종료합니다 **");
				System.exit(0);				
			}
			System.out.println();
		}
	}
	
	
}



















