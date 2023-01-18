import java.util.Objects;

public class Person {
    protected final String name;
    protected final String surname;
    protected Integer age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, Integer age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public boolean hasAge() {
        return this.age != null;
    }

    public boolean hasAddress() {
        return this.address != null;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (this.hasAge()) {
            this.age++;
        }
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder builder = new PersonBuilder()
                .setAge(0)
                .setSurname(this.surname)
                .setAddress(this.address);
        return builder;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + this.name +
                ", surname=" + this.surname +
                (this.hasAge() ? (", age=" + this.age) : ("")) +
                (this.hasAddress() ? (", address=" + this.address) : ("")) +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !obj.getClass().equals(Person.class)) {
            return false;
        }

        Person altPerson = (Person) obj;

        // Два объекта являются одинаковыми если их имена и фамилии совпадают.
        // Учел только имя и фамилию, так как только эти поля являются final
        return this.name.equals(altPerson.getName()) &&
                this.surname.equals(altPerson.getSurname());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.surname);
    }
}