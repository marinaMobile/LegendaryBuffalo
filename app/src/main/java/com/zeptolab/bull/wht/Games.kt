package com.zeptolab.bull.wht

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.zeptolab.bull.R
import com.zeptolab.bull.databinding.ActivityGamesBinding
import java.util.*

class Games : AppCompatActivity() {
    lateinit var bindGame: ActivityGamesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindGame = ActivityGamesBinding.inflate(layoutInflater)
        setContentView(bindGame.root)
        var counter: Int = 0

        bindGame.tr1.setOnClickListener{
            counter++
        }

        bindGame.tr2.setOnClickListener{
            counter++
        }

        bindGame.tr3.setOnClickListener{
            counter++
        }

        val running : TextView = findViewById(R.id.running)


        val s : Long = "15".toLong() * 1000

        object : CountDownTimer( s , 1000) {

            override fun onTick(millisUntilFinished: Long) {
                running.text = "${millisUntilFinished / 1000}"
            }

            override fun onFinish() {
                MaterialAlertDialogBuilder(this@Games)
                    .setTitle("Time's up!")
                    .setMessage("You caught the treasures $counter times")
                    .setCancelable(false)
                    .setPositiveButton("Play again"){dialog, _ ->
                        startActivity(Intent(applicationContext, Games::class.java))
                        finish()
                        dialog.dismiss()
                    }
                    .create()
                    .show()
            }
        }.start()




        Timer().schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    val rand = Random()
                    val dx: Float = rand.nextFloat() * (bindGame.llWasp.width-bindGame.tr1.width)
                    val dy: Float = rand.nextFloat() * (bindGame.llWasp.height-bindGame.tr1.height)
                    bindGame.tr1.animate()
                        .x(dx)
                        .y(dy)
                        .setDuration(500)
                        .start()
                }
            }
        }, 0, 300)

        Timer().schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    val rand = Random()
                    val dx: Float = rand.nextFloat() * (bindGame.llWasp.width-bindGame.tr1.width)
                    val dy: Float = rand.nextFloat() * (bindGame.llWasp.height-bindGame.tr1.height)
                    bindGame.tr2.animate()
                        .x(dx)
                        .y(dy)
                        .setDuration(200)
                        .start()
                }
            }
        }, 0, 400)

        Timer().schedule(object : TimerTask() {
            override fun run() {
                runOnUiThread {
                    val rand = Random()
                    val dx: Float = rand.nextFloat() * (bindGame.llWasp.width-bindGame.tr1.width)
                    val dy: Float = rand.nextFloat() * (bindGame.llWasp.height-bindGame.tr1.height)
                    bindGame.tr3.animate()
                        .x(dx)
                        .y(dy)
                        .setDuration(700)
                        .start()
                }
            }
        }, 0, 600)


    }
}