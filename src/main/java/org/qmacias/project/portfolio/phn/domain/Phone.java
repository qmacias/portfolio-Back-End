package org.qmacias.project.portfolio.phn.domain;

import javax.persistence.*;

import com.google.common.base.Objects;

import java.util.StringJoiner;

import static com.google.common.base.Preconditions.checkNotNull;

@Entity
public class Phone implements java.io.Serializable {

    static final long serialVersionUID = 6208406100133839657L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String number;

    protected Phone() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        checkNotNull(type);
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        checkNotNull(number);
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Phone phone = (Phone) o;
        return Objects.equal(id, phone.id) && Objects.equal(type, phone.type) && Objects.equal(number, phone.number);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, type, number);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Phone.class.getSimpleName() + "[", "]")
                .add("id=" + id).add("type='" + type + "'").add("number='" + number + "'").toString();
    }

}
