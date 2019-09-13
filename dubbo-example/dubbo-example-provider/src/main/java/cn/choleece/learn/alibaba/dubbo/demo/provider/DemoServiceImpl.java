package cn.choleece.learn.alibaba.dubbo.demo.provider;

import cn.choleece.learn.alibaba.dubbo.demo.DemoService;

public class DemoServiceImpl implements DemoService {

    @Override
    public String sayHello(String name) {
        return "hello " + name;
    }
}
