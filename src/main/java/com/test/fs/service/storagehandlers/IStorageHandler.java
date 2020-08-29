package com.test.fs.service.storagehandlers;

import java.io.InputStream;

public interface IStorageHandler {
    void upload(String key, InputStream inputStream, long contentLength, String contentType);
    String getDownloadLink(String key);
    void delete(String Key);
}
