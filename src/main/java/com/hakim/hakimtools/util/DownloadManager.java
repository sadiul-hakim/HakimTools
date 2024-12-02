package com.hakim.hakimtools.util;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.Callable;

public class DownloadManager implements Callable<Boolean> {

    private final String urlText;
    private final String realPath;

    public DownloadManager(String urlText, String realPath) {
        this.urlText = urlText;
        this.realPath = realPath;
    }


    @Override
    public Boolean call() throws Exception {
        File file = new File(realPath);
        if(!file.exists()){
            file.createNewFile();
        }

        URL url = new URL(urlText);
        URLConnection urlConnection = url.openConnection();
        InputStream inputStream = urlConnection.getInputStream();

        Files.copy(inputStream,file.toPath(), StandardCopyOption.REPLACE_EXISTING);

        return true;
    }
}
