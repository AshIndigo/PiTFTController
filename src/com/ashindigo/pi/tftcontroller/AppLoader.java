package com.ashindigo.pi.tftcontroller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import com.google.common.collect.Lists;

public class AppLoader {
	
	static ArrayList<IApplication> appList = new ArrayList<IApplication>();

	public static void loadInternal() throws InstantiationException, IllegalAccessException {
		
		// Credit to Aleksander Blomskøld on Stackoverflow for the package checking code
		List<ClassLoader> classLoadersList = new LinkedList<ClassLoader>();
		classLoadersList.add(ClasspathHelper.contextClassLoader());
		classLoadersList.add(ClasspathHelper.staticClassLoader());

		Reflections reflections = new Reflections(new ConfigurationBuilder()
		    .setScanners(new SubTypesScanner(false), new ResourcesScanner())
		    .setUrls(ClasspathHelper.forClassLoader(classLoadersList.toArray(new ClassLoader[0])))
		    .filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix("com.ashindigo.pi.tftcontroller.apps"))));
		Set<Class<?>> classes = reflections.getSubTypesOf(Object.class);
	
		ArrayList<Class<?>> classess = new ArrayList<Class<?>>(Lists.newArrayList( classes.toArray(new Class<?>[]{})));
		for (int i = 0; classess.size() > i; i++) {
			if (Lists.newArrayList(classess.get(i).getInterfaces()).contains(IApplication.class)) {
				appList.add((IApplication) classess.get(i).newInstance());
			}
		}
	}
	
	// Oh god what is this mess
	public static void loadExternal() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		File[] folder = new File(System.getProperty("user.dir") + "/apps/").listFiles(new JarFileNameFilter());
		for (int i = 0; folder.length > i; i++) {
			JarFile jar = new JarFile(folder[i]);
			Enumeration<JarEntry> enum1 = jar.entries();
			while (enum1.hasMoreElements()) {
				JarEntry je = enum1.nextElement();
				if (je.getName().endsWith(".class")) {
					ClassLoader cl = new URLClassLoader(new URL[]{folder[i].toURI().toURL()});
					Class<?> clazz = cl.loadClass(je.getName().replaceAll("/", ".").replaceAll(".class", ""));
					if (Lists.newArrayList(clazz.getInterfaces()).contains(IApplication.class)) {
						appList.add((IApplication) clazz.newInstance());
					}
				}
			}
		}
	}

}
