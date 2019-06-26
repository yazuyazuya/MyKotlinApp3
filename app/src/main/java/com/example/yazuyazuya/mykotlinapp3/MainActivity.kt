package com.example.yazuyazuya.mykotlinapp3

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 値を入れる変数
        var num : Int = 0

        // 演算子を入れる変数
        var operater : String? = null

        // 各ボタンのフラグ
        // trueなら機能を実行する
        var clear : Boolean = false
        var calc : Boolean = false

        // 各数字のボタン
        val zero : Button = findViewById(R.id.zero)
        val one : Button = findViewById(R.id.one)
        val two : Button = findViewById(R.id.two)
        val three : Button = findViewById(R.id.three)
        val four : Button = findViewById(R.id.four)
        val five : Button = findViewById(R.id.five)
        val six : Button = findViewById(R.id.six)
        val seven : Button = findViewById(R.id.seven)
        val eight : Button = findViewById(R.id.eight)
        val nine : Button = findViewById(R.id.nine)

        // 各演算子のボタン
        val add : Button = findViewById(R.id.add)
        val sub : Button = findViewById(R.id.sub)
        val mul : Button = findViewById(R.id.mul)
        val dev : Button = findViewById(R.id.dev)

        // イコールボタン
        val equal : Button = findViewById(R.id.equal)

        // クリアボタン
        val clearBtn : Button = findViewById(R.id.clear)

        // 表示テキスト
        val text : TextView = findViewById(R.id.display)

        // 数字を押した時の処理をまとめた関数
        fun numButtonAction(num: String) {
            text.text = if(text.text.toString() != "0" && clear == false){
                text.text.toString() + num
            } else {
                clear = false
                num
            }
            calc = true
        }

        // クリアボタンを押された時の処理
        clearBtn.setOnClickListener {
            text.text = "0"
            num = 0
            operater = null
            clear = false
            calc = false
        }

        // 数字ボタンを押した時の処理
        zero.setOnClickListener {
            numButtonAction("0")
        }

        one.setOnClickListener {
            numButtonAction("1")
        }

        two.setOnClickListener {
            numButtonAction("2")
        }

        three.setOnClickListener {
            numButtonAction("3")
        }

        four.setOnClickListener {
            numButtonAction("4")
        }

        five.setOnClickListener {
            numButtonAction("5")
        }

        six.setOnClickListener {
            numButtonAction("6")
        }

        seven.setOnClickListener {
            numButtonAction("7")
        }

        eight.setOnClickListener {
            numButtonAction("8")
        }

        nine.setOnClickListener {
            numButtonAction("9")
        }

        // 計算処理を行う関数
        fun calculation(op: String?) : Int {
            return if (op == "+") {
                num + text.text.toString().toInt()
            } else if (op == "-") {
                num - text.text.toString().toInt()
            } else if (op == "*") {
                num * text.text.toString().toInt()
            } else if (op == "/") {
                num / text.text.toString().toInt()
            } else {
                text.text.toString().toInt()
            }
        }

        // 演算子ボタンを押した時の処理をまとめた関数
        fun calcButtonaction(op: String?) {
            if (calc == true) {
                num = calculation(operater)
                clear = true
                calc = false
                text.text = num.toString()
            }
            operater = op

        }

        // 演算子ボタンが押された時の処理
        add.setOnClickListener {
            calcButtonaction("+")
        }

        sub.setOnClickListener {
            calcButtonaction("-")
        }

        mul.setOnClickListener {
            calcButtonaction("*")
        }

        dev.setOnClickListener {
            calcButtonaction("/")
        }

        // イコールボタンが押されたときの処理
        equal.setOnClickListener {
            if (calc == true) {
                num = calculation(operater)
                calc = false
                clear = true
                text.text = num.toString()
                operater = null
            }
        }

    }
}
