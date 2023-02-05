package org.qmacias.project.portfolio.img.domain;

import com.google.common.base.Objects;

import javax.persistence.*;

import java.util.StringJoiner;

import static com.google.common.base.Preconditions.checkNotNull;

@Entity
public class Image implements java.io.Serializable {

    static final long serialVersionUID = -2931477247727626623L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String alt;

    protected Image() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        checkNotNull(alt);
        this.alt = alt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Image image = (Image) o;
        return Objects.equal(id, image.id) && Objects.equal(alt, image.alt);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, alt);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Image.class.getSimpleName() + "[", "]")
                .add("id=" + id).add("alt='" + alt + "'").toString();
    }

}
