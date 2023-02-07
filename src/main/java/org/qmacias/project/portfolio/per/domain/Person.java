package org.qmacias.project.portfolio.per.domain;

import javax.persistence.*;

import com.google.common.base.Objects;

import java.util.StringJoiner;

import static com.google.common.base.Preconditions.checkNotNull;

@Entity
@Table(name = "PERSON")
public class Person implements java.io.Serializable {

    static final long serialVersionUID = 6208406100133839657L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String degree;

    private String email;

    protected Person() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        checkNotNull(firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        checkNotNull(lastName);
        this.lastName = lastName;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        checkNotNull(degree);
        this.degree = degree;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        checkNotNull(email);
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equal(id, person.id) && Objects.equal(firstName, person.firstName) && Objects.equal(lastName, person.lastName) && Objects.equal(degree, person.degree) && Objects.equal(email, person.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, firstName, lastName, degree, email);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("id=" + id).add("firstName='" + firstName + "'").add("lastName='" + lastName + "'").add("degree='" + degree + "'").add("email='" + email + "'").toString();
    }

}
