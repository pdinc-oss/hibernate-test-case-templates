package us.pdinc.products.cresaptown.ds.beans.db.approval;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import us.pdinc.products.cresaptown.ds.beans.db.frontend.Profile;

/**
 *
 * Copyright 2020 PD Inc. Rights given to Hibernate project and forks for testing purposes.
 *
 */
@Entity
@Table(/*schema = "cresaptown", */name = "routing")
public class Routing
{
    Long id;

    /*Signature*/ String signature;

    /**
     * Refers to who the email is being sent to
     */
    Profile profile;

    /*RoutingType*/ String typeFlag;

    String message;

    public Routing()
    {
    }

    @Lob
    public String getMessage()
    {
        return this.message;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public void setSignature(final /*Signature*/ String signature)
    {
        this.signature = signature;
    }

    /**
     * Refers to who the email is being sent to
     */
    public void setProfile(final Profile profile)
    {
        this.profile = profile;
    }

    public void setTypeFlag(final /*RoutingType*/ String typeFlag)
    {
        this.typeFlag = typeFlag;
    }

    public void setMessage(final String message)
    {
        this.message = message;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object o)
    {
        if (o == this) return true;
        if (!(o instanceof Routing)) return false;
        final Routing other = (Routing) o;
        if (!other.canEqual((java.lang.Object) this)) return false;
        final java.lang.Object this$id = this.getId();
        final java.lang.Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final java.lang.Object this$signature = this.getSignature();
        final java.lang.Object other$signature = other.getSignature();
        if (this$signature == null ? other$signature != null : !this$signature.equals(other$signature)) return false;
        final java.lang.Object this$profile = this.getProfile();
        final java.lang.Object other$profile = other.getProfile();
        if (this$profile == null ? other$profile != null : !this$profile.equals(other$profile)) return false;
        final java.lang.Object this$typeFlag = this.getTypeFlag();
        final java.lang.Object other$typeFlag = other.getTypeFlag();
        if (this$typeFlag == null ? other$typeFlag != null : !this$typeFlag.equals(other$typeFlag)) return false;
        final java.lang.Object this$message = this.getMessage();
        final java.lang.Object other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) return false;
        return true;
    }

    protected boolean canEqual(final java.lang.Object other)
    {
        return other instanceof Routing;
    }

    @java.lang.Override
    public int hashCode()
    {
        final int PRIME = 59;
        int result = 1;
        final java.lang.Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final java.lang.Object $signature = this.getSignature();
        result = result * PRIME + ($signature == null ? 43 : $signature.hashCode());
        final java.lang.Object $profile = this.getProfile();
        result = result * PRIME + ($profile == null ? 43 : $profile.hashCode());
        final java.lang.Object $typeFlag = this.getTypeFlag();
        result = result * PRIME + ($typeFlag == null ? 43 : $typeFlag.hashCode());
        final java.lang.Object $message = this.getMessage();
        result = result * PRIME + ($message == null ? 43 : $message.hashCode());
        return result;
    }

    @java.lang.Override
    public java.lang.String toString()
    {
        return "Routing(id=" + this.getId() + ", signature=" + this.getSignature() + ", profile=" + this.getProfile() + ", typeFlag=" + this.getTypeFlag()
                + ", message=" + this.getMessage() + ")";
    }

    @Id
    @GeneratedValue
    public Long getId()
    {
        return this.id;
    }

    /*
    @ManyToOne
    */
    public /*Signature*/ String getSignature()
    {
        return this.signature;
    }

    /**
     * Refers to who the email is being sent to
     */
    @ManyToOne
    public Profile getProfile()
    {
        return this.profile;
    }

    /*
    @ManyToOne
    */
    public /*RoutingType*/ String getTypeFlag()
    {
        return this.typeFlag;
    }
}
