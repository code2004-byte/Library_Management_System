**🔍 Introduction**
The Library Management System is a simple Java console application designed to automate basic library operations such as managing books and members, issuing books, and tracking returns. This system streamlines the manual process of library management and ensures efficient handling of records.

**🎯 Objective:**
The primary objective of the system is to:

Maintain a list of books and members.

Enable easy book issuance and return.

Track the availability of books.

Provide a simple user interface through the command-line menu.

**🛠️ Key Features**
Add Book: Allows the librarian to add new books with unique IDs, titles, and authors.

Register Member: Enables the registration of new members by assigning them an ID and name.

Issue Book: Facilitates issuing books to registered members while checking for availability.

Return Book: Handles the return of previously issued books and updates their status.

View Available Books: Lists all books that are currently not issued.

Exit System: Terminates the application safely.

**🧱 System Components**
Book Class: Represents a book with properties like id, title, author, and isIssued status.

Member Class: Represents a library member with id and name.

Library Class: Manages collections of books and members using List and Map, and contains methods to perform all operations.

Main Class: Provides a menu-driven interface to interact with the user and call respective library operations.

**💻 Technology Stack**
Language: Java

Input/Output: Java Scanner for user input

Data Structures: ArrayList for books, HashMap for member data storage

**✅ Advantages**
Easy to use for small to medium libraries.

Modular design with separate responsibilities for each class.

Prevents double issuance of books.

Real-time updates of book availability.
