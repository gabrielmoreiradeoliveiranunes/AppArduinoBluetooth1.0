import android.app.*
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat

class BluetoothService : Service() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        val notification = NotificationCompat.Builder(this, "canal_alerta")
            .setContentTitle("Sistema ativo")
            .setContentText("Monitorando sensores...")
            .setSmallIcon(android.R.drawable.ic_media_play)
            .build()

        startForeground(1, notification)

        // Aqui você pode rodar o Bluetooth em segundo plano

        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
