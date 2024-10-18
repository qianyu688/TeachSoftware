package main.java.com.example.architecture.architecture;

import main.java.com.example.architecture.models.Filter;
import main.java.com.example.architecture.models.Pipe;

import java.io.*;

public class Input extends Filter {
    private File file;

    public Input(File file, Pipe output) {
        super(null, output);
        this.file = file;
    }

    @Override
    public void transform() throws IOException {
        BufferedReader inputFile = null;
        try {
            inputFile = new BufferedReader(new FileReader(file));
            String line;
            while ((line = inputFile.readLine()) != null) {
                output.writerLine(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            output.closeWriter();
        }
    }
}