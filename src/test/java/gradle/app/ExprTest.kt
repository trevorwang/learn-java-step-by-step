package gradle.app

import gradle.app.algo.Expr
import org.junit.Assert.assertEquals
import org.junit.Test


class ExprTest {

    @Test
    fun testExpr() {
        assertEquals(6, Expr.calc("1+2+3"))
        assertEquals(0, Expr.calc("1+2-3"))
        assertEquals(7, Expr.calc("1+2*3"))
        assertEquals(9, Expr.calc("(1+2)*3"))
        assertEquals(-3, Expr.calc("(1-2)*3"))
        assertEquals(8, Expr.calc("5+6-(4-1)"))
        assertEquals(23, Expr.calc("5+6*(4-1)"))
    }
}
