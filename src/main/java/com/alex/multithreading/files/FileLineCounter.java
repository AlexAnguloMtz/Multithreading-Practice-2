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

    /**
     * Reads all the lines in a file with the provided file name
     * and adds the number of lines to the received Counter object
     *
     * @param fileName  the name of the file
     * @param counter   the Counter to count the number of lines
     */
    public void countLinesInFile(String fileName, Counter counter) {
        try (var reader = new BufferedReader(new FileReader(fileName))) {
            countLinesWith(reader, counter);
        } catch (Exception exception) {
            throw new RuntimeException(format(COULD_NOT_READ_FILE, fileName));
        }
    }

    private void countLinesWith(BufferedReader reader, Counter counter) throws IOException {
        String line = null;
        while ((line = reader.readLine()) != null)
            counter.add(1);
    }

}