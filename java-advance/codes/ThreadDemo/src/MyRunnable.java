/**
 * Created by leeson8888 on 2018/5/5.
 */
class MyRunnable implements Runnable {
	private String title;

	public MyRunnable(String title) {
		this.title = title;
	}


	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(this.title + ",x=" + i);
		}
	}
}
