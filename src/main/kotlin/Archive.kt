class Archive(val name: String) {
    val notes = mutableListOf<Note>()

    fun addNote(note: Note) {
        notes.add(note)
    }

    fun viewNotes() {
        if (notes.isEmpty()) {
            println("Нет заметок в архиве.")
        } else {
            notes.forEachIndexed { index, note -> println("${index + 1}. ${note.title}") }
        }
    }
}