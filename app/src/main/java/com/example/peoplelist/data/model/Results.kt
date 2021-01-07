package com.example.peoplelist.data.model

import com.google.gson.annotations.SerializedName

class Results {
    @SerializedName("name")
    private lateinit var name: String

    @SerializedName("height")
    private lateinit var height: String

    @SerializedName("mass")
    private lateinit var mass: String

    @SerializedName("hair_color")
    private lateinit var hairColor: String

    @SerializedName("skin_color")
    private lateinit var skinColor: String

    @SerializedName("eye_color")
    private lateinit var eyeColor: String

    @SerializedName("birth_year")
    private lateinit var birthYear: String

    @SerializedName("gender")
    private lateinit var gender: String

    @SerializedName("homeworld")
    private lateinit var homeworld: String

    @SerializedName("films")
    private lateinit var films: ArrayList<String?>

    @SerializedName("species")
    private lateinit var species: ArrayList<String?>

    @SerializedName("vehicles")
    private lateinit var vehicles: ArrayList<String?>

    @SerializedName("starships")
    private lateinit var starships: ArrayList<String?>

    @SerializedName("created")
    private lateinit var created: String

    @SerializedName("edited")
    private lateinit var edited: String

    @SerializedName("url")
    private lateinit var url: String


    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name!!
    }

    fun getHeight(): String? {
        return height
    }

    fun setHeight(height: String?) {
        this.height = height!!
    }

    fun getMass(): String? {
        return mass
    }

    fun setMass(mass: String?) {
        this.mass = mass!!
    }

    fun getHairColor(): String? {
        return hairColor
    }

    fun setHairColor(hairColor: String?) {
        this.hairColor = hairColor!!
    }

    fun getSkinColor(): String? {
        return skinColor
    }

    fun setSkinColor(skinColor: String?) {
        this.skinColor = skinColor!!
    }

    fun getEyeColor(): String? {
        return eyeColor
    }

    fun setEyeColor(eyeColor: String?) {
        this.eyeColor = eyeColor!!
    }

    fun getBirthYear(): String? {
        return birthYear
    }

    fun setBirthYear(birthYear: String?) {
        this.birthYear = birthYear!!
    }

    fun getGender(): String? {
        return gender
    }

    fun setGender(gender: String?) {
        this.gender = gender!!
    }

    fun getHomeworld(): String? {
        return homeworld
    }

    fun setHomeworld(homeworld: String?) {
        this.homeworld = homeworld!!
    }

    fun getFilms(): ArrayList<String?>? {
        return films
    }

    fun setFilms(films: ArrayList<String?>?) {
        this.films = films!!
    }

    fun getSpecies(): ArrayList<String?>? {
        return species
    }

    fun setSpecies(species: ArrayList<String?>?) {
        this.species = species!!
    }

    fun getVehicles(): ArrayList<String?>? {
        return vehicles
    }

    fun setVehicles(vehicles: ArrayList<String?>?) {
        this.vehicles = vehicles!!
    }

    fun getStarships(): ArrayList<String?>? {
        return starships
    }

    fun setStarships(starships: ArrayList<String?>?) {
        this.starships = starships!!
    }

    fun getCreated(): String? {
        return created
    }

    fun setCreated(created: String?) {
        this.created = created!!
    }

    fun getEdited(): String? {
        return edited
    }

    fun setEdited(edited: String?) {
        this.edited = edited!!
    }

    fun getUrl(): String? {
        return url
    }

    fun setUrl(url: String?) {
        this.url = url!!
    }

}