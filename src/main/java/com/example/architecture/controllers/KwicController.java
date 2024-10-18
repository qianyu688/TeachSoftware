package main.java.com.example.architecture.controllers;

import main.java.com.example.architecture.architecture.*;
import main.java.com.example.architecture.models.*;
import java.io.File;
import java.io.IOException;

import main.java.com.example.architecture.models.*;
import java.io.File;

public class KwicController {
    public void process(File inputFile, File outputFile) {
        Pipe pipe1 = new Pipe();
        Pipe pipe2 = new Pipe();
        Pipe pipe3 = new Pipe();
        Input input = new Input(inputFile, pipe1);
        Shift shift = new Shift(pipe1, pipe2);
        Alphabetizer alphabetizer = new Alphabetizer(pipe2, pipe3);
        Output output = new Output(outputFile, pipe3);

        try {
            input.transform();
            shift.transform();
            alphabetizer.transform();
            output.transform();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}