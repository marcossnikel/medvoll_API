package med.voll.api.address;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    String street;
    String city;
    String state;
    String zip;
    String complement;
    String number;
    String neighborhood;

    public Address(DataAddress address) {
        this.street = address.street();
        this.city = address.city();
        this.state = address.state();
        this.zip = address.zip();
        this.complement = address.complement();
        this.number = address.number();
        this.neighborhood = address.neighborhood();
    }
}
