package com.andrejzdravev.task.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Factss(
    @SerializedName("all") val all: List<All>
): Serializable


data class All(
    @SerializedName("_id") val _id: String,
    @SerializedName("text") val text: String,
    @SerializedName("type") val type: String,
    @SerializedName("user") val user: User,
    @SerializedName("upvotes") val upvotes: Int,
    @SerializedName("userUpvoted") val userUpvoted: String
): Serializable

data class User(

    @SerializedName("_id") val _id: String,
    @SerializedName("name") val name: Name
): Serializable

data class Name(
    @SerializedName("first") val first: String,
    @SerializedName("last") val last: String
): Serializable
