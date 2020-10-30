package day0907;

public class Ex6Object {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1개의 상품만 등록후 출력하기");
		Shop shop1=new Shop();
		shop1.setSang("사과");
		shop1.setSu(3);
		shop1.setDan(1200);
		
		System.out.println("상품:"+shop1.getSang());
		System.out.println("수량:"+shop1.getSu());
		System.out.println("단가:"+shop1.getDan());
		System.out.println("총금액:"+shop1.getTotal());
		
		System.out.println("여러개의 상품을 배열에 저장하기");
		Shop []shopData=new Shop[2];//객체 배열-메모리 할당
		//3개의 배열에 생성후 값 저장
		shopData[0]=new Shop();//생성
		shopData[1]=new Shop();
		
		shopData[0].setSang("오렌지");
		shopData[0].setSu(5);
		shopData[0].setDan(3000);
		
		shopData[1].setSang("수박");
		shopData[1].setSu(2);
		shopData[1].setDan(15000);
		
		//출력
		for(int i=0;i<shopData.length;i++)
		{
			Shop s=shopData[i];
			System.out.println(s.getSang()+"\t"+s.getSu()+"\t"+s.getDan()+"\t"+s.getTotal());
		}
		System.out.println();
		for(Shop s:shopData)
		{
			System.out.println(s.getSang()+"\t"+s.getSu()+"\t"+s.getDan()+"\t"+s.getTotal());
		}
	}

}









