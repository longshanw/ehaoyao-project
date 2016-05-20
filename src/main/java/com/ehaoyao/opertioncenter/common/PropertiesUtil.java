package com.ehaoyao.opertioncenter.common;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
/**
 * 
 * Title: PropertiesUtil.java
 * 
 * Description: properties文件操作
 * 
 * @author xcl
 * @version 1.0
 * @created 2014年8月27日 上午10:20:53
 */
public class PropertiesUtil {
	private static final Logger logger = Logger.getLogger(PropertiesUtil.class);
	public static Map<String,Properties> proMap = new HashMap<String,Properties>();
	
	/**
	 * 
	 * 读取properties
	 * @param filePath
	 * @param key
	 * @return
	 */
	public static String getProperties(String filePath,String key){
		try {
			Properties prop = getPropertiesFile(filePath);
			String val = null;
			if(prop.get(key)!=null){
				val = prop.get(key).toString();
			}
			return val;
		} catch (Exception e) {
			logger.error("properties文件"+filePath+"读取 "+key+" 值异常！");
		}
		return null;
	}
	
	/**
	 * 读取properties文件
	 * @param filePath 文件路径
	 * @return
	 */
	public static Properties getPropertiesFile(String filePath){
		InputStream in = null;
		Properties prop = null;
		try {
			if(proMap==null){
				proMap = new HashMap<String,Properties>();
			}
			if(proMap.get(filePath)==null){
				logger.info("加载配置文件:"+filePath);
				in = PropertiesUtil.class.getClassLoader().getResourceAsStream(filePath);				
				prop = new Properties();
				prop.load(in);
				proMap.put(filePath, prop);
				in.close();
			}else{
				prop = proMap.get(filePath);
			}
			return prop;
		} catch (Exception e) {
			logger.error("配置文件"+filePath+"加载异常",e);
			try{
				if(in != null) in.close();
			}catch(Exception ee){}
			return prop;
		}
		
	}
}