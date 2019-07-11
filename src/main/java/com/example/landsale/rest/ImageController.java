
package com.example.landsale.rest;

import com.example.landsale.builder.MyFormatter;
import org.apache.commons.io.FilenameUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

@RestController
@RequestMapping("/api")
@CrossOrigin()
public class ImageController {

    @Autowired
    private Environment environment;
    @Autowired
    MyFormatter myFormatter;

    @PostMapping("/image")
    public String at(@RequestParam(value = "file", required = false) MultipartFile file) {

        String fName = "";
        try {

            File dir = new File(environment.getRequiredProperty("file.path"));
            System.out.println(dir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            byte[] bytes;

            String fileExtention = FilenameUtils.getExtension(file.getOriginalFilename());

            if (fileExtention.equals("PNG")) {

                bytes = file.getBytes();

            } else {

                File orginalFile = myFormatter.convertToFile(file);
                System.out.println(orginalFile + " ordinal File");
                bytes = myFormatter.compressImge(orginalFile, 0.5f);

            }

            fName = new Date().getTime() + "_" + file.getOriginalFilename();

            File serverFile = new File(dir.getAbsolutePath() + File.separator + fName);
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
            stream.write(bytes);
            stream.close();

            System.out.println(file.getContentType());

        } catch (Exception e) {
            System.out.println("Exception Availble  -  " + e.getMessage());
        }

        JSONObject j = new JSONObject();
        j.put("url", "api/image/" + fName);

        return j.toString();
    }

    @GetMapping("/image/{name:.+}")
    public ResponseEntity<Resource> file(
            @PathVariable(value = "name") String name
    ) throws IOException, InterruptedException {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.set(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=" + name);

        File file = new File(environment.getRequiredProperty("file.path") + File.separator + name);

        System.out.println(file);


        Path pathF = Paths.get(file.getAbsolutePath());
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(pathF));


        System.out.println(pathF);

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(resource);
    }


    @PostMapping("/files")
    public String saveFile(@RequestParam(value = "files", required = false) MultipartFile multipartFile) {
        String fName = "";

        try {



            File dir = new File(environment.getRequiredProperty("file.path"));

            int count = 0;

            File file;
            byte[] bytes;

            String extension = FilenameUtils.getExtension(multipartFile.getOriginalFilename());

            if (extension.equals("txt")) {
                Path filepath = Paths.get(dir.toString(), multipartFile.getOriginalFilename());
                fName=filepath+"";
                System.out.println(filepath);
                try (OutputStream os = Files.newOutputStream(filepath)) {
                    os.write(multipartFile.getBytes());
                }
            }

        } catch (Exception e) {
            System.out.println(e + " kjfdf");
        }
        JSONObject j = new JSONObject();
        j.put("url", "api/image/" + fName);

        return j.toString();
    }



}
