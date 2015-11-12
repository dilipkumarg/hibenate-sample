package com.dilipkumarg.samples.comptest;

import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @author <a href="mailto:dilip.gundu@wavemaker.com">Dilip Kumar</a>
 * @since 4/11/15
 */
@Entity
@Table(name = "INT_PROD_DETAILS", schema = "comptest", catalog = "")
@IdClass(IntProdDetailsEntityPK.class)
public class IntProdDetailsEntity {
    private Integer detProdId;
    private Integer detCountId;
    private String address;
    private String vendor;

    @Id
    @Column(name = "DET_PROD_ID")
    public Integer getDetProdId() {
        return detProdId;
    }

    public void setDetProdId(final Integer detProdId) {
        this.detProdId = detProdId;
    }

    @Id
    @Column(name = "DET_COUNT_ID")
    public Integer getDetCountId() {
        return detCountId;
    }

    public void setDetCountId(final Integer detCountId) {
        this.detCountId = detCountId;
    }

    @Basic
    @Column(name = "ADDRESS")
    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "VENDOR")
    public String getVendor() {
        return vendor;
    }

    public void setVendor(final String vendor) {
        this.vendor = vendor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(detProdId, detCountId, address, vendor);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final IntProdDetailsEntity that = (IntProdDetailsEntity) o;
        return Objects.equals(detProdId, that.detProdId) &&
                Objects.equals(detCountId, that.detCountId) &&
                Objects.equals(address, that.address) &&
                Objects.equals(vendor, that.vendor);
    }
}
