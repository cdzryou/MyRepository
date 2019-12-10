package com.atguigu.mr.sort;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author 游正荣
 * @create 2019-12-03 15:24
 */
public class FlowCountSortMapper extends Mapper<LongWritable,Text,FlowBean,Text> {

    FlowBean k = new FlowBean();
    Text v = new Text();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 1获取一行
        String line = value.toString();
        
        // 2切割
        String[] fields = line.split("\t");

        // 3封装对象
        String phoneNum = fields[0];

        long upFlow = Long.parseLong(fields[1]);
        long downFlow = Long.parseLong(fields[2]);
        long sumFlow = Long.parseLong(fields[3]);

        k.setUpFlow(upFlow);
        k.setDownFlow(downFlow);
        k.setSumFlow(sumFlow);

        v.set(phoneNum);

        // 写出
        context.write(k,v);

    }
}
