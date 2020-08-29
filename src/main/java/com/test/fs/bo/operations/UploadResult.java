package com.test.fs.bo.operations;


public class UploadResult {

    public UploadResult() {
    }

    public UploadResult(Integer code, String status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
    }

    private Integer code;
    private String status;
    private String message;

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

}
