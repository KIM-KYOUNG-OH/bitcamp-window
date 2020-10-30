package day0910;

public class Ex5Exception {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("안녕하세요..3초후에 봐요");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("잘가세요");
	}

}
