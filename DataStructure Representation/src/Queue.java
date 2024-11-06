import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class QueueImpl{
	private String q[];
	int front,rear;
	public final int MAX=10;

	public QueueImpl(){
		q = new String[MAX];
                front = rear = -1;
        }

  	public boolean isFull(){
        	return rear==MAX-1;
	}

	public boolean isEmpty(){
		return front==rear;
	}
 
        public void addq(String val){
		if(isFull()){
			JOptionPane.showMessageDialog(null,"Queue Overflow.");
			return;
		}
		q[++rear]=val;
	}

	public String delq(){
		if(isEmpty()){
			JOptionPane.showMessageDialog(null,"Queue Underflow.");
			return null;
		}
		return q[++front];
	}

        public String frontq(){
		if(isEmpty()){
			JOptionPane.showMessageDialog(null,"Queue Underflow.");
			return null;
		}
		return q[front+1];
	}

        public String rearq(){
		if(isEmpty()){
			JOptionPane.showMessageDialog(null,"Queue Underflow.");
			return null;
		}
		return q[rear];
	}

	public int getFront(){
		return front;
	}

	public int getRear(){
		return rear;
	}

	public String[] getElements(){
		return q;
	}
}

class QueuePanel extends JPanel{
	private QueueImpl queue;

	public QueuePanel(QueueImpl que){
		queue = que;
	}

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		int w = getWidth();
		int cw = w/(queue.MAX+1) - 10;
		for(int i=0;i<queue.MAX;i++){
			g.drawRect(i*cw+cw,20,cw,70);
		}
		g.drawString("Front",queue.getFront()*cw+cw+5,105);
		g.drawString("Rear",queue.getRear()*cw+cw+5,120);
		
		String elements[]=queue.getElements();
		for(int i=queue.getFront()+1;i<=queue.getRear();i++){
			g.drawString(elements[i],i*cw+cw+5,45);
		}		
	}
}

class Queue extends JFrame{
	private JButton btnAdd,btnDel,btnFront,btnRear,btnClose;
	private JPanel panDown;
	private QueuePanel panUp;
 	private QueueImpl qs;

	public Queue(){
		btnAdd = new JButton("Add");
		btnDel = new JButton("Delete");
		btnFront = new JButton("Front");
		btnRear = new JButton("Rear");
		btnClose = new JButton("Close");

		panDown = new JPanel();
		panDown.setLayout(new GridLayout(1,5));
		panDown.add(btnAdd);
		panDown.add(btnDel);
		panDown.add(btnFront);
		panDown.add(btnRear);
		panDown.add(btnClose);

		qs = new QueueImpl();
		panUp = new QueuePanel(qs);

		setTitle("Queue Implementation");
		setSize(800,300);
		add(panUp,"Center");
		add(panDown,"South");
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		ButtonHandler bh = new ButtonHandler();
		btnAdd.addActionListener(bh);
		btnDel.addActionListener(bh);
		btnFront.addActionListener(bh);
		btnRear.addActionListener(bh);
		btnClose.addActionListener(bh);
	}

	class ButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent ae){
			if(ae.getSource()==btnAdd){
				String val = JOptionPane.showInputDialog(
						"Enter value:");
				qs.addq(val);
			}
			if(ae.getSource()==btnDel){
				String val = qs.delq();
				if(val!=null)
					JOptionPane.showMessageDialog(
					null,"Deleted element:"+val);
			}
			if(ae.getSource()==btnFront){
				String val = qs.frontq();
				if(val!=null)
					JOptionPane.showMessageDialog(
					null,"Front element:"+val);
			}
			if(ae.getSource()==btnRear){
				String val = qs.rearq();
				if(val!=null)
					JOptionPane.showMessageDialog(
					null,"Rear element:"+val);
			}
			if(ae.getSource()==btnClose){
				dispose();
			}
			panUp.repaint();
		}
	}

	public static void main(String args[]){
		new Queue();
	}
}
	
		
			

			
			

			

			

		
	












		

