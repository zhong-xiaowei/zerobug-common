package cn.com.zerobug.common.utils;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;

import java.util.concurrent.TimeUnit;

/**
 * @author zhongxiaowei
 * @contact zhongxiaowei.nice@gmail.com
 * @date 2022/5/27
 */
public class TimerUtil {

    private static final int DEFAULT_TIMER_TICK_DURATION = 50;

    private volatile static Timer INSTANCE;

    public static Timer getTimer() {
        if (INSTANCE == null) {
            synchronized (TimerUtil.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HashedWheelTimer(
                            r -> new Thread(r, "netty-timer" + r.hashCode()),
                            DEFAULT_TIMER_TICK_DURATION,
                            TimeUnit.MILLISECONDS
                    );
                }
            }
        }
        return INSTANCE;
    }

    public static Timeout newTimeout(TimerTask task) {
        return getTimer().newTimeout(task, DEFAULT_TIMER_TICK_DURATION, TimeUnit.MILLISECONDS);
    }

    public static Timeout newTimeout(TimerTask task, long delay, TimeUnit unit) {
        return getTimer().newTimeout(task, delay, unit);
    }
}
