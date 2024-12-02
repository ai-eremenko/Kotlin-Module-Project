import Note.Companion.createNote

class ArchiveMenu (private val archive: Archive) {

    fun showArchiveMenu() {
        val archiveMenuOptions = mutableListOf<Pair<String, () -> Unit>>(
            "Назад" to {val archiveManagerMenu = ArchiveManagerMenu()
                val archiveManager = ArchiveManager()
                archiveManagerMenu.showArchiveManagerMenu(archiveManager) },
            "Создать заметку" to { createAndAddNoteToArchive(archive) },
            "Просмотреть заметки" to { archive.viewNotes() },
            "Выбрать заметку для просмотра" to { selectNoteToView(archive) }
        )

        val menu = Menu()
       menu.showMenu("Меню заметок в архиве '${archive.name}'", archiveMenuOptions)
    }

    private fun createAndAddNoteToArchive(archive: Archive) {
        val note = createNote()
        if (note != null) {
            archive.addNote(note)
            println("Заметка '${note.title}' добавлена в архив '${archive.name}'.")
        }
    }

    fun selectNoteToView(archive: Archive) {
        if (archive.notes.isEmpty()) {
            println("Нет доступных заметок.")
            return
        }

        println("Выберите номер заметки для просмотра:")
        archive.notes.forEachIndexed { index, note ->
            println("${index + 1}. ${note.title}")
        }
        val menu = Menu()
        val choice = menu.readInput("Введите номер заметки:")

        val selectedIndex = choice.toIntOrNull()

        if (selectedIndex != null && selectedIndex in 1..archive.notes.size) {
            val selectedNote = archive.notes[selectedIndex - 1]
            val noteMenu = NoteMenu(archive)
            noteMenu.showNoteMenu(selectedNote)
        } else {
            println("Некорректный ввод. Пожалуйста, попробуйте снова.")
        }
    }
}