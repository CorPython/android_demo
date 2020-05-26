package com.example.lab2exam04;

public class myBean {
    private String name;//名字
    private String msg;//信息
    private int ImageID;//图片

    public myBean(String name, String msg, int imageID) {
        this.name = name;
        this.msg = msg;
        ImageID = imageID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getImageID() {
        return ImageID;
    }

    public void setImageID(int imageID) {
        ImageID = imageID;
    }
}
