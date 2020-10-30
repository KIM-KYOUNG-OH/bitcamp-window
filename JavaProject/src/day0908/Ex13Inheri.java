package day0908;

class SuperObj5
{
	private String name;
	SuperObj5()
	{
		name="noname";
	}
	
	SuperObj5(String name)
	{
		this.name=name;
	}
	
	public void write()
	{
		System.out.println("name="+name);
	}
}

class SubObj5 extends SuperObj5
{
	private int score;
	SubObj5()
	{
		score=90;
	}
	
	SubObj5(int score)
	{
		this.score=score;
	}
	
	SubObj5(String name,int score)
	{
		super(name);
		this.score=score;
	}
	
	@Override
	public void write() {
		// TODO Auto-generated method stub
		super.write();
		System.out.println("score="+score);
	}
}

public class Ex13Inheri {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SubObj5 s1=new SubObj5();
		SubObj5 s2=new SubObj5(25);
		SubObj5 s3=new SubObj5("이영자",40);
		
		s1.write();//noname 90
		s2.write();//noname 25
		s3.write();//이영자 40
	}

}






