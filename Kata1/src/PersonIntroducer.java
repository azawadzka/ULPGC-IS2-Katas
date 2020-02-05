public class PersonIntroducer {

    public String introduce(Person p) {
        return "Hello! My name is " + p.getName() + " " + p.getSurname() + " and I work in " + p.getDepartament() + ".";
    }

}
