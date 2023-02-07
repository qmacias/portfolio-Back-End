package org.qmacias.project.backoffice.mod.domain;

import javax.persistence.*;

import com.google.common.base.Objects;

import java.util.StringJoiner;

import static com.google.common.base.Preconditions.checkNotNull;

@Entity
@Table(name = "MODALITY")
public class Modality {

    static final long serialVersionUID = 4220303882976837670L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    protected Modality() {
    }

    public Modality(final String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        checkNotNull(name);
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Modality modality = (Modality) o;
        return Objects.equal(id, modality.id) && Objects.equal(name, modality.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Modality.class.getSimpleName() + "[", "]")
                .add("id=" + id).add("name='" + name + "'").toString();
    }

}
