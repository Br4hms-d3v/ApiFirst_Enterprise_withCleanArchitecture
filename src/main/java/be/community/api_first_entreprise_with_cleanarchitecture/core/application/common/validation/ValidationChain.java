package be.community.api_first_entreprise_with_cleanarchitecture.core.application.common.validation;

import be.community.api_first_entreprise_with_cleanarchitecture.core.application.common.Result;
import java.util.function.Predicate;

public class ValidationChain<T, E> {

  private final T value;
  private E errror;
  private boolean valid = true;

  private ValidationChain(T value) {
    this.value = value;
  }

  public static <T, E> ValidationChain<T, E> of(T value) {
    return new ValidationChain<>(value);
  }

  public ValidationChain<T, E> validate(Predicate<T> predicate, E error) {
    if (!valid) {
      return this;
    }

    if (!predicate.test(value)) {
      this.valid = false;
      this.errror = error;
    }

    return this;
  }

  public Result<E, T> toResult() {
    if (valid) {
      return Result.success(value);
    } else {
      return Result.failure(errror);
    }
  }
}
