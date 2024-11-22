package model.DTO;

public class PeopleDTO {
    private String name;
    private String email;
    private String address;
    private String gender;
    private String birthday;
    private String group;

    public PeopleDTO(String name, String email, String address, String gender, String birthday, String group) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.gender = gender;
        this.birthday = birthday;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return "PeopleDTO{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday='" + birthday + '\'' +
                ", group='" + group + '\'' +
                '}';
    }
}
