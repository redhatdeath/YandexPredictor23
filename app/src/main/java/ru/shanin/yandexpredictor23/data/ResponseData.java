package ru.shanin.yandexpredictor23.data;

import com.google.gson.Gson;

public class ResponseData {
    private boolean endOfWord;
    private int pos;
    private String[] text;

    public boolean isEndOfWord() {
        return endOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String[] getText() {
        return text;
    }

    public void setText(String[] text) {
        this.text = text;
    }
    @Override
    public String toString() {
        return (new Gson()).toJson(this);
    }
}
