package com.alex.multithreading.files;

import com.alex.multithreading.counter.Counter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static java.lang.String.format;

/**
 *  Class to count all lines in a file
 *
 * @author Alex Angulo
 */
public class FileLineCounter {

    private static final String COULD_NOT_READ_FILE = "Could not read file: %s";

    public void countLinesInFile(String filename, Counter counter) {
        try (var reader = new BufferedReader(new FileReader(filename))) {
            countLinesWith(reader, counter);
        } catch (Exception exception) {
            throw new RuntimeException(format(COULD_NOT_READ_FILE, filename));
        }
    }

    private void countLinesWith(BufferedReader reader, Counter counter) throws IOException {
        String line = null;
        while ((line = reader.readLine()) != null)
            counter.add(1);
    }

}