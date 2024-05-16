package com.devcarlos.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

//classe p decodificar a url
public class URL {
	
	//metodo p decodificar vai ser static p ñ precisar estanciar
	public static String decodeParam(String text) {
		
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}

}
