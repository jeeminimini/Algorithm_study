import java.util.*
class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var nowWeight = 0
        var time = 0
        var before = 0
        var bridge = ArrayDeque<Int>()
        var idx = 0
        while ((bridge.all{ it == 0 } && bridge.size == bridge_length).not()) {
            //println("time $time $bridge idx $idx")
            if (bridge.size == bridge_length) {
                bridge.removeFirst()
            }
            if (idx < truck_weights.size && bridge.sum() + truck_weights[idx] <= weight) {
                bridge.addLast(truck_weights[idx])
                idx += 1
            } else {
                bridge.add(0)
            }
            time += 1
            
        }
        return time
    }
}