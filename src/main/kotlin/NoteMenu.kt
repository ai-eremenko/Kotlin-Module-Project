class NoteMenu(private val archive: Archive) {
    fun showNoteMenu(note: Note) {
        println("Название заметки: ${note.title}")
        println("Содержимое заметки:\n${note.content}")

        val noteMenuOptions = mutableListOf<Pair<String, () -> Unit>>(
            "Назад" to {
                val archiveMenu = ArchiveMenu( archive)
                archiveMenu.showArchiveMenu() }
        )
        val menu = Menu()
        menu.showMenu("Меню заметки '${note.title}'", noteMenuOptions)

    }
}
