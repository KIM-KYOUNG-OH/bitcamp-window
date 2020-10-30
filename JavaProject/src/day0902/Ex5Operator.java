package day0902;

public class Ex5Operator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//관계 연산자
		int kor=98,eng=80,mat=90;
		System.out.println(kor>eng);//true
		System.out.println(kor==mat);//false
		System.out.println(kor>eng || eng==mat);//true,단회로성질,앞에 조건이 true면 뒷 조건은 실행자체를 안한다
		System.out.println(eng==mat && eng<mat);//false
		System.out.println(!(eng==mat));//true
		System.out.println(eng!=mat);//true
	}

}
