package hello.upload.domain;

import lombok.Data;

@Data
public class UploadFile7 {

    private String uploadFileName;
    private String storeFileName;

    public UploadFile7(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }
}
