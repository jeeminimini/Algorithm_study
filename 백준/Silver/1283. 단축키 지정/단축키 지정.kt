package jimin.`8week`

import java.io.BufferedReader
import java.io.InputStreamReader

/*
<문제>


<구현 방법>


<트러블 슈팅>
 */


fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val wordList = mutableListOf<String>()
    val shortcut = mutableListOf<String>()
    repeat(readLine().toInt()) {
        val words = readLine().split(" ")
        run {
            words.map { it[0] }.forEachIndexed { index, c ->
                if (shortcut.none { it.equals(c.toString(), true) }) {
                    shortcut.add(c.toString())
                    wordList.add(
                        words.subList(0, index).joinToString(" ")
                                + " [" + c + "]"
                                + words[index].substring(1)
                                + " "
                                + words.subList(index + 1, words.size).joinToString(" ")
                    )
                    return@run
                }
            }
            run {
                words.forEachIndexed { index1, word ->
                    word.forEachIndexed { index2, c ->
                        if (shortcut.none { it.equals(c.toString(), true) }) {
                            shortcut.add(c.toString())
                            wordList.add(
                                words.subList(0, index1).joinToString(" ") + " " +
                                        word.substring(0, index2) + "[" + c + "]" + word.substring(index2 + 1) + " " +
                                        words.subList(index1 + 1, words.size).joinToString(" ")
                            )
                            return@run
                        }
                    }
                }
                wordList.add(words.joinToString(" "))
            }

        }
    }
    wordList.forEach {
        println(it.trim())
    }
}