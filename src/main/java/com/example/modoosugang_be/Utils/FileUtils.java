package com.example.modoosugang_be.Utils;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

    public static void saveFile(MultipartFile file, String directoryPath) throws IOException {
        Path directory = Paths.get(directoryPath).toAbsolutePath().normalize();
        Files.createDirectories(directory);
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        Assert.state(!fileName.contains(".."), "Name of file cannot contain '..'");
        Path targetPath = directory.resolve(fileName).normalize();

        Assert.state(!Files.exists(targetPath), fileName + " File alerdy exists.");
        file.transferTo(targetPath);
    }
}