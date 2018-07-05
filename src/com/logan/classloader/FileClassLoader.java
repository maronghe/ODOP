package com.logan.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * This is a self defined file class loader
 * @author RongHeMaRongHe
 *
 */
public class FileClassLoader extends ClassLoader{

	private String filePath;

	public FileClassLoader(String filePath) {
		this.filePath = filePath;
	}

	@SuppressWarnings("deprecation")
	public Class<?> loadFile(String className){
		Class<?> clazz = null;

		clazz = findLoadedClass(className);

		if(clazz != null)
			return clazz;

//		try {
//			ClassLoader parent = this.getParent();
////			clazz = parent.loadClass(className);
//			if(clazz != null) {
//				return clazz;
//			}
//		} catch (ClassNotFoundException e) {
//			try {
//				throw new ClassNotFoundException("Parent can't load class.");
//			} catch (ClassNotFoundException e1) {
//				e1.printStackTrace();
//			}
//		}
		byte[] bytes = loadByMyself(className);
		
		clazz = defineClass(bytes, 0, bytes.length);
		
		if(clazz != null) {
			return clazz;
		}

		return null;
	}

	private byte[] loadByMyself(String className) {
		
		InputStream is = null;
		ByteArrayOutputStream abos = new ByteArrayOutputStream();
		String calssFilePath = filePath + "/" + className.replace('.', '/') + ".class";
		byte[] buffer = new byte[1024];
		try {
			is = new FileInputStream(new File(calssFilePath));
			int readLength = 0;
			while ((readLength = is.read(buffer) ) != -1) {
				abos.write(buffer,0,readLength);
			}
			return abos.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(abos != null) {
				try {
					abos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
		return null;
	}


}
