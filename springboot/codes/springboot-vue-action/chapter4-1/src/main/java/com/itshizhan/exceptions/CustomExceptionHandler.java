/**
 * Created by leeson8888 on 2019/2/26.
 */
package com.itshizhan.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public  void uploadException(MaxUploadSizeExceededException e, HttpServletResponse response)
					throws IOException {
		  // 防止中文乱码
			response.setContentType("text/html;charset=utf-8");
		  PrintWriter printWriter = response.getWriter();
		  printWriter.write("文件上传大小超出限制");
		  printWriter.flush();
		  printWriter.close();
	}
}
