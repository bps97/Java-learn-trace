package cn.bps.mms.controller;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.*;


@RestController
public class DownloadController {

    final static String fileUploadRootDir = "D://download/";

    @GetMapping("/download/{fileName}")
    @ResponseBody
    public ResponseEntity<Object> downloadFile(@PathVariable(name = "fileName") String fileName) throws FileNotFoundException {

        File file = new File ( fileUploadRootDir + fileName);
        InputStreamResource resource = new InputStreamResource ( new FileInputStream ( file ) );

        HttpHeaders headers = new HttpHeaders();
        headers.add ( "Content-Disposition",String.format("attachment;filename=\"%s",fileName));
        headers.add ( "Cache-Control","no-cache,no-store,must-revalidate" );
        headers.add ( "Pragma","no-cache" );
        headers.add ( "Expires","0" );

        ResponseEntity<Object> responseEntity = ResponseEntity.ok()
                .headers ( headers )
                .contentLength ( file.length ())
                .contentType(MediaType.parseMediaType ( "application/txt" ))
                .body(resource);

        return responseEntity;
    }

}