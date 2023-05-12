import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tombola extends JFrame {
    private JPanel panel;
    private JLabel Number;
    private JButton Extract;
    private List<Integer> numbers;
    private int currentNumberIndex;

    public Tombola() {
        setTitle("Tombola");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        panel = new JPanel(new GridLayout(10, 9));
        Number = new JLabel();
        Extract = new JButton("Estrai numero");
        Extract.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                extractNumber();
            }
        });

        add(panel, BorderLayout.CENTER);
        add(Number, BorderLayout.NORTH);
        add(Extract, BorderLayout.SOUTH);

        numbers = new ArrayList<>();
        for (int i = 1; i <= 90; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);

        currentNumberIndex = 0;

        createNumberGrid();

        setVisible(true);
    }

    private void createNumberGrid() {
        panel.removeAll();
        for (int i = 1; i <= 90; i++) {
            JButton button = new JButton(String.valueOf(i));
            button.setEnabled(false);
            panel.add(button);
        }
        panel.setSize(700,700);
    }

    private void extractNumber() {
        if (currentNumberIndex < numbers.size()) {
            int number = numbers.get(currentNumberIndex);
            JButton button = (JButton) panel.getComponent(number - 1);
            button.setBackground(Color.YELLOW);
            Number.setText("Numero estratto: " + number);
            currentNumberIndex++;
        } else {
            Number.setText("Tutti i numeri sono stati estratti.");
            Extract.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Tombola();
            }
        });
    }
}
