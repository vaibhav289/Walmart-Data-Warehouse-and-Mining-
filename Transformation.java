
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author student
 */
public class Main extends JFrame {

    static int columnTable;

    JPanel jpmain, left, right;
    JTextArea t1;
    JButton b1, b2, b3, b4;
    static java.sql.Statement st;
    static Connection con;


    Main()
    {
        try {
            jpmain = new JPanel();
            add(jpmain);
            left = new JPanel();
           //left.setSize(jpmain.getHeight(),50);
            right = new JPanel(new GridLayout(4, 1));
            //t1 = new JTextArea(100, 200);
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            createConnection();
            getColumns("customer");
            final JTable table = new JTable(getRows("customer"), columnTable+1);
            //table.setSize(left.getHeight(),50000);
            JScrollPane scrollPane = new JScrollPane(table);
            
            left.add(scrollPane);
            b1 = new JButton("Extraction");
            right.add(b1);
            b2 = new JButton("Transformation");
            right.add(b2);
            b3 = new JButton("Loading");
            right.add(b3);
            b4 = new JButton("Mining Algorithm");
            right.add(b4);
            jpmain.add(left);
            jpmain.add(right);

            b2.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {

                    if(e.getSource() == b2){
                        for(int i=0;i<getRows("customer");i++){
                            for(int j=0;j<columnTable;j++){
                                 Object obj1 = GetData(table, i, j);

                                 if(obj1 == null)
                                     table.setValueAt("null", i, j);
                                 
                                 obj1=GetData(table, i, j);
                                 System.out.println(obj1);

                                 if( (obj1).toString().contains("-"))
                                 {
                                 int t=Integer.parseInt(obj1.toString().substring(0,4));
                                 table.setValueAt(""+(2012-t), i, columnTable);
                                }
                                obj1=GetData(table, i, j);
                                if (obj1.toString().length()==10)
                                {
                                    if (Character.isDigit(obj1.toString().charAt(0)) )
                                    {
                                         String s=obj1.toString();
                                         table.setValueAt(s.substring(0,3) + "-" +s.substring(3,6) + "-" + s.substring(6) , i, j);
                                    }
                                }
                           }
                        }
                   }
                }
            });
         
            //setExtendedState(MAXIMIZED_BOTH);
            setVisible(true);
            pack();
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        } catch (ClassNotFoundException ex) {
           
        }

        }

    public static void getColumns(String tableName)
    {
        int temp=0;
        ResultSet rs;
        try {
            rs = st.executeQuery("select * from " + tableName);
            ResultSetMetaData rsMetaData = rs.getMetaData();
            temp = rsMetaData.getColumnCount();
            System.out.println(temp+"cols");
            columnTable=temp;
        }
        catch (SQLException ex)
        {

        }
    }
public static int getRows(String tableName)
    {
        int temp=0;
        try
        {
            ResultSet rs = st.executeQuery("select * from " + tableName);
            while(rs.next())
                temp++;
            System.out.println(temp);
            rs.close();
            //temp= rs.getRow();
        } 
        catch (SQLException ex)
        {
            System.out.println(ex);
        }
        return temp;
    }
    public static void createConnection() {
        try
        {
            con = DriverManager.getConnection("jdbc:odbc:car");
            st = con.createStatement();

        }
        catch (SQLException ex)
        {

        }
    }
    
     public static Object GetData(JTable table, int row_index, int col_index){
  return table.getModel().getValueAt(row_index, col_index);
  }



    public static void main(String[] args) {
        Main m = new Main();

    }


}
