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
  public <T, R> PagedResponseDto<R> toPagedResponseDto(Page<T> page, Function<T, R> mapper) {
    // Transform data
    List<R> content = page.getContent().stream().map(mapper).toList();

    return new PagedResponseDto<>(
        content,
        page.getNumber(),
        page.getSize(),
        page.getTotalElements(),
        page.getTotalPages(),
        page.isLast());
  }
}
