package main.java.com.example.architecture.architecture;

import main.java.com.example.architecture.models.Filter;
import main.java.com.example.architecture.models.Pipe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Alphabetizer extends Filter {
    private ArrayList<String> kwicList = new ArrayList<>();

    public Alphabetizer(Pipe input, Pipe output) {
        super(input, output);
    }

    @Override
    public void transform() throws IOException {
        while (input.hasNextLine()) {
            kwicList.add(input.readerLine());
        }
        Collections.sort(kwicList);
        for (String line : kwicList) {
            output.writerLine(line);
        }
        input.closeReader();
        output.closeWriter();
    }
}