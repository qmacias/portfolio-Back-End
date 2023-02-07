package org.qmacias.project.portfolio.edu.domain;

import javax.persistence.*;

import com.google.common.base.Objects;

import org.qmacias.project.portfolio.cer.domain.Certification;
import org.qmacias.project.portfolio.img.domain.Image;
import org.qmacias.project.backoffice.cat.domain.Category;
import org.qmacias.project.backoffice.mod.domain.Modality;

import java.sql.Date;
import java.time.LocalDate;
import java.util.StringJoiner;

import static com.google.common.base.Preconditions.checkNotNull;

@Entity
@Table(name = "EDUCATION")
public class Education implements java.io.Serializable {

    static final long serialVersionUID = -7018170656001321402L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IMAGE_ID", referencedColumnName = "ID")
    private Image image;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
    private Category category;

    private String description;

    private String place;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MODALITY_ID", referencedColumnName = "ID")
    private Modality modality;

    private Integer schedule;

    private Date date;

    private Boolean isCertified;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CERTIFICATION_ID", referencedColumnName = "ID")
    private Certification certification;

    protected Education() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        checkNotNull(description);
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        checkNotNull(place);
        this.place = place;
    }

    public Modality getModality() {
        return modality;
    }

    public void setModality(Modality modality) {
        this.modality = modality;
    }

    public Integer getSchedule() {
        return schedule;
    }

    public void setSchedule(Integer schedule) {
        checkNotNull(schedule);
        this.schedule = schedule;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(String dateStr) {
        checkNotNull(dateStr);
        this.date = Date.valueOf(LocalDate.parse(dateStr));
    }

    public Boolean getIsCertified() {
        return isCertified;
    }

    public void setIsCertified(Boolean isCertified) {
        checkNotNull(isCertified);
        this.isCertified = isCertified;
    }

    public Certification getCertification() {
        return certification;
    }

    public void setCertification(Certification certification) {
        this.certification = certification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Education education = (Education) o;
        return Objects.equal(id, education.id) && Objects.equal(image, education.image) && Objects.equal(category, education.category) && Objects.equal(description, education.description) && Objects.equal(place, education.place) && Objects.equal(modality, education.modality) && Objects.equal(schedule, education.schedule) && Objects.equal(date, education.date) && Objects.equal(isCertified, education.isCertified) && Objects.equal(certification, education.certification);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, image, category, description, place, modality, schedule, date, isCertified, certification);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Education.class.getSimpleName() + "[", "]")
                .add("id=" + id).add("image=" + image).add("category=" + category).add("description='" + description + "'").add("place='" + place + "'").add("modality=" + modality).add("schedule=" + schedule).add("date=" + date).add("isCertified=" + isCertified).add("certification=" + certification).toString();
    }

}
