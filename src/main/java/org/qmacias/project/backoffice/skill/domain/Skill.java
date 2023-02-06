package org.qmacias.project.backoffice.skill.domain;

import javax.persistence.*;

import com.google.common.base.Objects;

import java.util.StringJoiner;

import static com.google.common.base.Preconditions.checkNotNull;

@Entity
public class Skill implements java.io.Serializable {

    static final long serialVersionUID = -828339575008398595L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    protected Skill() {
    }

    public Skill(final String name) {
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
        Skill skill = (Skill) o;
        return Objects.equal(id, skill.id) && Objects.equal(name, skill.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Skill.class.getSimpleName() + "[", "]")
                .add("id=" + id).add("name='" + name + "'").toString();
    }

}
