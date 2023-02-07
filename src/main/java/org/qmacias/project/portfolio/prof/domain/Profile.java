package org.qmacias.project.portfolio.prof.domain;

import javax.persistence.*;

import org.qmacias.project.portfolio.phn.domain.Phone;
import org.qmacias.project.portfolio.soc.domain.Social;
import org.qmacias.project.portfolio.adr.domain.Address;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;

import java.sql.Date;
import java.util.List;
import java.time.LocalDate;
import java.util.StringJoiner;

import static com.google.common.base.Preconditions.checkNotNull;

@Entity
@Table(name = "PROFILE")
public class Profile implements java.io.Serializable {

    static final long serialVersionUID = 354181930931902258L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date birthdate;

    private String summary;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "PROFILE_ID", referencedColumnName = "ID")
    private List<Phone> phoneItems = Lists.newLinkedList();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "PROFILE_ID", referencedColumnName = "ID")
    private List<Social> socialItems = Lists.newLinkedList();

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "PROFILE_ID", referencedColumnName = "ID")
    private List<Address> addressItems = Lists.newLinkedList();

    protected Profile() {
    }

    public Profile addPhoneItem(final Phone phone) {
        checkNotNull(phone);
        phoneItems.add(phone);
        return this;
    }

    public Profile removePhoneItem(final Phone phone) {
        checkNotNull(phone);
        phoneItems.remove(phone);
        return this;
    }

    public Profile addSocialItem(final Social social) {
        checkNotNull(social);
        socialItems.add(social);
        return this;
    }

    public Profile removeSocialItem(final Social social) {
        checkNotNull(social);
        socialItems.remove(social);
        return this;
    }

    public Profile addAddressItem(final Address address) {
        checkNotNull(address);
        addressItems.add(address);
        return this;
    }

    public Profile removeAddressItem(final Address address) {
        checkNotNull(address);
        addressItems.remove(address);
        return this;
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

    public List<Phone> getPhoneItems() {
        return phoneItems;
    }

    public void setPhoneItems(List<Phone> phoneItems) {
        this.phoneItems = phoneItems;
    }

    public List<Social> getSocialItems() {
        return socialItems;
    }

    public void setSocialItems(List<Social> socialItems) {
        this.socialItems = socialItems;
    }

    public List<Address> getAddressItems() {
        return addressItems;
    }

    public void setAddressItems(List<Address> addressItems) {
        this.addressItems = addressItems;
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
        return Objects.equal(id, profile.id) && Objects.equal(birthdate, profile.birthdate) && Objects.equal(summary, profile.summary) && Objects.equal(socialItems, profile.socialItems) && Objects.equal(addressItems, profile.addressItems) && Objects.equal(phoneItems, profile.phoneItems);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, birthdate, summary, socialItems, addressItems, phoneItems);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Profile.class.getSimpleName() + "[", "]")
                .add("id=" + id).add("birthdate=" + birthdate).add("summary='" + summary + "'").add("socialItems=" + socialItems).add("addressItems=" + addressItems).add("phoneItems=" + phoneItems).toString();
    }

}
