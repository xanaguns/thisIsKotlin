package net.flow9.scopefunction

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import net.flow9.scopefunction.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        checkApply()
        checkRun()
        checkLet()
        checkAlso()
        checkWith()
    }

    fun checkApply() {
        val newStudent = MyStudent()
        val resultApply = newStudent.apply {
            age = 20
            name = "Tame"
            address = "ChungName Sejong"
        }
        println("새 학생 이름은 ${newStudent.name} 입니다.")
        Log.d("Scope","resultApply : $resultApply")
    }

    fun checkRun() {
        val students = mutableListOf("Jocker", "Superman","Batman")
        val studentsCount = students.run {
            add("Wonderwoman")
            add("Spiderman")
            count()
        }
        println("우리반 학생은 ${studentsCount}명 입니다")

        students.run {
            add("Flash")
            add("Wolverine")
            println("우리반 학생은 ${count()}명 입니다")
        }
    }

    fun checkLet() {
        val checkAge:Int? = 18
        val resultLet = checkAge?.let { number ->
            if(number < 19) {
                println("You are under age")
            }
            number
        }
        Log.d("Scope","resultLet : $resultLet")
    }

    fun checkAlso() {
        val dayOffList = mutableListOf(11,12,13)
        val resultAlso = dayOffList.also { dayOff ->
            dayOff.add(14)
            dayOff.add(15)
            println("나의 휴일은 ${dayOff.count()}일 입니다")
        }
        Log.d("Scope","resultAlso : $resultAlso")
    }

    fun checkWith() {
        with(binding.textView) {
            text = "Hi~"
            textSize = 21f
            setTextColor(Color.BLUE)
        }
    }
}

data class MyStudent (
    var age : Int = 21,
    var name : String = "Heath Ledger",
    var address : String = "Parkway CA 94043"
)
