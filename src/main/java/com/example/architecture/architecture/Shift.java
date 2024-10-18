package main.java.com.example.architecture.architecture;

import main.java.com.example.architecture.models.Filter;
import main.java.com.example.architecture.models.Pipe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Shift extends Filter {

    public Shift(Pipe input, Pipe output) {
        super(input, output);
    }

    @Override
    public void transform() throws IOException {
        while (input.hasNextLine()) {
            StringTokenizer token = new StringTokenizer(input.readerLine());
            ArrayList<String> tokens = new ArrayList<>();
            while (token.hasMoreTokens()) {
                tokens.add(token.nextToken());
            }

            for (int i = 0; i < tokens.size(); i++) {
                StringBuilder lineBuffer = new StringBuilder();
                for (int j = 0; j < tokens.size(); j++) {
                    lineBuffer.append(tokens.get((i + j) % tokens.size())).append(" ");
                }
                output.writerLine(lineBuffer.toString().trim());
            }
        }
        input.closeReader();
        output.closeWriter();
    }
}