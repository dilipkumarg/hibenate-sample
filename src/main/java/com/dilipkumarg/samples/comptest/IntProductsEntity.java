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
@Table(name = "INT_PRODUCTS", schema = "comptest", catalog = "")
@IdClass(IntProductsEntityPK.class)
public class IntProductsEntity {
    private Integer prodId;
    private Integer countId;
    private String name;

    @Id
    @Column(name = "PROD_ID")
    public Integer getProdId() {
        return prodId;
    }

    public void setProdId(final Integer prodId) {
        this.prodId = prodId;
    }

    @Id
    @Column(name = "COUNT_ID")
    public Integer getCountId() {
        return countId;
    }

    public void setCountId(final Integer countId) {
        this.countId = countId;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prodId, countId, name);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final IntProductsEntity that = (IntProductsEntity) o;
        return Objects.equals(prodId, that.prodId) &&
                Objects.equals(countId, that.countId) &&
                Objects.equals(name, that.name);
    }
}
