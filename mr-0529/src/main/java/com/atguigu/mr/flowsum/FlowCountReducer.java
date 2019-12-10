package com.atguigu.mr.flowsum;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author 游正荣
 * @create 2019-12-02 15:25
 */
public class FlowCountReducer extends Reducer<Text,FlowBean,Text,FlowBean > {

    FlowBean v = new FlowBean();

    @Override
    protected void reduce(Text key, Iterable<FlowBean> values, Context context) throws IOException, InterruptedException {

        long sum_upFlow = 0;
        long sum_downFlow = 0;
        // 1累加求和
        for (FlowBean flowBean : values) {
            sum_upFlow += flowBean.getUpFlow();
            sum_downFlow += flowBean.getDownFlow();
        }

        v.set(sum_upFlow,sum_downFlow);

        // 2写出
        context.write(key,v);
    }
}
