package com.test.fs.service.storagehandlers;

import com.google.common.io.Files;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class LocalFileStorageHandler implements IStorageHandler {

  private String directory = "C:\\Users\\Naseer\\Downloads\\Compressed";

  @PostConstruct
  public void init() {

  }

  @Override
  public void upload(String key, InputStream inputStream, long contentLength, String contentType) {
    try {
      File file = new File(directory + "/" + key);
      Files.createParentDirs(file);
      file.createNewFile();
      copyInputStreamToFile(inputStream, file);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public String getDownloadLink(String key) {
    return directory + "/" + key;
  }

  @Override
  public void delete(String key) {
    File file = new File(directory + "/" + key);
    file.delete();
  }


  private void copyInputStreamToFile(InputStream inputStream, File file)
    throws IOException {

    try (FileOutputStream outputStream = new FileOutputStream(file)) {
      int read;
      byte[] bytes = new byte[1024];

      while ((read = inputStream.read(bytes)) != -1) {
        outputStream.write(bytes, 0, read);
      }
    }
  }

}
