package hello.upload.domain;

import lombok.Data;

@Data
public class UploadFile3 {

    private String uploadFileName;
    private String storeFileName;

    public UploadFile3(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }
}
