package org.qmacias.project.portfolio.prof.domain;

import javax.persistence.*;

import com.google.common.base.Objects;

import java.sql.Date;
import java.time.LocalDate;
import java.util.StringJoiner;

import static com.google.common.base.Preconditions.checkNotNull;

@Entity
public class Profile implements java.io.Serializable {

    static final long serialVersionUID = 354181930931902258L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date birthdate;

    private String summary;

    protected Profile() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdateStr) {
        checkNotNull(birthdateStr);
        this.birthdate = Date.valueOf(LocalDate.parse(birthdateStr));
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        checkNotNull(summary);
        this.summary = summary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Profile profile = (Profile) o;
        return Objects.equal(id, profile.id) && Objects.equal(birthdate, profile.birthdate) && Objects.equal(summary, profile.summary);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, birthdate, summary);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Profile.class.getSimpleName() + "[", "]")
                .add("id=" + id).add("birthdate=" + birthdate).add("summary='" + summary + "'").toString();
    }

}
