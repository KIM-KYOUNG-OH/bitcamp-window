package day0910;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//Map �� Key �� Value ������ ����Ǵ� �÷��� Ÿ��
//�̶� Key �� Ÿ���� Set �̹Ƿ� �ߺ�Ű���� ������� �ʴ´�
public class Ex9Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map=new HashMap<String, String>();
		map.put("name", "�̿���");
		map.put("age", "23��");
		map.put("blood", "AB��");
		map.put("addr", "����");
		map.put("name","������");//���� Ű���� ������� �����
		
		System.out.println("����:"+map.size());
		System.out.println("�̸�:"+map.get("name"));
		System.out.println("����:"+map.get("age"));
		System.out.println("������:"+map.get("blood"));
		System.out.println("�ּ�:"+map.get("addr"));
		System.out.println("�ڵ���:"+map.get("hp"));//�ش� Ű���� ������� null�� ��ȯ
		System.out.println();
		System.out.println("Ű���� ������ �ش� Ű���� ����ִ� ���� ����غ���");
		//Ű���� Ÿ���� Set
		Set<String> keys=map.keySet();
		for(String key:keys)
		{
			String value=map.get(key);
			System.out.println(key+":"+value);
		}

	}

}












