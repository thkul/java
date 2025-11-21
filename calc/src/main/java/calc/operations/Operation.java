package calc.operations;

public interface Operation {
    double apply(double... numbers);

    String getName();
}
