package com.logan.classloader;

/**
 * 
 * Bootstrap ClassLoader : 加载核心库，加载 JAVA_HOME/jre/lib/rt.jar 等
 * Extention ClassLoader : 加载扩展库， 加载 JAVA_HOME/jre/lib/ext/ 下的文件
 * Application ClassLoader : 加载当前class path 下的所有文类
 * 
 * @author RongHeMaRongHe
 *
 */
public class SelfDefinedClassLoaderTester {
	public static void main(String[] args) {
		FileClassLoader classLoader = new FileClassLoader("C:\\myjava");
		Class<?> c1 = classLoader.loadFile("com.logan.classloader.MyClass");
		Class<?> c2 = classLoader.loadFile("com.logan.classloader.MyClass");
	
//		System.out.println(classLoader.getParent().getParent());
		
		System.out.println(c1);
		System.out.println(c1.getClassLoader());
		System.out.println(c1.hashCode());
		
		System.out.println(c2);
		System.out.println(c2.getClassLoader());
		System.out.println(c2.hashCode());
		
	}
}
