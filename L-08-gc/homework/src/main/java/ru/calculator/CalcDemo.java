package ru.calculator;

/*
-Xms256m
-Xmx256m
-Xlog:gc=debug:file=./logs/gc-%p-%t.log:tags,uptime,time,level:filecount=5,filesize=10m
-XX:+HeapDumpOnOutOfMemoryError
-XX:HeapDumpPath=./logs/dump
-XX:+UseG1GC
*/

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalcDemo {
    private static final Logger log = LoggerFactory.getLogger(CalcDemo.class);

    /*
       memory value | before                     | after                      |   optimal

       256          | spend msec:567433, sec:567 | spend msec:517571, sec:517 |
       512          | spend msec:556650, sec:556 | spend msec:515364, sec:515 |
       1024         | spend msec:551309, sec:551 | spend msec:504886, sec:504 | optimal ratio
       1280         | spend msec:552037, sec:552 | spend msec:505819, sec:505 |
       1536         | spend msec:557510, sec:557 | spend msec:510778, sec:510 |
       2048         | spend msec:553470, sec:553 | spend msec:507480, sec:507 |
    */

    public static void main(String[] args) {
        long counter = 500_000_000;
        var summator = new Summator();
        long startTime = System.currentTimeMillis();

        for (var idx = 0; idx < counter; idx++) {
            var data = new Data(idx);
            summator.calc(data);

            if (idx % 10_000_000 == 0) {
                log.info("{} current idx:{}", LocalDateTime.now(), idx);
            }
        }

        long delta = System.currentTimeMillis() - startTime;
        log.info("PrevValue:{}", summator.getPrevValue());
        log.info("PrevPrevValue:{}", summator.getPrevPrevValue());
        log.info("SumLastThreeValues:{}", summator.getSumLastThreeValues());
        log.info("SomeValue:{}", summator.getSomeValue());
        log.info("Sum:{}", summator.getSum());
        log.info("spend msec:{}, sec:{}", delta, (delta / 1000));
    }
}
