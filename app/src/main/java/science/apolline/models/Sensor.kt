package science.apolline.models

/**
 * Created by sparow on 10/20/17.
 */

import android.arch.persistence.room.*
import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
class Sensor(
        @SerializedName("sensorId")
        @Expose
        @PrimaryKey(autoGenerate = true)
        var sensorId: Int?,
        @SerializedName("device")
        @Expose
        var device: String,
        @SerializedName("sensor")
        @Expose
        var sensor: String,
        @SerializedName("date")
        @Expose
        var date: String,
        @SerializedName("position")
        @Expose
        @Embedded
        var position: Position?,
        @SerializedName("data")
        @Expose
        var data: JsonObject?
) {
    constructor() : this(0, "", "", "", null, null)

    override fun toString(): String {
        return """
        |Device = $device
        |Sensor = $sensor
        |Date = $date
        |Position = $position
        |Data = $data
        """.trimMargin()
    }

}