import java.io.File

fun main() {
    var mine = mutableListOf<File>()
    var red = mutableListOf<File>()
    for (file in File("C:\\Users\\Shmuel\\OneDrive\\IdeaProjects\\CompareFolders\\Spelling mine").listFiles()!!
        .sorted()) {
        if (file.isDirectory) {
            for (file2 in file.listFiles()!!)
                mine.add(file2)
        }
        for (file1 in File("C:\\Users\\Shmuel\\OneDrive\\IdeaProjects\\CompareFolders\\Spelling red").listFiles()!!
            .sorted()) {
            if (file1.isDirectory) {
                for (file2 in file1.listFiles()!!)
                    red.add(file2)
            }
        }
    }
    val zipped = mine.zip(red)
    for (pair in zipped) {
        if (pair.first.length() != pair.second.length())
                println("file in mine: ${pair.first.absolutePath}, ${pair.first.length()}; file in red: ${pair.second.absolutePath}, ${pair.second.length()}.")
//            println("${pair.first.length()},${pair.second.length()}")
    }
    for(file1 in File("C:\\Users\\Shmuel\\OneDrive\\IdeaProjects\\CompareFolders\\Spelling mine").listFiles()!!
        .sorted())
        for(file2 in File("C:\\Users\\Shmuel\\OneDrive\\IdeaProjects\\CompareFolders\\Spelling red").listFiles()!!
            .sorted()) if(file1.hashCode()==file2.hashCode()){
            file1.delete()
            file2.delete()
        }
}
