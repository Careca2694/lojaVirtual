package model.entities;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class Client {

    private Integer id;
    private String name;
    private Integer contact;
    private String location;
    private Date birthDay;

    public Client(){}

    public Client(Integer id, String name, Integer contact, String location, Date birthDay) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.location = location;
        this.birthDay = birthDay;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact=" + contact +
                ", location='" + location + '\'' +
                ", birthDay=" + birthDay +
                '}';
    }
}
