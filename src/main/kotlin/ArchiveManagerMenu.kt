class ArchiveManagerMenu() {

    fun showArchiveManagerMenu(archiveManager: ArchiveManager) {
        val archiveManagerMenuOptions = mutableListOf<Pair<String, () -> Unit>>(
            "Выход" to { null },
            "Создать архив" to { archiveManager.createArchive() },
            "Просмотреть архивы" to { archiveManager.viewArchives() },
            "Выбрать архив для просмотра" to { selectArchives(archiveManager) }
        )

        val menu = Menu()
        menu.showMenu("Меню архивов", archiveManagerMenuOptions)
    }


    private fun selectArchives(archiveManager: ArchiveManager) {
        archiveManager.viewArchives()
        val menu = Menu()
        val index = menu.readInput("Введите номер архива для просмотра заметок:")
        if (index == "0") return

        val archiveIndex = index.toIntOrNull()?.minus(1)
        val archive = archiveManager.getArchive(archiveIndex ?: -1)
        if (archive != null) {
            val archiveMenu = ArchiveMenu(archive)
            archiveMenu.showArchiveMenu()
        } else {
            println("Архив не найден.")
        }
    }
}