import java.sql.*;

class Database {
    private String URL;
    private Connection connection = null;

    public Database(String URL) {
        this.URL = URL;
    }

    public static void main(String[] args) {
        Database database = new Database("jdbc:sqlite:database.db");
        database.open();

        Person p = new Person("John", "Smith", "Test");

        database.selectPeople();
        database.addPerson(p);
        database.selectPeople();
    }

    public void open() {
        try {
            this.connection = DriverManager.getConnection(this.URL);
            System.out.println("Database open.");
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
            System.out.println("Database closed.");
        }
        catch (SQLException exception) {
            System.out.println("ERROR DataBase::close (SQLException)");
        }
    }

    public void selectPeople() {
        String select = "SELECT * FROM STAFF";
        try {
            Statement statement = this.connection.createStatement();
            ResultSet resultset = statement.executeQuery(select);
            System.out.println("ID \t NAME \t SURNAME \t DEPARTAMENT");
            while (resultset.next()) {
                System.out.println(resultset.getInt("ID") + " \t" +
                        resultset.getString("name") + " \t"  +
                        resultset.getString("surname") + " \t"  +
                        resultset.getString("departament") + " \t"
                );
            }
        }
        catch (SQLException exception) {
            System.out.println("ERROR DataBase::select (SQLExecute)");
        }
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
}
