final public class Division extends MathOperation {
    @Override
    final public char getOperationSymbol() {
        return '/';
    }

    @Override
    final public int performOperation(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }
}
