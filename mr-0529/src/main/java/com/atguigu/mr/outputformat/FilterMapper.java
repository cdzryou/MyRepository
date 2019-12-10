package com.atguigu.mr.outputformat;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author 游正荣
 * @create 2019-12-08 20:54
 */
public class FilterMapper extends Mapper<LongWritable,Text,Text,NullWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

//        http://www.baidu.com
//        http://www.google.com

        context.write(value,NullWritable.get());
    }
}
