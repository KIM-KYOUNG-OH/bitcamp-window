package day0904;

public class Ex6Jungbok {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//10개짜리 배열에 1~30 사이의 난수를 구해서 넣는데 
		//중복된 숫자는 다시 구해서 중복처리 하기
		int []num=new int[10];
		Loop:
		for(int i=0;i<num.length;i++)
		{
			num[i]=(int)(Math.random()*30)+1;
			for(int j=0;j<i;j++)//현재 발생한 번지 이전에서 같은 숫자가 있는지 찾는다
			{
				if(num[i]==num[j])
				{
					i--;
					//break;//현재 반복문을 빠져나온다
					continue Loop;//-i++ 로 이동
				}
			}
		}
		//오름차순으로 정렬-selection sort -다중for문
		for(int i=0;i<num.length-1;i++)
		{
			for(int j=i+1;j<num.length;j++)
			{
				if(num[i]>num[j])//오름차순이므로 기준값이 더 클경우 바꾼다
				{
					int temp=num[i];
					num[i]=num[j];
					num[j]=temp;
				}
			}
		}
		
		
		//출력
		for(int n:num)
			System.out.print(n+" ");
		System.out.println();
	}

}
