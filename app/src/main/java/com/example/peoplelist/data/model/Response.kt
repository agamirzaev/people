package com.example.peoplelist.data.model

import com.google.gson.annotations.SerializedName

class Response {
    @SerializedName("count")
    private var count: Int = 0

    @SerializedName("next")
    private lateinit var next: String

    @SerializedName("previous")
    private lateinit var previous: Any

    @SerializedName("results")
    private lateinit var results: ArrayList<Results?>

    fun getCount(): Int? {
        return count
    }

    fun setCount(count: Int?) {
        this.count = count!!
    }

    fun getNext(): String? {
        return next
    }

    fun setNext(next: String?) {
        this.next = next!!
    }

    fun getPrevious(): Any? {
        return previous
    }

    fun setPrevious(previous: Any?) {
        this.previous = previous!!
    }

    fun getResults(): ArrayList<Results?>? {
        return results
    }

    fun setResults(results: ArrayList<Results?>?) {
        this.results = results!!
    }
}