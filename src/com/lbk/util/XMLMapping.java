package com.lbk.util;
/** 
  * @author  LTC 
  * @date 创建时间：2017年12月20日 下午9:03:17 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.List;

public class XMLMapping {
	private static String configPath = XMLMapping.class.getClassLoader().getResource("resources/api-config.xml").getPath();
    private static Document document;
    private static Element rootElement;

    static {
        SAXReader saxReader = new SAXReader();
        try {
            document = saxReader.read(configPath);
            rootElement = document.getRootElement();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

    /**
     * Get method method.
     *
     * @param path the path
     * @return the method
     */
    public Method getMethod(String path){
        try{
            Element element = getMatchingElement(path);
            if(element!=null){
                String className = element.elementTextTrim("class");
                String methodName = element.elementTextTrim("method");
                Class<?> clazz = Class.forName(className);
                return clazz.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private Element getMatchingElement(String path){
        List<Element> elements = rootElement.elements();
        for (Element element : elements){
            if(element.attributeValue("path").equals(path)){
                return element;
            }
        }
        return null;
    }
}
