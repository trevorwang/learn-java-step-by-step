package gradle.app.exercise12

import java.util.concurrent.CountDownLatch

class Driver {
    fun run(N: Int) {
        val startSignal = CountDownLatch(1)
        val doneSignal = CountDownLatch(N)

        for (i in 1..N) {
            println(i)
            Thread(Worker(startSignal, doneSignal)).start()
            println("I am trying to countdown")
            startSignal.countDown()
            println("countDown")
        }
        doneSignal.await()
    }
}
