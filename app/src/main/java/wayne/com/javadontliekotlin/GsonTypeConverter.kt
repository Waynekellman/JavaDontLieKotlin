package wayne.com.javadontliekotlin

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GsonTypeConverter {

    @TypeConverter
    fun fromGamesList(games: ArrayList<Game>) : String? {
        return if (games == null) null else Gson().toJson(games)
    }

    @TypeConverter
    fun toGamesList(games: String) : ArrayList<Game>? {
        return if (games == null) null else Gson().fromJson(games,object : TypeToken<ArrayList<Game>>(){}.type)
    }

    @TypeConverter
    fun fromLogList(log: ArrayList<String>) : String? {
        return if (log == null) null else Gson().toJson(log)
    }

    @TypeConverter
    fun toLogList(log: String) : ArrayList<String>? {
        return if (log == null) null else Gson().fromJson(log,object : TypeToken<ArrayList<String>>(){}.type)
    }

}