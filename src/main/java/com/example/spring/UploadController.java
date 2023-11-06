package com.example.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/upload")
public class UploadController {

    @GetMapping
    public String doGet(){
        return "upload";
    }
    @PostMapping
    public ModelAndView uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        if (!file.isEmpty()) {
            try {
                String filePath = "uploads/" + file.getOriginalFilename();
                String realPath = request.getServletContext().getRealPath(filePath);
                System.out.println(realPath);
                File uploadFile = new File(realPath);
                File parentDir = uploadFile.getParentFile();

                if (!parentDir.exists()) {
                    parentDir.mkdirs();
                }

                file.transferTo(uploadFile);
                modelAndView.setViewName("uploadSuccess");
            } catch (IOException e) {
                e.printStackTrace();
                modelAndView.setViewName("uploadFailure");
            }
        } else {
            modelAndView.setViewName("upload");
        }
        return modelAndView;
    }
}