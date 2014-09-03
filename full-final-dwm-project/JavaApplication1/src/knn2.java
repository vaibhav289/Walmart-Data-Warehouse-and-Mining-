
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


/**
 *
 * @author student
 */
public class knn2 extends JFrame implements ActionListener {

   
    JLabel label1,label2;
    static JTextArea text1;
    static JTextArea text2;
    JButton KNN;
    JPanel jpmain;
    
    knn2()
    {
        
        jpmain = new JPanel(new FlowLayout());
        add(jpmain);
        
        label1=new JLabel("Specify the salary  you want to classify:");
        
      //  label8=new JLabel("                                                                                ");
			label2=new JLabel("Age is classified as ");
                        KNN=new JButton("KNN");
                      
                     
                        jpmain.add(label1);
                       
                       
                        text1=new JTextArea("",2,45);
                        text2=new JTextArea("",2,45);
                     
                         jpmain.add(text1);
                         jpmain.add(KNN);
                         jpmain.add(text2);
    
                       
                        
                         
                        
                        
                       
                        
                        KNN.addActionListener(this);
                        setVisible(true);
    }
                        
        /*label1=new JLabel("Specify the salary  you want to classify:");
			label2=new JLabel("Age is classified as ");
		
			text1=new JTextArea("",10,10);
			text2=new JTextArea("",10,10);
			//text1.setEditable(false);
			text2.setEditable(false);
			KNN=new JButton("KNN");
                        
                        panel=new JPanel();
                        panel.setLayout(new FlowLayout());
			panel1=new JPanel(new FlowLayout());
			panel2=new JPanel(new FlowLayout());
			
			panel.add(label1);
			panel.add(text1);
			
			panel1.add(label2);	
			panel1.add(text2);
			
			panel2.add(KNN);
                         add(panel);
                        add(panel1);
                        add(panel2);
                        KNN.addActionListener(this);
                        
                       
                        
                        setVisible(true);
    }*/
                        
    public void actionPerformed(ActionEvent ae)
    {
        Main.knn(Integer.parseInt(text1.getText()),text2);
    }
    
    
        
    
}