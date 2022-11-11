package BH;

public class rev_each_elem_ofarray {

	public static void main(String[] args) {
		int a[]= new int[] {0,17,27,78,97};
		for(int i=0; i<a.length; i++)
		{
			int sum =0, rem=0;
			while(a[i]>0)
			{
				rem=a[i]%10;
				a[i]=a[i]/10;
				sum = (sum*10)+rem;
			}
		a[i]=sum;
		
		}
		for(int i=0; i<a.length; i++)
		{
		System.out.println(a[i]);}
	}

}
