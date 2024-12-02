import java.util.Scanner

class Menu {
    private val scanner = Scanner(System.`in`)

    fun showMenu(title: String, options: List<Pair<String, () -> Unit>>) {
        while (true) {
            println("\n$title:")
            options.forEachIndexed { index, option -> println("$index. ${option.first}") }
            println("Введите номер пункта меню:")

            val input = scanner.nextLine()
            if (input == "0") break

            val index = input.toIntOrNull()
            if (index == null) {
                println("Пожалуйста, вводите только цифры.")
            } else if (index !in options.indices) {
                println("Такого пункта нет. Пожалуйста, введите корректный номер.")
            } else {
                options[index].second.invoke()
            }
        }
    }

    fun readInput(prompt: String): String {
        println(prompt)
        return scanner.nextLine()
    }
}
