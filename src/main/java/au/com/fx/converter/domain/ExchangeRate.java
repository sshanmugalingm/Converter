package au.com.fx.converter.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Represents the Exchange Rate Information for BASE/TERM currency combination.
 *
 * @author senthurshanmugalingm.
 */
@Entity
public class ExchangeRate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "baseCurrency_id", referencedColumnName = "id", nullable = false)
    //@JoinColumn(name = "id", nullable = false)
    private Currency baseCurrency;

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "termCurrency_id", referencedColumnName = "id", nullable = false)
    //@JoinColumn(name = "id", nullable = false)
    private Currency termCurrency;

    @Column(nullable = false)
    private BigDecimal rate;

    public ExchangeRate() {
    }


    public Currency getBaseCurrency() {
        return baseCurrency;
    }

    public Currency getTermCurrency() {
        return termCurrency;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setBaseCurrency(Currency baseCurrency) {
        this.baseCurrency = baseCurrency;
    }

    public void setTermCurrency(Currency termCurrency) {
        this.termCurrency = termCurrency;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof ExchangeRate)) return false;

        ExchangeRate that = (ExchangeRate) o;

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
        return "ExchangeRate{" +
                "baseCurrency=" + baseCurrency.toString() +
                ", termCurrency=" + termCurrency.toString() +
                ", rate=" + rate +
                '}';
    }
}
