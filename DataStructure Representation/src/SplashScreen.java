import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
class SplashScreen extends JWindow {
    private JProgressBar pb;
    JLabel text0 = new JLabel(""
            + "<html>"
            + "<br>"
            + "&ensp; <span style = 'color:#d72640; font-size: 48; font-weight: 900' > Welcome to our Project </span> <br> <br>"
            +" &emsp; &ldquo;Visual Representation <br> &emsp;&emsp;&emsp;&emsp;&emsp; &ensp; of <br>"
            +" &emsp;&emsp;&ensp; Data Structures &rdquo;"
            + " </html>",SwingConstants.CENTER);
    JLabel text = new JLabel(""  
            +"<html>"
            + " </html>");
    JButton b1 = new JButton("Let's Go");
    JLabel text1 = new JLabel("Please wait a while....",SwingConstants.CENTER);
      
    public SplashScreen() {
       text.setFont(new Font("Italic", Font.ITALIC, 35));
       text.setForeground(Color.black);
        text0.setFont(new Font("Italic", Font.ITALIC, 45));
        text0.setForeground(Color.black);
        pb = new JProgressBar(1, 100);
        //pb.setSize(100,300);
        //pb.setStringPainted(true);
        pb.setValue(0);
        pb.setStringPainted(true);
        pb.setBackground(Color.LIGHT_GRAY);
        pb.setForeground(Color.darkGray);
         pb.setVisible(false);
        setSize(700, 550);
        setLocation(400, 100);
        b1.setSize(100,100);
        b1.setBounds(300, 420, 90, 30);
         Color color=new Color(0,200,252);
        getContentPane().setBackground(color);
        add(b1);
        add(pb, BorderLayout.PAGE_END);
        add(text0,BorderLayout.NORTH);
        add(text,BorderLayout.CENTER);
        SplashScreen.ButtonHandler bh = new SplashScreen.ButtonHandler();
        b1.addActionListener(bh);
        setVisible(true);      
    }
    class ButtonHandler implements ActionListener{
     public void actionPerformed(ActionEvent e) {
    if (e.getSource() == b1) {
     text1.setFont(new Font("PLAIN", Font.PLAIN, 18));
     text1.setBounds(120, 430,450, 100);
        add(text1,BorderLayout.SOUTH);
      pb.setVisible(true);
      text1.setVisible(true);
       new ProgressThread().start();
    }
  }
    }
    class ProgressThread extends Thread {
        public void run() {
            for (int i = 0; i < 100; i++) {
                pb.setValue(i);
                try {
                    Thread.sleep(40);
                } catch (Exception e) {
                }
            }
            new Welcome();
            dispose();
        }
    }
        public static void main(String args[]) {
        new SplashScreen();
    }
}