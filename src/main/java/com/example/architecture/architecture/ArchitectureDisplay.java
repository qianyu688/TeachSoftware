package main.java.com.example.architecture.architecture;

import javax.swing.*;
import java.awt.*;

public class ArchitectureDisplay extends JPanel {
    private JLabel titleLabel;
    private JTextArea description;
    private JLabel diagramLabel;
    private JTextArea outputArea;

    public ArchitectureDisplay() {
        setLayout(new BorderLayout());

        titleLabel = new JLabel("", SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        diagramLabel = new JLabel();
        add(diagramLabel, BorderLayout.CENTER);

        outputArea = new JTextArea(10, 50);
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.SOUTH);
    }

    public void updateDisplay(String architecture, String diagramPath, String output) {
        titleLabel.setText(architecture + " 体系结构");
        diagramLabel.setIcon(new ImageIcon(diagramPath));
        outputArea.setText(output);
    }
}
