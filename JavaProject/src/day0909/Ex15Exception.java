package day0909;

public class Ex15Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []data= {3,2,5,6};
		for(int i=0;i<=data.length;i++)
		{
			try {
				System.out.println(data[i]);
				System.out.println("--------");
			}catch (ArrayIndexOutOfBoundsException e) {
				// TODO: handle exception
				//에러가 나는 라인번호를 추적하고싶으면
				e.printStackTrace();
				System.out.println("배열범위 오류:"+e.getMessage());
			}
		}
		System.out.println("** 종료 **");
	}

}
