package cn.choleece.learn.alibaba.nacos.discovery.consumer.controller;

import cn.choleece.learn.alibaba.nacos.discovery.consumer.feign.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Created by choleece on 2019/4/20.
 */
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RestTemplate restTemplate1;

    @Autowired
    private EchoService echoService;

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/echo-rest/{str}", method = RequestMethod.GET)
    public String rest(@PathVariable String str) {
        return restTemplate.getForObject("http://nacos-discovery-provider/echo/" + str,
                String.class);
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return restTemplate1.getForObject("http://nacos-discovery-provider", String.class);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return restTemplate1.getForObject("http://nacos-discovery-provider/test", String.class);
    }

    @RequestMapping(value = "/sleep", method = RequestMethod.GET)
    public String sleep() {
        return restTemplate1.getForObject("http://nacos-discovery-provider/sleep", String.class);
    }

    @RequestMapping(value = "/notFound-feign", method = RequestMethod.GET)
    public String notFound() {
        return echoService.notFound();
    }

    @RequestMapping(value = "/divide-feign", method = RequestMethod.GET)
    public String divide(@RequestParam Integer a, @RequestParam Integer b) {
        return echoService.divide(a, b);
    }

    @RequestMapping(value = "/echo-feign/{str}", method = RequestMethod.GET)
    public String feign(@PathVariable String str) {
        return echoService.echo(str);
    }

    @RequestMapping(value = "/services/{service}", method = RequestMethod.GET)
    public Object client(@PathVariable String service) {
        return discoveryClient.getInstances(service);
    }

    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public Object services() {
        return discoveryClient.getServices();
    }
}
