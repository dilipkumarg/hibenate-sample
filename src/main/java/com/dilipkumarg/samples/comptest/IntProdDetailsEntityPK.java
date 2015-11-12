package com.dilipkumarg.samples.comptest;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author <a href="mailto:dilip.gundu@wavemaker.com">Dilip Kumar</a>
 * @since 4/11/15
 */
public class IntProdDetailsEntityPK implements Serializable {
    private Integer detProdId;
    private Integer detCountId;

    @Column(name = "DET_PROD_ID")
    @Id
    public Integer getDetProdId() {
        return detProdId;
    }

    public void setDetProdId(final Integer detProdId) {
        this.detProdId = detProdId;
    }

    @Column(name = "DET_COUNT_ID")
    @Id
    public Integer getDetCountId() {
        return detCountId;
    }

    public void setDetCountId(final Integer detCountId) {
        this.detCountId = detCountId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(detProdId, detCountId);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final IntProdDetailsEntityPK that = (IntProdDetailsEntityPK) o;
        return Objects.equals(detProdId, that.detProdId) &&
                Objects.equals(detCountId, that.detCountId);
    }
}
