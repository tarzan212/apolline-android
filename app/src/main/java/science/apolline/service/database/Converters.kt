package science.apolline.service.database

/**
 * Created by sparow on 11/5/17.
 */
import android.arch.persistence.room.TypeConverter
import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonElement
import com.google.gson.JsonNull
import com.google.gson.JsonObject

import java.util.Date

/**
 * Created by sparow on 10/31/17.
 */

class Converters {


    @TypeConverter
    fun fromTimestamp(value: Long?): Date? = if (value == null) null else Date(value)

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? = date?.time

    @TypeConverter
    fun fromData(data: String?): JsonObject? {
        if( !data.equals("null") && data!=null){
            val gson = Gson()
            return  gson.fromJson(data, JsonObject::class.java)
        }
        return null
    }

    @TypeConverter
    fun dataToString(data: JsonObject?): String? {
        val gson = Gson()
        return gson.toJson(data)
    }

}