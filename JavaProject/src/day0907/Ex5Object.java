package day0907;

public class Ex5Object {
	//private 접근지정자는 다른 패키지의 클래스뿐 아니라
	//같은 패키지의 다른 클래스에서도 접근이 안됨
	//자기 자신이 가진 메서드만 접근이 가능
    private String name;
    
    //메서드를 통해서 접근
    //setter 메서드-변경목적
    public void setName(String name)
    {
    	this.name=name;
    }
    
    //getter 메서드-멤버변수의 값을 반환
    public String getName()
    {
    	return name;//이때는 this.name 이라고 써야하지만 this생략가능
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex5Object ex=new Ex5Object();
		//값 변경
		ex.setName("마이클");
		//값출력
		System.out.println("내 이름은 "+ex.getName()+"입니다");
		
		Ex5Object ex2=new Ex5Object();
		ex2.setName("캐서린");
		System.out.println("Name:"+ex2.getName());
	}

}







