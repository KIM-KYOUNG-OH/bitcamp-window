package day0907;

//상품명, 수량,단가 멤버 변수
public class Shop {
	private String sang;
	private int su;
	private int dan;
	
	//setter method
	public void setSang(String sang)
	{
		this.sang=sang;
	}
	
	public void setSu(int su)
	{
		this.su=su;
	}
	
	public void setDan(int dan)
	{
		this.dan=dan;
	}
	
	//getter method
	public String getSang()
	{
		return sang;
	}
	
	public int getSu()
	{
		return su;
	}
	
	public int getDan()
	{
		return dan;
	}
	
	//수량*단가
	public int getTotal()
	{
		return su*dan;
	}
}























