package com.example.bootrestbookapplication.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.plaf.PanelUI;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

@Component
public class FileUploadHelper {

    public final String UPLOAD_DIR="D:\\";

    public boolean uploadFile(MultipartFile multipartFile){
        boolean flag =  false;

        try {
//            Input Stream
            InputStream inputStream =  multipartFile.getInputStream();
            byte data[] = new byte[inputStream.available()];

//            write
            FileOutputStream fileOutputStream = new FileOutputStream(UPLOAD_DIR+ File.separator+multipartFile.getOriginalFilename());
            fileOutputStream.write(data);
            fileOutputStream.flush();
            fileOutputStream.close();
            flag=true;

        } catch (Exception e) {
            e.printStackTrace();
        }



        return flag;
    }
}
