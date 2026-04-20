package be.community.api_first_entreprise_with_cleanarchitecture.core.application.address.mapper;

import be.community.api_first_entreprise_with_cleanarchitecture.core.application.address.dto.AddressDto;
import be.community.api_first_entreprise_with_cleanarchitecture.core.domain.address.Address;
import org.springframework.stereotype.Component;

/** This class maps Address and AddressDto. */
@Component
public class AddressMapper {
  /** Convert Address to AddressDto. */
  public AddressDto toDto(Address address) {
    if (address == null) {
      return null;
    }

    return new AddressDto(address.getStreet(), address.getZipCode(), address.getCity());
  }

  /** Convert AddressDto to Address. */
  public Address toEntity(AddressDto dto) {
    if (dto == null) {
      return null;
    }

    Address address = new Address();
    address.setStreet(dto.street());
    address.setZipCode(dto.zipCode());
    address.setCity(dto.city());

    return address;
  }
}
