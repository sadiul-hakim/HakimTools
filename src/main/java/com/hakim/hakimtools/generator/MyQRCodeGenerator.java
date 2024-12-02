package com.hakim.hakimtools.generator;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import javax.imageio.ImageIO;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyQRCodeGenerator {
    private static final Logger LOGGER = Logger.getLogger(MyQRCodeGenerator.class.getName());

    private MyQRCodeGenerator() {
    }

    public static void generate(String content, String path) throws RuntimeException {
        try {
            File file = new File(path);

            ImageType type;
            if (path.endsWith(".jpg")) {
                type = ImageType.JPG;
            } else if (path.endsWith(".png")) {
                type = ImageType.PNG;
            } else {
                throw new RuntimeException("Invalid Image Type");
            }

            ByteArrayOutputStream out = QRCode.from(content).to(type).stream();
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(out.toByteArray());

            fos.close();

        } catch (Exception ex) {
            LOGGER.log(Level.INFO, ex.getMessage());
            throw new RuntimeException(ex);
        }
    }

    public static String read(String path) {
        try {
            File file = new File(path);
            Result result = new MultiFormatReader().decode(new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(file)))));
            return result.getText();
        } catch (Exception ex) {
            LOGGER.log(Level.INFO, ex.getMessage());
            throw new RuntimeException(ex);
        }
    }
}
