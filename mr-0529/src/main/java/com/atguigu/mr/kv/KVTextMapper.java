package com.atguigu.mr.kv;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author 游正荣
 * @create 2019-12-02 19:36
 */
public class KVTextMapper extends Mapper<Text,Text,Text,IntWritable> {

    IntWritable intWritable = new IntWritable(1);

    @Override
    protected void map(Text key, Text value, Context context) throws IOException, InterruptedException {

        // 1封装对象

        // 2写出
        context.write(key,intWritable);
    }
}
