package com.atguigu.mr.order;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

/**
 * @author 游正荣
 * @create 2019-12-04 10:58
 */
public class OrderGroupingComparator extends WritableComparator {

    protected OrderGroupingComparator(){
        super(OrderBean.class,true);
    }

    @Override
    public int compare(WritableComparable a, WritableComparable b) {
        // 要求只要ID相同，就认为是相同的key

        OrderBean aBean = (OrderBean) a;
        OrderBean bBean = (OrderBean) b;

        int result;
        if(aBean.getOrder_id() > bBean.getOrder_id()){
            result = 1;
        }else if(aBean.getOrder_id() < bBean.getOrder_id()){
            result = -1;
        }else{
            result = 0;
        }

        return result;
    }
}
