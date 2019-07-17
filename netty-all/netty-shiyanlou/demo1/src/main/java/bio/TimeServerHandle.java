package bio;

import java.io.*;
import java.net.Socket;
import java.util.Date;


class TimeServerHandle implements Runnable {

	private Socket socket;

	public TimeServerHandle(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try (
						//拿到客户端的输入、输出流
						BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))
		) {
			String line;
			//循环读取一行字符串，如果非空则一直读
			while ((line = reader.readLine()) != null) {
				System.out.println("接收到客户端数据：" + line);
				//判断客户端输入的字符串是否为Get Date
				if (line.equalsIgnoreCase("Get Date")) {
					//输出服务器时间字符串
					writer.write(new Date().toString());
				} else {
					//提示客户端请求有误
					writer.write("Bad Request");
				}
				writer.newLine();
				//刷新缓冲区
				writer.flush();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

