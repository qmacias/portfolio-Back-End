package org.qmacias.project.portfolio.soc.domain;

import javax.persistence.*;

import com.google.common.base.Objects;

import java.util.StringJoiner;

import static com.google.common.base.Preconditions.checkNotNull;

@Entity
public class Social implements java.io.Serializable {

    static final long serialVersionUID = -4252317219321089754L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String path;

    protected Social() {
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        checkNotNull(path);
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Social social = (Social) o;
        return Objects.equal(id, social.id) && Objects.equal(type, social.type) && Objects.equal(path, social.path);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, type, path);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Social.class.getSimpleName() + "[", "]")
                .add("id=" + id).add("type='" + type + "'").add("path='" + path + "'").toString();
    }

}
