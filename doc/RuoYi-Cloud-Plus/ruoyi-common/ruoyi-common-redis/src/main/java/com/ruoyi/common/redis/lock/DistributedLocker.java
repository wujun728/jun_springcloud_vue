package com.ruoyi.common.redis.lock;

import org.redisson.api.RCountDownLatch;
import org.redisson.api.RLock;
import org.redisson.api.RSemaphore;

import java.util.concurrent.TimeUnit;

/**
 * 分布式锁接口
 *
 * @author rayson.fang
 * @date 2021/05/26 19:23
 */
public interface DistributedLocker {
    
    RLock lock(String lockKey);
    
    RLock lock(String lockKey, int timeout);
    
    RLock lock(String lockKey, TimeUnit unit, int timeout);
    
    boolean tryLock(String lockKey, TimeUnit unit, int waitTime, int leaseTime);
    
    void unlock(String lockKey);
    
    void unlock(RLock lock);
    
    RCountDownLatch getCountDownLatch(String name);
    
    RSemaphore getSemaphore(String name);
}
