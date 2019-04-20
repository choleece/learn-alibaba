package cn.choleece.learn.alibaba.nacos.discovery.consumer.feign;

import cn.choleece.learn.alibaba.nacos.discovery.consumer.config.InitialBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by choleece on 2019/4/20.
 */
@FeignClient(name = "nacos-discovery-provider", fallback = EchoServiceFallback.class, configuration = InitialBean.class)
public interface EchoService {
    @RequestMapping(value = "/echo/{str}", method = RequestMethod.GET)
    String echo(@PathVariable("str") String str);

    @RequestMapping(value = "/divide", method = RequestMethod.GET)
    String divide(@RequestParam("a") Integer a, @RequestParam("b") Integer b);

    @RequestMapping(value = "/notFound", method = RequestMethod.GET)
    String notFound();
}
