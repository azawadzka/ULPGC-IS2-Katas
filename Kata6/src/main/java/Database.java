import java.sql.*;
import java.util.ArrayList;

class Database {
    private String URL;
    private Connection connection = null;

    public Database(String URL){
        this.URL = URL;
    }

    void open() {
        try {
            this.connection = DriverManager.getConnection(this.URL);
            System.out.println("Database opened");
        }
        catch (SQLException ex) {
            System.out.println("ERROR DataBase::open (SQLException)");
            ex.printStackTrace();
        }
    }

    public void close() {
        try {
            if(this.connection != null)
                this.connection.close();
            System.out.println("Database closed");
        }
        catch (SQLException exception) {
            System.out.println("ERROR DataBase::close (SQLException)");
        }
    }

    public Person[] selectPeople() {
        String select = "SELECT * FROM STAFF";
        ArrayList<Person> list = new ArrayList<Person>();
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultset = statement.executeQuery(select);
            while (resultset.next()) {
                list.add(new Person(
                        resultset.getString("name"),
                        resultset.getString("surname"),
                        resultset.getString("departament")
                ));
            }
        }
        catch (SQLException ex) {
            System.out.println("ERROR DataBase::select (SQLExecute)");
            ex.printStackTrace();
        }
        return list.toArray(new Person[0]);
    }

    public void addPerson(Person person) {
        String SQL = "INSERT INTO STAFF(NAME, SURNAME, DEPARTAMENT) VALUES(?,?,?)";
        try {
            PreparedStatement preparedstatement = this.connection.prepareStatement(SQL);
            preparedstatement.setString(1, person.getName());
            preparedstatement.setString(2, person.getSurname());
            preparedstatement.setString(3, person.getDepartament());
            preparedstatement.executeUpdate();
        }
        catch(SQLException exception) {
            System.out.println("ERROR DataBase::insertPeople" + exception.getMessage());
        }
    }

    public void deletePerson(Person person) {
        String SQL = "DELETE FROM STAFF WHERE NAME = ? AND SURNAME = ? AND DEPARTAMENT = ?";
        try {
            PreparedStatement preparedstatement = this.connection.prepareStatement(SQL);
            preparedstatement.setString(1, person.getName());
            preparedstatement.setString(2, person.getSurname());
            preparedstatement.setString(3, person.getDepartament());
            preparedstatement.executeUpdate();
        }
        catch(SQLException ex) {
            System.out.println("ERROR DataBase::insertPeople" + ex.getMessage());
            ex.printStackTrace();
        }
    }
}
