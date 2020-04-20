package us.pdinc.products.cresaptown.ds.beans.db.int1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import us.pdinc.products.cresaptown.ds.beans.db.frontend.Profile;

/**
*
* Copyright 2020 PD Inc. Rights given to Hibernate project and forks for testing purposes.
*
*/
@Entity
@Table(/*schema = "dbo", */name = "person_role")
public class PersonRole
{
    Long roleId;
    /*
    Person person;
    */
    String email1;
    /*
    String email2;

    Date added;
    Date modified;

    Set<PocGroupMembership> group;

    String phoneWork;

    ServiceCode serviceCode;

    String prefTitle;

    Grade grade;

    Location location;

    String room;

    Office office;

    Person supervisor;
    */
    Profile profile;

    /*
    Collection<Investigation> investigations;

    Collection<VisitAuthorizationRequest> visitAuthorizationRequest;

    Collection<IdmX509DN> distinguishedNames;

    @Override
    public String toString()
    {
        return "PersonRole [roleId=" + roleId + (person == null ? ", person=null" : ", person.personId=" + person.getPersonId()) + ", email1=" + email1
                + (profile == null ? ", profile=null" : ", profile.id=" + profile.getId()) + "]";
    }
    */
    public PersonRole()
    {
    }

    /*
    public Date getAdded()
    {
        return this.added;
    }

    public Date getModified()
    {
        return this.modified;
    }

    public String getRoom()
    {
        return this.room;
    }
    */
    public void setRoleId(final Long roleId)
    {
        this.roleId = roleId;
    }

    /*
    public void setPerson(final Person person)
    {
        this.person = person;
    }
    */
    public void setEmail1(final String email1)
    {
        this.email1 = email1;
    }

    /*
    public void setEmail2(final String email2)
    {
        this.email2 = email2;
    }

    public void setAdded(final Date added)
    {
        this.added = added;
    }

    public void setModified(final Date modified)
    {
        this.modified = modified;
    }

    public void setGroup(final Set<PocGroupMembership> group)
    {
        this.group = group;
    }

    public void setPhoneWork(final String phoneWork)
    {
        this.phoneWork = phoneWork;
    }

    public void setServiceCode(final ServiceCode serviceCode)
    {
        this.serviceCode = serviceCode;
    }

    public void setPrefTitle(final String prefTitle)
    {
        this.prefTitle = prefTitle;
    }

    public void setGrade(final Grade grade)
    {
        this.grade = grade;
    }

    public void setLocation(final Location location)
    {
        this.location = location;
    }

    public void setRoom(final String room)
    {
        this.room = room;
    }

    public void setOffice(final Office office)
    {
        this.office = office;
    }

    public void setSupervisor(final Person supervisor)
    {
        this.supervisor = supervisor;
    }
    */
    public void setProfile(final Profile profile)
    {
        this.profile = profile;
    }

    /*
    public void setInvestigations(final Collection<Investigation> investigations)
    {
        this.investigations = investigations;
    }

    public void setVisitAuthorizationRequest(final Collection<VisitAuthorizationRequest> visitAuthorizationRequest)
    {
        this.visitAuthorizationRequest = visitAuthorizationRequest;
    }

    public void setDistinguishedNames(final Collection<IdmX509DN> distinguishedNames)
    {
        this.distinguishedNames = distinguishedNames;
    }
    */
    @java.lang.Override
    public boolean equals(final java.lang.Object o)
    {
        if (o == this) return true;
        if (!(o instanceof PersonRole)) return false;
        final PersonRole other = (PersonRole) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$roleId = this.getRoleId();
        if (roleId==null) return false;
        final java.lang.Object other$roleId = other.getRoleId();
        if (this$roleId == null ? other$roleId != null : !this$roleId.equals(other$roleId)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other)
    {
        return other instanceof PersonRole;
    }

    @java.lang.Override
    public int hashCode()
    {
        if (roleId==null) return super.hashCode();
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $roleId = this.getRoleId();
        result = result * PRIME + ($roleId == null ? 43 : $roleId.hashCode());
        return result;
    }

    @Id
    @Column(name = "roleid")
    @GeneratedValue
    public Long getRoleId()
    {
        return this.roleId;
    }

    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "personid")
    public Person getPerson()
    {
        return this.person;
    }
    */
    @Column(name = "email1")
    public String getEmail1()
    {
        return this.email1;
    }

    /*
    @Column(name = "email2")
    public String getEmail2()
    {
        return this.email2;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    public Set<PocGroupMembership> getGroup()
    {
        return this.group;
    }

    @Column(name = "phone_work")
    public String getPhoneWork()
    {
        return this.phoneWork;
    }

    @ManyToOne
    @JoinColumn(name = "serviceid")
    public ServiceCode getServiceCode()
    {
        return this.serviceCode;
    }

    @JoinColumn(name = "preftitle")
    public String getPrefTitle()
    {
        return this.prefTitle;
    }

    @ManyToOne
    @JoinColumn(name = "gradeid")
    public Grade getGrade()
    {
        return this.grade;
    }

    @ManyToOne
    @JoinColumn(name = "locationid")
    public Location getLocation()
    {
        return this.location;
    }

    @ManyToOne
    @JoinColumn(name = "officeid")
    public Office getOffice()
    {
        return this.office;
    }

    @ManyToOne
    @JoinColumn(name = "supervisorid")
    public Person getSupervisor()
    {
        return this.supervisor;
    }
    */
    @OneToOne(mappedBy = "cmisPersonRole", fetch = FetchType.LAZY, optional = true)
    public Profile getProfile()
    {
        return this.profile;
    }
    /*
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "personRole")
    @OrderBy("dateOfInvestigation DESC")
    public Collection<Investigation> getInvestigations()
    {
        return this.investigations;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "roleId")
    @OrderBy("varExp DESC")
    public Collection<VisitAuthorizationRequest> getVisitAuthorizationRequest()
    {
        return this.visitAuthorizationRequest;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "dbo.PLS_PERSON_ROLE_X509_MAP", joinColumns = @JoinColumn(name = "roleid"), inverseJoinColumns = @JoinColumn(name = "x509dnid"))
    public Collection<IdmX509DN> getDistinguishedNames()
    {
        return this.distinguishedNames;
    }
    */
}
