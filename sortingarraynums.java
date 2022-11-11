package BH;

public class sortingarraynums {

	public static void main(String[] args) {
		int a[]= new int[] {-6,-1,-8,0,1,2,7,9};
		for(int i=0; i<a.length; i++)
		{
			for(int j=i+1; j<a.length;j++)
			{
				int temp = 0;
				if(a[i]>a[j])
				{
					temp= a[i];
					a[i]=a[j];
					a[j]= temp;
					
				}
			}
			System.out.println(a[i]);
		}

	}

}
