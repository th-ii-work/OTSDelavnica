fun main() {
    highOrderLambda(50, 80, 40, { num1: Int, num2: Int, num3: Int -> (num1 + num2 + num3) / 3 })
}

fun highOrderLambda(n1: Int, n2: Int, n3: Int, funcName: (Int, Int, Int) -> Int) {
    println(funcName(n1, n2, n3))
}