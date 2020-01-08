package com.tree.www.spring;

import com.tree.www.spring.service.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by pysh on 2020-01-06.
 */
public class SpringTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
        MessageService service = context.getBean(MessageService.class);
        service.printMessage();
    }
}
