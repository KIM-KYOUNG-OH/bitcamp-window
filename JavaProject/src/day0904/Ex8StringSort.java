package day0904;

public class Ex8StringSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String []name= {"한은정","강호동","소유진","남보라","강부자"};
		int []age= {29,34,22,19,55};
		int []score= {89,90,78,100,90};

		System.out.println("** 정렬전 출력 **");
		System.out.println("번호\t이름\t나이\t점수");
		for(int i=0;i<name.length;i++)
		{
			System.out.println(i+1+"\t"+name[i]+"\t"+age[i]+"\t"+score[i]);
		}
		System.out.println();
		//정렬
		//오름차순 정렬
		for(int i=0;i<name.length-1;i++)
		{
			for(int j=i+1;j<name.length;j++)
			{
				//오름차순일땐 음수,거꾸로 내림차순일땐 양수
				int diff=name[i].compareTo(name[j]);
				if(diff>0)
				{
					//이름바꾸기
					String temp=name[i];
					name[i]=name[j];
					name[j]=temp;
					
					//나이바꾸기
					int temp2=age[i];
					age[i]=age[j];
					age[j]=temp2;
					
					//점수바꾸기
					int temp3=score[i];
					score[i]=score[j];
					score[j]=temp3;
				}
			}
		}
		
		System.out.println("** 정렬후 출력 **");
		System.out.println("번호\t이름\t나이\t점수");
		for(int i=0;i<name.length;i++)
		{
			System.out.println(i+1+"\t"+name[i]+"\t"+age[i]+"\t"+score[i]);
		}
	}

}
