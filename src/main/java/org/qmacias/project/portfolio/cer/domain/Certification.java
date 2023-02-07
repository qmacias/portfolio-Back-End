package org.qmacias.project.portfolio.cer.domain;

import javax.persistence.*;

import com.google.common.base.Objects;

import java.util.StringJoiner;

import static com.google.common.base.Preconditions.checkNotNull;

@Entity
@Table(name = "CERTIFICATION")
public class Certification implements java.io.Serializable {

    static final long serialVersionUID = 2544088736420074813L;

    @Id
    private String id;

    private String url;

    protected Certification() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        checkNotNull(id);
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        checkNotNull(url);
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Certification that = (Certification) o;
        return Objects.equal(id, that.id) && Objects.equal(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, url);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Certification.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'").add("url='" + url + "'").toString();
    }

}
