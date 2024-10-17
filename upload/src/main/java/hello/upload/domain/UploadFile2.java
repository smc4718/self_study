package hello.upload.domain;

import lombok.Data;

@Data
public class UploadFile2 {

    private String uploadFileName;
    private String storeFileName;

    public UploadFile2(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }
}
