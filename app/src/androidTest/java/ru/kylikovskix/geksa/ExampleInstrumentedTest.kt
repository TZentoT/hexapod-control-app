package ru.kylikovskix.geksa

import android.util.Log
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.junit.runners.JUnit4
import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.io.PrintWriter

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("ru.kylikovskix.geksa", appContext.packageName)
    }

    @Test
    fun testSendMessage(){
        var  mTCPClient: TCPClient = TCPClient("test", 2000, object : TCPClient.OnMessageListener {

            override fun msgReceived(message: String) {

            }

            override fun msgError(message: String) {
            }
        })
        //val mBufferOut = PrintWriter(BufferedWriter(OutputStreamWriter(socket?.getOutputStream())), true)

        Assert.assertTrue("test".equals( mTCPClient.sendMessage("test")))
    }

    @Test
    fun testTCPClient(){
        val host_addr2 = "192.168.1.29:2000".split(":")
        val client = TCPClient(host_addr2?.get(0) ?: "", host_addr2?.get(1)?.toInt() ?: 2000, object : TCPClient.OnMessageListener {

            override fun msgReceived(message: String) {
            }

            override fun msgError(message: String) {
            }
        })

        val  mTCPClient: TCPClient = TCPClient("192.168.1.29", 2000, object : TCPClient.OnMessageListener {

            override fun msgReceived(message: String) {

            }

            override fun msgError(message: String) {
            }
        })

        assertEquals( "Some error",true,client.addr == mTCPClient.addr)
    }

}
