import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Controller {

    public static void main(String[] args) {
        new Controller(new MainWindow(), new Database("jdbc:sqlite:database.db"));
    }

    public Controller(final MainWindow view, final Database database) {

        database.open();
        view.refreshComboBox(database.selectPeople());

        // MainWindow listeners
        view.setListenerAddButton(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // AddPersonWindow listeners// AddPersonWindow listeners
                final AddPersonWindow addWindow = new AddPersonWindow();
                addWindow.setListenerPersonButton(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        try {
                            database.addPerson(addWindow.getPerson());
                            addWindow.setVisible(false);
                            view.refreshComboBox(database.selectPeople());
                        } catch (IncorrectInputException ex) {
                            addWindow.handleIncorrectInput();
                        }
                    }
                });

                addWindow.setListenerCancelButton(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        addWindow.setVisible(false);
                    }
                });
            }
        });

        view.setListenerDeleteButton(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                database.deletePerson(view.getSelectedPerson());
                view.refreshComboBox(database.selectPeople());
            }
        });

        view.setListenerShowButton(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new HistogramDisplay(database.selectPeople());
            }
        });

        view.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(WindowEvent winEvt) {
                database.close();
                System.exit(0);
            }
        });
    }
}
