package be.community.api_first_entreprise_with_cleanarchitecture.core.application.common;

import be.community.api_first_entreprise_with_cleanarchitecture.core.application.common.dto.PagedResponseDto;
import java.util.List;
import java.util.function.Function;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/** This class maps Page to PagedResponse. */
@Component
public class PagedResponseMapper {

  /** Convert a Page of entities to a PagedResponse of DTO. */
  public static <E, D> PagedResponseDto<D> toPagedResponseDto(
      Page<E> page, Function<List<E>, List<D>> mapper) {
    // Transform data
    List<D> content = mapper.apply(page.getContent());

    return new PagedResponseDto<>(
        content,
        page.getNumber() +1,
        page.getSize(),
        page.getTotalElements(),
        page.getTotalPages(),
        page.isLast());
  }
}
