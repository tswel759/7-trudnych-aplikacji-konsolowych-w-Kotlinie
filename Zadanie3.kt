data class Book(val title: String, val author: String, val year: Int)

fun main() {
    val books = mutableListOf<Book>()

    while (true) {
        println("\nFavorite Books Tracker")
        println("1. Add a new book")
        println("2. Filter books by author")
        println("3. Filter books by year")
        println("4. Sort books alphabetically by title")
        println("5. Show all books")
        println("6. Exit")
        print("Choose an option: ")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                print("Enter title: ")
                val title = readLine() ?: ""
                print("Enter author: ")
                val author = readLine() ?: ""
                print("Enter year: ")
                val year = readLine()?.toIntOrNull() ?: 0
                books.add(Book(title, author, year))
                println("Book added.")
            }
            2 -> {
                print("Enter author name to filter: ")
                val author = readLine() ?: ""
                val filteredBooks = books.filter { it.author.equals(author, ignoreCase = true) }
                println("Books by $author:")
                filteredBooks.forEach { println(it) }
            }
            3 -> {
                print("Enter year to filter: ")
                val year = readLine()?.toIntOrNull() ?: 0
                val filteredBooks = books.filter { it.year == year }
                println("Books from year $year:")
                filteredBooks.forEach { println(it) }
            }
            4 -> {
                val sortedBooks = books.sortedBy { it.title }
                println("Books sorted by title:")
                sortedBooks.forEach { println(it) }
            }
            5 -> {
                println("All books:")
                books.forEach { println(it) }
            }
            6 -> {
                println("Exiting the application. Goodbye!")
                break
            }
            else -> println("Invalid option. Please try again.")
        }
    }
}
