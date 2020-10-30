package day0910;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//Map 은 Key 와 Value 쌍으로 저장되는 컬렉션 타입
//이때 Key 의 타입은 Set 이므로 중복키값은 허용하지 않는다
public class Ex9Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map=new HashMap<String, String>();
		map.put("name", "이영자");
		map.put("age", "23세");
		map.put("blood", "AB형");
		map.put("addr", "서울");
		map.put("name","김태희");//같은 키값이 있을경우 덮어쓴다
		
		System.out.println("갯수:"+map.size());
		System.out.println("이름:"+map.get("name"));
		System.out.println("나이:"+map.get("age"));
		System.out.println("혈액형:"+map.get("blood"));
		System.out.println("주소:"+map.get("addr"));
		System.out.println("핸드폰:"+map.get("hp"));//해당 키값이 없을경우 null값 반환
		System.out.println();
		System.out.println("키값을 얻은후 해당 키값에 들어있는 값을 출력해보자");
		//키값은 타입이 Set
		Set<String> keys=map.keySet();
		for(String key:keys)
		{
			String value=map.get(key);
			System.out.println(key+":"+value);
		}

	}

}












