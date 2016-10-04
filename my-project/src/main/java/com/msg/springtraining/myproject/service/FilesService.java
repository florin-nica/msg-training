package com.msg.springtraining.myproject.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.*;

public class FilesService {

    final static private int BUFFER = 2048;
    private byte[] data = new byte[BUFFER];

    public List<String> readFromCSVFile(String filePath) throws IOException {

        Path file = FileSystems.getDefault().getPath(filePath);

        return Files.readAllLines(file);
    }

    public void archiveFileToZip(String fileToBeArchived) throws IOException {

        try (FileInputStream fileInputStream = new FileInputStream(fileToBeArchived);
             FileOutputStream destination = new FileOutputStream(fileToBeArchived.substring(0, fileToBeArchived.indexOf('.') + 1) + "zip");
             ZipOutputStream zipOutputStream = new ZipOutputStream(destination)) {

            zipOutputStream.putNextEntry(new ZipEntry(fileToBeArchived));

            byte[] data = new byte[BUFFER];

            int len;
            while ((len = fileInputStream.read(data)) > 0) {
                zipOutputStream.write(data, 0, len);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void unZipFile(String fileToBeUnzipped) throws IOException {

        try (FileInputStream fileInputStream = new FileInputStream(fileToBeUnzipped);
             FileOutputStream fileOuputStream = new FileOutputStream(fileToBeUnzipped.substring(0, fileToBeUnzipped.indexOf('.') + 1) + "unzipped");
             ZipInputStream zipInputStream = new ZipInputStream(fileInputStream)) {

            zipInputStream.getNextEntry();

            int len;
            while ((len = zipInputStream.read(data)) > 0) {
                fileOuputStream.write(data, 0, len);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void archiveFileToGZip(String fileToBeArchived) throws IOException {

        try (FileInputStream fileInputStream = new FileInputStream(fileToBeArchived);
             FileOutputStream destination = new FileOutputStream(fileToBeArchived.substring(0, fileToBeArchived.indexOf('.') + 1) + "gz");
             GZIPOutputStream gzipOutputStream = new GZIPOutputStream(destination)) {

            int len;
            while ((len = fileInputStream.read(data)) > 0) {
                gzipOutputStream.write(data, 0, len);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    public void unGZipFile(String fileToBeUnzipped) throws IOException {

        try (FileInputStream fileInputStream = new FileInputStream(fileToBeUnzipped);
             FileOutputStream fileOuputStream = new FileOutputStream(fileToBeUnzipped.substring(0, fileToBeUnzipped.indexOf('.') + 1) + "unzipped");
             GZIPInputStream gzipInputStream = new GZIPInputStream(fileInputStream)) {

            int len;
            while ((len = gzipInputStream.read(data)) > 0) {
                fileOuputStream.write(data, 0, len);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
