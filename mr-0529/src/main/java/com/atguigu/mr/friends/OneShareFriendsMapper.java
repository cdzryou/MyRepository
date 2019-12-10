package com.atguigu.mr.friends;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

/**
 * @author 游正荣
 * @create 2019-12-10 9:33
 */
public class OneShareFriendsMapper extends Mapper<LongWritable,Text,Text,Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // 1获取一行
        String line = value.toString();

        // 2切割
        String[] fields = line.split(":");

        // 3获取person和好友
        String person = fields[0];
        String[] friends = fields[1].split(",");

        // 4写出<好友,人>
        for (String friend : friends) {
            context.write(new Text(friend),new Text(person));
        }
    }
}
