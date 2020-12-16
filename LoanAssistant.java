
package loanassistant;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

public class LoanAssistant implements ActionListener {
    JFrame frame;
    Container c;
    Font font1,font2,font3;
    JLabel l1,l2,l3,l4;
    JTextField t1,t2,t3,t4;
    JTextArea textarea1;
    JButton b1,b2,b3,b4,b5,b6;
    LoanAssistant(){        
        frame=new JFrame("Loan Assistant");
        frame.setBounds(100,100,1000,600);
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        
        
        c=frame.getContentPane();
        c.setLayout(null);
        
        font1=new Font("Arial",Font.PLAIN,22);
        font2=new Font("Arial",Font.PLAIN,20);
        font3=new Font("Arial",Font.PLAIN,19);
        
        l1=new JLabel("Loan Balance:");
        l1.setBounds(30,50,140,30);
        l1.setFont(font1);
        c.add(l1);
        
        l2=new JLabel("Interest Rate:");
        l2.setBounds(30,110,140,30);
        l2.setFont(font1);
        c.add(l2);
        
        l3=new JLabel("Number of Payments:");
        l3.setBounds(30,170,220,30);
        l3.setFont(font1);
        c.add(l3);
        
        l4=new JLabel("Monthly Payments:");
        l4.setBounds(30,230,220,30);
        l4.setFont(font1);
        c.add(l4);
        
        
        //creating textfields
        
        t1=new JTextField();
        t1.setBounds(250,50,200,35);
        t1.setFont(font1);
        c.add(t1);
        
        t2=new JTextField();
        t2.setBounds(250,110,200,35);
        t2.setFont(font1);
        c.add(t2);
        
        t3=new JTextField();
        t3.setBounds(250,170,200,35);
        t3.setFont(font1);
        t3.setForeground(Color.BLACK);
        t3.setBackground(Color.YELLOW);
        c.add(t3);
        
        t4=new JTextField();
        t4.setBounds(250,230,200,35);
        t4.setFont(font1);
        c.add(t4);
        
        //creating buttons
        b1=new JButton("Compute Number of Payments");
        b1.setBounds(50,300,300,40);
        b1.setForeground(Color.WHITE);
        b1.setBackground(Color.BLACK);
        b1.setFont(font3);
        b1.addActionListener(this);
        c.add(b1);
        
        b2=new JButton("New Loan Analysis");
        b2.setBounds(50,360,300,40);
        b2.setForeground(Color.WHITE);
        b2.setBackground(Color.BLACK);
        b2.setEnabled(false);
        b2.setFont(font2);
        b2.addActionListener(this);
        c.add(b2);

        b3=new JButton("X");
        b3.setBounds(465,170,60,35);
        b3.setForeground(Color.WHITE);
        b3.setBackground(Color.BLACK);
        b3.setFont(font2);
        b3.addActionListener(this);
        c.add(b3);
        
        
        b4=new JButton("Exit");
        b4.setBounds(685,480,120,40);
        b4.setForeground(Color.WHITE);
        b4.setBackground(Color.BLACK);
        b4.setFont(font2);
        b4.addActionListener(this);
        c.add(b4);
        
        
        
        
        //creating textarea
        textarea1=new JTextArea();
        textarea1.setBounds(560,50,400,400);
        textarea1.setFont(font1);
        c.add(textarea1);
        
        
        frame.setVisible(true);        
    }
    @Override 
    public void actionPerformed(ActionEvent ae)
    {
        int a;
        float loan_balance,interest_rate,monthly_payments,total_payment,number_of_payments,last_payment,interest_paid;
        int first_payments;
        String string1,string2,string3;
        if(ae.getSource()==b1)
        {
            if(b1.getText()=="Compute Number of Payments")
            {
                loan_balance = Float.parseFloat(t1.getText());
                interest_rate= Float.parseFloat(t2.getText());
                monthly_payments=Float.parseFloat(t4.getText());
            
                total_payment= loan_balance+(loan_balance*interest_rate) /100;            
                number_of_payments= total_payment/monthly_payments;
                first_payments= Math.abs((int) number_of_payments);
            
            
                last_payment=total_payment - monthly_payments*first_payments;
                interest_paid=total_payment - loan_balance;
                string1="Loan balance  : ";
                string2="Interest Rate  : ";
                string3="Total_payments: ";
            
                t3.setText(""+number_of_payments);
                textarea1.setText(string1+loan_balance+"\n"+string2+interest_rate+"\n\n\n\n\n\n"+string3+total_payment+"\n"+first_payments+" Payments of "+monthly_payments+"\n"+"Last payment of "+last_payment+"\n"+"Interest Paid : "+interest_paid);                                                        
                b2.setEnabled(true);
            }
            else if(b1.getText()=="Compute Monthly Payments")
            {
                /*
                double balance, interest, payment;
                int months;
                double monthlyInterest, multiplier;
                loan_balance =(float) Double.parseDouble(t1.getText());
                interest     =(float) Double.parseDouble(t2.getText());
                monthlyInterest = interest / 1200;
                // Compute loan payment
                months =Integer.valueOf(t3.getText()).intValue();
                multiplier = Math.pow(1 + monthlyInterest, months);
                monthly_payments = (float) (loan_balance * monthlyInterest * multiplier / (multiplier - 1));
                t4.setText(new DecimalFormat("0.00").format(monthly_payments));
                */
                
                loan_balance = Float.parseFloat(t1.getText());
                interest_rate= Float.parseFloat(t2.getText());
                number_of_payments=Float.parseFloat(t3.getText());
                
                total_payment=loan_balance + loan_balance*interest_rate/100;
                System.out.println(total_payment);
                
            }
                        
        }
        if(ae.getSource()==b2)
        {
            t1.setText(null);
            t2.setText(null);
            t3.setText(null);
            t4.setText(null);
            
            textarea1.setText(null);
            
            
            
        }
        if(ae.getSource()==b3)
        {
            t1.setText(null);
            t2.setText(null);
            t3.setText(null);
            t4.setText(null);
            textarea1.setText(null);
            
            
            if(b1.getText()=="Compute Number of Payments")
            {
                b3.setBounds(465,230,60,35);
                t4.setEnabled(false);
                t4.setBackground(Color.YELLOW);
                t3.setBackground(Color.WHITE);
                t3.setEnabled(true);
                b1.setText("Compute Monthly Payments");
            }
            else if(b1.getText()=="Compute Monthly Payments")
            {
                b3.setBounds(465,170,60,35);
                t3.setBackground(Color.YELLOW);
                t4.setBackground(Color.WHITE);
                t4.setEnabled(true);
                b1.setText("Compute Number of Payments");
            }
            
            
            
        }
        if(ae.getSource()==b4)
        {
            System.exit(0);
        }
    }
    public static void main(String[] args) throws Exception{
        LoanAssistant l1=new LoanAssistant();
    }
    
}
