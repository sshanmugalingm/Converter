package au.com.fx.converter.domain;

import javax.persistence.*;

/**
 * Represents a Currency Entity.
 *
 * @author senthurshanmugalingm.
 */
@Entity
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String code;

    private String description;

    @Column(nullable = false)
    private Integer decimalPlaces;


    private String country;

    public Currency() {
    }

    public String getCode() {
        return code;
    }

    public Integer getDecimalPlaces() {
        return decimalPlaces;
    }

    public String getDescription() {
        return description;
    }

    public String getCountry() {
        return country;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDecimalPlaces(Integer decimalPlaces) {
        this.decimalPlaces = decimalPlaces;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Currency)) return false;

        Currency currency = (Currency) o;
        return new org.apache.commons.lang3.builder.EqualsBuilder().append(code, currency.code).isEquals();
    }

    @Override
    public int hashCode() {
        return new org.apache.commons.lang3.builder.HashCodeBuilder(17, 37).append(code).toHashCode();
    }

    @Override
    public String toString() {
        return "Currency{code='" + code + "', id='" + id.toString() + "'}";
    }
}
