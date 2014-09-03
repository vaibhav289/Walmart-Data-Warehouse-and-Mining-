import java.io.*;
import java.util.*;
import java.math.*;

class kmeans
{
	static int[][] flush(int temp[][],int n,int k)
	{
		for(int q=1;q<=k;q++)
		{
			for(int p=1;p<=n;p++)
			{
				temp[q][p]=0;
			}
		}
		return temp;
	}
	
	static boolean compare(int temp[][],int twod[][],int n,int k)
	{
		for(int q=1;q<=k;q++)
		
			for(int p=1;p<=n;p++)
			{
				if(twod[q][p]!=temp[q][p])
				return false;
			}
			return true;
		
	}
	
	static int comparemain(int main[],double mean[],int count)
	{
		double need[]=new double[mean.length];
		double min;
		int w;
		
		for(int q=1;q<=(mean.length-1);q++)
		{
			need[q]=Math.abs((double)main[count]-mean[q]);
		}
		
		min=need[1];
		
		for(int q=1;q<=(mean.length-1);q++)
		{
			if(min>need[q])
			min=need[q];
		}
		
		for(w=1;w<=(mean.length-1);w++)
		{
			if(need[w]==min)
			break;
		}
		return w;
	}
	
	static int[][] fill(int temp[][],double mean[],int n,int main[])
	{
		int count=1;
		int countee;
		int helper;
		int pointer[]=new int[mean.length];
		
		for(int q=1;q<=(pointer.length-1);q++)
		{
			pointer[q]=1;
		}
		
		for(int p=1;p<=(main.length-1);p++)
		{
			if(count<=n)
			{
				countee=comparemain(main,mean,count);
				helper=pointer[countee];
				temp[countee][helper]=main[count];
				pointer[countee]++;
				count++;
			}
			
		}
		return temp;
		
	}
	
	static double givemean(int twod[][],int row,int n)
	{
		double m;
		int c=0,sum=0;
		for(int j=1;j<=n;j++)
		if(twod[row][j]!=0)
		{
			sum+=twod[row][j];
			c++;
		}
		m=(double)sum/(double)c;
		return m;
	}
	
	public static void main(String arg[])throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n,i,j,k,c,j1;
		j=0;
		
		System.out.println("Enter the number of elements");
		n=Integer.parseInt(br.readLine());
		int main[]=new int[n+1];
		System.out.println("Enter the elements:");
		
		for(i=1;i<=n;i++)
		{
			main[i]=Integer.parseInt(br.readLine());
		}
		
		System.out.println("Enter the number of clusters:");
		k=Integer.parseInt(br.readLine());
		
		int twod[][]=new int[k+1][n+1];
		int temp[][]=new int [k+1][n+1];
		double mean[]=new double[k+1];
		c=1;
		
		for(i=1;i<=k;i++)
			for(j=1;j<=(n/k);j++)
			{
				twod[i][j]=main[c];
				c++;
			}
			
		for(i=c;i<=n;i++)
		{
			twod[k][j]=main[i];
			j++;
		}
		
		for(i=1;i<=k;i++)
		{
			mean[i]=givemean(twod,i,n);
		}
		
		for(int z=1;;z++)
		{
			temp=fill(temp,mean,n,main);
			System.out.println();
			
			for(i=1;i<=k;i++)
			{
				System.out.println("Cluster "+i+" : ");
				for(j=1;j<=n;j++)
				{
					if(twod[i][j]!=0)
					System.out.println(" "+twod[i][j]);
				}
				System.out.println();
			}
			
			for(int q=1;q<=(mean.length-1);q++)
			System.out.println("Mean for cluster "+q+":"+mean[q]);
			if(compare(temp,twod,n,k))
			{
				System.out.println();
				System.out.println("Same as previous.So the final answer is below:");
				break;
			}
			else
			{
			twod=flush(twod,n,k);
			twod=temp;
			
			for(i=1;i<=k;i++)
				mean[i]=givemean(twod,i,n);
				
				temp=flush(temp,n,k);
			}
		}
		
		for(i=1;i<=k;i++)
		{
			System.out.println("Cluster "+i+":");
			for(j=1;j<=n;j++)
			{
				if(twod[i][j]!=0)
				System.out.println(" "+twod[i][j]);
			}
			System.out.println();
		}
		
		for(int q=1;q<=(mean.length-1);q++)
			System.out.println("Mean for Cluster "+q+": "+mean[q]);
	}

}

/* OUTPUT::

C:\Users\sagar\Desktop>java kmeans
Enter the number of elements
10
Enter the elements:
10
4
2
12
3
20
30
11
25
31
Enter the number of clusters:
2

Cluster 1 :
 10
 4
 2
 12
 3

Cluster 2 :
 20
 30
 11
 25
 31

Mean for cluster 1:6.2
Mean for cluster 2:23.4

Cluster 1 :
 10
 4
 2
 12
 3
 11

Cluster 2 :
 20
 30
 25
 31

Mean for cluster 1:7.0
Mean for cluster 2:26.5

Same as previous.So the final answer is below:
Cluster 1:
 10
 4
 2
 12
 3
 11

Cluster 2:
 20
 30
 25
 31

Mean for Cluster 1: 7.0
Mean for Cluster 2: 26.5


*/