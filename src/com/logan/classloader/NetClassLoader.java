package com.logan.classloader;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * This class is based on network to load a class.
 * @author RongHeMaRongHe
 *
 */
public class NetClassLoader extends ClassLoader{


	private String url;

	public NetClassLoader(String url) {
		this.url = url;
	}

	@SuppressWarnings("deprecation")
	public Class<?> loadFile(String className){
		Class<?> clazz = null;

		clazz = findLoadedClass(className);

		if(clazz != null)
			return clazz;

		
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
		String calssPath = url + "/" + className.replace('.', '/') + ".class";
		byte[] buffer = new byte[1024];
		try {
			// different method to get stream.
			is = new URL(calssPath).openStream();
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
