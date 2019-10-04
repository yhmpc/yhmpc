package net.cxyuan.bean;

public enum YesNo {
    YES("y"), NO("n");

    private final String status;

    private YesNo(String status) {
        this.status = status;
    }
}
