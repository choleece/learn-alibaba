package cn.choleece.cloud.nacos.config.modal;

/**
 * @author choleece
 * @Description: TODO
 * @Date 2020-01-05 15:37
 **/
public class SysUser {

    public SysUser() {
    }

    public SysUser(String id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public SysUser(String userName) {
        this.userName = userName;
    }

    private String id;

    private String userName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }
}
