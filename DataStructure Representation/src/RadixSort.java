import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
class RadixSort extends JFrame{
        private RadixSortPanel radixSortPanel = new RadixSortPanel();
	JButton b1 = new JButton("Step");
        JButton b2 = new JButton("Reset");
	public RadixSort(){
                add(radixSortPanel, BorderLayout.CENTER);
                JPanel pane = new JPanel();
                pane.add(b1);
                pane.add(b2);
                add(pane, BorderLayout.SOUTH);
		setTitle("Radix Sort");
		setSize(960, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE   );
                 b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                radixSortPanel.nextStep();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                radixSortPanel.reset();
                b1.setEnabled(true);
            }
        });

	}
    class RadixSortPanel extends JPanel {
        private static final long serialVersionUID = 1L;
        private int numInts = 20;
        private int maxNum = 1000;
        private int order = 1;
        private boolean isCycle = false;
        private int iCycle = 0;
        private ArrayList<Integer>[] bucket;
        int lastNumberCol = 0;
        ArrayList<Integer> numbers = new ArrayList<>();

        public RadixSortPanel() {
            reset();
        }

        public void nextStep() {
            if (!isCycle) {
                bucket = new ArrayList[10];
                for (int i = 0; i < bucket.length; i++) {
                    bucket[i] = new java.util.ArrayList<>();
                }
                isCycle = true;
                iCycle = 0;
            }

            if (isCycle) {
                bucket[(numbers.get(iCycle) / order) % 10].add(numbers.get(iCycle));
                lastNumberCol = (numbers.get(iCycle) / order) % 10;
                iCycle++;
                if (iCycle >= numbers.size()) {
                    isCycle = false;
                }
            }

            if (isCycle == false) {
                int k = 0;
                for (int i = 0; i < bucket.length; i++) {
                    if (bucket[i] != null) {
                        for (int j = 0; j < bucket[i].size(); j++) {
                            numbers.set(k++, bucket[i].get(j));
                        }
                    }
                }
                order *= 10;
                if (order >= maxNum) {
                    b1.setEnabled(false);
                    order = 1;
                }
                bucket = null;
            }
            repaint();
        }

        public void reset() {
            numbers.clear();
            for (int i = 1; i <= numInts; i++) {
                numbers.add((int) (Math.random() * maxNum));
            }
            order = 1;
            isCycle = false;
            iCycle = 0;
            bucket = null;
            lastNumberCol = 0;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            int numberWidth = getWidth() / (numInts + 2);
            int numberHeight = 20;
            for (int i = 0; i < numInts; i++) {
                g.drawRect(numberWidth * (i + 1), 20, numberWidth, numberHeight);
                g.drawString(numbers.get(i) + "", numberWidth * (i + 1) + 5, 35);
            }

            int columns = 10;
            int columnWidth = getWidth() / columns;
            int columnHeight = getHeight() - 80;
            for (int index = 0; index < columns; index++) {
                g.drawRect(columnWidth * index + 10, 60, columnWidth - 20, columnHeight);
                if (bucket != null) {
                    for (int j = 0; j < bucket[index].size(); j++) {
                        if ((index == lastNumberCol) && (j == bucket[index].size() - 1)) {
                            g.setColor(Color.RED);
                        }
                        g.drawString(bucket[index].get(j) + "", columnWidth * index + 20, 90 + j * 20);
                        if ((index == lastNumberCol) && (j == bucket[index].size() - 1)) {
                            g.setColor(Color.BLACK);
                        }
                    }
                }
            }
        }
    }

	public static void main(String args[]){
             new RadixSort();
	}
}