package searching;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public final class MainFrame extends JFrame {
    protected JButton buttonAdd = new JButton("Add any");
    protected JButton buttonSearch = new JButton("Search Persons");
    protected JButton buttonSort = new JButton("Sort Persons");
 
    protected JList<Person> listPerson = new JList<>();
    protected CustomListModel<Person> listModel;
    protected java.util.List<Person> persons = new ArrayList<>();
 
    public MainFrame() {
        super("Adding, Searching & Sorting");
        initComponents();
        setSize(600, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    protected void initComponents() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JPanel panelButton = new JPanel();
        panelButton.setLayout(new FlowLayout(FlowLayout.CENTER));
 
        buttonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                addPerson();
            }
        });
 
        buttonSort.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                sortPersons();
            }
        });
 
        buttonSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                searchPersons();
            }
        });
 
        panelButton.add(buttonAdd);
        panelButton.add(buttonSearch);
        panelButton.add(buttonSort);
 
        add(panelButton);
 
        listPerson.setPreferredSize(new Dimension(400, 200));
 
        listModel = new CustomListModel<Person>(persons);
        listPerson.setModel(listModel);
 
       //listModel.addElement(new Person("Mostafijur Rahman"));
 
        add(listPerson);
    }
 
    private void addPerson() {
        String personName = JOptionPane.showInputDialog(this, "Enter person name");
        if (personName != null) {
            listModel.addElement(new Person(personName));
        }
        else{
             JOptionPane.showMessageDialog(this,"Please Enter something");
        }
    }
 
    private void sortPersons() {
        Collections.sort(persons);
        listModel.fireDataChanged();
    }
 
    private void searchPersons() {
        String personName = JOptionPane.showInputDialog(this, "Enter person name to search for:");
 
        if (personName == null) {          
            return;
        } 
        //Collections.sort(persons);
        int foundIndex = Collections.binarySearch(persons, new Person(personName));
        if (foundIndex >= 0) {
            listPerson.setSelectedIndex(foundIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Could not find the person " + personName);
        }
    }
     public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
                
            }
        });
    }
}
