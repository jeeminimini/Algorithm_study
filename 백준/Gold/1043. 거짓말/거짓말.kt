package jimin.`18week`

val partyPeople = mutableMapOf<Int, MutableSet<Int>>()
lateinit var truePeople: MutableSet<Int>
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    truePeople = readln().split(" ").map { it.toInt() }.drop(1).toMutableSet()
    val partyInfo = mutableListOf<List<Int>>()
    repeat(n) {
        partyPeople[it + 1] = mutableSetOf()
    }
    repeat(m) {
        val people = readln().split(" ").map { it.toInt() }.drop(1)
        people.forEach { person ->
            people.forEach {
                if (person != it) {
                    partyPeople[person]?.add(it)
                }
            }
        }
        partyInfo.add(people)
    }

    setTrue(MutableList(n){false})
    var result = 0
    partyInfo.forEach{ party ->
        if(party.all{it !in truePeople}){
            result += 1
        }
    }
    println(result)
}

fun setTrue(visited: MutableList<Boolean>) {
    val queue = truePeople.toMutableList()
    while (queue.isNotEmpty()) {
        val person = queue.removeAt(0)

        visited[person - 1] = true
        partyPeople[person]?.forEach{
            if (visited[it - 1].not()) {
                queue.add(it)
                truePeople.add(it)
                //println("person $person party ${partyPeople[person]} visited $visited true $truePeople")
            }
        }
    }
}