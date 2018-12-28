package com.jzw.todo.entity;

public class Todo {
    private int id;
    private String things;
    private boolean isFinished;
    private String createTime;
    private int uid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThings() {
        return things;
    }

    public void setThings(String things) {
        this.things = things;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "id=" + id +
                ", things='" + things + '\'' +
                ", isFinished=" + isFinished +
                ", createTime='" + createTime + '\'' +
                ", uid=" + uid +
                '}';
    }
}
