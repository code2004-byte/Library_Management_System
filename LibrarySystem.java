import java.util.*;

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n========== Library Menu ==========");
            System.out.println("1. Add Book");
            System.out.println("2. Register Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Available Books");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    int bookId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(bookId, title, author));
                    break;

                case 2:
                    System.out.print("Enter Member ID: ");
                    int memberId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Member Name: ");
                    String name = scanner.nextLine();
                    library.registerMember(new Member(memberId, name));
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    int issueBookId = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Member ID: ");
                    int issueMemberId = Integer.parseInt(scanner.nextLine());
                    library.issueBook(issueBookId, issueMemberId);
                    break;

                case 4:
                    System.out.print("Enter Book ID to return: ");
                    int returnBookId = Integer.parseInt(scanner.nextLine());
                    library.returnBook(returnBookId);
                    break;

                case 5:
                    library.listAvailableBooks();
                    break;

                case 6:
                    System.out.println("👋 Exiting the system. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("❌ Invalid choice. Try again.");
            }
        }
    }
}

class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
}

class Member {
    int id;
    String name;

    Member(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Library {
    List<Book> books = new ArrayList<>();
    Map<Integer, Member> members = new HashMap<>();

    void addBook(Book book) {
        books.add(book);
        System.out.println("✅ Book added: " + book.title);
    }

    void registerMember(Member member) {
        members.put(member.id, member);
        System.out.println("✅ Member registered: " + member.name);
    }

    void issueBook(int bookId, int memberId) {
        Book bookToIssue = null;
        for (Book book : books) {
            if (book.id == bookId) {
                bookToIssue = book;
                break;
            }
        }

        if (bookToIssue == null) {
            System.out.println("❌ Book not found.");
            return;
        }

        if (!members.containsKey(memberId)) {
            System.out.println("❌ Member not found.");
            return;
        }

        if (bookToIssue.isIssued) {
            System.out.println("❌ Book is already issued.");
        } else {
            bookToIssue.isIssued = true;
            System.out.println("✅ Book issued to " + members.get(memberId).name);
        }
    }

    void returnBook(int bookId) {
        for (Book book : books) {
            if (book.id == bookId) {
                if (book.isIssued) {
                    book.isIssued = false;
                    System.out.println("✅ Book returned: " + book.title);
                } else {
                    System.out.println("❌ This book was not issued.");
                }
                return;
            }
        }
        System.out.println("❌ Book not found.");
    }

    void listAvailableBooks() {
        System.out.println("📚 Available Books:");
        boolean found = false;
        for (Book book : books) {
            if (!book.isIssued) {
                System.out.println(" - " + book.id + ": " + book.title + " by " + book.author);
                found = true;
            }
        }
        if (!found) {
            System.out.println("❌ No available books.");
        }
    }
}
