package jimin.`22week`

import java.util.*

class `최소 회의실 개수` {
    val meetings = mutableListOf<Meeting>()

    fun solve() {
        repeat(readln().toInt()) {
            readln().split(" ").map { it.toInt() }.apply {
                meetings.add(Meeting(first(), last()))
            }
        }
        meetings.sortWith(compareBy<Meeting> { it.start }.thenBy{ it.end })

        val pq = PriorityQueue<Int>()
        pq.add(meetings.first().end)
        meetings.drop(1).forEach{ meeting ->
            if (pq.peek() <= meeting.start) {
                pq.poll()
            }
            pq.add(meeting.end)
        }
        println(pq.size)
    }

    data class Meeting(
        val start: Int,
        val end: Int
    )
}

fun main() {
    `최소 회의실 개수`().solve()
}