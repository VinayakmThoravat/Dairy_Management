import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFrame;
import java.io.FileWriter;
import java.io.IOException;


class prod extends JFrame implements ActionListener, FocusListener{
  
  
    JTextField etf , wegh;
    JFrame ob;
    JTextField tf, snf, mno;
    JLabel lb,lbfat,lbsnf, sname;
    JButton bt, purdet, md, addmem;
    JButton back= new JButton("Back"); 
    Font font= new Font("Serif", Font.BOLD,25);
    Font font1= new Font("Arial", Font.LAYOUT_NO_START_CONTEXT,19);
    Map<Integer, String> memdet = new HashMap<>();
    int cnt=0;
    Integer s11, amt;
    String f1 , f2 , f3 , f4, f5, f6, f7, f8, f9;
    prod(){  
        memdet.put(1,"Vinayak");
        memdet.put(2,"Rahul");
        memdet.put(3,"Sachin");
        memdet.put(4,"Rohan");
        memdet.put(5,"Saurabh");
        cnt =5;
        f1= "vinayak";
        f2="rahul";
        f3="sachin";
        f5="saurabh";
        f4="rohan";
  }
 public void MainScreen(){

         ob= new JFrame("kamlai dairy");
         ob.setBounds(380, 0,500,680);
         ob.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ob.setLayout(null);

        lb= new JLabel("कमल-आई दूध संघ  \r\n");
        lb.setBounds(20, 30,230, 50);
        lb.setForeground(Color.magenta);
        ob.add(lb);
        lb.setFont(font);

        
      
        purdet=new JButton("PURCHASE DETAIL");
        purdet.setBounds(30,180,150,90);// aadv khali rundi unchi
        purdet.setBackground(Color.green);
        purdet.addActionListener(this);
        ob.add(purdet);

        md= new JButton("MEMBER DETAIL");
        md.setBounds(200,180,150,90);
        md.addActionListener(this);
        md.setBackground(Color.GRAY);
        ob.add(md);

      
        ob.setVisible(true);

    }

    
   public void purchase(){
       
        JLabel mnl= new JLabel("Enter Producer ID");
        mnl.setBounds(30,120,280,50);
        mnl.setFont(font);
        ob.add(mnl);

        
        

        
        mno = new JTextField(" ID ");
        mno.setBounds(30, 170, 90,40 );// aadv khali rundi unchi
        mno.setFont(font1);
        ob.add(mno);
        mno.addFocusListener(this);
       
        sname = new JLabel("");
        sname.setBounds(130,170,200,40);
        sname.setFont(font);
        ob.add(sname);


        lbfat= new JLabel("FAT : ");
        lbfat.setBounds(20,230,90,30);
        lbfat.setFont(font);
        ob.add(lbfat);

        
        tf= new JTextField("FAT ");
        tf.setForeground(Color.darkGray);
        tf.setBounds(100,230,80,30);
        tf.setBackground(Color.lightGray);
        tf.setFont(font1 );
        tf.addFocusListener(this);
        ob.add(tf);
        
       
        
        lbsnf= new JLabel("SNF : ");
        lbsnf.setBounds(20,280,90,30);
        lbsnf.setFont(font);
        ob.add(lbsnf);
        snf = new JTextField("SNF ");
        snf.setForeground(Color.DARK_GRAY);
        snf.setBounds(100,280,80,30);
        snf.setBackground(Color.lightGray);
        snf.setFont(font1);
        snf.addFocusListener(this);
        ob.add(snf);

        JLabel weghl= new JLabel("Weight");
        weghl.setBounds(20,330, 90,30);
        weghl.setFont(font);
        ob.add(weghl);

        wegh = new JTextField("Weight ");
        wegh.setForeground(Color.DARK_GRAY);
        wegh.setBounds(130,330,80,30);
        wegh.setBackground(Color.lightGray);
        wegh.setFont(font1);
        wegh.addFocusListener(this);
        ob.add(wegh);


        bt = new JButton("Cheak");
        bt.setBounds(20,380,90,30);// aadv khali rundi unchi
        bt.setBackground(Color.CYAN);
        bt.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    String fat= tf.getText();
                    String snf1= snf.getText();
                    String cod= mno.getText();
                   int code= Integer.parseInt(cod);
                   String wegh1 = wegh.getText();
                    int wght = Integer.parseInt(wegh1);
                   
                    if(fat.matches(".*[a-zA-Z]+.*")||snf1.matches(".*[a-zA-Z]+.*")|| !(memdet.containsKey(code)) ){
                        
                    }
                    
                    else{
                        double fat1= Double.parseDouble(fat);
                        double snf11= Double.parseDouble(snf1);
                    
                    if(wght==0){
                        JOptionPane.showMessageDialog(null,"Warning:\nWeight Should Not be zero");
                                 
                    }

                    else{
                        double rate=find_rate(fat1, snf11);
                    
                    JOptionPane.showMessageDialog(null,"FAT : "+fat1+"\nSNF : "+snf11+"\n Rate: "+rate);

                    }
                  /* int result = JOptionPane.showConfirmDialog(
                    null,
                    "Do you want to proceed?",
                    "Confirmation",
                    JOptionPane.OK_CANCEL_OPTION
                );*/
            }
                        
            }

        });
        ob.add(bt);
       
        back.setBounds(130, 380,90,30);// aadv khali rundi unchi
        back.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                {
                    ob.removeAll();
                    MainScreen();
                    ob.revalidate();
                    ob.repaint();
                }
           
            }
         });

 
        ob.add(back);     
    } 
    
    void addData(double fa, double sn, double rt, double wt, int cd){

        switch(cd){
                case 1:
                try {
                    // Create a FileWriter object in append mode
                    FileWriter writer = new FileWriter(f1, true);

                    String content ="  Fat :"+ fa+"\n  SNF"+sn+"\n  Rate"+rt+"\n  Weight"+wt;
        
                    // Write content to the file
                    writer.write(content);
        
                    // Close the FileWriter
                    writer.close();
        
                    System.out.println("File created or appended to successfully.");
                } catch (IOException e) {
                    System.out.println("An error occurred while writing to the file.");
                    e.printStackTrace();
                }

                break;
        




        }



    }




    public   void MemDet(){

       ob.add(lb);
       
        int y = 100;
        for (Map.Entry<Integer, String> entry : memdet.entrySet()) {
            JLabel label = new JLabel("ID: " + entry.getKey() + ", Name: " + entry.getValue());
            label.setBounds(20, y, 300, 30);// aadv khali rundi unchi
            label.setFont(font1);
            ob.add(label);
            y += 40;
        }

        addmem=new JButton("Update Membership");
        addmem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             updateMem();
            }
        });
        addmem.setBounds(20, y, 160, 30);
        ob.add(addmem);
        back.setBounds(200,y,100,30);// aadv khali rundi unchi
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              MainScreen();
            }
        });
        ob.add(back);
    }    

    public void   updateMem(){
        ob.getContentPane().removeAll();
        ob.add(lb);
        ob.repaint();
        JButton upd, del;
        upd=new JButton("Add Member");
        del=new JButton("Remove Member");
        upd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               AddMem();
            }
         });
        upd.setBounds(80,230,160,40);// aadv khali rundi unchi
        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ob.getContentPane().removeAll();
                ob.add(lb);
                ob.repaint();  
                DelMem();
            }
        });
        del.setBounds(270,230,160,40);
        ob.add(upd);
        ob.add(del);
        
        JButton back1= new JButton("Back");
        back1.setBounds(200,300,100,30);// aadv khali rundi unchi
        back1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ob.getContentPane().removeAll();
                ob.add(lb);
                ob.repaint();
                MemDet();
            }
        });
        ob.add(back1);
    }

    public void AddMem(){
        ob.getContentPane().removeAll();
        ob.add(lb);
        ob.repaint();
        JLabel n1=new JLabel("Enter the Name");
        n1.setBounds(50,178,200,50);
        n1.setFont(font);
        ob.add(n1);
        JTextField adm= new JTextField();
        adm.setBounds(50,250,120,40);// aadv khali rundi unchi
        adm.setFont(font1);
        ob.add(adm);
        JButton b1=new JButton("Submit");
        b1.setBounds(50,300,100,40);
        ob.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              String s1 =adm.getText();
              memdet.put(++cnt, s1);
              adm.setText("");
            }
        });
        JButton b2= new JButton("Back");
        b2.setBounds(180, 300,100,40);
        ob.add(b2);
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             updateMem();
            }
        });       
    }

    public void DelMem() {

        

    }





        @Override
        public void actionPerformed(ActionEvent e){
            
            if(e.getSource()==purdet){
                ob.remove(purdet);
                ob.remove(md);
                ob.revalidate();
            
                
                ob.repaint();
                
                purchase();
            }    

            if(e.getSource()==md){
                ob.remove(md);
                ob.remove(purdet);
                ob.revalidate();
                ob.repaint();
                MemDet();
            }

           
          
          

           
        }
        
        
        @Override
        public void focusGained( FocusEvent e ){
            if(e.getSource()== tf &&  tf.getText().equals("FAT ")){
                tf.setText("");
                System.out.println("focus is at ");
                tf.setForeground(Color.BLACK);
            }
             if (e.getSource() == snf && snf.getText().equals("SNF ")) {
                snf.setText("");
                snf.setForeground(Color.BLACK);
            }
            if(e.getSource() ==wegh && wegh.getText().equals("Weight ")){
                wegh.setText("");
                wegh.setForeground(Color.BLACK);
            }

            if (e.getSource()==mno&& mno.getText().equals(" ID ")) {
                mno.setText("");
                mno.setForeground(Color.BLACK);
                
            }

         
        }
        @Override
        public void focusLost(FocusEvent e){
            if(e.getSource()== tf &&  tf.getText().isEmpty()){
                tf.setText("FAT ");
                tf.setForeground(Color.WHITE);

            }
            if (e.getSource() == snf && snf.getText().isEmpty()) {
                snf.setText("SNF ");
                snf.setForeground(Color.WHITE);
            }

            if(e.getSource() ==wegh && wegh.getText().isEmpty()){
                wegh.setText("Weight ");
                wegh.setForeground(Color.WHITE);
            }
            
            if(e.getSource() ==mno && mno.getText().isEmpty()){
                mno.setText(" ID ");
                mno.setForeground(Color.DARK_GRAY);


            }
            if(e.getSource() ==mno &&!( mno.getText().isEmpty())){
               String s1 = mno.getText();
               s11= Integer.parseInt(s1);
                if (memdet.containsKey(s11)) {
                    // Access the corresponding value
                    String value = memdet.get(s11);
                    sname.setText(value);
                    sname.setForeground(Color.DARK_GRAY);
                } else {
                        sname.setText("Member not found");  
                        sname.setForeground(Color.RED);
                        sname.setFont(font);                  
                }
            }
        }
        double find_rate(double fat, double snf){
            final double const_fat=3.5;
            final double const_snf=8.5;
            double min_fat= const_fat- fat;
            double min_snf=const_snf-snf;
            double rate=28.25-((min_fat*1)+(min_snf*1));
            return (rate);


        }
      

       
}


 class Dairy{

    public static void main(String[] args) {
        
    
    prod obj= new prod();
    obj.MainScreen();
} 
  
 }
