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

  // Success with value
  public static <E, T> Result<E, T> success(T value) {
    return new Result<>(null, value, true);
  }

  // Failure
  public static <E, T> Result<E, T> failure(E error) {
    return new Result<>(error, null, false);
  }

  // Success without value (Unit)
  public static <E, T> Result<E, Unit> success() {
    return Result.success(Unit.INSTANCE);
  }

  // Give only a failure or a succes
  public <R> R fold(Function<E, R> failure, Function<T, R> onSuccess) {
    if (success) {
      return onSuccess.apply(value);
    } else {
      return failure.apply(error);
    }
  }

  // Map
  public <U> Result<E, U> map(Function<T, U> mapper) {
    if (success) {
      return Result.success(mapper.apply(value));
    } else {
      return Result.failure(error);
    }
  }

  // FlatMap
  public <U> Result<E, U> flatMap(Function<T, Result<E, U>> mapper) {
    if (success) {
      return mapper.apply(value);
    } else {
      return Result.failure(error);
    }
  }

  // Unit
  public static final class Unit {
    public static final Unit INSTANCE = new Unit();

    private Unit() {}

    public static Unit unit() {
      return INSTANCE;
    }

    @Override
    public String toString() {
      return "Unit";
    }
  }

  /** Getters */

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
