package au.com.fx.converter.domain;

import au.com.fx.converter.commons.enums.ConversionType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;

/**
 * Represents the Conversion Chart.  This chart will help to figure out the conversion path of two currencies (Term and Base).
 *
 * @author senthurshanmugalingm.
 */
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"sourceCurrency_id", "destinationCurrency_id"})})
public class ConversionChart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "sourceCurrency_id", referencedColumnName = "id", nullable = false)
    private Currency sourceCurrency;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "destinationCurrency_id", referencedColumnName = "id", nullable = false)
    private Currency destinationCurrency;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ConversionType conversionType;

    @OneToOne
    @JoinColumn(name = "referenceCurrency_id", referencedColumnName = "id")
    private Currency referenceCurrency;

    public ConversionChart() {
    }

    public Currency getSourceCurrency() {
        return sourceCurrency;
    }

    public Currency getDestinationCurrency() {
        return destinationCurrency;
    }

    public Currency getReferenceCurrency() {
        return referenceCurrency;
    }

    public ConversionType getConversionType() {
        return conversionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ConversionChart)) return false;

        ConversionChart that = (ConversionChart) o;

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
