/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.codegen.util;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Hiep
 */
public class FileUtil {

    public static Path createFile(String baseDir, String subDir, String packValue) throws IOException {
        String separator = FileSystems.getDefault().getSeparator();
        String fullPath = baseDir + separator + subDir + separator + convertPackageToPath(packValue);
        return Files.createDirectories(Paths.get(fullPath));
    }

    public static void writeFile(Path path, String fileName, String value) throws IOException {
        
        Path file = Files.createFile(Paths.get(path.toString(), fileName));
        Charset charset = Charset.forName("US-ASCII");
        try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
            writer.write(value);
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    public static String convertPackageToPath(String packValue) {
        if (packValue == null) {
            return null;
        }
        FileSystem fs = FileSystems.getDefault();
        String separator = fs.getSeparator();
        return packValue.replace(".", separator);
    }
}
