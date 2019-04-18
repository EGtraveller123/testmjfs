package com.hxg.testmjfs.bean;

public class Jincang {

    private Integer id;
    private String kuanhao;
    private String kehu;
    private Integer jcshuliang;
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

    public Integer getJcshuliang() {
        return jcshuliang;
    }

    public void setJcshuliang(Integer jcshuliang) {
        this.jcshuliang = jcshuliang;
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
        return "Jincang{" +
                "id=" + id +
                ", kuanhao='" + kuanhao + '\'' +
                ", kehu='" + kehu + '\'' +
                ", jcshuliang=" + jcshuliang +
                ", mianliao='" + mianliao + '\'' +
                ", chriqi='" + chriqi + '\'' +
                '}';
    }
}
