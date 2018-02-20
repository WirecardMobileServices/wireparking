package com.example.wire.domain;

import com.example.wire.domain.enums.Salutation;
import com.example.wire.domain.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "SALUTATION")
    private Salutation salutation;

    @NotNull
    @Size(max = 50)
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotNull
    @Size(max = 50)
    @Column(name = "LAST_NAME")
    private String lastName;

    @NotNull
    @Column(name = "MOBILE_NUMBER")
    private String mobileNumber;

    @NotNull
    @Size
    @Column(name = "EMAIL")
    private String email;

    @NotNull
    @Size(max = 100)
    @Column(name = "USERNAME")
    private String username;

    @NotNull
    @Size(min = 8, max = 16)
    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "SECURITY_QUESTION")
    private String securityQuestion;

    @Size(min = 3, max = 255)
    @Column(name = "SECURITY_ANSWER")
    private String securityAnswer;

    @Column(name = "TERM_OF_USE_ACCEPTED")
    private Boolean termsOfUseAccpted;

    @Column(name = "STATUS")
    @Enumerated(EnumType.STRING)
    private Status status;

    // Add User Role

    public User() {

    }

    public User(Salutation salutation, String firstName, String lastName, String mobileNumber, String email, String username, String password, String securityQuestion, String securityAnswer, Boolean termsOfUseAccpted) {
        this.salutation = salutation;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.username = username;
        this.password = password;
        this.securityQuestion = securityQuestion;
        this.securityAnswer = securityAnswer;
        this.termsOfUseAccpted = termsOfUseAccpted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Salutation getSalutation() {
        return salutation;
    }

    public void setSalutation(Salutation salutation) {
        this.salutation = salutation;
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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSecurityQuestion() {
        return securityQuestion;
    }

    public void setSecurityQuestion(String securityQuestion) {
        this.securityQuestion = securityQuestion;
    }

    public String getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(String securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public Boolean getTermsOfUseAccpted() {
        return termsOfUseAccpted;
    }

    public void setTermsOfUseAccpted(Boolean termsOfUseAccpted) {
        this.termsOfUseAccpted = termsOfUseAccpted;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", salutation=" + salutation +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", securityQuestion='" + securityQuestion + '\'' +
                ", securityAnswer='" + securityAnswer + '\'' +
                ", termsOfUseAccpted=" + termsOfUseAccpted +
                ", status=" + status +
                '}';
    }
}
