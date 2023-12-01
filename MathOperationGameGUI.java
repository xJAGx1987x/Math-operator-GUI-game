import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MathOperationGameGUI {
    private int input;
    private int correctGuesses;
    private int currentRound;
    private MathOperation[] operations;
    private Random random;

    private JTextField userGuessField;
    private JLabel questionLabel;
    private JLabel resultLabel;
    private JLabel operatorLabel ;

    public MathOperationGameGUI(int input) {
        this.input = input;
        this.correctGuesses = 0;
        this.currentRound = 0;
        this.operations = new MathOperation[] { new Addition(), new Subtraction(), new Multiplication(), new Division() };
        this.random = new Random();

        JFrame frame = new JFrame("Math Operation Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1));

        userGuessField = new JTextField(5);
        userGuessField.addActionListener(new GuessListener());

        questionLabel = new JLabel("", SwingConstants.CENTER);
        operatorLabel = new JLabel("Operators: + - * / ", SwingConstants.CENTER);
        resultLabel = new JLabel("", SwingConstants.CENTER);

        frame.add(questionLabel);
        frame.add(resultLabel);
        frame.add(operatorLabel) ;
        frame.add(userGuessField);

        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        nextRound();
    }

    private void nextRound() {
        if (currentRound < input) {
            int a = random.nextInt(10) + 1;
            int b = random.nextInt(10) + 1;
            MathOperation operation = operations[random.nextInt(operations.length)];
            int result = operation.performOperation(a, b);

            char correctOperation = operation.getOperationSymbol();

            questionLabel.setText("Round " + (currentRound + 1) + ": What operation was performed on " + a + " and " + b + "?");
            resultLabel.setText("Result: " + result);

            userGuessField.putClientProperty("correctOperation", correctOperation);

            userGuessField.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Game Over! You got " + correctGuesses + " out of " + input + " correct.");
            System.exit(0);
        }
    }

    private class GuessListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            char userGuess = userGuessField.getText().charAt(0) ;
            char correctOperation = (char) userGuessField.getClientProperty("correctOperation");

            if (userGuess == correctOperation) {
                JOptionPane.showMessageDialog(null, "Correct!");
                correctGuesses++;
            } else {
                JOptionPane.showMessageDialog(null, "Wrong! The correct answer is " + correctOperation);
            }

            currentRound++;
            nextRound();
        }
    }

}
