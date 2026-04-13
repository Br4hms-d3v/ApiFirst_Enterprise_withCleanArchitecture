package be.community.api_first_entreprise_with_cleanarchitecture.core.application.common;

import java.util.function.Function;

/**
 * This class represents a result. It can be success or failure.
 *
 * @param <E> Type error
 * @param <T> Type value
 */
public class Result<E, T> {
  private final E error;
  private final T value;
  private final boolean success;

  public Result(E error, T value, boolean success) {
    this.error = error;
    this.value = value;
    this.success = success;
  }

  // Create a succes result.
  public static <E, T> Result<E, T> success(T value) {
    return new Result<>(null, value, true);
  }

  // Create a failure result.
  public static <E, T> Result<E, T> failure(E error) {
    return new Result<>(error, null, false);
  }

  // Give only a failure or a succes
  public <R> R fold(Function<E, R> onfailure, Function<T, R> onSuccess) {
    if (success) {
      return onSuccess.apply(value);
    } else {
      return onfailure.apply(error);
    }
  }

  // Check if result is success
  public boolean isSuccess() {
    return success;
  }

  // Get the value.
  public T getValue() {
    return value;
  }

  // Get the error
  public E getError() {
    return error;
  }
}
