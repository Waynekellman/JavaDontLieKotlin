package wayne.com.javadontliekotlin.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import wayne.com.javadontliekotlin.data.db.Game

class GsonTypeConverter {

    @TypeConverter
    fun fromGamesList(games: ArrayList<Game>) : String? {
        return Gson().toJson(games)
    }

    @TypeConverter
    fun toGamesList(games: String) : ArrayList<Game>? {
        return Gson().fromJson(games,object : TypeToken<ArrayList<Game>>(){}.type)
    }

    @TypeConverter
    fun fromLogList(log: ArrayList<String>) : String? {
        return Gson().toJson(log)
    }

    @TypeConverter
    fun toLogList(log: String) : ArrayList<String>? {
        return Gson().fromJson(log,object : TypeToken<ArrayList<String>>(){}.type)
    }

}