package net.cxyuan.bean;

public enum YesNo {
    y("y"), n("n");

    private final String status;

    YesNo(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
