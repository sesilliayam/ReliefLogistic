package com.delisar.relo.FAQ;

public class FAQModel {
    private String tanya;
    private String jawab;

    public FAQModel(String tanya, String jawab) {
        this.tanya = tanya;
        this.jawab = jawab;
    }

    public String getTanya() {
        return tanya;
    }

    public void setTanya(String tanya) {
        this.tanya = tanya;
    }

    public String getJawab() {
        return jawab;
    }

    public void setJawab(String jawab) {
        this.jawab = jawab;
    }
}
