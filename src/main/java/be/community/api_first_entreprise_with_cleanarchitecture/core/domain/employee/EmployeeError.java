package be.community.api_first_entreprise_with_cleanarchitecture.core.domain.employee;

/**
 * This interface represents all employee errors. It uses sealed types to define all possible
 * errors.
 */
public sealed interface EmployeeError
    permits EmployeeError.EmployeeNotFound,
        EmployeeError.EmployeeCreationFailed,
        EmployeeError.EmployeeInvalidFailed,
        EmployeeError.EmployeeNameIsMissing,
        EmployeeError.EmployeeListIsEmpty,
        EmployeeError.EmployeeEmailNotValid,
        EmployeeError.EmployeeInvalidLevel {

  /** This error is used when an employee is not found. */
  record EmployeeNotFound(String message) implements EmployeeError {
    /**
     * Get the error message.
     *
     * @return a message
     */
    public String getMessage() {
      return message;
    }
  }

  /**
   * This error is used when employee creation fails.
   *
   * @param message
   */
  record EmployeeCreationFailed(String message) implements EmployeeError {
    /**
     * Get the error message.
     *
     * @return a message
     */
    public String getMessage() {
      return message;
    }
  }

  /** This error is used when employee data is invalid. */
  record EmployeeInvalidFailed(String message) implements EmployeeError {
    /**
     * Get the error message.
     *
     * @return a message
     */
    public String getMessage() {
      return message;
    }
  }

  /** This error is used when employee name is missing. */
  record EmployeeNameIsMissing(String message) implements EmployeeError {
    /**
     * Get the error message.
     *
     * @return a message
     */
    public String getMessage() {
      return message;
    }
  }

  /** This error is used when employee list is empty. */
  record EmployeeListIsEmpty(String message) implements EmployeeError {
    /**
     * Get the error message.
     *
     * @return a message
     */
    public String getMessage() {
      return message;
    }
  }

  /** This error is used when employee email is not valid. */
  record EmployeeEmailNotValid(String message) implements EmployeeError {
    /**
     * Get the error message.
     *
     * @return a message
     */
    public String getMessage() {
      return message;
    }
  }

  /** This error is used when we input the wrong floor */
  record EmployeeInvalidLevel(String message) implements EmployeeError {
    /**
     * Get the error message
     *
     * @return a message
     */
    @Override
    public String message() {
      return message;
    }
  }
}
