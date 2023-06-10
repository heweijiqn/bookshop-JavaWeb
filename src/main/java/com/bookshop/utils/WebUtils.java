package com.bookshop.utils;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

public class WebUtils {
    /**
     * 把Map中的值注入到对应的JavaBean属性中。
     * @param value
     * @param bean
     */
    public static <T> T copyParamToBean( Map value , T bean ){//多个参数，但是只有一个返回值，也可以是一个参数，但是有多个返回值
        try {
            System.out.println("注入之前：" + bean);
            /**
             * 把所有请求的参数都注入到user对象中
             */
            BeanUtils.populate(bean, value);
            System.out.println("注入之后：" + bean);
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
        return bean;
    }
    /**
     * 将字符串转换成为int类型的数据
     * @param strInt
     * @param defaultValue
     * @return
     */
    public static int parseInt(String strInt,int defaultValue) {//多个参数，但是只有一个返回值
        try {
            return Integer.parseInt(strInt);
        } catch (Exception e) {
            System.out.println("转换出错了");

        }
            return defaultValue;

    }

}
