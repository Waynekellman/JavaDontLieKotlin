package wayne.com.javadontliekotlin.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey


@Entity(tableName = "Games")
class Game(@PrimaryKey(autoGenerate = true) var id: Long?,
           @ColumnInfo(name = "gameName") var gameName: String,
           @ColumnInfo(name = "amount") var amount: Int,
           @ColumnInfo(name = "log") var log: ArrayList<String>)
{
    @Ignore
    constructor():this(null,"",0,ArrayList())
}