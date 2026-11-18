import javax.print.DocPrintJob;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class HospitalPricingCalculator 
{
    static double total=0;
    
    public static void main(String[] args)
    {

      

        ArrayList<Double> servicesPriceDatabaseArrayList = new ArrayList<>();

        servicesPriceDatabaseArrayList.add(25.0);
        servicesPriceDatabaseArrayList.add(10.0);
        servicesPriceDatabaseArrayList.add(5.0);
        servicesPriceDatabaseArrayList.add(0.0);

        ArrayList<String> servicesNameDatabaseArrayList = new ArrayList<>();

        servicesNameDatabaseArrayList.add("Chest Xray");
        servicesNameDatabaseArrayList.add("Blood Test");
        servicesNameDatabaseArrayList.add("Urine dip");
        servicesNameDatabaseArrayList.add("Others");
     




        JFrame frame = new JFrame("Hospital Services Pricing Calculator");
        frame.setBounds(600,250,400,400);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComboBox servicesBox = new JComboBox<>();
        servicesBox.setBounds(30,30,200,30);
        servicesBox.addItem ("Chest Xray : $25");
        servicesBox.addItem("Blood test: $10");
        servicesBox.addItem("Urine dip: $5");
        servicesBox.addItem("Others");
        servicesBox.setSelectedIndex(0);
        frame.add(servicesBox);


        JTextArea textArea = new JTextArea();
        textArea.setBounds(35,90, 200,150);
        textArea.setEditable(false);
        frame.add(textArea);


        JLabel totalL = new JLabel("Total:");
        totalL.setBounds(35, 250, 105,20);
        frame.add(totalL);

        JTextField totalT = new JTextField();
        totalT.setBounds(95,250,100,20);
        frame.add(totalT);

        JLabel testL = new JLabel("Tests:");
        testL.setBounds(35, 280, 105,20);
        testL.setVisible(false);
        frame.add(testL);

        JTextField testT = new JTextField();
        testT.setBounds(95, 280,100,20);
        testT.setVisible(false);
        frame.add(testT);

        JLabel priceL = new JLabel("Price:");
        priceL.setBounds(35,310,105,20);
        priceL.setVisible(false);
        frame.add(priceL);

        JTextField priceT = new JTextField();
        priceT.setBounds(95,310,100,20);
        priceT.setVisible(false);
        frame.add(priceT);

        JButton SubmitButton = new JButton("Submit");
        SubmitButton.setBounds(95,339,100,20);
        SubmitButton.setVisible(false);
        frame.add(SubmitButton);

        SubmitButton.addActionListener(new ActionListener() 
        {

            public void actionPerformed(ActionEvent e) 
            {
                String newTest ="";
                
                
                
                    if (testT.getText().isEmpty()||priceT.getText().isEmpty())
                    {
                        testT.setBackground(Color.red);
                        priceT.setBackground(Color.red);
                    }

                    else 
                    {
                        
                        newTest = testT.getText();

                        Double newTestPrice = Double.parseDouble(priceT.getText());
                        servicesPriceDatabaseArrayList.add(newTestPrice);
                        servicesBox.addItem(newTest+ ": " +"$"+newTestPrice);
                        priceT.setBackground(Color.white);
                        priceT.setText("");
                        
                        
                        
                        servicesNameDatabaseArrayList.add(testT.getText());
                       
                        testT.setBackground(Color.white);
                        //servicesBox.addItem(newTest);
                        testT.setText("");  
                        
                        
                        

                        

                       testL.setVisible(false);
                       testT.setVisible(false);
                       priceL.setVisible(false);
                       priceT.setVisible(false);
                       SubmitButton.setVisible(false);
                    }

                   
                    
                    
                
                
            }
            
        });

    


        JButton AddButton = new JButton("Add");
        AddButton.setBounds(250,33, 100,20);
        frame.add(AddButton);

        JScrollPane outputAreaScrollpane =new JScrollPane(textArea);
        outputAreaScrollpane.setBounds(35,90, 200,150);
        frame.add(outputAreaScrollpane);

        AddButton.addActionListener(new ActionListener() 
        {

           
            public void actionPerformed(ActionEvent e) 

            {
                
               

                String outputText = "";
               
               if(servicesBox.getSelectedIndex()==3)
                {
                    SubmitButton.setVisible(true);
                    testL.setVisible(true);
                    testT.setVisible(true);
                    priceL.setVisible(true);
                    priceT.setVisible(true);
                    return ;
                }
                
                for (int i =0; i<servicesNameDatabaseArrayList.size();i++)
                {
                   
                    
                   if(servicesBox.getSelectedIndex()==i)
                    {
                        

                    outputText = ("Service:" + servicesNameDatabaseArrayList.get(i)+ "\n"+ "Price: $" +servicesPriceDatabaseArrayList.get(i)+"\n"+"\n" );
                      break; 
                    }

                    else
                    {
                        outputText =("");
                    }
                
                }

                for (int i =0;i<servicesPriceDatabaseArrayList.size();i++)
                {
                    if(servicesBox.getSelectedIndex()==i)
                    {
                        
                        total = total + servicesPriceDatabaseArrayList.get(i);
                        totalT.setText("$" + total);
                        

                    }

                   
                }

                
              
                
                

                textArea.append(outputText);

              

                 


               
                
            }
            
        });





        frame.setVisible(true);
        
    }

    
}
