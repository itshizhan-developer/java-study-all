import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {

			//collectionsOne();
			//collectionsTwo();
			//CollectionsThree();
			CollectionsFour();
    }

		public static void collectionsOne(){
			// 面向接口编写，运行时，表现来的是子类的特征（多态）
			Collection c = new ArrayList();
			boolean b1 = c.add("abc");
			boolean b2 = c.add(10);
			boolean b3 = c.add(true);

			Student s = new Student();
			s.setName("Lesson");
			s.setAge("17");
			boolean b4 = c.add(s);
			boolean b5 = c.add("abc");

			System.out.println(b1);
			System.out.println(b2);
			System.out.println(b3);
			System.out.println(b4);
			System.out.println(b5);
			// 以上全部返还 true
			System.out.println(c);

		}

		public static  void  collectionsTwo(){

			Collection c = new ArrayList();
			c.add("a");
			c.add("b");
			c.add("c");

			System.out.println(c);

			c.remove("a");
			System.out.println(c);
			System.out.println(c.size());

			c.clear();
			System.out.println(c.size());

		}

		public  static void  CollectionsThree(){

			Collection c = new ArrayList();
			c.add("a");
			c.add("b");
			c.add("c");

			System.out.println(c);

			Object[] arr = c.toArray();
			for(int i=0;i<arr.length;i++){
				System.out.println("集合遍历，下标"+i+"："+arr[i]);
			}

		}


	public  static void  CollectionsFour(){

		Collection c = new ArrayList();
		c.add(new Dog("dog1"));
		c.add(new Dog("dog2"));


		Object[] arr = c.toArray();
		for(int i=0;i<arr.length;i++){
			System.out.println("集合数据："+arr[i]);
			Dog dog = (Dog)arr[i];
			System.out.println("集合数据："+dog.getName());
		}

	}

}

class Dog{
	private  String name;

	public Dog(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}


class  Student{
	private String name;
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}


}
