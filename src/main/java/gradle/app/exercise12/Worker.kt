package gradle.app.exercise12

import java.util.concurrent.CountDownLatch

class Worker(private val startSignal: CountDownLatch, private val doneSignal: CountDownLatch) : Runnable {
    override fun run() {
        try {
            startSignal.await();
            doWork();
            doneSignal.countDown();
        } catch (e: InterruptedException) {
        } // return;
    }

    private fun doWork() {
        println("doing work!")
    }
}
