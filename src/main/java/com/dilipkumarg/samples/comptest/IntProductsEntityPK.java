package com.dilipkumarg.samples.comptest;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author <a href="mailto:dilip.gundu@wavemaker.com">Dilip Kumar</a>
 * @since 4/11/15
 */
public class IntProductsEntityPK implements Serializable {
    private Integer prodId;
    private Integer countId;

    @Column(name = "PROD_ID")
    @Id
    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(final Integer prodId) {
        this.prodId = prodId;
    }

    @Column(name = "COUNT_ID")
    @Id
    public Integer getCountId() {
        return countId;
    }

    public void setCountId(final Integer countId) {
        this.countId = countId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodId, countId);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final IntProductsEntityPK that = (IntProductsEntityPK) o;
        return Objects.equals(prodId, that.prodId) &&
                Objects.equals(countId, that.countId);
    }
}
