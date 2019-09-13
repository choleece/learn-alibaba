package cn.choleece.learn.alibaba.dubbo.demo.consumer;

import cn.choleece.learn.alibaba.dubbo.demo.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author choleece
 */
public class Consumer {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/dubbo-demo-consumer.xml"});

        context.start();

        DemoService demoService = (DemoService) context.getBean("demoService");

        String hello = demoService.sayHello("choleece");

        System.out.println(hello);
    }

}
