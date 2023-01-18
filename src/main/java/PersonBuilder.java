public class PersonBuilder {
    protected String name;
    protected String surname;
    protected Integer age;
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("Некорректно задан возраст. Был указан возраст " + age + " лет.");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() throws IllegalStateException {
        if (this.name == null || this.surname == null) {
            throw new IllegalStateException("Не указано имя и/или фамилия для создаваемого объекта человека");
        }

        Person person;

        if (this.age != null) {
            person = new Person(this.name, this.surname, this.age);
        } else {
            person = new Person(this.name, this.surname);
        }

        if (this.address != null) {
            person.setAddress(this.address);
        }

        return person;
    }
}