package day0903;

public class Ex5String {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String ��ü ����
		String s1=new String("apple");
		String s2="Apple";
		String msg="Have a Nice Day!!";
		String msg2="   Happy day   ";
		System.out.println("length="+msg.length());
		System.out.println("length="+msg2.length());
		System.out.println("length="+msg2.trim().length());//���� ���� ������ ����
		System.out.println(msg.charAt(7));//N,0���Ͱ��
		System.out.println(msg.indexOf('a'));//a �� ��ġ
		System.out.println(msg.indexOf('a',4));//4�������� �˻��� a �� ��ġ
		System.out.println(s1.toUpperCase());//��� �빮�ڷ� ��ȯ
		System.out.println(s1.toLowerCase());//��� �ҹ��ڷ� ��ȯ
		System.out.println(s1.concat("Orange"));//���� ���ڿ��� Orange �߰��ؼ� ��ȯ
		System.out.println(msg.endsWith("Day!!"));//�ش繮�ڿ��� ������ true
		System.out.println(msg.endsWith("Day!!!"));//false
		System.out.println(msg.startsWith("Have"));//�ش� ���ڿ��� �����ϸ� true
		System.out.println(msg.startsWith("Haha"));//false
		System.out.println(msg.replace("a", "*"));//��� a��*�� ����Ǽ� ��ȯ 
		System.out.println(msg.substring(7));//7�� �ε������� ������ ����
		System.out.println(msg.substring(7,10));//7~9������ ����
		
		//��
		System.out.println(s1==s2);//��ü������ == �� �ּ� �񱳸� �ǹ�
		System.out.println(s1.equals(s2));//���� ��-��ҹ��ڱ��� ���ƾ� true
		System.out.println(s1.equalsIgnoreCase(s2));//��ҹ��� ������� ��
		System.out.println(s1.equals("apple"));//true
		
		//������� 0
		//a�� b���� ũ�� �����
		System.out.println(s1.compareTo("apple"));//0
		System.out.println(s1.compareTo("Apple"));//32..apple(a�� 97)-Apple(A�� 65)
		System.out.println(s1.compareTo("Banana"));//31
		System.out.println(s1.compareTo("application"));//-4  (apple-application)-e(101)-i(105) �� ��
		System.out.println("Orange".compareTo("Purple"));//-1	
		
		//split - Ư�� ���ڷ� �и�(�迭����)
		String s="red,green,blue,yellow";
		//, �� �и�
		String []arr=s.split(",");
		for(String a:arr)
		{
			System.out.println(a);
		}
		
		//valueOf : � ����Ÿ�� ���ڿ��� ��ȯ�ؼ� ��ȯ
		String a1=String.valueOf('A');
		String a2=String.valueOf(1234);		
	}

}









