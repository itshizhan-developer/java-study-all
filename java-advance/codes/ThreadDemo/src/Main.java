public class Main {

	public static void main(String[] args) {

		MyThread threadA = new MyThread("线程A");
		threadA.start();
		MyThread threadB = new MyThread("线程B");
		threadB.start();

	}
}
