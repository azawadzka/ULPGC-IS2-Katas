import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddPersonWindow extends JFrame {

    JLabel nameLabel = new JLabel("Name:");
    JLabel surnameLabel = new JLabel("Surname:");
    JLabel depLabel = new JLabel("Departament:");
    JTextField nameField = new JTextField();
    JTextField surnameField = new JTextField();
    JComboBox depCombo = new JComboBox(new String[]{"Sales", "Human Resources", "Data Analysis", "Management", "Consulting", "Accountance"});
    JButton addButton = new JButton("Add");
    JButton cancelButton = new JButton("Cancel");
    JPanel mainPanel = new JPanel();

    public static void main(String[] args) {
        new AddPersonWindow();
    }

    public AddPersonWindow() {
        super("Add person");
        this.setSize(300, 150);
        this.setResizable(false);
        setComponents();
        this.setVisible(true);
    }

    private void setComponents() {
        this.add(mainPanel);

        mainPanel.setLayout(new GridLayout(4,2));
        mainPanel.add(nameLabel);
        mainPanel.add(nameField);
        mainPanel.add(surnameLabel);
        mainPanel.add(surnameField);
        mainPanel.add(depLabel);
        mainPanel.add(depCombo);
        mainPanel.add(addButton);
        mainPanel.add(cancelButton);
    }

    public Person getPerson() throws IncorrectInputException {
        return new Person(
                takeName(),
                takeSurname(),
                takeDepartament()
        );
    }

    private String takeName() throws IncorrectInputException {
        if (nameField.getText().isEmpty()) throw new IncorrectInputException();
        return nameField.getText();
    }

    private String takeSurname() throws IncorrectInputException {
        if (surnameField.getText().isEmpty()) throw new IncorrectInputException();
        return surnameField.getText();
    }

    private String takeDepartament() {
        return depCombo.getSelectedItem().toString();
    }


    public void setListenerPersonButton(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void setListenerCancelButton(ActionListener listener) {
        cancelButton.addActionListener(listener);
    }

    public void handleIncorrectInput() {
        JOptionPane.showMessageDialog(this, "The input is incorrect." , "Error", JOptionPane.ERROR_MESSAGE);
    }
}
