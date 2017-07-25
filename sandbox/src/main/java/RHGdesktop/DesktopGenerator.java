package RHGdesktop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class DesktopGenerator extends JFrame {

    java.util.List<String> hits = Arrays.asList("Вертикальный", "Правая диагональ", "Левая диагональ", "Правый горизонт",
            "Левый горизонт", "Правая нижняя диагональ", "Левая нижняя диагональ", "Правая плоскость", "Левая плоскость");

    int hit;
    int lastHit = 15;
    int numberOfHits;
    Random random = new Random();

    JButton generateButton;
    JLabel hitQuantity;
    JTextField hitField;
    JTextArea series;

    public DesktopGenerator (String name) {
        super(name);
        setLayout(new FlowLayout());
        generateButton = new JButton("Сгенерировать");
        hitQuantity = new JLabel("Введите количество ударов");
        hitField = new JTextField(2);
        hitField.setHorizontalAlignment(JTextField.CENTER);
        series = new JTextArea(10, 17);
        series.setFocusable(false);
        add(hitQuantity);
        add(hitField);
        add(generateButton);
        add(series);

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    series.setText(null);
                    numberOfHits = Integer.parseInt(hitField.getText());
                    if (!(numberOfHits > 0 && numberOfHits <= 10)) {
                        JOptionPane.showMessageDialog(null, "Количество ударов должно быть от 0 до 10");
                    } else {
                        for (int i = 0; i < numberOfHits; i++) {
                            hit = random.nextInt(8);
                            while (hit == lastHit) {
                                hit = random.nextInt(8);
                            }
                            series.setText(series.getText() + (i + 1) + ". " + hits.get(hit) + "\n");
                            lastHit = hit;
                        }
                    }
                    } catch(Exception ex){
                        JOptionPane.showMessageDialog(null, "Введите количество ударов");
                    }

            }
        });
    }

    public static void main(String[] args) {
        DesktopGenerator dG = new DesktopGenerator("Generator");
        dG.setSize(210,260);
        dG.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dG.setVisible(true);
        dG.setLocationRelativeTo(null);
        dG.setResizable(false);
    }
}
