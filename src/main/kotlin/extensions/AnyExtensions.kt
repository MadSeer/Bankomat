package extensions

fun Any.anything(predicate: () -> Boolean, operation: () -> Unit, operationFailed: () -> Unit) {
    if (predicate.invoke()) {
        operation.invoke()
    } else {
        operationFailed.invoke()
    }
}