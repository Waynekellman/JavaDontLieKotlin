package wayne.com.javadontliekotlin.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlin.collections.ArrayList


@Entity(tableName = "Games")
class Game(@PrimaryKey(autoGenerate = true) var id: Long? = null,
           @ColumnInfo(name = "gameName") var gameName: String = "",
           @ColumnInfo(name = "amount") var amount: Double = 0.0,
           @ColumnInfo(name = "log") var log: ArrayList<String> = ArrayList()
)