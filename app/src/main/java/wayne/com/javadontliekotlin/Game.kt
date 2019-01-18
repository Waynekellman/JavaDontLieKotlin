package wayne.com.javadontliekotlin

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Games")
class Game(@PrimaryKey(autoGenerate = true) var id: Long?,
           @ColumnInfo(name = "gameName") var gameName: String,
           @ColumnInfo(name = "amount") var amount: Int,
           @ColumnInfo(name = "log") var log: ArrayList<String>)
{
    constructor():this(null,"",0,ArrayList())
}