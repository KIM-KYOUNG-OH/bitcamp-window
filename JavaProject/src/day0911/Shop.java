package day0911;

public class Shop {
	private String sang;
	private String color;
	private int cnt;
	private int price;
	
	public Shop() {
		// TODO Auto-generated constructor stub
	}

	public Shop(String sang, String color, int cnt, int price) {
		super();
		this.sang = sang;
		this.color = color;
		this.cnt = cnt;
		this.price = price;
	}

	public String getSang() {
		return sang;
	}

	public void setSang(String sang) {
		this.sang = sang;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}	
	
}
