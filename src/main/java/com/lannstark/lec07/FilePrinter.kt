package com.lannstark.lec07

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

//class FilePrinter {

    // Kotlin
    // -> Checked Exception, UnChecked Exception 구분하지 않는다
    // -> 즉 모두 UnChecked Exception !!
    fun readFile(){
        val currentFile = File(".")
        val file = File(currentFile.absoluteFile.absolutePath + "/a.txt")
        val reader = BufferedReader(FileReader(file))
        println(reader.readLine())
        reader.close()
    }

    // Kotlin 에서는 try-with-resources 구문이 없다
    // 대신 use 라는 inline 함수를 사용한다
    fun readFile2(path: String) {
        BufferedReader(FileReader(path)).use{ reader ->
            println(reader.readLine())
        }

    }

    fun main() {
        repeat("test")
        // named argument
        // 단 Kotlin 에서 Java 함수를 가져다 사용할 때는 named argument 를 사용할 수 없다
        repeat("test2", useNewLine = false)

        printAll("A","B","C")
        val array = arrayOf("A","B","C")
        // 스프레드 연산자 : *
        printAll(*array)
    }

    fun repeat(str: String,
               num: Int = 3,
               useNewLine: Boolean = true
    ) {
        for (i in 1..num) {
            if (useNewLine) {
                println(str)
            }else{
                println(str)
            }
        }
    }

// 4. 같은 타입의 여러 파라미터 받기(가변인자)
    fun printAll(vararg strings: String) {
        for(str in strings) {
            println(str)
        }
    }




//}