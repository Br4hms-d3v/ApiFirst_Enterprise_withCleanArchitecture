package be.community.api_first_entreprise_with_cleanarchitecture.core.application.common;

/**
 * The interface handles a command
 *
 * @param <C> The command
 * @param <E> The error
 */
public interface CommandHandler<C, E> {

  /**
   * Handle a command
   *
   * @param command the command
   * @return the result
   */
  Result<E, ?> handle(C command);
}
