package com.atguigu.mr.sort;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * @author 游正荣
 * @create 2019-12-03 15:41
 */
public class ProvincePartitioner extends Partitioner<FlowBean,Text> {

    @Override
    public int getPartition(FlowBean key, Text value, int numPartitions) {
        // 按照手机号前三位分区
        String prePhoneNum = value.toString().substring(0, 3);

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
