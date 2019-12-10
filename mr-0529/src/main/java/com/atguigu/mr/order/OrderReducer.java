package com.atguigu.mr.order;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author 游正荣
 * @create 2019-12-04 10:46
 */
public class OrderReducer extends Reducer<OrderBean,NullWritable,OrderBean,NullWritable> {

    @Override
    protected void reduce(OrderBean key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {

        context.write(key,NullWritable.get());
    }
}
