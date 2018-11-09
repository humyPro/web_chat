package com.humy.springboot.pojo;

/**
 * @Auther: Hu Min
 * @Date: 2018/11/9 15:48
 * @Description:
 */
public class WebSocketVo {
    private String sender;
    private String addr;
    private String msg;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "WebSocketVo{" +
                "sender='" + sender + '\'' +
                ", addr='" + addr + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
