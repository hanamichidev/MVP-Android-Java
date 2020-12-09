
package com.ecruz.rickandmorty.model;

import java.util.ArrayList;
import java.util.List;

import com.ecruz.rickandmorty.model.Location;
import com.ecruz.rickandmorty.model.Origin;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Personaje {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("species")
    @Expose
    private String species;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("origin")
    @Expose
    private Origin origin;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("episode")
    @Expose
    private List<String> episode = new ArrayList<String>();
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("created")
    @Expose
    private String created;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Personaje() {
    }

    /**
     * 
     * @param image
     * @param gender
     * @param species
     * @param created
     * @param origin
     * @param name
     * @param location
     * @param episode
     * @param id
     * @param type
     * @param url
     * @param status
     */
    public Personaje(Integer id, String name, String status, String species, String type, String gender, Origin origin, Location location, String image, List<String> episode, String url, String created) {
        super();
        this.id = id;
        this.name = name;
        this.status = status;
        this.species = species;
        this.type = type;
        this.gender = gender;
        this.origin = origin;
        this.location = location;
        this.image = image;
        this.episode = episode;
        this.url = url;
        this.created = created;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<String> getEpisode() {
        return episode;
    }

    public void setEpisode(List<String> episode) {
        this.episode = episode;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("status", status).append("species", species).append("type", type).append("gender", gender).append("origin", origin).append("location", location).append("image", image).append("episode", episode).append("url", url).append("created", created).toString();
    }

}
