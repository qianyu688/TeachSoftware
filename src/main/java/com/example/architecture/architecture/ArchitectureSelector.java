package main.java.com.example.architecture.architecture;

import main.java.com.example.architecture.controllers.KwicController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ArchitectureSelector extends JPanel {
    private JComboBox<String> architectureOptions;
    private JButton processButton;
    private ArchitectureDisplay architectureDisplay;

    public ArchitectureSelector(ArchitectureDisplay architectureDisplay) {
        this.architectureDisplay = architectureDisplay;
        String[] architectures = {"主程序-子程序", "面向对象", "事件系统", "管道-过滤器"};
        architectureOptions = new JComboBox<>(architectures);
        processButton = new JButton("处理文件");

        processButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedArchitecture = (String) architectureOptions.getSelectedItem();
                processFile(selectedArchitecture);
            }
        });

        add(architectureOptions);
        add(processButton);
    }

    private void processFile(String architecture) {
        File inputFile = new File("resources/input.txt");
        File outputFile = new File("resources/output.txt");
        String diagramPath = "resources/architecture_diagrams/";

        String outputResult = "";
        switch (architecture) {
            case "主程序-子程序":
                new KwicController().process(inputFile, outputFile);
                outputResult = readOutputFile(outputFile);
                diagramPath += "main_subprogram.png";
                break;
            case "面向对象":
                // 处理面向对象逻辑
                outputResult = "处理完成: 面向对象";
                diagramPath += "object_oriented.png";
                break;
            case "事件系统":
                // 处理事件系统逻辑
                outputResult = "处理完成: 事件系统";
                diagramPath += "event_system.png";
                break;
            case "管道-过滤器":
                // 处理管道-过滤器逻辑
                outputResult = "处理完成: 管道-过滤器";
                diagramPath += "pipe_filter.png";
                break;
        }
        architectureDisplay.updateDisplay(architecture, diagramPath, outputResult);
    }

    private String readOutputFile(File outputFile) {
        try {
            return new String(Files.readAllBytes(Paths.get(outputFile.getPath())));
        } catch (IOException e) {
            e.printStackTrace();
            return "读取输出文件时出错";
        }
    }
}
