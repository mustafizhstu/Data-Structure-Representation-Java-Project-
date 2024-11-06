
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import searching.MainFrame;

class Welcome extends JFrame {

    private JButton btnBubble, btnInsertion, btnSelection,btnQueue,
            btnStack, btnList, btnRadix, btnsearch, btntowerofhanoi;
    public Welcome() {
        btnsearch = new JButton("Adding & Searching");
        btnQueue = new JButton("Queue");
        btnStack = new JButton("Stack");
        btnList = new JButton("Linked List");
        btnBubble = new JButton("Bubble Sort");
        btnRadix = new JButton("Radix Sort");
        btnInsertion = new JButton("Insertion Sort");
        btnSelection = new JButton("Selection Sort");
        btntowerofhanoi = new JButton("Towers of Hanoi");
        setTitle("Visual Representation of Data Structure ");
        setSize(500, 450);
        setLocation(400, 200);
        setLayout(new GridLayout(10, 2));
        Color c = new Color(0, 30, 240);
        setBackground(c);
        add(btnsearch);
        add(btnList);
        add(btnStack);
        add(btnQueue);
        add(btnBubble);
        add(btnRadix);
        add(btnInsertion);
        add(btnSelection);
        add(btntowerofhanoi);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ButtonHandler bh = new ButtonHandler();
        btnBubble.addActionListener(bh);
        btnInsertion.addActionListener(bh);
        btnSelection.addActionListener(bh);
        btnStack.addActionListener(bh);
        btnQueue.addActionListener(bh);
        btnList.addActionListener(bh);
        btnRadix.addActionListener(bh);
        btnsearch.addActionListener(bh);
        btntowerofhanoi.addActionListener(bh);
        // btnbst.addActionListener(bh);
    }

    class ButtonHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == btnBubble) {
                new BubbleSort();
            }
            if (ae.getSource() == btnInsertion) {
                new InsertionSort();
            }
            if (ae.getSource() == btnSelection) {
                new SelectionSort();
            }
            if (ae.getSource() == btnStack) {
                new Stack();
            }
            if (ae.getSource() == btnQueue) {
                new Queue();
            }
            if (ae.getSource() == btnList) {
                new LinkedList();
            }
            if (ae.getSource() == btnRadix) {
                new RadixSort();
            }
            if (ae.getSource() == btnsearch) {
                new MainFrame().setVisible(true);
            }
            if (ae.getSource() == btntowerofhanoi) {
                new TowerOfHanoi().setVisible(true);
            }
        }
    }
    public static void main(String args[]) {
        new SplashScreen();
    }
}
