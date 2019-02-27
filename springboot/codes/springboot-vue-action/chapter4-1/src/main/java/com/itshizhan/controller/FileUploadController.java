/**
 * Created by leeson8888 on 2019/2/25.
 */
package com.itshizhan.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileUploadController {


	@PostMapping("upload")
	public String upload(MultipartFile uploadFile, HttpServletRequest req){


		//获取文件名
		String oldName = uploadFile.getOriginalFilename();
		//获取文件后缀名
		String suffixName = oldName.substring(oldName.lastIndexOf("."));

		//重新生成文件名
		String newName = UUID.randomUUID().toString() + suffixName;

		System.out.println("FileUploadController.upload:" + newName);

		String path = "/usr/local/var/www/gitclone/java_study_notes/springboot/codes/springboot-vue-action/chapter4-1/src/main/resources/static/";

		try {
			//将图片保存到static文件夹里
			uploadFile.transferTo(new File(path,newName));
			return  "Success:http://localhost:8080/static/" + newName;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "上传失败!";


	}
}
