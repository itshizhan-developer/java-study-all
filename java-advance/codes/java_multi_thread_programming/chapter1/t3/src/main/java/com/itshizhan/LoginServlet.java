/**
 * Created by leeson8888 on 2018/8/8.
 */
package com.itshizhan;

public class LoginServlet {
	private static String unameRef;
	private static String pwdRef;

	synchronized  public static void Post(String uname,String pwd){
		try {
			unameRef = uname;
			if(uname.equals("a")){
				Thread.sleep(5000);
			}
			pwdRef = pwd;

			System.out.println("uname = [" + unameRef + "], pwd = [" + pwdRef + "]");
		}catch (Exception e){
			e.printStackTrace();

		}
	}
}
