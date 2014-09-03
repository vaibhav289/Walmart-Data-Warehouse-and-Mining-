import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 *
 * @author student
 */
public class extract extends JFrame implements ActionListener {

    JPanel jpmain,cbox,buttons,ll;
    JButton b1;
    JCheckBox acc,txt,both;
    JList l,l2;

    extract()
    {
        jpmain = new JPanel(new GridLayout(3,1));
        add(jpmain);

        String a[] = {"Categories","importloc","products","location","staff","manager"};
        l = new JList(a);
        JScrollPane scrollPane1 = new JScrollPane(l);

        //String b[] = {"Categories", "importloc","products", "location"};
      //  l2 = new JList(b);
    //    JScrollPane scrollPane2 = new JScrollPane(l2);
        ll = new JPanel(new GridLayout(1,1));
        ll.add(scrollPane1);
      //  ll.add(scrollPane2);

        acc=new JCheckBox("Access");
        txt=new JCheckBox("text");
        both=new JCheckBox("both");

        cbox = new JPanel(new GridLayout(1,3));
        cbox.add(acc);
        cbox.add(txt);
        cbox.add(both);

        jpmain.add(ll);
        jpmain.add(cbox);

        b1=new JButton("Choose");
        b1.addActionListener(this);
        jpmain.add(b1);

        
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String tab=null;
        Boolean y=false;
        if (e.getSource() == b1) {


            if(acc.isSelected()){
            tab = l.getSelectedValue().toString();
            Main.fillTable(tab);
            }
            else if(txt.isSelected()){
             tab = l.getSelectedValue().toString();
            Main.fillTxtTable(tab,y);
            }
            else  if (both.isSelected()) {
            y=true;
            
            tab = l.getSelectedValue().toString();
            
            Main.fillTable(tab);
            Main.fillTxtTable(tab,y);
            }

            setVisible(true);
        }
    }

}
