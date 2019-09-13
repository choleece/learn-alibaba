package cn.choleece.learn.alibaba.dubbo.demo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author choleece
 */
public class Provider {

    public static void main(String[] args) throws IOException {
        System.getProperty("java.net.preferIPv4Stack", "true");

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"META-INF/spring/dubbo-demo-provider.xml"});

        context.start();

        System.out.println("Provider started!");

        System.in.read();

    }

}
