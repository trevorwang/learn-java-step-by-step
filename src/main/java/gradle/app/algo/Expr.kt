package gradle.app.algo

import java.security.InvalidParameterException
import java.util.*

object Expr {

    @Throws(InvalidParameterException::class)
    fun calc(expr: String): Int {
        val nums = Stack<Int>()
        val operators = Stack<Char>()
        expr.forEach {
            when (it) {
                '+', '-', '*', '/' -> operators.push(it)
                in '0'..'9' -> nums.push(Character.getNumericValue(it))
                ')' -> {
                    calcOnce(nums, operators)
                }
            }
        }

        while (!operators.isEmpty()) {
            calcOnce(nums, operators)
        }
        if (nums.size != 1) {
            throw InvalidParameterException("INVALID expr!!")
        }
        return nums.pop()
    }


    @Throws(InvalidParameterException::class)
    private fun calcOnce(nums: Stack<Int>, operators: Stack<Char>) {
        if (nums.size < 2 || operators.size < 1) {
            throw InvalidParameterException("INVALID expr!!")
        }
        val v2 = nums.pop()
        val v1 = nums.pop()
        val res = when (operators.pop()) {
            '+' -> v1 + v2
            '-' -> v1 - v2
            '*' -> v1 * v2
            '/' -> v1 / v2
            else -> 0
        }
        nums.push(res)
    }
}
