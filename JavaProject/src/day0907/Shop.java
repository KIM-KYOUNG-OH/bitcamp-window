package day0907;

//��ǰ��, ����,�ܰ� ��� ����
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
	
	//����*�ܰ�
	public int getTotal()
	{
		return su*dan;
	}
}























