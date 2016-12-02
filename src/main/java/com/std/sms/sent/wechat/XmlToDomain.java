/**
 * @Title XmlConverterBean.java 
 * @Package com.std.sms.sent.wechat 
 * @Description 
 * @author xieyj  
 * @date 2016年12月2日 下午4:43:59 
 * @version V1.0   
 */
package com.std.sms.sent.wechat;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/** 
 * @author: xieyj 
 * @since: 2016年12月2日 下午4:43:59 
 * @history:
 */
public class XmlToDomain {

    /**
     * 解析微信xml消息
     * @param xml 
     * @create: 2016年12月2日 下午4:39:33 xieyj
     * @history:
     */
    public ReceiveXml convertXml(String strXml) {
        ReceiveXml msg = null;
        try {
            if (strXml.length() <= 0 || strXml == null)
                return null;

            // 将字符串转化为XML文档对象
            Document document = DocumentHelper.parseText(strXml);
            // 获得文档的根节点
            Element root = document.getRootElement();
            // 遍历根节点下所有子节点
            Iterator<?> iter = root.elementIterator();
            // 遍历所有结点
            msg = new ReceiveXml();
            // 利用反射机制，调用set方法
            // 获取该实体的元类型
            Class<?> c = Class.forName("com.std.sms.sent.wechat.ReceiveXml");
            msg = (ReceiveXml) c.newInstance();// 创建这个实体的对象

            while (iter.hasNext()) {
                Element ele = (Element) iter.next();
                // 获取set方法中的参数字段（实体类的属性）
                Field field = c.getDeclaredField(ele.getName());
                // 获取set方法，field.getType())获取它的参数数据类型
                Method method = c.getDeclaredMethod("set" + ele.getName(),
                    field.getType());
                // 调用set方法
                method.invoke(msg, ele.getText());
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("xml 格式异常: " + strXml);
            e.printStackTrace();
        }
        return msg;
    }
}
