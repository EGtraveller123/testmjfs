package com.hxg.testmjfs.bean;

public class Houdaobu {
    private Integer id;
    private String kuanhao;
    private String kehu;
    private Integer hdbshuliang;
    private String mianliao;
    private String chriqi;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKuanhao() {
        return kuanhao;
    }

    public void setKuanhao(String kuanhao) {
        this.kuanhao = kuanhao;
    }

    public String getKehu() {
        return kehu;
    }

    public void setKehu(String kehu) {
        this.kehu = kehu;
    }

    public Integer getHdbshuliang() {
        return hdbshuliang;
    }

    public void setHdbshuliang(Integer hdbshuliang) {
        this.hdbshuliang = hdbshuliang;
    }

    public String getMianliao() {
        return mianliao;
    }

    public void setMianliao(String mianliao) {
        this.mianliao = mianliao;
    }

    public String getChriqi() {
        return chriqi;
    }

    public void setChriqi(String chriqi) {
        this.chriqi = chriqi;
    }

    @Override
    public String toString() {
        return "Houdaobu{" +
                "id=" + id +
                ", kuanhao='" + kuanhao + '\'' +
                ", kehu='" + kehu + '\'' +
                ", hdbshuliang=" + hdbshuliang +
                ", mianliao='" + mianliao + '\'' +
                ", chriqi='" + chriqi + '\'' +
                '}';
    }
}
