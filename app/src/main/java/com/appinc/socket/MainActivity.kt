package com.appinc.socket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.PrintWriter
import java.net.Socket

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectToSocket()
    }

    fun connectToSocket() {
        val serverAddress = "your_server_ip" // Replace with the actual IP address or hostname of the server
        val serverPort = 12345 // Replace with the actual port number on which the server is listening

        try {
            // Create a socket and connect to the server
            val socket = Socket(serverAddress, serverPort)

            // Get the input and output streams of the socket
            val outputStream = socket.getOutputStream()
            val printWriter = PrintWriter(outputStream, true)

            // Send a message to the server
            printWriter.println("Hello, Server!")

            // Get the input stream of the socket to read the response from the server
            val inputStream = socket.getInputStream()
            val bufferedReader = BufferedReader(InputStreamReader(inputStream))

            // Read the response from the server
            val response = bufferedReader.readLine()
            println("Server response: $response")

            // Close the socket when done
            socket.close()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}