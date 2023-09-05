fun main() {
    highOrder(50, 80, 40, ::myFunction)
}

fun myFunction(n1: Int, n2: Int, n3: Int): Int {
    return ((n1 + n2 + n3) / 3)
}

fun highOrder(n1: Int, n2: Int, n3: Int, funcName: (Int, Int, Int) -> Int) {
    println(funcName(n1, n2, n3))
}