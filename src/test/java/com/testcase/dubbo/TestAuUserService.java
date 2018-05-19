package com.testcase.dubbo;


//import com.alibaba.dubbo.common.serialize.support.kryo.RestRequest;
//import com.alibaba.dubbo.common.serialize.support.kryo.RestResponse;
//import com.lemall.srd.order.promise.api.IPromiseForOrderService;
//import com.lemall.srd.order.promise.domain.common.PromiseVersion;
//import com.lemall.srd.order.promise.domain.request.FreeStockForOrderParam;

import com.xyc.facade.user.entity.AuUser;
import com.xyc.facade.user.service.AuUserService;
import jxl.read.biff.BiffException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tools.excelread.GetTestCaseExcel;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import java.util.HashMap;

/**
 * @author 喻海洋
 * Created Time: 2017/12/8 下午4:59
 */
public class TestAuUserService {

    //不需要修改：固定值变量
    private static final String FILE_PATH = "/src/test/TestCaseExcelData/dubbo/";  //文件路径src/testExampleForJmeterData/GetTestCaseExcel/dubbo
    public static final ApplicationContext CONTEXT = new ClassPathXmlApplicationContext("dubbo-config.xml");
    private GetTestCaseExcel excelData;


    //1、fileName是dubbo接口的包名， caseName是dubbo接口名
    private String fileName = "com.xyc.facade.user.service.AuUserService"; //dubbo接口的包名作为文件名，不包含文件后缀.xls
    private String caseName = "AuUserService"; //dubbo接口名作为sheet名


    //2、request随着dubbo接口的不同，需要定义指定类型
    private AuUser requestParam = new AuUser();


    //3、新建dubbo的消费者对象，需要修改类名
    private AuUserService ClassConsumer = (AuUserService) CONTEXT.getBean(caseName);


    //不需要修改： 从excel文件中读取数据，不需要修改
    @DataProvider
    public Object[][] Numbers() throws BiffException, IOException {
        excelData = new GetTestCaseExcel(FILE_PATH, fileName, caseName);
        return excelData.getExcelData();
    }

    //不需要修改：dubbo接口访问Provider
    @Test(dataProvider = "Numbers")
    public void test(HashMap<String, String> data) {

        //4、从excel中取出各项参数
        String orderNo = data.get("orderNo");
        String operater = data.get("operater");
        String channel = data.get("channel");
        String operateId = data.get("operateId");
        String version = "";
        String status = data.get("Status");
        String message = data.get("Message");
        String Result = data.get("Result");

        //5、将请求参数导入对象requestParam中
        requestParam.setUserId("027ee8a5f57548f1b7d818885cad1d78");
        //requestParam.setOperater(operater);
        //requestParam.setChannel(channel);
        //requestParam.setOperateId(operateId);
        //requestParam.setVersion(version);

        ////6、定义dubbo接口请求参数，修改类名
        //RestRequest<AuUser> request = new RestRequest<AuUser>();
        //
        ////不需要修改：向生产者发送请求
        //request.setRequest(requestParam);
        //JSONObject request = JSONObject.parseObject(requestParam.toString());
        //7、修改dubbo接口方法名 和 responseData类型
        AuUser auUserInfo = new AuUser();
        auUserInfo = ClassConsumer.get(requestParam);

        //8、自定义log记录内容及校验数据(根据responseData来判断dubbo接口是否请求成功)
        if (auUserInfo.toString()!=null) {
            //String responseStatus = responseData.getStatus().toString();
            //String responseMessage = responseData.getMessage().toString();
            //if (responseStatus.equals(status) && responseMessage.equals(message)) {
            //    Reporter.log("期望的Status：" + status + "，期望的Message：" + message + "\n" + "实际的Status：" + responseStatus + "，实际的Message：" + responseMessage);
            //    System.out.println("期望的Status：" + status + "，期望的Message：" + message + "\n" + "实际的Status：" + responseStatus + "，实际的Message：" + responseMessage);
            //    Assert.assertTrue(true);
            //
            //} else {
            //    Reporter.log("期望的Status：" + status + "，期望的Message：" + message + "\n" + "实际的Status：" + responseStatus + "，实际的Message：" + responseMessage);
            //    System.out.println("期望的Status：" + status + "，期望的Message：" + message + "\n" + "实际的Status：" + responseStatus + "，实际的Message：" + responseMessage);
            //    Assert.assertTrue(false);
            //
            //}
        } else {
            Reporter.log("responseData为空");
            Assert.assertTrue(false);
        }

    }
}