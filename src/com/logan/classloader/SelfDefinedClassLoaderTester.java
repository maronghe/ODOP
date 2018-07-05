package com.logan.classloader;

/**
 * 
 * Bootstrap ClassLoader : ���غ��Ŀ⣬���� JAVA_HOME/jre/lib/rt.jar ��
 * Extention ClassLoader : ������չ�⣬ ���� JAVA_HOME/jre/lib/ext/ �µ��ļ�
 * Application ClassLoader : ���ص�ǰclass path �µ���������
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
