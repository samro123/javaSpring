package com.checonbinh.controller;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class CustomLoader implements ResourceLoaderAware{
	private ResourceLoader resourceLoaders;

	public void setResourceLoader(ResourceLoader resourceLoader) {
		resourceLoaders = resourceLoader;
		
	}
	
	public Resource getResource(String link) {
		return resourceLoaders.getResource(link);
	}

}
