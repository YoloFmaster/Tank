package com.example.tank

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.KeyEvent.KEYCODE_DPAD_DOWN
import android.view.KeyEvent.KEYCODE_DPAD_LEFT
import android.view.KeyEvent.KEYCODE_DPAD_RIGHT
import android.view.KeyEvent.KEYCODE_DPAD_UP
import android.widget.FrameLayout
import com.example.tank.Direction.UP
import com.example.tank.Direction.LEFT
import com.example.tank.Direction.RIGHT
import com.example.tank.Direction.DOWN
import com.example.tank.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when(keyCode){
            KEYCODE_DPAD_DOWN -> move(DOWN)
            KEYCODE_DPAD_LEFT -> move(LEFT)
            KEYCODE_DPAD_RIGHT ->  move(RIGHT)
            KEYCODE_DPAD_UP -> move(UP)
        }
        return super.onKeyDown(keyCode, event)
    }
    private fun move(direction: Direction){
        when(direction){
            UP ->{
                binding.MyTank.rotation = 0f
                (binding.MyTank.layoutParams as FrameLayout.LayoutParams).topMargin += -50
            }
            DOWN ->{
                binding.MyTank.rotation = 180f
                (binding.MyTank.layoutParams as FrameLayout.LayoutParams).topMargin += 50
            }
            RIGHT ->{
                binding.MyTank.rotation = 90f
                (binding.MyTank.layoutParams as FrameLayout.LayoutParams).leftMargin += 50
            }
            LEFT ->{
                binding.MyTank.rotation = 270f
                (binding.MyTank.layoutParams as FrameLayout.LayoutParams).leftMargin -= 50
            }
        }
        binding.container.removeView( binding.MyTank)
        binding.container.addView(binding.MyTank)
    }
}