package com.atguigu.mr.friends;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author 游正荣
 * @create 2019-12-10 9:38
 */
public class OneShareFriendsReducer extends Reducer<Text,Text,Text,Text> {

    @Override
    protected void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

        StringBuilder sb = new StringBuilder();

        // 1拼接
        for (Text person : values) {
            sb.append(person).append(",");
        }

        // 2写出
        context.write(key,new Text(sb.toString()));
    }
}
