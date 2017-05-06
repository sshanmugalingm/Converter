package au.com.fx.converter.domain;

import au.com.fx.converter.enums.ConversionType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

/**
 * Created by senthurshanmugalingm on 4/05/2017.
 */
@Entity
public class ConversionMatrix {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "baseCurrency_id", referencedColumnName = "id", nullable = false)
    private Currency baseCurrency;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "termCurrency_id", referencedColumnName = "id", nullable = false)
    private Currency termCurrency;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ConversionType conversionType;

    @OneToOne
    @JoinColumn(name = "referenceCurrency_id", referencedColumnName = "id")
    private Currency referenceCurrency;

    public ConversionMatrix() {
    }

    public Currency getBaseCurrency() {
        return baseCurrency;
    }

    public void setBaseCurrency(Currency baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public Currency getTermCurrency() {
        return termCurrency;
    }

    public void setTermCurrency(Currency termCurrency) {
        this.termCurrency = termCurrency;
    }

    public Currency getReferenceCurrency() {
        return referenceCurrency;
    }

    public void setReferenceCurrency(Currency referenceCurrency) {
        this.referenceCurrency = referenceCurrency;
    }

    public ConversionType getConversionType() {
        return conversionType;
    }

    public void setConversionType(ConversionType conversionType) {
        this.conversionType = conversionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ConversionMatrix)) return false;

        ConversionMatrix that = (ConversionMatrix) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .toHashCode();
    }

    @Override
    public String toString() {
        return "ConversionMatrix{" +
                "id=" + id +
                '}';
    }
}
