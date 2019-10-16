package cn.bps.controller;

import cn.bps.domain.UploadedFile;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


@Controller
public class Html5FileUploadController {

    private static final Log logger = LogFactory.getLog(Html5FileUploadController.class);

    @RequestMapping(value = "/html5")
    public String inputProduct(){
        return "html5";
    }

    @RequestMapping(value = "/file-upload",method = RequestMethod.POST)
    public String saveFile(HttpServletRequest request, @ModelAttribute UploadedFile uploadedFile,
                         Model model){
        MultipartFile multipartFile = uploadedFile.getMultipartFile();

        String fileName = multipartFile.getOriginalFilename();

        try{
            File file = new File(request.getServletContext().getRealPath("/file"),fileName);
            System.out.println(file.getPath());
            multipartFile.transferTo(file);
        }catch (IOException e){
            e.printStackTrace();
        }

        model.addAttribute("uploadedFile",uploadedFile);
        return "show";
    }
}
