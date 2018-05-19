package com.testcase.sql;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.w3c.tidy.Report;
import tools.sqlRequest.DBHelper;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 喻海洋
 * Created Time: 2017/12/26 上午11:05
 */
public class SqlTest {
    //jdbc路径
    private String DBurl = "jdbc:mysql://61.164.59.232:3306/test";
    //jdbc驱动
    private String JdbcName = "com.mysql.jdbc.Driver";
    //mysql用户名
    private String UserName = "root";
    //密码
    private String PassWord = "yht1234";

    private SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
   // String strDate = df.format(new Date());
    int sex = 1;
    //要执行的sql语句，支持增删改查
    private String sql = "INSERT INTO user  ( name, sex) VALUES ( \"Memcached.com\", '" + sex + "')";

    //sql请求、执行，并判断用例成功与否
    @Test
    public void SqlTest() {
        DBHelper dbHelper = new DBHelper(DBurl, JdbcName, UserName, PassWord, sql);

        if(dbHelper.isRequestSuccessful()) {
            Reporter.log("sql执行成功");
            Assert.assertTrue(true);
        } else {
            Reporter.log("sql执行失败");
            Assert.assertTrue(false);
        }
    }


}
