package com.torquato.workshopmongo.dto;

import java.util.Date;

public class ComentarioDTO {

    private String text;
    private Date date;
    private AuthorDTO autor;

    public ComentarioDTO() {
    }

    public ComentarioDTO(String text, Date date, AuthorDTO autor) {
        this.text = text;
        this.date = date;
        this.autor = autor;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AuthorDTO getAutor() {
        return autor;
    }

    public void setAutor(AuthorDTO autor) {
        this.autor = autor;
    }
}
