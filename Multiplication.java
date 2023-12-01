final public class Multiplication extends MathOperation {
    @Override
    final public char getOperationSymbol() {
        return '*';
    }

    @Override
    final public int performOperation(int a, int b) {
        return a * b;
    }
}
