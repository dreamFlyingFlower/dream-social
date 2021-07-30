package com.wy.services;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.ParameterNameDiscoverer;

/**
 * 非Spring组件中使用Spring组件
 *
 * @author 飞花梦影
 * @date 2021-07-30 16:41:04
 * @git {@link https://github.com/dreamFlyingFlower }
 */
public class SpringContextServices implements InitializingBean, ApplicationContextAware {

	/** Spring上下文 */
	private static ApplicationContext applicationContext;

	/** 该类为spring特有类,可以拿到反射中方法的形参名.需jdk1.8以上 */
	private static final ParameterNameDiscoverer PARAMETER_NAME_DISCOVERER;

	static {
		PARAMETER_NAME_DISCOVERER = new LocalVariableTableParameterNameDiscoverer();
	}

	public ApplicationContext getContext() {
		return applicationContext;
	}

	public ParameterNameDiscoverer getDisCoverer() {
		return PARAMETER_NAME_DISCOVERER;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextServices.applicationContext = applicationContext;
	}

	@Override
	public void afterPropertiesSet() throws Exception {

	}

	/**
	 * 根据bean的class来查找对象
	 * 
	 * @param c 需要查找的类字节码
	 * @return 对象
	 */
	public static <T> T getBean(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}

	/**
	 * 根据bean的beanName来查找对象
	 * 
	 * @param beanName spring组件中定义的value,若是不写,默认为类名首字母小写
	 * @return 对象,需强转
	 */
	public static Object getBean(String beanName) {
		return applicationContext.getBean(beanName);
	}

	/**
	 * 根据bean的class来查找所有的对象(包括子类) @param c 父类字节码
	 * 
	 * @return 所有子类
	 */
	public static <T> Map<String, T> getBeansOfType(Class<T> clazz) {
		return applicationContext.getBeansOfType(clazz);
	}

	/**
	 * 如果context中包含一个与所给名称匹配的bean定义则返回true
	 * 
	 * @param beanName spring组件的name
	 * @return boolean 是否存在
	 */
	public static boolean containsBean(String beanName) {
		return applicationContext.containsBean(beanName);
	}

	/**
	 * 根据beanName返回该组件的具体字节码类
	 * 
	 * @param beanName spring组件的name
	 * @return Class 注册对象的类型
	 */
	public static Class<?> getType(String beanName) {
		return applicationContext.getType(beanName);
	}
}