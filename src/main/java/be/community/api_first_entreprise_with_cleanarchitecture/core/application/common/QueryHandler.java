package be.community.api_first_entreprise_with_cleanarchitecture.core.application.common;

/**
 * The interface handles a query
 *
 * @param <Q> The query
 * @param <R> The result
 * @param <E> The error
 */
public interface QueryHandler<Q, R, E> {
  /**
   * Handle a query and return a result
   *
   * @param query the query
   * @return return a result
   */
  Result<E, R> handle(Q query);
}
