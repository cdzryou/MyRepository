package com.atguigu.mr.flowsum;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * @author 游正荣
 * @create 2019-12-03 14:36
 */
public class ProvincePartitioner extends Partitioner<Text,FlowBean> {

    @Override
    public int getPartition(Text key, FlowBean flowBean, int numPartitions) {
        // key是手机号
        // value是流量信息

        // 获取手机号前三位
        String prePhoneNum = key.toString().substring(0, 3);

        int partition = 4;

        if("136".equals(prePhoneNum)){
            partition = 0;
        }else if ("137".equals(prePhoneNum)){
            partition = 1;
        }else if ("138".equals(prePhoneNum)){
            partition = 2;
        }else if ("139".equals(prePhoneNum)){
            partition = 3;
        }

        return partition;
    }
}
