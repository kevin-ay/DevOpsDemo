package ch.zhaw.iwi.devops.demo;

public class Gelato {
    private int id;
    private String flavor;
    private String origin;

    public Gelato() {
    }

    public Gelato(int id, String flavor) {
        this.id = id;
        this.flavor = flavor;
    }

    public Gelato(int id, String flavor, String origin) {
        this.id = id;
        this.flavor = flavor;
        this.origin = origin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlavor() {
        return flavor;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}