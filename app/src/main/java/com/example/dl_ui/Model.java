package com.example.dl_ui;

public class Model {

    String img,row, col1, col1text1,color, font, style, col1text2, col1text3, col2,col2text1, col2text2, col2text3;
    Boolean card;

    public Model() {
    }

    public Model(String img, String color, String font, String style, String row, String col1, String col1text1, Boolean card) {
        this.img = img;
        this.color = color;
        this.font = font;
        this.style = style;
        this.row = row;
        this.col1 = col1;
        this.col1text1 = col1text1;
        this.card = card;
    }

    public Model(String row, String col1, String col1text1, String col1text2, String col1text3, String col2, String col2text1, String col2text2, String col2text3, Boolean card) {
        this.row = row;
        this.col1 = col1;
        this.col1text1 = col1text1;
        this.col1text2 = col1text2;
        this.col1text3 = col1text3;
        this.col2 = col2;
        this.col2text1 = col2text1;
        this.col2text2 = col2text2;
        this.col2text3 = col2text3;
        this.card = card;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getRow() {
        return row;
    }

    public void setRow(String row) {
        this.row = row;
    }

    public String getCol1() {
        return col1;
    }

    public void setCol1(String col1) {
        this.col1 = col1;
    }

    public String getCol1text1() {
        return col1text1;
    }

    public void setCol1text1(String col1text1) {
        this.col1text1 = col1text1;
    }

    public String getCol1text2() {
        return col1text2;
    }

    public void setCol1text2(String col1text2) {
        this.col1text2 = col1text2;
    }

    public String getCol1text3() {
        return col1text3;
    }

    public void setCol1text3(String col1text3) {
        this.col1text3 = col1text3;
    }

    public String getCol2() {
        return col2;
    }

    public void setCol2(String col2) {
        this.col2 = col2;
    }

    public String getCol2text1() {
        return col2text1;
    }

    public void setCol2text1(String col2text1) {
        this.col2text1 = col2text1;
    }

    public String getCol2text2() {
        return col2text2;
    }

    public void setCol2text2(String col2text2) {
        this.col2text2 = col2text2;
    }

    public String getCol2text3() {
        return col2text3;
    }

    public void setCol2text3(String col2text3) {
        this.col2text3 = col2text3;
    }

    public Boolean getCard() {
        return card;
    }

    public void setCard(Boolean card) {
        this.card = card;
    }
}
