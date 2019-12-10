package com.atguigu.mr.log;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author 游正荣
 * @create 2019-12-09 14:32
 */
public class LogMapper extends Mapper<LongWritable,Text,Text,NullWritable> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        // 1获取一行
        String line = value.toString();

        // 2解析数据
        boolean result = parseLog(line,context);

        if(!result){
            return;
        }

        // 3解析通过 写出去
        context.write(value,NullWritable.get());

    }

    private boolean parseLog(String line, Context context) {

        String[] fields = line.split(" ");

        if(fields.length > 11){

            context.getCounter("map","true").increment(1);
            return true;
        }else {
            context.getCounter("map","false").increment(1);
            return false;
        }

    }
}
