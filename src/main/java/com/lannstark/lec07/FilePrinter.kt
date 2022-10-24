package com.lannstark.lec07

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

class FilePrinter {

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
}