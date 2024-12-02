class ArchiveManager {
    private val archives = mutableListOf<Archive>()

    fun createArchive() {
        val menu = Menu()
        val name = menu.readInput("Введите название архива:")

        if (name.isNotBlank()) {
            archives.add(Archive(name))
            println("Архив '$name' создан.")
        } else {
            println("Название не может быть пустым.")
        }
    }

    fun viewArchives() {
        if (archives.isEmpty()) {
            println("Нет архивов.")
        } else {
            archives.forEachIndexed { index, archive -> println("${index + 1}. ${archive.name}") }
        }
    }

    fun getArchive(index: Int): Archive? {
        return if (index in archives.indices) archives[index] else null
    }
}