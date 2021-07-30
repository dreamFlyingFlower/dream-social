package com.wy.base;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Configuration;

import com.wy.lang.AssertTool;

/**
 * 国际化配置读取,非Spring组件使用
 *
 * @author 飞花梦影
 * @date 2021-04-21 09:47:38
 * @git {@link https://github.com/dreamFlyingFlower}
 */
@Configuration
public class Internation {

	public static MessageSource messageSource;

	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		Internation.messageSource = messageSource;
	}

	public static String get(String key) {
		AssertTool.notBlank(key);
		return messageSource.getMessage(key, null, Locale.getDefault());
	}

	public static String get(String key, String defaultVal) {
		return messageSource.getMessage(key, null, defaultVal, Locale.getDefault());
	}

	public static String get(String key, Object... args) {
		AssertTool.notBlank(key);
		return messageSource.getMessage(key, args, Locale.getDefault());
	}

	public static String get(String key, String defaultVal, Object... args) {
		return messageSource.getMessage(key, args, defaultVal, Locale.getDefault());
	}

	public static String get(String key, Locale locale, Object... args) {
		AssertTool.notBlank(key);
		return messageSource.getMessage(key, args, locale);
	}

	public static String get(String key, String defaultVal, Locale locale, Object... args) {
		return messageSource.getMessage(key, args, defaultVal, locale);
	}
}