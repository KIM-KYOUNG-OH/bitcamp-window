package day0908;

class SuperObj4
{
	private String title;
	
	SuperObj4(String title)
	{
		System.out.println("부모 생성자 호출");
		this.title=title;
	}
	
	public void write()
	{
		System.out.println("title:"+title);
	}
}

class SubObj4 extends SuperObj4
{
	private String msg;
	SubObj4(String msg,String title)
	{
		super(title);
		System.out.println("자식 생성자 호출");
		this.msg=msg;
	}
	
	@Override
	public void write() {
		// TODO Auto-generated method stub
		System.out.println("msg:"+msg);
		super.write();
	}
}
//////////////////////////////////////////
public class Ex12Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubObj4 sub=new SubObj4("안녕", "공부");
		sub.write();
	}

}







