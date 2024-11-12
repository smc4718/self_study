package hello.upload.domain;

import lombok.Data;

@Data
public class UploadFile6 {

    private String uploadFileName;
    private String storeFileName;

    public UploadFile6(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }
}
