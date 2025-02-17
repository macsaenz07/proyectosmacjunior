fun main() {
    val tareas = mutableListOf<String>() // Lista para almacenar tareas

    while (true) {
        println("\n📌 MENÚ: ")
        println("1. Agregar tarea")
        println("2. Ver tareas")
        println("3. Eliminar tarea")
        println("4. Salir")
        print("Selecciona una opción: ")

        when (readln()) {
            "1" -> {
                print("📌 Ingresa una nueva tarea: ")
                val tarea = readln()
                tareas.add(tarea)
                println("✅ Tarea agregada.")
            }
            "2" -> {
                println("\n📋 Lista de tareas:")
                if (tareas.isEmpty()) {
                    println("No hay tareas pendientes.")
                } else {
                    tareas.forEachIndexed { index, tarea -> println("${index + 1}. $tarea") }
                }
            }
            "3" -> {
                println("\n🗑️ Eliminar tarea")
                tareas.forEachIndexed { index, tarea -> println("${index + 1}. $tarea") }
                print("Selecciona el número de la tarea a eliminar: ")
                val index = readln().toIntOrNull()
                if (index != null && index in 1..tareas.size) {
                    tareas.removeAt(index - 1)
                    println("✅ Tarea eliminada.")
                } else {
                    println("❌ Opción inválida.")
                }
            }
            "4" -> {
                println("👋 Saliendo...")
                break
            }
            else -> println("❌ Opción no válida, intenta de nuevo.")
        }
    }
}
