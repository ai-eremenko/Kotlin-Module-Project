class Note(val title: String, val content: String) {

    companion object {
        fun createNote(): Note {
            var title: String
            var content: String

            while (true) {
                val menu = Menu()
                title = menu.readInput("Введите название заметки:")
                if (title.isBlank()) {
                    println("Название не может быть пустым. Пожалуйста, введите название заново.")
                } else {
                    break
                }
            }

            while (true) {
                val menu = Menu()
                content = menu.readInput("Введите текст заметки:")
                if (content.isBlank()) {
                    println("Текст не может быть пустым. Пожалуйста, введите текст заново.")
                } else {
                    break
                }
            }

            return Note(title, content)
        }
    }
}