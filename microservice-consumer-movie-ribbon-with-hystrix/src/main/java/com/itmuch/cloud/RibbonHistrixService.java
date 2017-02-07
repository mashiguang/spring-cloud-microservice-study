package com.itmuch.cloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/1/16.
 */
@Service
public class RibbonHistrixService {
    private static Logger log = LoggerFactory.getLogger(RibbonHistrixService.class);

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public User findById(Long id) {
        return restTemplate.getForObject("http://microservice-provider-user/"+id, User.class);
    }

    public User fallback(Long id) {
        log.error("发生异常, 进入fallback方法, id[{}]", id);
        User u = new User();
        u.setId(-1L);
        u.setUsername("default username");
        u.setAge(-1);

        return u;
    }

}
