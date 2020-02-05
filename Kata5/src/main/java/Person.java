public class Person {
    private final String name;
    private final String surname;
    private final String departament;

    public Person(String name, String surname, String departament) {
        this.name = name;
        this.surname = surname;
        this.departament = departament;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDepartament() {
        return departament;
    }
}
