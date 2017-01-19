package com.arolla.legacy.testing.quotebot;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class AdSpace {

	private static Map<String, Collection<String>> cache = new HashMap<String, Collection<String>>();

	public Collection<String> getAdSpaces_(Supplier<Collection<String>> allBlogs){
		if (cache.containsKey("blogs list")) {
			return cache.get("blogs list");
		}
		// FIXME : only return blogs that start with a 'T'
		Collection<String> listAllBlogs = allBlogs.get();
		cache.put("blogs list", listAllBlogs);
		return listAllBlogs;
	}

	public static Collection<String> getAdSpaces() {
		return new AdSpace().getAdSpaces_(TechBlogs::listAllBlogs);
	}
}
