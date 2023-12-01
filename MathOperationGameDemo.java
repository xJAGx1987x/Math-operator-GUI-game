import javax.swing.SwingUtilities;

public class MathOperationGameDemo {
  public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            int input = 5; // Replace with the desired number of rounds
            new MathOperationGameGUI(input);
        });
    }
}
