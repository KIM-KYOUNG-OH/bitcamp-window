package day0907;

public class Sawon {
//멤버변수  이름(name),나이(age),혈액형(blood),급여(pay),수당(sudang)
	private String name;
	private int age;
	private String blood;
	private int pay;
	private int sudang;
	
	public Sawon()
	{
		name="noname";
		age=10;
		blood="B";
		pay=200;
		sudang=0;
	}
	
	public Sawon(String name,int age,String blood)
	{
		this.name=name;
		this.age=age;
		this.blood=blood;
		pay=200;
		sudang=3;
	}
	
	public Sawon(String name,int age,String blood,int pay,int sudang)
	{
		this.name=name;
		this.age=age;
		this.blood=blood;
		this.pay=pay;
		this.sudang=sudang;
	}
	
	//setter method
	public void setName(String name)
	{
		this.name=name;
	}	
	public void setAge(int age)
	{
		this.age=age;
	}
	public void setBlood(String blood)
	{
		this.blood=blood;
	}
	public void setPay(int pay)
	{
		this.pay=pay;
	}
	public void setSudang(int sudang)
	{
		this.sudang=sudang;
	}
	//getter method
	public String getName()
	{
		return name;
	}
	public int getAge()
	{
		return age;
	}
	public String getBlood()
	{
		return blood;
	}
	public int getPay()
	{
		return pay;
	}
	public int getSudang()
	{
		return sudang;
	}
	public int getTotal()
	{
		return pay+sudang;
	}
}



























