package day0923;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Ex4PersonModel {
	PersonDao dao=new PersonDao();
	Scanner sc=new Scanner(System.in);
	
	//�޴� ���� �޼���
	public int getMenu()
	{
		int n;
		System.out.println("\t\t**�޴�**");
		System.out.println("1.�߰�  2.����  3.����  4.�˻�  5.��ü���  6.����");
		n=Integer.parseInt(sc.nextLine());
		return n;
	}
	//��� �޼���
	public void writeAll()
	{
		System.out.println("** ����մϴ� **");
		//dao �κ��� ����Ʈ ����� �޾ƿ´�
		List<PersonDto> list=dao.getAllPersons();
		System.out.println("��ȣ\t�̸�\t������\t�ڹ�\t������\tŰ\t�������");
		System.out.println("----------------------------------------------------------");
		for(PersonDto dto:list)
		{
			System.out.println(dto.getNum()+"\t"+dto.getName()+"\t"+dto.getBlood().toUpperCase()
			+"��\t"+dto.getJava()+"\t"+dto.getSpring()+"\t"+dto.getHeight()+"\t"+dto.getBirthday());
		}
	}
	//�Է� �޼���
	public void dataAdd()
	{
		System.out.println("** ����Ÿ�� �߰��մϴ� **");
		String name,blood;
		int java,spring;
		double height;
		System.out.println("�̸��Է�");
		name=sc.nextLine();
		System.out.println("������ �Է�(�ҹ��ڷ�)");
		blood=sc.nextLine();
		System.out.println("�ڹ������Է�");
		java=sc.nextInt();
		System.out.println("�����������Է�");
		spring=sc.nextInt();
		System.out.println("Ű �Է�");
		height=sc.nextDouble();
		System.out.println("��¥�Է�(yyyy-mm-dd �������� �Է�)");
		sc.nextLine();//������ ����ó��
		String birth=sc.nextLine();
		//���ڿ��� util.Date �� ��ȯ�ϴ¹��
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date birthday=null;
		try {
			birthday=sdf.parse(birth);
		} catch (ParseException e) {
			System.out.println("��¥ �������� �Է����ּ���");
		}
		
		//�Է��� ����Ÿ�� dto �� �ֱ�
		PersonDto dto=new PersonDto();
		dto.setName(name);
		dto.setBlood(blood);
		dto.setJava(java);
		dto.setSpring(spring);
		dto.setHeight(height);
		dto.setBirthday(birthday);
		
		//db insert �޼��� ȣ��
		dao.personInsert(dto);
		System.out.println("�߰��Ǿ����ϴ�");
	}
	//�����޼���
	public void dataUpdate()
	{
		System.out.println("** ����Ÿ�� �����մϴ� **");
		//num,name,blood,java,spring
		//�Է��� dto�� ��� �޼���� ������
		String name,blood;
		int num,java,spring;
		
		System.out.println("������ num��");
		num=Integer.parseInt(sc.nextLine());		
		System.out.println("�̸��Է�");
		name=sc.nextLine();
		System.out.println("������ �Է�(�ҹ��ڷ�)");
		blood=sc.nextLine();
		System.out.println("�ڹ������Է�");
		java=Integer.parseInt(sc.nextLine());
		System.out.println("�����������Է�");
		spring=Integer.parseInt(sc.nextLine());
		
		//dto �� ����
		PersonDto dto=new PersonDto();
		dto.setNum(num);
		dto.setName(name);
		dto.setBlood(blood);
		dto.setJava(java);
		dto.setSpring(spring);
		
		//dao �޼��� ȣ��
		int n=dao.personUpdate(dto);
		
		//n�� 0�̸� "�ش� ��ȣ�� �����ϴ�", �� �̿� "�����޽��ϴ�
		if(n==0)
			System.out.println("�ش� ��ȣ�� �����ϴ�");
		else
			System.out.println("�����߽��ϴ�");
	}
	//�����޼���
	public void dataDelete()
	{
		System.out.println("** ����Ÿ�������մϴ� **");
		//�̸� �Է�
		String name="";
		System.out.println("������ �̸� �Է�");
		name=sc.nextLine();
		
		//dao �� delete �޼��� ȣ��
		int n=dao.personDelete(name);
		
		//n�� 0�̸� "xxx ���� ��ܿ� �����ϴ�"
		//0�ƴϸ� "x���� ����Ÿ�� �����߽��ϴ�"
		if(n==0)
			System.out.println(name+"���� ��ܿ� �����ϴ�");
		else
			System.out.println(n+"���� ����Ÿ�� �����߽��ϴ�");
	}
	//�˻� �޼���
	public void dataSearch()
	{
		System.out.println("** ����Ÿ�� �˻��մϴ� **");
		String blood;		
		//������ �Է�
		System.out.println("�˻��� ������ �Է�");
		blood=sc.nextLine();
		
		//dao �� �޼��� ȣ��(��ȯŸ���� List)
		List<PersonDto> list=dao.getBloodSearch(blood);
		
		//list �� �ݺ����� �̿��ؼ� ���
		//��������  ** B�� ��� ** 
		//�̸�,�ڹ�,������,Ű,�������(�̸��� �������� ���)
		System.out.println("\t\t**"+blood.toUpperCase()+" �� ���**");
		System.out.println();
		System.out.println("�̸�\t�ڹ�\t������\tŰ\t�������");
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
			case 1://�߰�
				ex.dataAdd();
				break;
			case 2://����
				ex.dataDelete();
				break;
			case 3://����
				ex.dataUpdate();
				break;
			case 4://�˻�
				ex.dataSearch();
				break;
			case 5://��ü���
				ex.writeAll();
				break;
			default:
				System.out.println("** �ý����� �����մϴ� **");
				System.exit(0);				
			}
			System.out.println();
		}
	}
	
	
}



















