package com.humy.springboot.pojo;

/**
 * @Auther: Hu Min
 * @Date: 2018/11/9 11:37
 * @Description:
 */
public class ResultVo {
    private String name;
    private String data;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public ResultVo(String name, String data) {
        this.name = name;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultVo{" +
                "name='" + name + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
