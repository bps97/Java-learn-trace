package cn.bps.controller;

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
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC8bTkHYXc7IWH7d53aL5eM167J9ATNoB8HOEJ0h/zFq28xkPnk0wQ5F6UxUPziaJWY1oQANJxjypFz2upT74Gup1mgVszcA2HhOIf9G88HbK1zNMnjLZQE/3qS8RRmCYtShCSGVkoqmxV/0UOCxoK/ECk38FM79T03owxMJQWCgNAnnMDh0TVSzjiB0Keb+L+nU4xZudJPcDytddIccfjDZzw2LTcAcAzskH32R9LtCckIl9i5tmaSk5Eg3cNl/jrdlDj5JFFfDy4stnJVJnXGOmJDyZux/VYBPTkNyZ5Dr6/Wh6B0t21GC5Iw5JQpnueU56oYLjgAqi2k+u8PtxHBAgMBAAECggEAWeBPP3ICCTZXIjdgF95zjz6hpLq8P8iMhEkVibgDndWz6BSa3ca5UPIyXV+f/+6azJglxmNR5VeOIZDeDMNFPCWe3pgIhzklyuPIGbbV/VidM0KOucnXvLqPoN9VN4Z96hIVye4G2mO20YzjgtFlM/Vlc8UyLns/g/ZFu1w9UI2HIENZhQvSwrShFgcjbRWI9vIGnvxQStSXsKMf4F965MKon+Rzr+v9UQhRIhQJ88csbQ2ukHkgKTl8Gk+gquHYAs+jkJa+uxk4RkYggWc0DPmqSd7J+0NZr7PHwq0lFsBW9rBM0zwenfVzWJBTnysgQ/1+1eDnydPSCYIn6BvRAQKBgQDiCI4VO+Jb8t/pwPKapncExMMbsx2eREAZ+0eS2vTHeBUHzR8+hprGzec2cjZIj/INbKB0d7QimyvV2oA7xBYpLblA2vQclay1zj0WdTkw69Y4XYRsk3+NwuQtzxx9qcOTneQMok4xKvwwMAlo/JsppxS1B7n2gQ4SdGsj7fdsKQKBgQDVaFDLF5cxC7/CyqCV6pczwZ5Q/6/D9FlKhOL/tdlYb/8vkvmyeFQy+yODPvkrK/rfLprBqiXE+qJ81zinOQ/YhQtMwvCQXJCISxg+KuDf7PvFgGKzJdnSs3GmM1WzD5u98/w5JyWkD6CNr3TVKKKnPDsrJu2LFQ2Di1TJHXWr2QKBgQC+MSak9Vu1tPr2LPW2bYXOTGZD44ZzishJVGfYSUcYpJFFnDLDIO4RhGYeKSJGEmFBLHsjJSo8yEatTosCPy/KfH/Z86Lefo7x99TtFbwGzxrVGNN5rO7ycOAhL5mwn21Cw+OFQfj7ZEkJnxH79jn1ZXKGFTdEFTmrC6yvcef0aQKBgA6MkhWGgjRBzM0G63PNDonkxVpYVC9T1VKTRLaSO0MgP5GKv6M/ON5Q6Nbl0C71TKEymDJj2zdWrwU71wzvgvkL+P0+vQ/af7ALDpgObE5X5cJNQm1cQ0FuIm1mSo1unvuQSr3KwXIx7ow6TgjKQGyOWqpSeRdmVAmH0jvz2jXhAoGBAMLh7e8H6A9dcQyhMP+rvT2PS7Q+mG3rMeREmhRYMoPx0xnzJLqRnbUQMP6h5Wgs798XAnpz9H3O//x6nUncSOVukLEkMRNai+8yDeRGhFj0N2yWtBdxOqSv8RZa1ao1bQvZrFTaqbKjLK10Kp2AWF5gNZUxVekCRycl/jJ3wxhJ";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAs7/CMy+Krib72PRP5ijeXFD8dMyXIl89X+M7XcA8phMPkuBmeGqbfp/6J+3zA59G7UTotWiHsfQTxbQF/zkPQJRmgkKoTq+cl17HUPm75TfR3vS2DEOf9BSTs5d9l6FwZdrhEoLpAhz7tEKXJfIJ5woJVKp4JVLW1CFu5gAyHmlL9PDGn5A4/XVIihWv3SGHd7+ZUHi61fR0LJYW00wxMArai6KNUsUzfKNc9lpLSBlhjD4jIsKAC4ovO5dX1j8TYmBWb357yabRcjcoC3BHy6rQTJQUat57Ek7z1Hj14dyR2wpurrtU6RGssjkd7uYwSn0/AUyn1qeQfZeX0Ha7dQIDAQAB";

    // 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    //沙箱网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 仅支持JSON
    public static String format = "JSON";

    @RequestMapping(value = "/pay")
    public void pay(HttpServletRequest httpRequest, HttpServletResponse httpResponse,
                    @RequestParam Float totalCost)
            throws ServletException, IOException {
        AlipayClient alipayClient = new DefaultAlipayClient(
                gatewayUrl, app_id, merchant_private_key, format, charset,
                alipay_public_key, sign_type); // 获得初始化的AlipayClient



        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();// 创建API对应的request
        alipayRequest.setReturnUrl(return_url);
        alipayRequest.setNotifyUrl(notify_url);// 在公共参数中设置回跳和通知地址


        Map map = new HashMap();
        map.put("out_trade_no","2016101200668109");
        map.put("product_code","FAST_INSTANT_TRADE_PAY");
        map.put("total_amount",totalCost);
        map.put("subject","xx");
        map.put("body","xxx");


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
    public void returnUrl(HttpServletRequest request, HttpServletResponse response)
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

            response.getWriter().write(
                    "trade_no:" + trade_no + "<br/>out_trade_no:" + out_trade_no + "<br/>total_amount:" + total_amount);
        } else {
            response.getWriter().write("验签失败");
        }
        response.getWriter().flush();
        response.getWriter().close();
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
