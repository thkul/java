package calc.operations;

public class AddOperation implements Operation {
    @Override
    public double apply(double... numbers) {
        double sum = 0;
        for (double num : numbers) {
            sum += num;
        }
        return sum;
    }

    @Override
    public String getName() {
        return "Add";
    }
}
