package day0907;

public class Ex5Object {
	//private ���������ڴ� �ٸ� ��Ű���� Ŭ������ �ƴ϶�
	//���� ��Ű���� �ٸ� Ŭ���������� ������ �ȵ�
	//�ڱ� �ڽ��� ���� �޼��常 ������ ����
    private String name;
    
    //�޼��带 ���ؼ� ����
    //setter �޼���-�������
    public void setName(String name)
    {
    	this.name=name;
    }
    
    //getter �޼���-��������� ���� ��ȯ
    public String getName()
    {
    	return name;//�̶��� this.name �̶�� ��������� this��������
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex5Object ex=new Ex5Object();
		//�� ����
		ex.setName("����Ŭ");
		//�����
		System.out.println("�� �̸��� "+ex.getName()+"�Դϴ�");
		
		Ex5Object ex2=new Ex5Object();
		ex2.setName("ĳ����");
		System.out.println("Name:"+ex2.getName());
	}

}







