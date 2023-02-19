package com.example.curency;

public class history_exchange {
    private String name1;
    private String name2;
    private String money1;
    private String money2;
    private String dv1;
    private String dv2;

    public history_exchange(String name1, String name2, String money1, String money2, String dv1, String dv2) {
        this.name1 = name1;
        this.name2 = name2;
        this.money1 = money1;
        this.money2 = money2;
        this.dv1 = dv1;
        this.dv2 = dv2;
    }

    public String getDv1() {
        return dv1;
    }

    public void setDv1(String dv1) {
        this.dv1 = dv1;
    }

    public String getDv2() {
        return dv2;
    }

    public void setDv2(String dv2) {
        this.dv2 = dv2;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getMoney1() {
        return money1;
    }

    public void setMoney1(String money1) {
        this.money1 = money1;
    }

    public String getMoney2() {
        return money2;
    }

    public void setMoney2(String money2) {
        this.money2 = money2;
    }
}
