package com.tree.www.pattern.memento.memento2;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeanUtils {

	public static Map<String, Object> backupProp(Object bean) {
		Map<String, Object> result = new HashMap<String, Object>();

		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());

			PropertyDescriptor[] fields = beanInfo.getPropertyDescriptors();

			for (PropertyDescriptor propertyDescriptor : fields) {
				String fieldName = propertyDescriptor.getName();
				Method getter = propertyDescriptor.getReadMethod();

				Object fieldValue = getter.invoke(bean);

				if (!fieldName.equalsIgnoreCase("class")) {
					result.put(fieldName, fieldValue);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void restoreProp(Object bean, Map<String, Object> propMap) {
		try{
			BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
			PropertyDescriptor[] props = beanInfo.getPropertyDescriptors();

			for (PropertyDescriptor propertyDescriptor : props) {
				String fieldName = propertyDescriptor.getName();
				if (propMap.containsKey(fieldName)) {
					Method setter = propertyDescriptor.getWriteMethod();
					setter.invoke(bean, propMap.get(fieldName));
				}
			}
			
		}catch(Exception e){
			System.out.println("shit");
			e.printStackTrace();
		}
	}
}
