
import java.math.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.io.*;
import java.util.*;
class kmeans
{
	public static void main(String arg[])
	{
		int num[]=new int[100];
		int clus[][]=new int [10][100];
		int k,n,n1;
		Scanner sc=new Scanner(System.in);

	int p=0;
		String l=null;
		int index=0;
	try
	{
		BufferedReader br=new BufferedReader(new FileReader("staff.txt"));
	 l=br.readLine();
		String s[]=l.split(",");
		for(int i=0;i<s.length;i++)
		{
			if(s[i].equals("salary"))
				p=i;
		}
		for(l=br.readLine();l!=null;l=br.readLine())
		{
				 s=l.split(",");
		for(int i=0;i<s.length;i++)
		{
			if(i==p)
				num[index++]=Integer.parseInt(s[i]);
				
		}
		
		}
/*	  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con1=DriverManager.getConnection("Jdbc:Odbc:dwm1");
  
            Statement stmt1=con1.createStatement();

            String st="select salary from staff";
            ResultSet rs=stmt1.executeQuery(st);
            if(rs.next())
              {  n=rs.getInt(1);
              num[index++]=n;
              }	*/
           		}
		catch(Exception e){}
	 n=index;


     for(int i=0;i<n;i++)
     	System.out.print(num[i]+"       ");
     	System.out.println();
		System.out.println("Enter the number of clusters to be made");
		k=sc.nextInt();
		
		float means[]=new float[10];
		for(int i=1;i<=k;i++)
		means[i-1]=i*10000;

		for(int i=0;i<k;i++)
		clus[i][0]=0;
		
		int pos;
		for(int i=0;i<n;i++)
		{
			pos=0;
			for(int j=0;j<k;j++)
			{
				if(Math.abs(means[j]-num[i])<Math.abs(means[pos]-num[i]))
				pos=j;
			}
			clus[pos][clus[pos][0]+1]=num[i];
			clus[pos][0]+=1;
				
		}

		float prevm[]=new float[10];
		int numi=0;
		System.out.println("Iteration:"+numi);

			for(int i=0;i<k;i++)
		{
			System.out.print(means[i]+": ");
			for(int j=1;j<=clus[i][0];j++)
			System.out.print(clus[i][j]+" ");
			System.out.println();
		}
		while(true&&numi<90)
		{
			for(int i=0;i<k;i++)
			prevm[i]=means[i];

			numi++;
			float tot=0;
			for(int i=0;i<k;i++)
			{
				tot=0;
				for(int j=1;j<=clus[i][0];j++)
				{
					tot+=clus[i][j];
				}
				if(clus[i][0]!=0)
				{tot/=clus[i][0];
				
				means[i]=tot;}
				
			}
			
			for(int i=0;i<k;i++)
				clus[i][0]=0;			
	
			for(int i=0;i<n;i++)
			{
				pos=0;
				for(int j=0;j<k;j++)
				{
					if(Math.abs(means[j]-num[i])<Math.abs(means[pos]-num[i]))
					pos=j;
				}
				clus[pos][clus[pos][0]+1]=num[i];
				clus[pos][0]+=1;
				//System.out.println(pos);	
			}
			
			System.out.println("Iteration:"+numi);

			for(int i=0;i<k;i++)
		{
			System.out.print(means[i]+": ");
			for(int j=1;j<=clus[i][0];j++)
			System.out.print(clus[i][j]+" ");
			System.out.println();
		}


			boolean flag=true;
			for(int i=0;i<k;i++)
			if(prevm[i]!=means[i])
			{flag=false;break;}
			if(flag)
			break;	
			
		}
		System.out.println("Final Clusters are:");

		for(int i=0;i<k;i++)
		{
			for(int j=1;j<=clus[i][0];j++)
			System.out.print(clus[i][j]+" ");
			System.out.println();
		}
		
	}
}



         
        
