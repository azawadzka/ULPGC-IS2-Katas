public class Person {
    private final String name;
    private final String surname;
    private final String departament;

    public static void main(String[] args) {
        Person p1 = new Person("Rachel", "Greene", "Sales");
        Person p2 = new Person("Monica", "Geller", "Management");
        PersonIntroducer pi = new PersonIntroducer();
        System.out.println(pi.introduce(p1));
        System.out.println(pi.introduce(p2));
    }

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
