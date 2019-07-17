package bio;

public class Main {
	public static void main(String[] args) {
		//启动服务器
		new TimeServer().bind(8989);
	}
}
