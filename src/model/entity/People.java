package model.entity;

public class People extends Person {
    public People(long phone, String name, String email, String address, String gender, String birthday, String group) {
        super(phone, name, email, address, gender, birthday, group);
    }

    public People(int phone, String name, String email, double v, String gender) {
        super();
    }

    @Override
    public String toString() {
        return "People{}";
    }
}
