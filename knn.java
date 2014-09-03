import java.io.*;
import java.util.*;
class knn
{
	public static void main(String arg[])throws Exception
	{
		Scanner sc=new Scanner(System.in);
		int a[]={2000,500000,40000,500000,10000,1000,50000,5000,50000,5000000,60000};
		int cls[]={0,2,1,2,1,0,2,0,2,2,1};
		int diff[]=new int[11];
		System.out.println("Enter commission");
		int p=sc.nextInt();
		System.out.println("Enter name");
		String name=sc.next();
		System.out.println("Enter id");
		String id=sc.next();
		String comp=name+","+id+","+p;
		System.out.println(comp);
		
		for(int i=0;i<11;i++)
		{
			diff[i]=a[i]-p;
			if(diff[i]<0)
				diff[i]=diff[i]*(-1);	
		}
		for(int i=0;i<11;i++)
		{
			for(int j=0;j<10;j++)
			{
				if(diff[j]>diff[j+1])
				{
					int t=diff[j];
					diff[j]=diff[j+1];
					diff[j+1]=t;
					t=cls[j];
					cls[j]=cls[j+1];
					cls[j+1]=t;
				}
			}
		}
	
		
		int c0=0,c1=0,c2=0;
		for(int i=0;i<5;i++)
		{
			if(cls[i]==0)
				c0++;
			else if(cls[i]==1)
				c1++;
				else
					c2++;
		}
		if(c0>c1&&c0>c2)
			System.out.println("Low");
		else if(c1>c0&&c1>c2)
 			System.out.println("Medium");
 			else if(c2>c0&&c2>c1)
 				System.out.println("High");
 				else
 					System.out.println("Error");
	}
}