package com.atguigu.admin.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 孙
 * @data 2021-8-13
 * 
 * 文件上传测试
 */

@Slf4j
@Controller
public class FormController {

	
	@GetMapping("/form_layouts")
	public String form_layouts() {
		
		return "form/form_layouts";
	}
	
	@PostMapping("/upload")
	public String upload(@RequestParam("email") String email ,
			             @RequestParam("username") String username ,
			             @RequestPart("headerImg") MultipartFile headerImg ,
			             @RequestPart("photos") MultipartFile[] photos) {
		
		log.info("上传的信息: email={} , username={}, headerImg={}, photos={}",email,username,headerImg.getSize(),photos.length);
		try {
			
		if (!headerImg.isEmpty()) {
			
				headerImg.transferTo(new File("C:\\Users\\Dell\\Desktop\\"+headerImg.getOriginalFilename()));
		
		}
		
		if (photos.length > 0) {
			
			for (MultipartFile photo : photos) {
				photo.transferTo(new File("C:\\Users\\Dell\\Desktop\\"+photo.getOriginalFilename()));
			}
			
		}
		
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "main";
	}
	
}
