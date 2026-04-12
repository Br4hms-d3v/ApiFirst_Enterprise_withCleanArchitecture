package be.community.api_first_entreprise_with_cleanarchitecture.core.application.common.dto;

import java.util.List;

/** This class represents a paginated response. */
public record PagedResponseDto<T>(
    // The list of items.
    List<T> content,

    // The current page number.
    int page,

    // The size of the page.
    int size,

    // The total number of elements
    long totalElements,

    // The total number of  pages
    int totalPages,

    // True if this is the last page.
    boolean last) {}
