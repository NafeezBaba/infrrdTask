package com.test.fs.controller;

import com.test.fs.bo.operations.DeleteFileResult;
import com.test.fs.bo.operations.GetFileResult;
import com.test.fs.bo.operations.UploadResult;
import com.test.fs.service.FileServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.QueryParam;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;


@RestController
@RequestMapping("/fileservice")
public class FileServiceController {


    @GetMapping("/ping")
    public String ping() {
        return "ping";
    }

    @Autowired
    private FileServiceFacade fileServiceFacade;

    @GetMapping(produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> getFileByName(@RequestParam("fileName") String fileName) throws IOException {
        GetFileResult result = fileServiceFacade.get(fileName);
        File file = new File(result.getFilePath());
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        return ResponseEntity.ok().contentLength(file.length()).contentType(MediaType.APPLICATION_OCTET_STREAM).body(resource);
    }

    @RequestMapping(method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
    public DeleteFileResult deleteFileByName(@RequestParam("fileName") String fileName){
        return fileServiceFacade.delete(fileName);
    }

    @PostMapping()
    public UploadResult upload(HttpServletRequest request, @QueryParam("fileName") String fileName ) throws IOException {
        InputStream stream = request.getInputStream();
        int contentLength = request.getContentLength();
        return fileServiceFacade.upload(stream,contentLength,fileName);
    }
}
