package com.lsj.trans.params;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public abstract class HttpParams {
	protected final Map<String, String> params = new HashMap<>();
	abstract public HttpParams put(String key, String value);
	abstract public String Send(String baseUrl) throws Exception;

	protected String ReadInputStream(InputStream is) throws Exception{
		InputStreamReader ir = new InputStreamReader(is);	//将字节流转换为字符流，否则中文容易乱码
		StringBuilder text = new StringBuilder();
		char[] buffer = new char[1024];
		int length = 0;
		
		while(((length = ir.read(buffer)) != -1)){
			text.append(new String(buffer, 0, length));
		}		
		
		return new String(text);
	}
}
