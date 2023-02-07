package org.qmacias.project.portfolio.per.domain;

import javax.persistence.*;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import org.qmacias.project.portfolio.job.domain.Job;
import org.qmacias.project.portfolio.prof.domain.Profile;
import org.qmacias.project.portfolio.proj.domain.Project;

import java.util.List;
import java.util.StringJoiner;

import static com.google.common.base.Preconditions.checkNotNull;

@Entity
@Table(name = "PERSON")
public class Person implements java.io.Serializable {

    static final long serialVersionUID = 6208406100133839657L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String degree;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PROFILE_ID", referencedColumnName = "ID")
    private Profile profile;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "ID")
    private List<Job> jobs = Lists.newLinkedList();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "PERSON_ID", referencedColumnName = "ID")
    private List<Project> projects = Lists.newLinkedList();

    protected Person() {
    }

    public Person addJobItem(final Job job) {
        checkNotNull(job);
        jobs.add(job);
        return this;
    }

    public Person removeJobItem(final Job job) {
        checkNotNull(job);
        jobs.remove(job);
        return this;
    }

    public Person addProjectItem(final Project project) {
        checkNotNull(project);
        projects.add(project);
        return this;
    }

    public Person removeProjectItem(final Project project) {
        checkNotNull(project);
        projects.remove(project);
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        checkNotNull(firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        checkNotNull(lastName);
        this.lastName = lastName;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        checkNotNull(degree);
        this.degree = degree;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        checkNotNull(email);
        this.email = email;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equal(id, person.id) && Objects.equal(firstName, person.firstName) && Objects.equal(lastName, person.lastName) && Objects.equal(degree, person.degree) && Objects.equal(email, person.email) && Objects.equal(profile, person.profile) && Objects.equal(jobs, person.jobs) && Objects.equal(projects, person.projects);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, firstName, lastName, degree, email, profile, jobs, projects);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
                .add("id=" + id).add("firstName='" + firstName + "'").add("lastName='" + lastName + "'").add("degree='" + degree + "'").add("email='" + email + "'").add("profile=" + profile).add("jobs=" + jobs).add("projects=" + projects).toString();
    }

}
