package com.example.dictionaryapp.feature_dictionary.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.dictionaryapp.feature_dictionary.data.util.JsonParser
import com.example.dictionaryapp.feature_dictionary.domain.model.Meaning
import com.google.gson.reflect.TypeToken

/**
 * pass something from it to json, it doesn't care which library is used
 */
@ProvidedTypeConverter //by default type converter can't have constructor argument like we use below. That's why we use @ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {

    @TypeConverter
    fun fromMeaningsJson(json: String): List<Meaning> {
        return jsonParser.fromJson<ArrayList<Meaning>>(
            json,
            object : TypeToken<ArrayList<Meaning>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toMeaningsJson(meanings: List<Meaning>): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<Meaning>>(){}.type
        ) ?: "[]"
    }
}