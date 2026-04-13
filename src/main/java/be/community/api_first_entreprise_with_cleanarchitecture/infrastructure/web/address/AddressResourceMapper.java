package be.community.api_first_entreprise_with_cleanarchitecture.infrastructure.web.address;

import be.community.api_first_entreprise_with_cleanarchitecture.core.application.address.dto.AddressDto;
import org.openapitools.model.Address;

public class AddressResourceMapper {

  private AddressResourceMapper() {}

  public static Address toAddressResponse(AddressDto dto) {
    if (dto == null) return null;

    return new Address().street(dto.street()).city(dto.city()).zipcode(dto.zipCode());
  }
}
