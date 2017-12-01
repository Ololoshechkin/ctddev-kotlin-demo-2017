import org.junit.Assert.assertEquals
import org.junit.Test
import kotlin.math.min
import java.util.Random

class MainTest {
    class Graph(val v: Array<Int>, val u: Array<Int>, val c: Array<Int>)

    private fun ClosedRange<Int>.random() = Random().nextInt(endInclusive + 1 - start) + start

    private fun checkGraph(v: Int, g: Array<ArrayList<Int>>, used: Array<Boolean>, t: Int): Boolean {
        if (v == t) {
            return true
        }
        used[v] = true
        return g[v].any { !used[it] && checkGraph(it, g, used, t) }
    }

    private fun genTest(n: Int, m: Int, maxc: Int): Graph {
        while (true) {
            val v = Array(m, { 0 })
            val u = Array(m, { 0 })
            val g = Array(n, { ArrayList<Int>() })
            var ind = 0
            val eds = Array(n + 1, { Array(n + 1) { false } })
            while (ind < m) {
                val a = (1..n).random()
                val b = (1..n).random()
                if ((a == b) || eds[a][b]) {
                    continue
                }
                eds[a][b] = true
                v[ind] = a
                u[ind] = b
                ++ind
            }
            for (i in 0..(m - 1)) {
                g[v[i] - 1].add(u[i] - 1)
            }
            val used = Array(n, { false })
            if (!checkGraph(0, g, used, n - 1)) {
                continue
            }
            val c = Array(m) { (1..maxc).random() }
            return Graph(v, u, c)
        }
    }

    private fun runTest(n: Int, m: Int, maxc: Int) {
        val data = genTest(n, m, maxc)
        val ans = maxFlow(n, m, data.v, data.u, data.c, 0, n - 1)
        val g = Array<ArrayList<Int>>(n) { _ -> ArrayList() }
        ((1..(m - 1)).filter { data.c[it] - ans[it] > 0 }).forEach { g[data.v[it] - 1].add(data.u[it] - 1) }
        val used = Array(n, { false })
        assertEquals(false, checkGraph(0, g, used, n - 1))
    }


    @Test
    fun testSmall() {
        val n = 4
        val m = 6
        val maxc = 8
        runTest(n, m, maxc)
    }

    @Test
    fun testSmallWide() {
        val n = 4
        val m = 6
        val maxc = 100000
        runTest(n, m, maxc)
    }

    @Test
    fun testRandSmall() {
        val n = (2..10).random()
        val m = (1..min(50, n * (n - 1))).random()
        val maxc = (1..100).random()
        runTest(n, m, maxc)
    }

    @Test
    fun testRandSmallWide() {
        val n = (2..10).random()
        val m = (1..min(50, n * (n - 1))).random()
        val maxc = 10000
        runTest(n, m, maxc)
    }


    @Test
    fun testRand1() {
        val n = (2..1000).random()
        val m = (1..min(1000, n * (n - 1))).random()
        val maxc = (1..1000_000_000).random()
        runTest(n, m, maxc)
    }

    @Test
    fun testRand2() {
        val n = (2..1000).random()
        val m = (1..min(1000, n * (n - 1))).random()
        val maxc = (1..1000_000_000).random()
        runTest(n, m, maxc)
    }

    @Test
    fun testRand3() {
        val n = (2..1000).random()
        val m = (1..min(1000, n * (n - 1))).random()
        val maxc = (1..1000_000_000).random()
        runTest(n, m, maxc)
    }

    @Test
    fun testMax() {
        val n = 1000
        val m = 1000
        val maxc = 1000_000_000
        runTest(n, m, maxc)
    }

}