/**
 * Created by leeson8888 on 2018/8/8.
 */
package com.itshizhan;

public class Blogin extends  Thread{
	@Override
	public void run() {
		super.run();
		LoginServlet.Post("b","bbbb");
	}
}
