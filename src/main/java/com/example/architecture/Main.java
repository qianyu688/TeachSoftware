package main.java.com.example.architecture;

import main.java.com.example.architecture.architecture.ArchitectureSelector;
import main.java.com.example.architecture.architecture.ArchitectureDisplay;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("经典软件体系结构教学软件");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            frame.setLayout(new BorderLayout());

            ArchitectureDisplay architectureDisplay = new ArchitectureDisplay();
            ArchitectureSelector selector = new ArchitectureSelector(architectureDisplay);

            frame.add(selector, BorderLayout.NORTH);
            frame.add(architectureDisplay, BorderLayout.CENTER);

            frame.setVisible(true);
        });
    }
}
