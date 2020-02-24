package com.eussi.springbootdemo.health;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author wangxueming
 * @create 2020-02-24 14:51
 * @description
 */
@Component
public class RocketMQHealthIndicator implements HealthIndicator {
    @Override
    public Health health() {
        int errorCode = check();
        if(errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }

    private int check() {
        //对监控对象的检测操作
        return 0;
    }
}
