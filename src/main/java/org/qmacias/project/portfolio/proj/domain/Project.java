package org.qmacias.project.portfolio.proj.domain;

import org.qmacias.project.portfolio.img.domain.Image;
import org.qmacias.project.backoffice.skill.domain.Skill;

import javax.persistence.*;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.sql.Date;
import java.util.List;
import java.time.LocalDate;
import java.util.StringJoiner;

import static com.google.common.base.Preconditions.checkNotNull;

@Entity
@Table(name = "PROJECT")
public class Project implements java.io.Serializable {

    static final long serialVersionUID = -8489749526995263068L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Date release;

    private String description;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "IMAGE_ID", referencedColumnName = "ID")
    private Image image;

    @ManyToMany(fetch = FetchType.EAGER, cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "PROJECT_SKILLS",
            joinColumns= @JoinColumn(name ="PROJECT_ID"),
            inverseJoinColumns=@JoinColumn(name="SKILL_ID")
    )
    private List<Skill> skills = Lists.newLinkedList();

    protected Project() {
    }

    public Project addSkillItem(final Skill skill) {
        checkNotNull(skill);
        skills.add(skill);
        return this;
    }

    public Project removeSkillItem(final Skill skill) {
        checkNotNull(skill);
        skills.remove(skill);
        return this;
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

    public Date getRelease() {
        return release;
    }

    public void setRelease(String releaseStr) {
        checkNotNull(releaseStr);
        this.release = Date.valueOf(LocalDate.parse(releaseStr));
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        checkNotNull(description);
        this.description = description;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Project project = (Project) o;
        return Objects.equal(id, project.id) && Objects.equal(name, project.name) && Objects.equal(release, project.release) && Objects.equal(description, project.description) && Objects.equal(image, project.image) && Objects.equal(skills, project.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, release, description, image, skills);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Project.class.getSimpleName() + "[", "]")
                .add("id=" + id).add("name='" + name + "'").add("release=" + release).add("description='" + description + "'").add("image=" + image).add("skills=" + skills).toString();
    }

}