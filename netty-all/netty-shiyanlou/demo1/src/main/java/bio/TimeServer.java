package bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {

	public void bind(int port) {
		// Java7新特性，支持使用try后面跟随（）括号管理释放资源
		// try括号内的资源会在try语句结束后自动释放，前提是这些可关闭的资源必须实现 java.lang.AutoCloseable 接口。
		try (
			//启动tcp服务器并监听指定端口
			ServerSocket serverSocket = new ServerSocket(port)
		) {
			System.out.println("服务器启动成功");
			//通过死循环来监听客户端连接
			while (true) {
				System.out.println("等待客户端连接");
				//accept方法会阻塞到有客户端连接进来
				// 用accept方法来接收客户端的连接，该方法在没有客户端连接到服务器时会一直阻塞。
				Socket socket = serverSocket.accept();
				System.out.println("客户端连接成功");
				//开启一个线程去处理对应的客户端连接
				new Thread(new TimeServerHandle(socket)).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}





}

