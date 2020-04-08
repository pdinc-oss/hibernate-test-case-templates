package us.pdinc.products.cresaptown.ds.beans.db.frontend;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * Copyright 2020 PD Inc. Rights given to Hibernate project and forks for testing purposes.
 *
 */

@Entity
@Table(/*schema = "cresaptown", */name = "profile")
public class Profile implements Comparable<Profile>
{
    protected Long id;

	String name;
	String email;
    /*
    Collection<Identity> identities;
    */
    /*PersonRole*/ String cmisPersonRole;

    @Override
    public int compareTo(Profile other)
    {
        if (this == other) return 0;
        if (other == null) return 1;
        if (email == null)
        {
            if (other.email == null) return 0;
            return -1;
        }
        else
            return email.compareTo(other.getEmail());
    }

    public Profile()
    {
    }

    public String getName()
    {
        return this.name;
    }

    public String getEmail()
    {
        return this.email;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public void setEmail(final String email)
    {
        this.email = email;
    }

    /*
    public void setIdentities(final Collection<Identity> identities)
    {
        this.identities = identities;
    }
    */
    public void setCmisPersonRole(final /*PersonRole*/ String cmisPersonRole)
    {
        this.cmisPersonRole = cmisPersonRole;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o)
    {
        if (o == this) return true;
        if (!(o instanceof Profile)) return false;
        final Profile other = (Profile) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$id = this.getId();
        final java.lang.Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final java.lang.Object this$name = this.getName();
        final java.lang.Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final java.lang.Object this$email = this.getEmail();
        final java.lang.Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final java.lang.Object this$cmisPersonRole = this.getCmisPersonRole();
        final java.lang.Object other$cmisPersonRole = other.getCmisPersonRole();
        if (this$cmisPersonRole == null ? other$cmisPersonRole != null : !this$cmisPersonRole.equals(other$cmisPersonRole)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other)
    {
        return other instanceof Profile;
    }

    @java.lang.Override
    public int hashCode()
    {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final java.lang.Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final java.lang.Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        /*
        final java.lang.Object $identities = this.getIdentities();
        result = result * PRIME + ($identities == null ? 43 : $identities.hashCode());
        */
        final java.lang.Object $cmisPersonRole = this.getCmisPersonRole();
        result = result * PRIME + ($cmisPersonRole == null ? 43 : $cmisPersonRole.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString()
    {
        return "Profile(id=" + this.getId() + ", name=" + this.getName() + ", email=" + this.getEmail() /*+ ", identities=" + this.getIdentities()*/
                + ", cmisPersonRole=" + this.getCmisPersonRole() + ")";
    }

    @Id
    @GeneratedValue
    public Long getId()
    {
        return this.id;
    }

    /*
    @OneToMany(mappedBy = "profile")
    public Collection<Identity> getIdentities()
    {
        return this.identities;
    }
    */
    /*
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cmis_personrole_id")
    */
    public /*PersonRole*/ String getCmisPersonRole()
    {
        return this.cmisPersonRole;
    }
}
