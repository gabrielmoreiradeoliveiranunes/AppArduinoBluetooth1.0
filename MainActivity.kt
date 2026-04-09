import android.bluetooth.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.io.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var socket: BluetoothSocket
    private lateinit var output: OutputStream
    private lateinit var input: InputStream

    private val nomeBluetooth = "HC-06"
    private val uuid: UUID = UUID.fromString("00001101-0000-1000-8000-00805f9b34fb")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private fun conectarBluetooth() {
        val adapter = BluetoothAdapter.getDefaultAdapter()
        val device = adapter.bondedDevices.find { it.name == nomeBluetooth }

        socket = device!!.createRfcommSocketToServiceRecord(uuid)
        socket.connect()

        output = socket.outputStream
        input = socket.inputStream
    }

    private fun enviar(cmd: String) {
        output.write(cmd.toByteArray())
    }
}
