package com.chris.entidades;

public class Noticia {
    private String title;
    private String description;
    private String link;
    private String guid;

    @Override
    public String toString() {
        return "Noticia [description=" + description + ", guid=" + guid + ", link=" + link + ", title=" + title + "]";
    }

    public Noticia(String title, String description, String link, String guid) {
        this.title = title;
        this.description = description;
        this.link = link;
        this.guid = guid;
    }

    public Noticia() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

}
