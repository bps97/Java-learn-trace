package cn.bps.common.lang.domain;

import cn.bps.common.lang.ResponseCode;
import cn.bps.common.lang.annotation.Label;
import cn.bps.common.lang.util.TimeUtils;

import java.util.function.Supplier;

@Label("Result<Data>")
public class Ret<D> {


    @Label("状态码") private Integer code;
    @Label("响应信息") private String message;
    @Label("数据内容") private D content;
    @Label("响应时间") private String timestamp;
    @Label("动作(方法名)") private String action;

    public Ret(D content){
        this.content = content;
        this.timestamp = TimeUtils.now();
    }

    /**
     *  ok 200
     */
    public static <T> Ret<T> ok(){
        return ok((T) null);
    }

    public static <T> Ret<T> ok(T content){
        return build(ResponseCode.OK.code(), ResponseCode.OK.reason(), content);
    }

    public static <T> Ret<T> ok(Supplier<T> supplier){
        return ok(supplier.get());
    }

    public static Ret<Void> ok(Callback callback){
        callback.execute();
        return ok();
    }


   /**
   * internal_server_error 500
   */
   public static <T> Ret<T> error(){
       return error((T) null);
   }

    public static <T> Ret<T> error(T content){
        return build(ResponseCode.INTERNAL_SERVER_ERROR.code(), ResponseCode.INTERNAL_SERVER_ERROR.reason(), content);
    }

    public static <T> Ret<T> error(Supplier<T> supplier){
        return ok(supplier.get());
    }

    private static <T> Ret<T> build(int code, String message, T content) {
        Ret<T> result = new Ret<>(content);
        result.code = code;
        result.message = message;
        return result;
    }

    public <T> Ret<T> message(String message){
       this.message = message;
       return (Ret<T>) this;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public D getContent() {
        return content;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getAction() {
        return action;
    }
    /*省略getter&setter和重写型方法等方法*/
}
