package calc.operations;

public interface Operation {
  String getName();

  int getRequiredArgCount();

  default int getMinimumArgCount() {
    return getRequiredArgCount() == -1 ? 1 : getRequiredArgCount();
  }

  default void validate(double... numbers) {
  }

  double apply(double... numbers);

  default double execute(double... numbers) {
    validate(numbers);
    return apply(numbers);
  }
}
