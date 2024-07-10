package med.voll.api.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DataAddress(
        @NotBlank
        String street,

        @NotBlank
        String city,

        @NotBlank
        String state,

        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String zip,

        String complement,

        String number,

        @NotBlank
        String neighborhood) {
}
