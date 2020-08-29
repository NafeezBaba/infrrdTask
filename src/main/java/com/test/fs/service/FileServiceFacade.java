package com.test.fs.service;

import com.jcabi.aspects.Loggable;
import com.test.fs.bo.operations.DeleteFileResult;
import com.test.fs.bo.operations.GetFileResult;
import com.test.fs.bo.operations.UploadResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.net.URLConnection;

@Service
@Loggable
public class FileServiceFacade {

  @Autowired
  private StorageHandlerFactory storageHandlerFactory;

  public UploadResult upload(InputStream inputStream, long contentLength, String fileName){
    String contentType =  getContentType(fileName);
    StorageHandlerFactory.Type storageType = StorageHandlerFactory.Type.LOCALFILE;
    storageHandlerFactory.getStorageHandler(storageType).upload(fileName, inputStream, contentLength, contentType);
    return new UploadResult(200, "true", "Successfully uploaded file");
  }


  private String getContentType(String fileName){
      String contentType = (URLConnection.guessContentTypeFromName(fileName));
      if (contentType!=null && !contentType.isEmpty())
        return contentType;
      if (fileName.contains(".jhtml"))
        return "text/jhtml";
      if (fileName.contains(".jap"))
        return "application/jap";
      if (fileName.contains(".css"))
        return "text/css";
      if (fileName.contains(".js"))
        return "text/javascript";
      return contentType;
  }


  public GetFileResult get(String fileName) {
    StorageHandlerFactory.Type storageType = StorageHandlerFactory.Type.LOCALFILE;
    String downloadLink = storageHandlerFactory.getStorageHandler(storageType).getDownloadLink(fileName);
    return new GetFileResult(200, "true", "Success", downloadLink);
  }


  public DeleteFileResult delete(String fileName)
  {
    storageHandlerFactory.getStorageHandler(StorageHandlerFactory.Type.LOCALFILE).delete(fileName);
    return new DeleteFileResult(200,"true","Success");
  }




}
