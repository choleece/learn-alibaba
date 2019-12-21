package cn.choleece.cloud.nacos.config.util;

/**
 * @author choleece
 * @Description: TODO
 * @Date 2019-12-21 15:27
 **/
public class R {

    private Integer code = 200;

    private Boolean success = true;

    private String msg;

    private Object data;

    public Integer getCode() {
        return code;
    }

    public R setCode(Integer code) {
        this.code = code;
        return this;
    }

    public Boolean getSuccess() {
        return success;
    }

    public R setSuccess(Boolean success) {
        this.success = success;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public R setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public R setData(Object data) {
        this.data = data;
        return this;
    }

    public static R ok() {
        return new R();
    }

    public static R okWithMsg(String msg) {
        return ok().setMsg(msg);
    }

    public static R ok(Object o) {
        return ok().setData(o);
    }

    public static R error(String msg) {
        return ok().setSuccess(false).setMsg(msg);
    }
}
