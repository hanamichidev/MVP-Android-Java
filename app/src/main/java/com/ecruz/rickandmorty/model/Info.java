package com.ecruz.rickandmorty.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;


public class Info {

    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("pages")
    @Expose
    private Integer pages;
    @SerializedName("next")
    @Expose
    private String next;
    @SerializedName("prev")
    @Expose
    private Object prev;

    /**
     * No args constructor for use in serialization
     *
     */
    public Info() {
    }

    /**
     *
     * @param next
     * @param pages
     * @param prev
     * @param count
     */
    public Info(Integer count, Integer pages, String next, Object prev) {
        super();
        this.count = count;
        this.pages = pages;
        this.next = next;
        this.prev = prev;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public Object getPrev() {
        return prev;
    }

    public void setPrev(Object prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("count", count).append("pages", pages).append("next", next).append("prev", prev).toString();
    }

}