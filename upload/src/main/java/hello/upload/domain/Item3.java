package hello.upload.domain;

import lombok.Data;

import java.util.List;

@Data
public class Item3 {

    private Long id;
    private String itemName;
    private UploadFile attachFile;
    private List<UploadFile> imageFiles;
}
