package com.gwf.gwf.weather.basic.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

/**
 * @author gaowenfeng
 * @package com.gwf.gwf.weather.basic.util
 * @describe Xml构建工具
 * @date 2018/2/21
 */
public class XmlBuilter {

    /**
     * 将Xml字符串转化为java对象
     * @param clazz
     * @param xmlStr
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> T xmlStrToObject(Class<T> clazz,String xmlStr) throws Exception{
        Object xmlObject = null;
        JAXBContext context = JAXBContext.newInstance(clazz);

        // XML转化为对象的接口
        Unmarshaller unmarshaller = context.createUnmarshaller();

        try(Reader reader = new StringReader(xmlStr)
            ){
            xmlObject = unmarshaller.unmarshal(reader);
        }

        return (T)xmlObject;
    }
}
