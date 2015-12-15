package boot.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Auth jay
 * @date 2015年12月8日 上午9:29:41
 */
public class ListSortTest {

	static class User {
		private String name;
		private Integer age;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		public User() {
		}

		public User(String name, Integer age) {
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			return "User [name=" + name + ", age=" + age + "]";
		}

	}

	public static void main(String[] args) {
		List<User> users = new ArrayList<User>();
		users.add(new User("mike", 21));
		users.add(new User("mike", 11));

		Collections.sort(users, new Comparator<User>() {
			public int compare(User arg0, User arg1) {
				int i = arg0.getName().compareTo(arg1.getName());
				if (i == 0) {
					return arg0.getAge().compareTo(arg1.getAge());
				}
				return i;
			}
		});

		for (User user : users) {
			System.out.println(user.toString());
		}

	}
}
