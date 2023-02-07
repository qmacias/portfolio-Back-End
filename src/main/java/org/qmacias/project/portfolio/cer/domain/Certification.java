package org.qmacias.project.portfolio.cer.domain;

import javax.persistence.*;

import com.google.common.base.Objects;
import org.qmacias.project.backoffice.cat.domain.Category;
import org.qmacias.project.portfolio.img.domain.Image;

import java.sql.Date;
import java.time.LocalDate;
import java.util.StringJoiner;

import static com.google.common.base.Preconditions.checkNotNull;

@Entity
public class Certification implements java.io.Serializable {

    static final long serialVersionUID = -7018170656001321402L;

    @Id
    private String id;

    private String pathName;

    private String pathUrl;

    private String emitter;

    private Date emission;

    private Integer schedule;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "IMAGE_ID", referencedColumnName = "ID")
    private Image image;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")
    private Category category;

    protected Certification() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        checkNotNull(id);
        this.id = id;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        checkNotNull(pathName);
        this.pathName = pathName;
    }

    public String getPathUrl() {
        return pathUrl;
    }

    public void setPathUrl(String pathUrl) {
        checkNotNull(pathUrl);
        this.pathUrl = pathUrl;
    }

    public String getEmitter() {
        return emitter;
    }

    public void setEmitter(String emitter) {
        checkNotNull(emitter);
        this.emitter = emitter;
    }

    public Date getEmission() {
        return emission;
    }

    public void setEmission(String emissionStr) {
        checkNotNull(emissionStr);
        this.emission = Date.valueOf(LocalDate.parse(emissionStr));
    }

    public Integer getSchedule() {
        return schedule;
    }

    public void setSchedule(Integer schedule) {
        this.schedule = schedule;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Certification that = (Certification) o;
        return Objects.equal(id, that.id) && Objects.equal(pathName, that.pathName) && Objects.equal(pathUrl, that.pathUrl) && Objects.equal(emitter, that.emitter) && Objects.equal(emission, that.emission) && Objects.equal(schedule, that.schedule) && Objects.equal(image, that.image);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, pathName, pathUrl, emitter, emission, schedule, image);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Certification.class.getSimpleName() + "[", "]")
                .add("id='" + id + "'").add("pathName='" + pathName + "'").add("pathUrl='" + pathUrl + "'").add("emitter='" + emitter + "'").add("emission=" + emission).add("schedule='" + schedule + "'").add("image=" + image).toString();
    }

}
