package com.xuantoan.springboot.utils;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Base64;

public class FileReadUtils {
    public static String readFile(String PATH_IMAGE, String fileName
                                ) throws IOException {
        String base64="";
        try {
            String urlPath = PATH_IMAGE+"//"+fileName;
            Path path = Paths.get(urlPath);
            //InputStream iSteamReader = new FileInputStream(path);
            byte[] arr = Files.readAllBytes(path);
            //byte[] buf = new byte[iSteamReader];

            base64 = Base64.getEncoder().encodeToString(arr);
            return base64;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "data:image/png;base64,"+base64;
    }
}
