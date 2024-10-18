package main.java.com.example.architecture.architecture;

import main.java.com.example.architecture.models.Filter;
import main.java.com.example.architecture.models.Pipe;

import java.io.*;

public class Output extends Filter {
    private File file;

    public Output(File file, Pipe input) {
        super(input, null);
        this.file = file;
    }

    @Override
    public void transform() throws IOException {
        BufferedWriter outputFile = null;
        try {
            outputFile = new BufferedWriter(new FileWriter(file));
            while (input.hasNextLine()) {
                outputFile.write(input.readerLine() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outputFile != null) {
                outputFile.close();
            }
            input.closeReader();
        }
    }
}