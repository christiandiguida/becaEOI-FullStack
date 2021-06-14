package com.chris.entidades;

public class Tarea {
    private int userId;
    private int id;
    private int String;
    private boolean completed;

    public Tarea() {
    }

    public Tarea(int userId, int id, int string, boolean completed) {
        this.userId = userId;
        this.id = id;
        String = string;
        this.completed = completed;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getString() {
        return String;
    }

    public void setString(int string) {
        String = string;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}
