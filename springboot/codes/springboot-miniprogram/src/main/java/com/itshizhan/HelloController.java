/**
 * Created by leeson8888 on 2018/9/11.
 */
package com.itshizhan;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/hello")
	public String sayHello(){

		return "hello springboot";
	}
}
