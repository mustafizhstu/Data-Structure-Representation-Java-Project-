import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class InsertionPanel extends JPanel{
	private int nos[],pos1,pos2,pass;
	private boolean flag,flag1,flag2;

	public InsertionPanel(int x[]){
		nos = x;
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(flag){
			int w = getWidth();
			int cw = w/10 - 4;
			if(flag1){			
				g.setColor(Color.PINK);
				g.fillRect(pos1*cw+4,20,cw,cw);
			}
			if(flag2){
				g.setColor(Color.CYAN);
				g.fillRect(pos2*cw+4,20,cw,cw);
			}
			g.setColor(Color.BLACK);
			for(int i=0;i<10;i++){
				g.drawRect(i*cw+4,20,cw,cw);
				g.drawString(Integer.toString(nos[i]),
					i*cw+10,20+cw/2);
			}
			g.drawString("Pass:"+pass,4,10);
		}	
	}

	public void setFlag(boolean b){
		flag = b;
	}

	public void setFlag1(boolean b){
		flag1 = b;
	}

	public void setFlag2(boolean b){
		flag2 = b;
	}

	public void setPos1(int i){
		pos1 = i;
	}

	public void setPos2(int i){
		pos2 = i;
	}

	public void setPass(int i){
		pass = i;
	}
}

class InsertionSort extends JFrame{
	private InsertionPanel panCenter;
	private JPanel panSouth;
	private JButton btnStart,btnClose;
	private MyThread t;
	private int nos[];

	public InsertionSort(){
		nos = new int[10];

		btnStart = new JButton("Start");
		btnClose = new JButton("Close");
		
		panCenter = new InsertionPanel(nos);
		
		panSouth = new JPanel();
		panSouth.setLayout(new GridLayout(1,2));
		panSouth.add(btnStart);
		panSouth.add(btnClose);

		setTitle("Insertion Sort");
		setSize(500,250);
                setLocation(50,50);
		add(panCenter,"Center");
		add(panSouth,"South");
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		ButtonHandler bh = new ButtonHandler();
		btnStart.addActionListener(bh);
		btnClose.addActionListener(bh);

	}

	public void generateNos(){
		for(int i=0;i<10;i++){
			nos[i] = (int)(Math.random()*100)+1;
		}
	}

	class MyThread extends Thread{
		public void run(){
			int n = 10,i,j,y;
			for(i=1;i<n;i++){
				panCenter.setPass(i+1);
				y = nos[i];
				panCenter.setPos1(i);
				panCenter.setFlag1(true);
				panCenter.repaint();
				try{
					Thread.sleep(400);
				}catch(Exception e){}
				for(j=i-1;j>=0;j--){
					if(y<nos[j])
						nos[j+1]=nos[j];
					else break;
				}
				nos[j+1]=y;
				panCenter.setPos2(j+1);
				panCenter.setFlag2(true);
				panCenter.repaint();
				try{
					Thread.sleep(4000);
				}
				catch(Exception e){}
				panCenter.setFlag1(false);
				panCenter.setFlag2(false);
			}
			JOptionPane.showMessageDialog(null,"Sorting Complete");
			panCenter.setPos1(-1);
			panCenter.setPos2(-1);
			panCenter.repaint();
		}
	}

	class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			if(ae.getSource()==btnStart){
				generateNos();
				panCenter.setFlag(true);
				t = new MyThread();
				t.start();
			}
			if(ae.getSource()==btnClose){
				dispose();
			}
		}
	}

	public static void main(String args[]){
		new InsertionSort();
	}
}
