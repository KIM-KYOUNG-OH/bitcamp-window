package day0908;

public class Person {
	private String name;
	private int year;
	private double height;
	private double weight;
	
	public Person()
	{
		this("noname",2020,170,55.3);
	}

	public Person(String name, int year, double height, double weight) {
		super();
		this.name = name;
		this.year = year;
		this.height = height;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", year=" + year + ", height=" + height + ", weight=" + weight + "]";
	}
	
	//년도에 해당하는 띠를 계산해서 반환하기
	public String getddi()
	{
		String ddi="";
		//서기 1년이 닭띠이다
		String []arrddi= {"원숭이","닭","개","돼지","쥐","소","범","토끼",
				"용","뱀","말","양"};
		ddi=arrddi[year%12];
		return ddi;
	}
	
	//표준몸무게 (키-100)*.0.9
	//표준 몸무게를 계산해서 표준몸무게-몸무게
	//5보다 크면 "허약"
	//-5보다 작으면 "비만"
	//그 나머지는 "정상" 반환
	public String getPungga()
	{
		String msg="";
		double st_weight=(height-100)*0.9;
		double diff=st_weight-weight;
		if(diff>=5.0)
			msg="허약";
		else if(diff<-5.0)
			msg="비만";
		else
			msg="정상";
		return msg;
	}
}













