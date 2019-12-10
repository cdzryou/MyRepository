package com.atguigu.mr.inputformat;

import org.apache.hadoop.io.BytesWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author 游正荣
 * @create 2019-12-03 10:19
 */
public class SequenceFileMapper extends Mapper<Text,BytesWritable,Text,BytesWritable> {

    @Override
    protected void map(Text key, BytesWritable value, Context context) throws IOException, InterruptedException {

        context.write(key,value);
    }
}
