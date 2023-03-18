package jimin.`27week`

class `친구 네트워크` {
    val friends = mutableMapOf<String, String>()
    val children = mutableMapOf<String, Int>()
    fun solve() {
        val n = readln().toInt()
        repeat(n) {
            val f = readln().toInt()
            repeat(f) {
                val (a, b) = readln().split(" ")
                if (friends[a] == null) {
                    friends[a] = a
                    children[a] = 1
                }
                if (friends[b] == null) {
                    friends[b] = b
                    children[b] = 1
                }
                setParent(a, b)
                getParent(a)
                getParent(b)
                println(children[friends[a]])
            }
            friends.clear()
            children.clear()
        }
    }

    fun getParent(name: String): String {
        if (name != friends[name]) {
            friends[name] = getParent(friends[name]!!)
        }
        return friends[name]!!
    }

    fun setParent(first:String, second: String) {
        val firstParent = getParent(first)
        val secondParent = getParent(second)

        if (firstParent < secondParent) {
            friends[secondParent] = firstParent
            children[firstParent] = children[firstParent]!! + children[secondParent]!!
        } else if (firstParent > secondParent){
            friends[firstParent] = secondParent
            children[secondParent] = children[secondParent]!! + children[firstParent]!!
        }
    }
}

fun main() {
    `친구 네트워크`().solve()
}