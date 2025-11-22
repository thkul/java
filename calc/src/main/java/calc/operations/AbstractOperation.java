package calc.operations;

public abstract class AbstractOperation implements Operation {
  private final String name;

  protected AbstractOperation(String name) {
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }
}
