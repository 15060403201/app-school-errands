package com.FJNU.seed;

import java.util.List;

import com.FJNU.seed.model.OrderInfo;
import com.FJNU.seed.model.OrderInfoDao;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TestJdbcTemplate {
    @Autowired // 将Spring管理的对象注入进来
    private OrderInfoDao orderInfoDao;

    @Test
    public void testGetOrderInfoList() throws Exception {
        List<OrderInfo> orderInfoList = orderInfoDao.getOrderInfoList(10, 1);
        System.out.println(orderInfoList);
        Assert.assertNotNull(orderInfoList);
    }

    @Test
    public void testGetGetOrderInfoByOrderid() throws Exception {
        OrderInfo orderInfo = orderInfoDao.getOrderInfoByOrderid("1647604759209L");
        System.out.println(orderInfo);
        Assert.assertNotNull(orderInfo);
    }
}
