package jimin.`11week`

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.collections.LinkedHashMap

fun main(): Unit = with(BufferedReader(InputStreamReader(System.`in`))) {
    val name = readLine().chunked(1).toMutableList()
    var nameMap = LinkedHashMap<String, Int>(50)
    name.forEach {
        nameMap[it] = (nameMap[it] ?: 0) + 1
    }
    if (checkResult(nameMap) > 1) {
        println("I'm Sorry Hansoo")
        return@with
    }

    nameMap = sortMapByKey(nameMap)

    var result = ""
    var remain = ""
    nameMap.forEach { key, value ->
        if (value % 2 != 0) remain = key

        repeat(value / 2) {
            result += key
        }
    }
    println(result + remain + result.reversed())
}

fun sortMapByKey(map: LinkedHashMap<String, Int>): LinkedHashMap<String, Int> {
    val entries = LinkedList(map.entries)

    entries.sortBy { it.key }

    val result = LinkedHashMap<String, Int>()
    for (entry in entries) {
        result[entry.key] = entry.value
    }

    return result
}

fun checkResult(map: LinkedHashMap<String, Int>): Int {
    var result = 0
    map.forEach { _, u ->
        if (u % 2 == 1) result += 1
    }
    return result
}