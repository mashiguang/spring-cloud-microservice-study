package com.itmuch.cloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017/1/11.
 */
@FeignClient(name = "microservice-provider-user", fallback = UserFeignHystrixClient.HystrixHystrixClientFallback.class)
public interface UserFeignHystrixClient {

    @RequestMapping("/{id}")
    User findByIdFeign(@RequestParam("id") Long id);

    @Component
    class HystrixHystrixClientFallback implements UserFeignHystrixClient {
        private static Logger log = LoggerFactory.getLogger(HystrixHystrixClientFallback.class);

        @Override
        public User findByIdFeign(@RequestParam("id") Long id) {
            log.error("发生异常，进入fallback方法，id[{}]", id);
            User u = new User();
            u.setId(-1L);
            u.setUsername("default username");
            u.setAge(-1);
            return u;
        }
    }
}
