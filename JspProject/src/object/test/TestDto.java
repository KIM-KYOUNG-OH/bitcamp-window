package object.test;

public class TestDto {
	private String carName;
	private String carColor;
	private int carPrice;
	
	public TestDto() {}

	public TestDto(String carName, String carColor, int carPrice) {
		super();
		this.carName = carName;
		this.carColor = carColor;
		this.carPrice = carPrice;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public String getCarColor() {
		return carColor;
	}

	public void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	public int getCarPrice() {
		return carPrice;
	}

	public void setCarPrice(int carPrice) {
		this.carPrice = carPrice;
	}
	
	
}
