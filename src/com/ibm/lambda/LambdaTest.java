package com.ibm.lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import javax.swing.JButton;

/**
 * Lambda 表达式 测试类
 * @author RongHeMaRongHe
 *
 */
public class LambdaTest {
	public static void main(String[] args) {
		// 创建一个Jbutton
		JButton jButton = new JButton("btn");
		// 添加一个监听类
		jButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("do something.");
			}
		});
		
		// 1.8 lambda写法
		jButton.addActionListener( e -> {
			System.out.println("hello, This is lambda.");
		});
		
		
		/*      之前写法         */
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("aaa");
			}
		});

		// 1.8写法 创建线程
		Thread thread = new Thread(()->{
			System.out.println("HHH");
		}) ;
		thread.start();

		System.out.println("---------");
	
		// 转换数字Function
		Function<String,Integer> function = Integer::parseInt;
		
		// 判断返回布尔类型
		Predicate<String> predicate = str-> str.startsWith("1");
		
		// 执行类AA的构造方法
		Consumer<String> consumer = AA::new;

		// 将字符串类型"123" 转换成123数字类型
		System.out.println(function.apply("123"));
		// 判断是否以1 开头
		predicate.test("123");
		// 执行类AA的构造方法
		consumer.accept("asd");
		
		System.out.println("---------");
		
		// stream 操作
		
		//创建数组
		List<String> list= Arrays.asList(null,"123","asdasd","asdas","as","as","123123");
		// .stream().forEach() 循环遍历，Function
		list.stream().forEach(System.out::println);
		
		System.out.println("=============");
		// distinct 去重; filter 过滤器； map转换； forEach输出
		list.stream()
		.distinct()
		.filter(a-> a != null)
		.filter(a-> Pattern.compile("^[-\\+]?[\\d]*$").matcher(a).matches())
		.map(Double::parseDouble).
		forEach(System.out::println);;
		
		System.out.println("-------------");	
		list.stream().filter(a->a!=null).forEach(System.out :: println);
		System.out.println("********************");
		List<Integer> nums = Arrays.asList(1,2,3,null,2,3,3,14,3,null);
		
		// method 1
//		List<Integer> nums1 = nums.stream()
//				.filter(a -> a !=null)
//				.collect(ArrayList::new,ArrayList::add,ArrayList::addAll);

		// method 2
//		List<Integer> nums1 = nums.stream()
//		.filter(a->a!=null)
//		.collect(Collectors.toList());
//		nums1.forEach(System.out :: println);
		
		// 以100为基础上 求和 
		System.out.println(nums.stream().filter(a->a!=null).reduce(100, (a,b)->(a+b)));;
		
	}
}
class AA{
	public AA(String str) {
		System.out.println(str);
	}
}
