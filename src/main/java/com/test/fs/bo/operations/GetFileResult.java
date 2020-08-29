package com.test.fs.bo.operations;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetFileResult {

    private Integer code;
    private String status;
    private String message;
    @JsonProperty("file_path")
    private String filePath;
    @JsonProperty("secure_file_path")
    private String secureFilePath;

    public GetFileResult() {
    }

    public GetFileResult(Integer code, String status, String message, String downloadLink) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.filePath = downloadLink;
        this.secureFilePath = downloadLink;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getSecureFilePath() {
        return secureFilePath;
    }

    public void setSecureFilePath(String secureFilePath) {
        this.secureFilePath = secureFilePath;
    }


}

