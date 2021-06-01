import com.wms.common.redis.service.RedisService;
import com.wms.oms.WmsOmsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {WmsOmsApplication.class})
public class TestRedis {


    @Autowired
    private RedisService redisService;


    public void test(){
        Long count = redisService.incr("P00001", 1000l);
        if (count <= 10) {
            System.out.println(Thread.currentThread().getId()+"--抢到");
        }else{
            System.out.println("抱歉："+Thread.currentThread().getId()+"--当前商品已经抢完");
        }
    }

    @Test
    public void get() {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                test();
            }).start();
        }
    }
}
