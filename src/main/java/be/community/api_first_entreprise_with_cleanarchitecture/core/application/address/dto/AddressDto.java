package be.community.api_first_entreprise_with_cleanarchitecture.core.application.address.dto;

/** This class is a data transfer object for address. */
public record AddressDto(
        // The id of the address.
        Long id,

        // The street name.
        String street,

        // The postcode.
        Integer zipCode,

        // The city name.
        String city) {}
