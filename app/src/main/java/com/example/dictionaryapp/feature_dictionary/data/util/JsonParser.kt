package com.example.dictionaryapp.feature_dictionary.data.util

import java.lang.reflect.Type

/**
 * contains two functions to get an object from json string and
 * to parse an object to a json string
 */
interface JsonParser {

    fun <T> fromJson(json: String, type: Type): T?

    fun <T> toJson(obj: T, type: Type): String?

}