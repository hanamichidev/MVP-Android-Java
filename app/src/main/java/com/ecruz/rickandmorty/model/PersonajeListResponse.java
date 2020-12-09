package com.ecruz.rickandmorty.model;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;


public class PersonajeListResponse {

    @SerializedName("info")
    @Expose
    private Info info;
    @SerializedName("results")
    @Expose
    private List<Personaje> results = new ArrayList<Personaje>();

    /**
     * No args constructor for use in serialization
     *
     */
    public PersonajeListResponse() {
    }

    /**
     *
     * @param results
     * @param info
     */
    public PersonajeListResponse(Info info, List<Personaje> results) {
        super();
        this.info = info;
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public List<Personaje> getResults() {
        return results;
    }

    public void setResults(List<Personaje> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("info", info).append("results", results).toString();
    }

}