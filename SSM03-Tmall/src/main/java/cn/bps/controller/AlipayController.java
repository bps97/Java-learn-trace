package cn.bps.controller;

import cn.bps.pojo.Order;
import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
public class AlipayController {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101200668109";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCMrMgwHQaantpfhRztmchqoWv+AsHogl7JBCgZ12Ko8Sh2xYDkn7yMcEHRTJGVf+voBNXRQWSrRZzVPAq/xygloikNzZc1MIYPQ4patFzT8hW21XX7dXO00FoCOJYCjrBNRySSDh8lWjqLzSO/54V3372YdfLMMKd8JFF/8XlK+rv322ytXaFbqD3HTuDrusIrcsRsU2vkQF6fADUNQZdtB4Lq3PS+0tLMO9jbVb+vNP49x9Yk+bk/vwqpjmrjqU/sFeh1SFrnM7Loin3AbCQ5mDBIvyGRbIOVWaF5k2XSd1T24c1GnS1FopSEtWaDiY0bdYIM2S8A2VMHm4HTQ+ItAgMBAAECggEAQFL1SsLK9UKz2b+VRbPu54seRUzfe8C5NLN43rAVBekXto+C64d7AMCH5/taCoEuzq3/UyrSrFotZ3eH9r9LRUIMAarDfGfOtQYOKoGUfLmSYkLjKvM+0CwBLEjRlyPFy+A/AaYBaeQDJ0/LDAICjpi5KhCsz99jhilZNuakrrqgTt+II3PQgiTqrC0L7enh0xi1illjqFpasuRz+ALPyzJTiwlW7KJgQIoDrkPqVTGsoDjccAdHxDuMfBDEziKNRUcnS/6468VeYESab2lg4E8gBIy5GUdHD29Zg639tAFW0YY9Ljl0iCyJOoYxe36jSX/+98mAWzLVxuGyCqlTpQKBgQDAGHNIa0ySwLU+BFHzqBgr/1coEN4sLe19cyHuAnr78sut0D6oNn+R82jkj/ivoAqjEw4iupB6esM6JylR0szR2D4vtSgXoPMNEnkVy++2aAkKq+eeGkSY9a3IjumMQTq5x/HWjm5eOTZb2SnWI1UJoZ00nEogKnJbHeSn0Xc7gwKBgQC7eSs0zAPZrvPhasc1j8lfcp+f60i0/19eXOtZXL7ES2j1FblwhfTQfDOUR76vFvtjxTMNoLprgwxUexJWSK0rvE9q4dpBfkpVgON7nsl3ATOz5zViUdRbbtQ4gEJrdcng+ob3sqrXv4mfO816yE5J8rJPGUyjEtLE8w5UbgqMjwKBgEJOrkyLLS1i86zqlNdEaMOXKiCcYfRiDh5FharAlG8vifr/bQFnfnWEzepHgBIvbjyIMVLvjzuX8Je8ONkTqLuupxiUsbgmSH90pvNNJ/uQwb47RIIgkxkxhME8A4X0Zi8Gw4XKOHKx0P+3YGeYXpwqezdT04py3HJzSSBcf4m9AoGBAJtoA2f94wc1n1dyg3akHgMwaqBPk3Lu6ui3UCVA26au+G+KNbHQabPV8Y/utWRBQd1f4EVgwohTFwqFBxtdnafOr2rjlGCMRyR/9pNIeqta5LgyZq99M/MjeWro76ZS+ymzo+R7SGIWlgfYtCofF773H9awGzZnaS74aR2WJsqDAoGBAJEXxQpuimjyyg59jBdbMxMlTHnA1OphtdRBrShLzWziKiF6/92JfFq3hdVFLtcfWtEfdcL/bhEsn6siclB+M1qE2xcQ36Mve11z8JSO4fKBuI5oUxi4qa8lxby4u9q4660ewWGAZ/I0QNw2UnbgEsdx2eNheSvCsKD5YF+vwaMS";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkl9DPgC7Sj4P1tYpPKAwmiv/pzquRrtRb0luOvo7aAfzV00u2obi8nnPudGnmdFcNDld9inEaLnvfP8R/Bd2ZHJSidDK6C0RJVq6M5GAzdy9SaS6HxfZHQOpSwcTSThyJTM8+bymRpOVqHMkxtd8VTpKy8XOV+wsRXa2JBmDCvvipkmr7z0qp01cNP2mpUvErQWmQMGsLq7lnz+gIIjZxqDGaUz08QVU+RqoOB5vHcB/TO9wmoStZfnOZZCUzQIr+oPpRcTOI68ecQTSDeqOUAykd5hesYLdk7Wbfjo6r3+IF8SMbVJMNm47/2R1i5JsEHgoTNZdFxADzWVPI6DuKwIDAQAB";
    // 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://bskcgh.natappfree.cc/notifyUrl";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://bskcgh.natappfree.cc/returnUrl";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    //沙箱网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 仅支持JSON
    public static String format = "JSON";

    @RequestMapping(value = "/pay")
    public void pay(HttpServletResponse httpResponse,
                    @RequestParam String orderCode,
                    @RequestParam String actualCost)
            throws  IOException {
        AlipayClient alipayClient = new DefaultAlipayClient(
                gatewayUrl, app_id, merchant_private_key, format, charset,
                alipay_public_key, sign_type); // 获得初始化的AlipayClient



        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();// 创建API对应的request
        alipayRequest.setReturnUrl(return_url);
        alipayRequest.setNotifyUrl(notify_url);// 在公共参数中设置回跳和通知地址




        Map map = new HashMap();
        map.put("out_trade_no",orderCode);
        map.put("product_code","FAST_INSTANT_TRADE_PAY");
        map.put("total_amount",actualCost);
        map.put("subject","简单商城:"+orderCode);
        map.put("body",orderCode);


        alipayRequest.setBizContent(JSON.toJSONString(map));


        String form = "";

        try {
            form = alipayClient.pageExecute(alipayRequest).getBody(); // 调用SDK生成表单
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        httpResponse.setContentType("text/html;charset=" + charset);
        httpResponse.getWriter().write(form);// 直接将完整的表单html输出到页面
        httpResponse.getWriter().flush();
        httpResponse.getWriter().close();


    }

    @RequestMapping(value = "/returnUrl", method = RequestMethod.GET)
    public String returnUrl(HttpServletRequest request, HttpServletResponse response)
            throws IOException, AlipayApiException {
        System.out.println("=================================同步回调=====================================");

        // 获取支付宝GET过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();

        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        System.out.println(params);
        boolean signVerified = AlipaySignature.rsaCheckV1(params, alipay_public_key, charset, sign_type);

        // ——请在这里编写您的程序（以下代码仅作参考）——
        if (signVerified) {
            // 商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");

            System.out.println("商户订单号=" + out_trade_no);
            System.out.println("支付宝交易号=" + trade_no);
            System.out.println("付款金额=" + total_amount);

            return "redirect:/index";

        } else {
            response.getWriter().write("error");
        }
        response.getWriter().flush();
        response.getWriter().close();
        return "/shop";
    }

    @RequestMapping(value = "/notifyUrl", method = RequestMethod.POST)
    public void notifyUrl(HttpServletRequest request, HttpServletResponse response)
            throws AlipayApiException, IOException {
        System.out.println("#################################异步回调######################################");

        // 获取支付宝POST过来反馈信息
        Map<String, String> params = new HashMap<String, String>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
            }
            // 乱码解决，这段代码在出现乱码时使用
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }

        System.out.println(params);
        boolean signVerified = AlipaySignature.rsaCheckV1(params, alipay_public_key, charset, sign_type); // 调用SDK验证签名

        // ——请在这里编写您的程序（以下代码仅作参考）——

        /*
         * 实际验证过程建议商户务必添加以下校验： 1、需要验证该通知数据中的out_trade_no是否为商户系统中创建的订单号，
         * 2、判断total_amount是否确实为该订单的实际金额（即商户订单创建时的金额）， 3、校验通知中的seller_id（或者seller_email)
         * 是否为out_trade_no这笔单据的对应的操作方（有的时候，一个商户可能有多个seller_id/seller_email）
         * 4、验证app_id是否为该商户本身。
         */
        if (signVerified) {// 验证成功
            // 商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");

            // 交易状态
            String trade_status = new String(request.getParameter("trade_status").getBytes("ISO-8859-1"), "UTF-8");

            System.out.println("商户订单号=" + out_trade_no);
            System.out.println("支付宝交易号=" + trade_no);
            System.out.println("交易状态=" + trade_status);
            if (trade_status.equals("TRADE_FINISHED")) {
                // 判断该笔订单是否在商户网站中已经做过处理
                // 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                // 如果有做过处理，不执行商户的业务程序

                // 注意：
                // 退款日期超过可退款期限后（如三个月可退款），支付宝系统发送该交易状态通知
            } else if (trade_status.equals("TRADE_SUCCESS")) {
                // 判断该笔订单是否在商户网站中已经做过处理
                // 如果没有做过处理，根据订单号（out_trade_no）在商户网站的订单系统中查到该笔订单的详细，并执行商户的业务程序
                // 如果有做过处理，不执行商户的业务程序

                // 注意：
                // 付款完成后，支付宝系统发送该交易状态通知
            }

            System.out.println("异步回调验证成功");
            response.getWriter().write("success");

        } else {// 验证失败
            System.out.println("异步回调验证失败");
            response.getWriter().write("fail");

            // 调试用，写文本函数记录程序运行情况是否正常
            // String sWord = AlipaySignature.getSignCheckContentV1(params);
            // AlipayConfig.logResult(sWord);
        }
        response.getWriter().flush();
        response.getWriter().close();
    }




}
