package com.example.polly.util;

/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Excelע�ⶨ��
 * @author ThinkGem
 * @version 2013-03-10
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelField {

	/**
	 * �����ֶ�����Ĭ�ϵ��õ�ǰ�ֶεġ�get����������ָ�������ֶ�Ϊ��������д��������.�������ԡ���������area.name������office.name����
	 */
	String value() default "";
	
	/**
	 * �����ֶα��⣨��Ҫ�����ע���á�**���ָ�������**��ע�����Ե���ģ����Ч��
	 */
	String title();
	
	/**
	 * �ֶ����ͣ�0���������룻1����������2�������룩
	 */
	int type() default 0;

	/**
	 * �����ֶζ��뷽ʽ��0���Զ���1������2�����У�3�����ң�
	 */
	int align() default 0;
	
	/**
	 * �����ֶ��ֶ���������
	 */
	int sort() default 0;

	/**
	 * ������ֵ����ͣ��������ֵ��typeֵ
	 */
	String dictType() default "";
	
	/**
	 * ��������
	 */
	Class<?> fieldType() default Class.class;
	
	/**
	 * �ֶι����飨���ݷ��鵼�����룩
	 */
	int[] groups() default {};
}

