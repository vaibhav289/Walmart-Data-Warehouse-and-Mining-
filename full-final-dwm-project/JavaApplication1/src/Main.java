
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ListSelectionListener;
import java.sql.*;
import javax.swing.event.ListSelectionEvent;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.table.JTableHeader;
import java.io.*;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.*;
import java.text.SimpleDateFormat;
import java.math.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author student
 */
public class Main extends JFrame implements ActionListener, ListSelectionListener {

    static int columnTable = 12, rowTable = 0,row2=0,check=0;
    JList l,l1,l2,l3;
    JPanel jpmain, gridtable, right, left, mm,lp = new JPanel(new GridLayout(1,3));
    static JTextArea t1;
    JButton b1, b2, b3, b4, b5,b6;
    static java.sql.Statement st,st1;
    static Connection con,con1;
    JDialog jd;
    static JTable table;
    static JTextArea ta = new JTextArea(50, 5);
    static JTextArea t11 = new JTextArea(15, 5);
    JFileChooser f = new JFileChooser();
    static String tablename="",tab1="",tab3="";
    static Boolean bn=false;

    public void valueChanged(ListSelectionEvent listSelectionEvent) {
    }
    
    public static void deDuplicateEntries() {
       
                    try
                   {
                        BufferedReader br5=new BufferedReader(new FileReader("products.txt"));
                        String l=br5.readLine();
                       String temp[]=new String[30];
                       int index=0;
                        for(l=br5.readLine();l!=null;l=br5.readLine())
                        {
                          temp[index++]=l;
                        }

                       for(int i=0;i<index-1;i++)
                       {
                       for(int j=i+1;j<index;j++)
                       {
                           if((temp[i].equals(temp[j])))
                           {
                               String t[]=temp[j].split(",");
                               for(int k=0;k<t.length;k++)
                              table.setValueAt("",j+1,k);

                           }
                           }
                       }


                   /* BufferedReader br5=new BufferedReader(new FileReader("products.txt"));
                    BufferedReader br6=new BufferedReader(new FileReader("products.txt"));
                    String v=br5.readLine();
                    String u=br6.readLine();
                   u=br6.readLine();
                   
                   for(int i=1;i<200;i++)
                   {
                       
                     
                       v=br5.readLine();
                       String a[]=v.split(",");
                       System.out.println(a[0]);
                       System.out.println(a[1]);
                       System.out.println(a[2]);
                       System.out.println();
                       
                      br6=new BufferedReader(new FileReader("products.txt"));

                       
                       for(int j=i+1;j<199;j++)
                       {
                           u=br6.readLine();
                            String b[]=u.split(",");
                          //  System.out.println(b[0]);
                     //  System.out.println(b[1]);
                      // System.out.println(b[2]);
                        //System.out.println();
                        
                           if(a[0].toString().equals(b[0].toString()))
                           {
                              
                                
                               if(a[1].toString().equals(b[1].toString()))
                               {
                                
                                   
                                   if(a[2].toString().equals(b[2].toString()))
                                   {
                                       
                                       
                                       if(a[3].toString().equals(b[3].toString()))
                                       {
                                          
                                           if(a[4].toString().equals(b[4].toString()))
                                           {
                                               
                                               System.out.println("dup");
                                               table.setValueAt("",j,0);
                                               table.setValueAt("",j,1);
                                               table.setValueAt("",j,2);
                                               table.setValueAt("",j,3);
                                               table.setValueAt("",j,4);
                                           
                                           }
                                           else
                                           {
                                               
                                               continue;
                                           }
                                       }
                                       else
                                       {
                                          
                                           continue;
                                       }
                                   }
                                   else
                                   {
                                      
                                       continue;
                                   }
                               }
                               else
                               {
                                   
                                   continue;
                               }
                           }
                           else
                           {
                              
                               continue;
                           }
                       }
                    
                   }
                   
         */
                   }
          catch(Exception e){}
     }
    
     public static void loadfile(){
         
          for (int i = 0; i < 30; i++)
          {
            //System.out.println(i);
            
         
               try
               {
                   
                   if(tab3.equals("products"))
                   {
                   Object a=table.getValueAt(i, 0);
                   Object b=table.getValueAt(i, 1);
                   Object c=table.getValueAt(i, 2);
                   Object d=table.getValueAt(i, 3);
                   Object e=table.getValueAt(i, 4);
                 
                  
                   System.out.println(a);
                   System.out.println(b);
                   System.out.println(c);
                   System.out.println(d);
                   System.out.println(e);
                   
                String abcd="insert into product(ID,prodname,price,catname,locid) values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"');";
                int ihkh=st1.executeUpdate(abcd);
                
                String r = "loaded successfully";
                    ta.setText(r);
                   }
                   
                   if(tab3.equals("Categories"))
                   {
                   Object a=table.getValueAt(i, 0);
                   Object b=table.getValueAt(i, 1);
                   Object c=table.getValueAt(i, 2);
                  
                 
                  
                   System.out.println(a);
                   System.out.println(b);
                   System.out.println(c);
                 
                   
                String abcd="insert into categories(ID,catname,wing) values('"+a+"','"+b+"','"+c+"');";
                int ihkh=st1.executeUpdate(abcd);
                
                String r = "loaded successfully";
                    ta.setText(r);
                   }
                   
                   
                    if(tab3.equals("location"))
                   {
                   Object a=table.getValueAt(i, 0);
                   Object b=table.getValueAt(i, 1);
                   Object c=table.getValueAt(i, 2);
                  Object d=table.getValueAt(i, 3);
                 
                  
                   System.out.println(a);
                   System.out.println(b);
                   System.out.println(c);
                   System.out.println(d);
                   
                String abcd="insert into location(ID,street,sales,locname) values('"+a+"','"+b+"','"+c+"','"+d+"');";
                int ihkh=st1.executeUpdate(abcd);
                
                String r = "loaded successfully";
                    ta.setText(r);
                   }
                    
                    if(tab3.equals("importloc"))
                   {
                   Object a=table.getValueAt(i, 0);
                   Object b=table.getValueAt(i, 1);
                   Object c=table.getValueAt(i, 2);
                 
                 
                  
                   System.out.println(a);
                   System.out.println(b);
                   System.out.println(c);
               
                   
                String abcd="insert into importloc(ID,locid,locname) values('"+a+"','"+b+"','"+c+"');";
                int ihkh=st1.executeUpdate(abcd);
                
                String r = "loaded successfully";
                    ta.setText(r);
                   }
                   
                    
                    
                     if(tab3.equals("staff"))
                   {
                   Object a=table.getValueAt(i, 0);
                   Object b=table.getValueAt(i, 1);
                   Object c=table.getValueAt(i, 2);
                   Object d=table.getValueAt(i, 3);
                   Object e=table.getValueAt(i, 4);
                    Object f=table.getValueAt(i, 5);
                     Object g=table.getValueAt(i, 6);
                      Object h=table.getValueAt(i, 7);
                      Object j=table.getValueAt(i, 8);
                  
                   System.out.println(a);
                   System.out.println(b);
                   System.out.println(c);
                   System.out.println(d);
                   System.out.println(e);
                   
                String abcd="insert into staff(ID,empid,manid,salary,sname,work_exp,dob,gender,Age) values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+j+"');";
                int ihkh=st1.executeUpdate(abcd);
                
                String r = "loaded successfully";
                    ta.setText(r);
                   }
                     
                     if(tab3.equals("manager"))
                   {
                   Object a=table.getValueAt(i, 0);
                   Object b=table.getValueAt(i, 1);
                   Object c=table.getValueAt(i, 2);
                   Object d=table.getValueAt(i, 3);
                   Object e=table.getValueAt(i, 4);
                    Object f=table.getValueAt(i, 5);
                     Object g=table.getValueAt(i, 6);
                      Object h=table.getValueAt(i, 7);
                       Object j=table.getValueAt(i, 8);
                 
                  
                   System.out.println(a);
                   System.out.println(b);
                   System.out.println(c);
                   System.out.println(d);
                   System.out.println(e);
                   
                String abcd="insert into manager(ID,sellocid,msalary,name,manid,implocid,mdob,mgender,Age) values('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"','"+g+"','"+h+"','"+j+"');";
                int ihkh=st1.executeUpdate(abcd);
                
                String r = "loaded successfully";
                    ta.setText(r);
                   }
                     
               }
               catch(Exception e){
              // System.out.println(e);
               }
                
            
         }
     }
     public static void knn(int p,JTextArea t12)
     {
     
         
      
         try
         {
         int a[]=new int[25];
         int cls[]=new int[25];
         int diff[]=new int[11];
         if(tablename=="manager" || tablename=="staff")
       {
        String s;
                for(int i=0;i<rowTable;i++)
                {
                  for(int j=0;j<columnTable;j++)
                  {
                   s =table.getTableHeader().getColumnModel().getColumn(j).getHeaderValue().toString();
                 
                   if(s.toString().equals("salary") || s.toString().equals("msalary"))
                   {
                      
                       a[i]=Integer.parseInt(table.getValueAt(i, j).toString());
                   //  System.out.println(a[i]);
                       
                      
                       if(a[i]<=12000)
                           cls[i]=0;
                       else if(a[i]>12000&&a[i]<=20000)
                           cls[i]=1;
                       else if(a[i]>20000)
                           cls[i]=2;
                       
                     //  System.out.println(cls[i]);
                       
                   }
                   }
                }
              
               
             
       
		
		for(int i=0;i<rowTable;i++)
		{
                   
			 diff[i]=(int)a[i]-p;
                       
			if(diff[i]<0)
                        {
			diff[i]=diff[i]*(-1);
                        
                        }
                      //  System.out.println(diff[i]);
		}
		for(int i=0;i<rowTable;i++)
		{
			for(int j=0;j<(rowTable-1);j++)
			{
				if((int)diff[j]>(int)diff[j+1])
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
	//for(int i=0;i<diff.length;i++)
      //      System.out.println(diff[i]);
		
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
                {
                    System.out.println("Low Salary");
                    String m="                              Tuple is grouped as having Low Salary";
                           t12.append("\n");
                            ta.append("\n");
                        ta.append("\n");
                        ta.append("\n");
                        ta.append("\n");
                        ta.append("\n");
                        ta.append("\n");
                        ta.append("\n");
                        ta.append("\n");
                        ta.append("\n");
                        ta.append("\n");
                        ta.append("\n");
                        ta.append("\n");
                        ta.append("\n");
                        ta.append("\n");
                    t12.append(m);
                }
		else if(c1>c0&&c1>c2)
                {
 			System.out.println("Medium Salary");
                        String m="                              Tuple is grouped as having Medium Salary";
                        ta.append("\n");
                        ta.append("\n");
                        ta.append("\n");
                        ta.append("\n");
                        ta.append("\n");
                        ta.append("\n");
                        ta.append("\n");
                        ta.append("\n");
                        ta.append("\n");
                        ta.append("\n");
                        ta.append(m);
                }
 			else if(c2>c0&&c2>c1)
                        {
 				System.out.println("High Salary");
                                
                                String m="                             Tuple is grouped as having High Salary";
                                       ta.append("\n");
                        ta.append("\n");
                        ta.append("\n");
                        ta.append("\n");
                        ta.append("\n");
                        ta.append("\n");
                        ta.append("\n");
                        ta.append("\n");
                        ta.append("\n");
                        ta.append("\n");
                                ta.append(m);
                        }
 				else
 					System.out.println("Error"); 
       }}
         catch(Exception e)
         {
             System.out.println(e);
         }
                
         
        
     }
     public void kmeans()
     {
          
         int num[]=new int[100];
		int clus[][]=new int [10][10];
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
		
		k=3;
		
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
               String a1[]=new String[clus[0].length-1];
               String a2[]=new String[clus[1].length-1];
               String a3[]=new String[clus[2].length-1];
                for(int i=0;i<clus[0].length-1;i++)
                {
                    if(clus[0][i+1]!=0)
                    a1[i]=clus[0][i+1]+"";
                }
		for(int i=0;i<clus[0].length-1;i++)
                {
                    if(clus[1][i+1]!=0)
                    a2[i]=clus[1][i+1]+"";
                }
                for(int i=0;i<clus[0].length-1;i++)
                {
                    if(clus[2][i+1]!=0)
                    a3[i]=clus[2][i+1]+"";
                }
                
                l1=new JList(a1);
                l2=new JList(a2);
                l3=new JList(a3);
         JScrollPane scrollPane1 = new JScrollPane(l1);
         JScrollPane scrollPane2 = new JScrollPane(l2);
         JScrollPane scrollPane3 = new JScrollPane(l3);
         
         
         
        lp.add(scrollPane1);
        lp.add(scrollPane2);
        lp.add(scrollPane3);
        left.remove(ta);
        left.add(lp);
        mm.add(left);
        mm.add(right);
        jpmain.add(mm);
        jpmain.add(gridtable);
         add(jpmain);
         check=1;
         
         setVisible(true);
         
     }
        
         
        
     
     
     
     
      public static void nullcheck() {
        //ta.setText("" + table.getRowCount());
        
        for (int i = 0; i < table.getRowCount(); i++) {
            //System.out.println(i);
            
            for (int j = 0; j < table.getColumnCount(); j++) {
              
                if (table.getValueAt(i, j) == null || table.getValueAt(i, j).toString().equals("-")||table.getValueAt(i, j).toString().equals(" ")) {
                  
                    //JFrame f= new JFrame();
                    String r = "The value at row " + (i + 1) + " and col " + (j + 1) + " is blank. Transforming it to null";
                  
                    table.setValueAt("null", i, j);
                  
                    ta.setText(ta.getText() + "\n" + r);
                    ta.setText(r);
                
                }
            }
        }
    }
      public static void defaultAttribute() {
           for (int i = 0; i < table.getRowCount(); i++) {
            //System.out.println(i);
            
            for (int j = 0; j < table.getColumnCount(); j++) {
                
                if (table.getValueAt(i, j).toString().equals("null") || table.getValueAt(i, j).toString().equals("-")||table.getValueAt(i, j).toString().equals(" ")) 
                {
              
                  if(table.getTableHeader().getColumnModel().getColumn(j).getHeaderValue().toString().equals("gender")||table.getTableHeader().getColumnModel().getColumn(j).getHeaderValue().toString().equals("mgender"))
                    {
                        String r = "The value at row " + (i + 1) + " and col " + (j + 1) + " is blank. Transforming it to male";
                  
                    table.setValueAt("m", i, j);
                    ta.setText(ta.getText() + "\n" + r);
                    }
                  else if(table.getValueAt(0, j).toString().equals("gender")||table.getValueAt(0, j).toString().equals("mgender"))
                  {
                      String r = "The value at row " + (i + 1) + " and col " + (j + 1) + " is blank. Transforming it to male";
                  
                    table.setValueAt("m", i, j);
                    ta.setText(ta.getText() + "\n" + r);
                  }
                    //JFrame f= new JFrame();
                  
                  if(table.getTableHeader().getColumnModel().getColumn(j).getHeaderValue().toString().equals("salary")||table.getTableHeader().getColumnModel().getColumn(j).getHeaderValue().toString().equals("msalary"))
                    {
                       
                        String r = "The value at row " + (i + 1) + " and col " + (j + 1) + " is blank. Transforming it to 11000";
                  
                    table.setValueAt("11000", i, j);
                    ta.setText(ta.getText() + "\n" + r);
                    }
                    else if(table.getValueAt(0, j).toString().equals("salary")||table.getValueAt(0, j).toString().equals("msalary"))
                  {
                      String r = "The value at row " + (i + 1) + " and col " + (j + 1) + " is blank. Transforming it to 11000";
                  
                    table.setValueAt("11000", i, j);
                    ta.setText(ta.getText() + "\n" + r);
                  }
                }
              
                
            }
           }
         
     }


    public static void contact()
    {
       // if(tablename=="manager" || tablename=="staff")
        //{
        if(tab1==null && bn!=true)//if access file
        {
            String s;
            int col=-1;       
                for(int i=0;i<columnTable;i++)
                {
                   s =table.getTableHeader().getColumnModel().getColumn(i).getHeaderValue().toString();
               
                   if(s.contains("dob") || s.contains("mdob"))
                   {
                       col=i;
                   }
                }

            if(col>-1)
            {
                for (int i = 0; i < table.getRowCount(); i++) {
                    s=table.getValueAt(i,col).toString();

                    s=s.substring(4,8)+"-"+s.substring(2,4)+"-"+s.substring(0,2);

                    table.setValueAt(s,i,col);
                }
               
                
                 
            }

        }
    //}

    //if text file
    else if(tab1!=null && bn!=true)
    {
        
        String b[]=new String[12];
        String x="",s1="";
          int j=-1;
                   try
                   {
                    BufferedReader br=new BufferedReader(new FileReader(tab3+".txt"));
                
                    x=br.readLine();
                    String a[]=x.split(",");
                  for(int i=0;i<a.length;i++)
                  {
                      if(a[i].equals("dob")||a[i].equals("mdob"))
                      {
                          j=i;
                      }
                  }
                    if(j>-1)
            {
                int i=0;
                for (x=br.readLine();x!=null;x=br.readLine())
                {
                    
                    b= x.split(",");
                    s1=b[j];
                    s1=s1.substring(4,8)+"-"+s1.substring(2,4)+"-"+s1.substring(0,2);

                    table.setValueAt(s1,i+1,j);
                    i++;
                }              
           }
         }
                   catch(Exception e) {}
    }
        else
        {
             String s;
            int col=-1;
                for(int i=0;i<columnTable;i++)
                {
                   s =table.getTableHeader().getColumnModel().getColumn(i).getHeaderValue().toString();

                   if(s.contains("dob") || s.contains("mdob"))
                   {
                       col=i;
                   }
                }

            if(col>-1)
            {
                for (int i = 0; i < table.getRowCount(); i++) {
                    s=table.getValueAt(i,col).toString();

                    s=s.substring(4,8)+"-"+s.substring(2,4)+"-"+s.substring(0,2);

                    table.setValueAt(s,i,col);
                }



            }




            String b[]=new String[12];
        String x="",s1="";
          int j=-1;
                   try
                   {
                    BufferedReader br=new BufferedReader(new FileReader(tab3+".txt"));

                    x=br.readLine();
                    String a[]=x.split(",");
                  for(int i=0;i<a.length;i++)
                  {
                      if(a[i].equals("dob")||a[i].equals("mdob"))
                      {
                          j=i;
                      }
                  }
                    if(j>-1)
            {
                int i=0;
                for (x=br.readLine();x!=null;x=br.readLine())
                {

                    b= x.split(",");
                    s1=b[j];
                    s1=s1.substring(4,8)+"-"+s1.substring(2,4)+"-"+s1.substring(0,2);

                    table.setValueAt(s1,i+1,j);
                    i++;
                }
           }
         }
                   catch(Exception e) {}
        }
   }

//--------------------------------------------------------------------------------------------------------

    public static void calage() {

        if(tab1==null && bn!=true)
        {System.out.println("wrong");
        if(tablename=="manager" || tablename=="staff")
   {
        String s;
         int col=-1;
                for(int i=0;i<columnTable;i++)
                {
                   s =table.getTableHeader().getColumnModel().getColumn(i).getHeaderValue().toString();
                   if(s.contains("dob") || s.contains("mdob"))
                   {System.out.println("here");
                       col=i;
                   }
                }

         int c=columnTable;
         int age=0;
         if(col!=-1)
         {
    String ag="Age";
                for (int i = 0; i < table.getRowCount(); i++) {
                    s=table.getValueAt(i,col).toString();
                    Calendar currentDate = Calendar.getInstance();
                    SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    String dateNow = formatter.format(currentDate.getTime());
                    //System.out.println("Now the date is :=>  " + dateNow);
                    int ay=Integer.parseInt(s.substring(0,4));
                    int by=Integer.parseInt(dateNow.substring(0,4));
                    age = by-ay;
                    table.getColumnModel().getColumn(c).setWidth(100);//these two lines i kept in for loop...thts y it runned
                    table.getTableHeader().getColumnModel().getColumn(c).setHeaderValue(ag);
                    table.setValueAt(age,i,c);

             }
         }
         if(bn==true)
         {

         }
     }
 //-------------------------------------------------------------------------------------------
        }
        else if(tab1!=null && bn!=true)
        {
          
        String b1[]=new String[12];
        String x1="",s2="";
          int j=-1;
                   try
                   {
                    BufferedReader br1=new BufferedReader(new FileReader(tab3+".txt"));
                   
                    x1=br1.readLine();
                    String a[]=x1.split(",");
                  for(int i=0;i<a.length;i++)
                  {
                      if(a[i].equals("dob")||a[i].equals("mdob"))
                      {
                          j=i;
                      }
                  }
                    
                    if(j!=-1)
         {
   int i=1;
                for (x1=br1.readLine();x1!=null;x1=br1.readLine()) {
                    b1=x1.split(",");
                    s2=b1[j];
                  s2=s2.substring(4,8)+"-"+s2.substring(2,4)+"-"+s2.substring(0,2);
                    Calendar currentDate = Calendar.getInstance();
                    SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    String dateNow = formatter.format(currentDate.getTime());
                    //System.out.println("Now the date is :=>  " + dateNow);
                    int ay=Integer.parseInt(s2.substring(0,4));
                    int by=Integer.parseInt(dateNow.substring(0,4));
                    int age = by-ay;
                    table.setValueAt("Age",0,(b1.length));
                    table.setValueAt(age,i,(b1.length));
                    i++;
             }
         }//end of if
        }
                   catch(Exception e){}
  }
        else
        {
System.out.println("enter");
        if(tablename=="manager" || tablename=="staff")
   {
        String s;
         int col=-1;
                for(int i=0;i<columnTable;i++)
                {System.out.println("1");
                   s =table.getTableHeader().getColumnModel().getColumn(i).getHeaderValue().toString();
                   System.out.println(s);
                   if(s.contains("dob") || s.contains("mdob"))
                   {
                       col=i;
                       System.out.println(col);
                   }
                }

         int c=columnTable;
         int age=0;
         if(col>-1)
         {
             System.out.println("2");
    String ag="Age";
                for (int i = 0; i < table.getRowCount(); i++) {
                    s=table.getValueAt(i,col).toString();
                    Calendar currentDate = Calendar.getInstance();
                    SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    String dateNow = formatter.format(currentDate.getTime());
                    //System.out.println("Now the date is :=>  " + dateNow);
                    int ay=Integer.parseInt(s.substring(0,4));
                    int by=Integer.parseInt(dateNow.substring(0,4));
                    age = by-ay;
                    table.getColumnModel().getColumn(c).setWidth(100);//these two lines i kept in for loop...thts y it runned
                    table.getTableHeader().getColumnModel().getColumn(c).setHeaderValue(ag);
                    table.setValueAt(age,i,c);

             }
         }
        }




        String b1[]=new String[12];
        String x1="",s2="";
          int j=-1;
                   try
                   {System.out.println("3");
                    BufferedReader br1=new BufferedReader(new FileReader(tab3+".txt"));
System.out.println(tab3);
                    x1=br1.readLine();
                    String a[]=x1.split(",");
                  for(int i=0;i<a.length;i++)
                  {
                      if(a[i].equals("dob")||a[i].equals("mdob"))
                      {
                          j=i;
                      }
                  }

                    if(j!=-1)
         {
   int i=1;
                for (x1=br1.readLine();x1!=null;x1=br1.readLine()) {
                    b1=x1.split(",");
                    s2=b1[j];
                  s2=s2.substring(4,8)+"-"+s2.substring(2,4)+"-"+s2.substring(0,2);
                    Calendar currentDate = Calendar.getInstance();
                    SimpleDateFormat formatter= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                    String dateNow = formatter.format(currentDate.getTime());
                    //System.out.println("Now the date is :=>  " + dateNow);
                    int ay=Integer.parseInt(s2.substring(0,4));
                    int by=Integer.parseInt(dateNow.substring(0,4));
                    int age = by-ay;
                    table.setValueAt("Age",0,(b1.length));
                    table.setValueAt(age,i,(b1.length));
                    i++;
             }
         }//end of if
        }
                   catch(Exception e){}

    }
    }
 public static void fillTable(String tab)
 {
     try {
         
                 tab1=null;
                 tab3=tab;
                table.selectAll();
                table.clearSelection();
                table.removeAll();
                for (int i = 0; i < table.getRowCount(); i++) {
                    for (int j = 0; j < table.getColumnCount(); j++) {
                        table.setValueAt("", i, j);
                    }
                }
                
                row2 = 0;
                //System.out.println(e.getSource());
                System.out.println(tab);
                tablename=tab;
                ResultSet rs = st.executeQuery("select * from " + tab);
             ResultSetMetaData rsmd = rs.getMetaData();
                //getColumns(tab);
                columnTable = rsmd.getColumnCount();

                while (rs.next()) {
                    int j = 0;
                    //t1.append(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7) + "\t\n");
                    for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                        //table.setv
                        table.setValueAt(rs.getString(i), row2, j);
                        table.getColumnModel().getColumn(j).setWidth(100);
                        j++;
                    }
                    row2++;

                }
                rowTable = row2;
                // ta.setText(rowTable+"");

                System.out.println("cc" + rsmd.getColumnCount());
//table.getTableHeader().getColumnModel().getColumn(0).setHeaderValue(rsmd.getColumnLabel(1));
//rsmd.getcol
                for (int i = 0; i < 12; i++) {
                    table.getTableHeader().getColumnModel().getColumn(i).setHeaderValue("");
                    //ta.setText(ta.getText() + rsmd.getColumnName(0));

                }
                for (int i = 0; i < rsmd.getColumnCount(); i++) {
                    table.getTableHeader().getColumnModel().getColumn(i).setHeaderValue(rsmd.getColumnLabel(i + 1));
                    //ta.setText(ta.getText() + rsmd.getColumnName(0));

                }
table.getTableHeader().getColumnModel().getColumn(10).setHeaderValue(rsmd.getColumnLabel(11));
            } catch (SQLException ex) {
                //Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }




 }

 public static void fillTxtTable(String tab,Boolean b)
 {
     bn=b;
     tab1=tab;
     tab3=tab;
    int j1 = 0,row1=0;
    String lx="";
    String s[]=new String[11];
   

              try
{

                  String file=tab+".txt";
                   
              
    BufferedReader br1=new BufferedReader(new FileReader(file));
                if(b==false)
                {
                    row1=0;
                     for (int i = 0; i < 100; i++) {
                    for (int j = 0; j < 12; j++) {
                        table.setValueAt("", i, j);
                    }
                }
                }
                else 
                {
                    row1=row2;
                    lx=br1.readLine();
                }


              for(lx=br1.readLine();lx!=null;lx=br1.readLine())
              {
                s= lx.split(",");
               
              j1=0;
                    //t1.append(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7) + "\t\n");
                    for (int i = 0; i <s.length; i++) {
                        //table.setv
                        
                        table.setValueAt(s[i], row1, j1);
                        table.getColumnModel().getColumn(j1).setWidth(100);
                        j1++;
                    }
                    row1++;
                    }
              if(b==false)
              {
                  for (int i = 0; i < 12; i++) {
                    table.getTableHeader().getColumnModel().getColumn(i).setHeaderValue("");
                    //ta.setText(ta.getText() + rsmd.getColumnName(0));

                }
            }
              

              }
 catch(Exception e){System.out.print(e);}

 }
    public void actionPerformed(ActionEvent e)
    {
        
        if (e.getSource() == b1) {

            extract ext = new extract();
            ext.setSize(500,403);
        }

        if (e.getSource() == b2) {
           tran t=new tran();
           t.setSize(500, 400);
        }
        if(e.getSource()== b4)
        {
            System.out.println("vai");
            loadfile();
        }
         if(e.getSource()== b5)
         {
            kmeans();
        }
         if(e.getSource()== b6)
         {
            knn2 k=new knn2();
            k.setSize(500,185);
             
        }
    }

     Main() {
        try {

            jpmain = new JPanel(new GridLayout(2,1 ));
            add(jpmain);
            mm = new JPanel(new GridLayout(1,2));

            
            gridtable = new JPanel(new GridLayout(1, 1));
            left = new JPanel(new GridLayout(1, 1));
            right = new JPanel(new GridLayout(5, 1));
            right.setSize(80, 1000);
           // right.setBackground(Color.red);
            //t1 = new JTextArea(100, 200);
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            createConnection();
            
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            createConnection1();
            //getColumns("branch");

            table = new JTable(100, 12);
            table.setAutoResizeMode(4);
            table.setAutoscrolls(true);
            // valueChanged1("branch");
            //getColumns("branch");

            //table = new JTable(getRows("branch"), columnTable);
            //  table.setAutoResizeMode(4);
            //  table.setAutoscrolls(true);

            JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            //scrollPane.setHorizontalScrollBar(1);
           
            gridtable.add(scrollPane);

            //left.add(f);
            //b5 = new JButton("Extract from txt file");
            //right.add(b5);
          
            b1 = new JButton("Extraction");
            right.add(b1);
            b2 = new JButton("Transformation");
            right.add(b2);
            //b3 = new JButton("Mining Algo");
            //right.add(b3);

            b4 = new JButton("Loading");
            right.add(b4);
            
            b5 = new JButton("kmeans");
            right.add(b5);
            
            b6 = new JButton("KNN");
            right.add(b6);
            
            mm.add(left);
            mm.add(right);
            left.add(ta);
           
  
             jpmain.add(mm);
            jpmain.add(gridtable);

            b1.addActionListener(this);
            b2.addActionListener(this);
            b4.addActionListener(this);
            b5.addActionListener(this);
            b6.addActionListener(this);
            //b5.addActionListener(this);

            

            //setExtendedState(MAXIMIZED_BOTH);
            setVisible(true);
            pack();
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        } catch (ClassNotFoundException ex) {
        }

    }

    public static void getColumns(String tableName) {
        int temp = 0;
        ResultSet rs;
        try {
            rs = st.executeQuery("select * from " + tableName);
            ResultSetMetaData rsMetaData = rs.getMetaData();
            temp = rsMetaData.getColumnCount();
            System.out.println(temp + "cols");
            columnTable = temp;
            temp = 0;
            while (rs.next()) {
                temp++;
            }
            rowTable = temp;
        } catch (SQLException ex) {
        }
    }

    public static void getRows(String tableName) {
        int temp = 0;
        try {
            ResultSet rs = st.executeQuery("select * from " + tableName);
            while (rs.next()) {
                temp++;
            }
            System.out.println(temp);
            //temp= rs.getRow();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        rowTable = temp;
        //return temp;
    }

    public static void createConnection() {
        try {
            con = DriverManager.getConnection("jdbc:odbc:dwm111");
            st = con.createStatement();

        } catch (SQLException ex) {
        }
    }
    
     public static void createConnection1() {
        try {
            con1 = DriverManager.getConnection("jdbc:odbc:dwm1111");
            st1 = con1.createStatement();

        } catch (SQLException ex) {
        }
    }

    public static void main(String[] args)
    {
        Main m = new Main();
        m.setSize(1000, 1000);
    }

   
    public void tpcal()
    {
       
    }
}
