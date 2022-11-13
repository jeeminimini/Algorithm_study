package jimin.`9week`

fun main() {
    val naming = readLine()
    var type = "Error!"
    if (naming != null) {
        if (naming.contains('_')) {
            if (naming[0] == '_' || naming[naming.length - 1] == '_' || naming.any { it.isUpperCase() } ||
                    naming.contains("__")) {
                type = "Error!"
            } else {
                type = "C++"
            }
        } else if (naming.filter { it.isUpperCase() }.isNotEmpty()) {
            if (naming[0].isUpperCase()) {
                type == "Error!"
            } else {
                type = "Java"
            }

        }
    }
    when (type) {
        "C++" -> {
            var underBar = false
            naming?.forEach {
                if (underBar) {
                    print(it.uppercaseChar())
                    underBar = false
                } else {
                    if (it.isLowerCase()) {
                        print(it)
                    } else if (it == '_') {
                        underBar = true
                    }
                }
            }
        }

        "Java" -> {
            naming?.forEach {
                if (it.isLowerCase()) {
                    print(it)
                } else {
                    print("_" + it.lowercaseChar())
                }
            }
        }

        "Error!" -> {
            if (naming != null) {
                if (naming.all { it.isLowerCase() }) {
                    println(naming)
                }else {
                    println(type)
                }
            }
        }
    }
}