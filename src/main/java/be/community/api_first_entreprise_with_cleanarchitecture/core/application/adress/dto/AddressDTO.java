package be.community.api_first_entreprise_with_cleanarchitecture.core.application.adress.dto;

import be.community.api_first_entreprise_with_cleanarchitecture.core.application.common.address.Address;

public record AddressDTO(String street, Integer zipcode, String city) {
  public static AddressDTO from(Address address) {
    return new AddressDTO(address.getStreet(), address.getZipcode(), address.getCity());
  }
}
