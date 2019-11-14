package com.atguigu.myrule;

import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import com.netflix.client.config.IClientConfig;
import java.util.List;

/**
 * @author 游正荣
 * @create 2019-11-14 9:53
 */
public class RandomRule_YZR extends AbstractLoadBalancerRule {

    // total = 0 //当total==5以后  我们指针才往下走
    //index= 0 //当前对外提供服务的服务器地址
    //total需要重新置为零，但是已经达到一个5次，我们的index=1
    //分析：我们5次，但是服务器只有8001 8002 8003 三台

    private int total = 0;          //总共被调用的次数，目前要求每台被调用5次
    private int currentIndex = 0;   //当前提供服务的机器号

    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        }
        Server server = null;

        while (server == null) {
            if (Thread.interrupted()) {
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if (serverCount == 0) {
                /*
                 * No servers. End regardless of pass, because subsequent passes
                 * only get more restrictive.
                 */
                return null;
            }

//            int index = chooseRandomInt(serverCount);
//            server = upList.get(index);

//            private int total = 0;          //总共被调用的次数，目前要求每台被调用5次
//            private int currentIndex = 0;   //当前提供服务的机器号
            if(total<5){
                server = upList.get(currentIndex);
                total++;
            }else{
                total = 0;
                currentIndex++;
                if(currentIndex>=upList.size()){
                    currentIndex = 0;
                }
            }

            if (server == null) {
                /*
                 * The only time this should happen is if the server list were
                 * somehow trimmed. This is a transient condition. Retry after
                 * yielding.
                 */
                Thread.yield();
                continue;
            }

            if (server.isAlive()) {
                return (server);
            }

            // Shouldn't actually happen.. but must be transient or a bug.
            server = null;
            Thread.yield();
        }

        return server;

    }

/*    protected int chooseRandomInt(int serverCount) {
        return ThreadLocalRandom.current().nextInt(serverCount);
    }*/

    @Override
    public Server choose(Object key) {
        return choose(getLoadBalancer(), key);
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }
}
