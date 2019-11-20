package com.caishen91.jupiter.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author jgn
 * @date 2018/6/13 下午3:38
 * @desc
 */
@Component
public class BeanFactoryUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext = null;



    /**
     * Spring容器启动后，会把 applicationContext 给自动注入进来，然后我们把 applicationContext 赋值到静态变量中，方便后续拿到容器对象
     * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
     * @param applicationContext
     * @throws BeansException
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(BeanFactoryUtil.applicationContext == null){
            BeanFactoryUtil.applicationContext  = applicationContext;
        }
    }

    //获取applicationContext
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    //通过name获取 Bean.
    //@service("***")需要 ***
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);

    }
    public static ApplicationContext getContext(){
        return applicationContext;
    }

    //通过class获取Bean.
    //@service("***")不需要 ***
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    //通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }
}
