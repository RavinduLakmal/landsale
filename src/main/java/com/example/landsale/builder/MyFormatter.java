package com.example.landsale.builder;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import javax.imageio.stream.MemoryCacheImageOutputStream;
import java.awt.image.RenderedImage;
import java.io.*;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class MyFormatter {

    public Date getDateFormStr(String date){
        if (null !=date){
            try{
                return new SimpleDateFormat("yyyy-MM-dd").parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public File convertToFile(MultipartFile multipartFile)throws FileNotFoundException,IOException {
        File confile= new File(multipartFile.getOriginalFilename());
        confile.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(confile);
        fileOutputStream.write(multipartFile.getBytes());
        fileOutputStream.close();
        return confile;
    }

    public byte [] con(MultipartFile multipartFile)throws FileNotFoundException,IOException {
        File confile= new File(multipartFile.getOriginalFilename());
        confile.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(confile);
        fileOutputStream.write(multipartFile.getBytes());
        fileOutputStream.close();

        return multipartFile.getBytes();
//        return confile;
    }

    public byte[] compressImge(File originalFile,float quality) throws Exception{
        byte[] compressImageBytes;

        RenderedImage renderedImage = ImageIO.read(originalFile);
        ImageWriter imageWriter = ImageIO.getImageWritersByFormatName("jpg").next();
        ImageWriteParam imageWriteParam = imageWriter.getDefaultWriteParam();
        imageWriteParam.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        imageWriteParam.setCompressionQuality(quality);

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ImageOutputStream output = new MemoryCacheImageOutputStream(baos)) {
            imageWriter.setOutput(output);
            IIOImage outputImage = new IIOImage(renderedImage, null, null);
            imageWriter.write(null, outputImage, imageWriteParam);

            compressImageBytes = baos.toByteArray();

        }

        imageWriter.dispose();
        originalFile.delete();

        return compressImageBytes;
    }



    public Date getTimestampFromStr(String date) {
        if (null != date) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(date);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public String getDateStrFromDate(Date date) {
        if (null == date) {
            return null;
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(date);

    }

    public String getTimestampStrFromDate(Date date) {
        if (null == date) {
            return null;
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public Date getDateFromSimpleDateFormat(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        if (null != dateFormat.format(date)) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(dateFormat.format(date));
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public String getCurrentTime(Time mytime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("kkmmss");
        String currentTime = dateFormat.format(System.currentTimeMillis());
        return currentTime;
    }
}
