// Definimos la data class Tarea para almacenar la descripción y la prioridad.
data class Tarea(val descripcion: String, var prioridad: Int)

fun main() {
    val tareas = mutableListOf<Tarea>() // Lista para almacenar tareas con prioridad

    while (true) {
        println("\n📌 MENÚ:")
        println("1. Agregar tarea")
        println("2. Ver tareas")
        println("3. Eliminar tarea")
        println("4. Reorganizar tareas por prioridad")
        println("5. Salir")
        print("Selecciona una opción: ")

        when (readln()) {
            "1" -> {
                print("📌 Ingresa una nueva tarea: ")
                val descripcion = readln()
                print("🔢 Ingresa la prioridad (1 = Alta, 2 = Media, 3 = Baja): ")
                // Si el usuario ingresa un número inválido, asignamos prioridad 3 (Baja) por defecto.
                val prioridad = readln().toIntOrNull() ?: 3
                tareas.add(Tarea(descripcion, prioridad))
                println("✅ Tarea agregada.")
            }
            "2" -> {
                println("\n📋 Lista de tareas:")
                if (tareas.isEmpty()) {
                    println("No hay tareas pendientes.")
                } else {
                    tareas.forEachIndexed { index, tarea ->
                        val prioTexto = when (tarea.prioridad) {
                            1 -> "Alta"
                            2 -> "Media"
                            3 -> "Baja"
                            else -> "Desconocida"
                        }
                        println("${index + 1}. [Prioridad: $prioTexto] ${tarea.descripcion}")
                    }
                }
            }
            "3" -> {
                println("\n🗑️ Eliminar tarea")
                if (tareas.isEmpty()) {
                    println("No hay tareas para eliminar.")
                } else {
                    tareas.forEachIndexed { index, tarea ->
                        println("${index + 1}. ${tarea.descripcion}")
                    }
                    print("Selecciona el número de la tarea a eliminar: ")
                    val index = readln().toIntOrNull()
                    if (index != null && index in 1..tareas.size) {
                        tareas.removeAt(index - 1)
                        println("✅ Tarea eliminada.")
                    } else {
                        println("❌ Opción inválida.")
                    }
                }
            }
            "4" -> {
                if (tareas.isEmpty()) {
                    println("No hay tareas para reorganizar.")
                } else {
                    // Ordenamos la lista: menor número de prioridad (1) es más alta.
                    tareas.sortBy { it.prioridad }
                    println("✅ Tareas reorganizadas por prioridad.")
                }
            }
            "5" -> {
                println("👋 Saliendo...")
                break
            }
            else -> println("❌ Opción no válida, intenta de nuevo.")
        }
    }
}
