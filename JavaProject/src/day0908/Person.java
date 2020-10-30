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
	
	//�⵵�� �ش��ϴ� �츦 ����ؼ� ��ȯ�ϱ�
	public String getddi()
	{
		String ddi="";
		//���� 1���� �߶��̴�
		String []arrddi= {"������","��","��","����","��","��","��","�䳢",
				"��","��","��","��"};
		ddi=arrddi[year%12];
		return ddi;
	}
	
	//ǥ�ظ����� (Ű-100)*.0.9
	//ǥ�� �����Ը� ����ؼ� ǥ�ظ�����-������
	//5���� ũ�� "���"
	//-5���� ������ "��"
	//�� �������� "����" ��ȯ
	public String getPungga()
	{
		String msg="";
		double st_weight=(height-100)*0.9;
		double diff=st_weight-weight;
		if(diff>=5.0)
			msg="���";
		else if(diff<-5.0)
			msg="��";
		else
			msg="����";
		return msg;
	}
}













