package boot.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jay
 * @date 2015年12月9日 下午5:00:27
 */
public class ListSubTest {
	public static void main(String[] args) {
			List<String> list = new ArrayList<String>();
			list.add("a");
			list.add("b");
			list.add("c");
			list.add("d");
			
			System.out.println(list.subList(1, 3));
			
	}
}
