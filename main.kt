fun main(){
    var keys = (0..999).map { String.format("%03d", it) }
    val conditions = mapOf(
        "291" to listOf(1, 1),
        "245" to listOf(1, 0),
        "463" to listOf(2, 0),
        "578" to listOf(0, 0),
        "569" to listOf(1, 0)
    )

    conditions.forEach{ (k, v) ->
        keys = keys.filter {value ->
            (k.toSet().intersect(value.toSet())).size == v[0] &&
                    (positionalSet(k).toSet().intersect(positionalSet(value))).size == v[1]
        }}
    println(keys)
}

fun positionalSet(value: String): MutableSet<String>{
    val elementPosition = mutableSetOf<String>();
    value.forEachIndexed { idx, e -> elementPosition.add("$e$idx")}
    return elementPosition
}
