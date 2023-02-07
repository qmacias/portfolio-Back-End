package org.qmacias.project.portfolio.adr.domain;

import javax.persistence.*;

import com.google.common.base.Objects;

import java.util.StringJoiner;

import static com.google.common.base.Preconditions.checkNotNull;

@Entity
@Table(name = "ADDRESS")
public class Address implements java.io.Serializable {

    static final long serialVersionUID = 6695605875978266773L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String description;

    protected Address() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        checkNotNull(description);
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return Objects.equal(id, address.id) && Objects.equal(type, address.type) && Objects.equal(description, address.description);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, type, description);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Address.class.getSimpleName() + "[", "]")
                .add("id=" + id).add("type='" + type + "'").add("description='" + description + "'").toString();
    }

}
