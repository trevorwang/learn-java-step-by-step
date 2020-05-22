package gradle.app

import gradle.app.algo.Regx
import gradle.app.exercise12.*
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import java.util.*

class Exercise12Test {
    @Test
    @Throws(InterruptedException::class)
    fun testConsumerProducer() {
        val cache: List<Int> = ArrayList()
        val p1 = Thread(Producer(cache), "P1")
        p1.start()
        val c1 = Thread(Customer(cache), "C1")
        c1.start()
        val c2 = Thread(Customer(cache), "C2")
        c2.start()
        p1.join()
        c1.join()
        c2.join()
    }

    @Test
    fun testCountDownLatch() {
        val driver = Driver()
        driver.run(10)
    }

    @Test
    fun testLruCache() {
        val cache = LRUCache(2)
        cache.put(1, 1)
        cache.put(2, 2)
        cache.get(1)
        cache.put(3, 3)
        cache.put(4, 4)
        cache.get(1)
        cache.get(3)
        cache.get(4)

        cache.let {  }
    }

    @Test
    fun testStrStr() {
        assertEquals(2, Solution.strStr("hello", "ll"))
        assertEquals(1, Solution.strStr("mississippi", "issi"))
    }

    @Test
    fun testRegx() {
        assertTrue(Regx.match("".toCharArray(),".*".toCharArray()))
        assertTrue(Regx.match("abc".toCharArray(),".*".toCharArray()))
        assertTrue(Regx.match("a".toCharArray(),".*".toCharArray()))
        assertTrue(Regx.match("a".toCharArray(),".*".toCharArray()))
        assertTrue(Regx.match("abcccc".toCharArray(),"ab.*".toCharArray()))
        assertTrue(Regx.match("abcccca".toCharArray(),"a.*ca".toCharArray()))
        assertTrue(Regx.match("aaaaa".toCharArray(),"aaaaa.*".toCharArray()))
        assertTrue(Regx.match("abbb".toCharArray(),".bbb".toCharArray()))
    }
}
