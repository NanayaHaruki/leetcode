class SeatManager(n: Int) {
    val pq = PriorityQueue<Int>((1..n).toList())
   
    fun reserve(): Int {
        return pq.poll()
   
    }

    fun unreserve(seatNumber: Int) {
        pq.offer(seatNumber)
    }

}
