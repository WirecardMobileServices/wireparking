package domainn;

import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.Table;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="users", catalog = "wireparking")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "fname")
    @NotNull
    private String firstName;

    @Column(name = "lname")
    @NotNull
    private String lastName;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)

    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)

    private Date updatedAt;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_car")
    private Cars cars;

    public Users(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
