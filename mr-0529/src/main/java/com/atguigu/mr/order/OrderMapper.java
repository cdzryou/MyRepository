package com.atguigu.mr.order;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author 游正荣
 * @create 2019-12-04 10:41
 */
public class OrderMapper extends Mapper<LongWritable,Text,OrderBean,NullWritable> {

    OrderBean k = new OrderBean();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        // 1获取一行
        String line = value.toString();

        // 2切割
        String[] fields = line.split("\t");

        // 3封装对象
        k.setOrder_id(Integer.parseInt(fields[0]));
        k.setPrice(Double.parseDouble(fields[2]));

        // 4写出
        context.write(k,NullWritable.get());

    }
}
