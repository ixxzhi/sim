package vip.ruok.obj;

/**
 * @author ixxzhi
 */
public class User {
    /**
     * 用户名
     */
   String userName;
    /**
     * 密码
     */
    String password;
    /**
     * 权限
     * 0    Suspended
     * 1	Observer
     * 2	Student1
     * 3	Student2
     * 4	Student3
     * 5	Controller1
     * 6	Controller2
     * 7	Controller3
     * 8	Instructor1
     * 9	Instructor2
     * 10	Instructor3
     * 11	Supervisor
     * 12	Administrator
     */
    String level;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String toLine(){
        return this.userName + " " + this.password + " " + this.level;
    }
}