package cn.bps.controller;

import cn.bps.domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {

    @RequestMapping(value = "/upload")
    public ModelAndView upload(){
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/save-resource",method = RequestMethod.POST)
    public String saveResource(HttpServletRequest request,
                               @ModelAttribute Product product, Model model){
        List<MultipartFile> files = product.getImages();
        if(files != null && files.size() > 0){
            for(MultipartFile multipartFile : files){
                String fileName = multipartFile.getOriginalFilename();
                File imageFile = new
                        File(request.getServletContext().getRealPath("/images"),fileName);
                System.out.println("文件存储在--> "+imageFile.getPath());
                try{
                    multipartFile.transferTo(imageFile);
                }catch (IOException e){
                    e.printStackTrace();
                    System.out.println("文件保存失败");
                }
            }
        }
        //model.addAttribute("product",product);
        return "show";
    }
}
