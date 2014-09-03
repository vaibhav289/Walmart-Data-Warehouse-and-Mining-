
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class tran extends JFrame implements ActionListener {
    JPanel jpmain;
    JButton  nc,nc1,cnt,age,nc2;
    
    tran()
    {
       
        jpmain = new JPanel(new GridLayout(5,1));
        add(jpmain);
        

        nc= new JButton("Null Check");
        nc1= new JButton("Assume Default Attributes");
        cnt= new JButton("Format Date");
        age= new JButton("Calculate Age");
        nc2= new JButton("De-duplicate Entries");

       nc.addActionListener(this);
       nc1.addActionListener(this);
       cnt.addActionListener(this);
       age.addActionListener(this); 
       nc2.addActionListener(this); 


        jpmain.add(nc);
         jpmain.add(nc1);
        jpmain.add(cnt);
        jpmain.add(age);
        jpmain.add(nc2);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == nc) {
                   Main.nullcheck();               
                  // Main.contact();              
                 //  Main.calage();               
            } 
         if (e.getSource() == nc1) {
                   Main.defaultAttribute();               
                  // Main.contact();              
                 //  Main.calage();               
            } 
        if (e.getSource() == cnt) {
            Main.contact();
        }
    if (e.getSource() == age) {
            Main.calage();           
        }
    if (e.getSource() == nc2) {
                   Main.deDuplicateEntries();               
                  // Main.contact();              
                 //  Main.calage();               
            } 
        setVisible(false);
    }
    
}
