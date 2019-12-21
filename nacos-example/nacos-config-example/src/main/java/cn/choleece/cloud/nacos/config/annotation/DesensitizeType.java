package cn.choleece.cloud.nacos.config.annotation;

/**
 * @author choleece
 * @Description: TODO
 * @Date 2019-12-21 15:14
 **/
public enum DesensitizeType {

    /**
     * 默认脱敏字段
     */
    DEFAULT,

    /**
     * 姓名
     */
    NAME,

    /**
     * 邮箱
     */
    EMAIL,

    /**
     * 地址
     */
    ADDRESS,

    /**
     * 电话-手机
     */
    MOBILE;
}
