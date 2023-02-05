package org.qmacias.project.portfolio.job.domain;

import org.qmacias.project.portfolio.skill.domain.SkillItem;

import javax.persistence.*;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.sql.Date;
import java.util.List;
import java.time.LocalDate;
import java.util.StringJoiner;

import static com.google.common.base.Preconditions.checkNotNull;

@Entity
public class Job implements java.io.Serializable {

    static final long serialVersionUID = 8966835232201131866L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String position;

    private Date start;

    private Date finish;

    private String description;

    @ManyToMany(fetch = FetchType.EAGER, cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "JOB_SKILLS",
            joinColumns= @JoinColumn(name ="JOB_ID"),
            inverseJoinColumns=@JoinColumn(name="SKILL_ID")
    )
    private List<SkillItem> skillItems = Lists.newLinkedList();

    public Job addSkillItem(final SkillItem skillItem) {
        checkNotNull(skillItem);
        skillItems.add(skillItem);
        return this;
    }

    public Job removeSkillItem(final SkillItem skillItem) {
        checkNotNull(skillItem);
        skillItems.remove(skillItem);
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        checkNotNull(position);
        this.position = position;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(String startStr) {
        checkNotNull(startStr);
        this.start = Date.valueOf(LocalDate.parse(startStr));
    }

    public Date getFinish() {
        return finish;
    }

    public void setFinish(String finishStr) {
        this.finish = finishStr == null ? Date.valueOf(LocalDate.now()) : Date.valueOf(LocalDate.parse(finishStr));
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        checkNotNull(description);
        this.description = description;
    }

    public List<SkillItem> getSkillItems() {
        return skillItems;
    }

    public void setSkillItems(List<SkillItem> skillItems) {
        this.skillItems = skillItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Job job = (Job) o;
        return Objects.equal(id, job.id) && Objects.equal(start, job.start) && Objects.equal(finish, job.finish) && Objects.equal(description, job.description) && Objects.equal(skillItems, job.skillItems);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, start, finish, description, skillItems);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Job.class.getSimpleName() + "[", "]")
                .add("id=" + id).add("start=" + start).add("finish=" + finish).add("description='" + description + "'").add("skillItems=" + skillItems).toString();
    }

}
