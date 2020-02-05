import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    JButton addButton = new JButton("Add");
    JButton deleteButton = new JButton("Delete");
    JButton statsButton = new JButton("Show statistics");
    JList list = new JList();
    JPanel mainPanel = new JPanel();
    JPanel leftPanel = new JPanel();
    JPanel buttonsGroupPanel = new JPanel();

    public MainWindow() throws HeadlessException {
        super("Staff management");
        setSize(400, 300);
        setResizable(false);
        setComponents();
        this.setVisible(true);
    }

    private void setComponents() {
        list.setFixedCellWidth(200);
        mainPanel.setLayout(new GridLayout(1,2));
        buttonsGroupPanel.setLayout(new GridLayout(3,1));

        this.add(mainPanel);
        mainPanel.add(leftPanel);
        mainPanel.add(list);

        leftPanel.add(buttonsGroupPanel);

        buttonsGroupPanel.add(addButton);
        buttonsGroupPanel.add(deleteButton);
        buttonsGroupPanel.add(statsButton);
    }

    public void setListenerAddButton(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void setListenerDeleteButton(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }

    public void setListenerShowButton(ActionListener listener) {
        statsButton.addActionListener(listener);
    }

    public void refreshComboBox(Person[] people) {
        list.setListData(people);
    }

    public Person getSelectedPerson() {
        return (Person) list.getSelectedValue();
    }
}
