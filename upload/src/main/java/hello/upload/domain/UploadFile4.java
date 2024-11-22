package hello.upload.domain;

import lombok.Data;

@Data
public class UploadFile4 {

    private String uploadFileName;
    private String storeFileName;

    public UploadFile4(String uploadFileName, String storeFileName) {
        this.uploadFileName = uploadFileName;
        this.storeFileName = storeFileName;
    }
}
