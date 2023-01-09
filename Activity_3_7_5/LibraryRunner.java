
/*
 * Activity 3.7.5
 */
import java.util.ArrayList;

public class LibraryRunner
{
  public static void main(String[] arg) {
    Library library = new Library();
    // String authorToFind = "L. Frank Baum";
    // System.out.println("Here are the books by " + authorToFind + ":");
    // for (Book b : library.getChildrensBooks()) {
    //   if (b.getAuthor().equals(authorToFind)) {
    //     System.out.println("\t" + b.getTitle());
    //   }
    // }

    String bookToFind = "Sky Island";
    double minimumRating = 0.0;
    for (Book b : library.getChildrensBooks()) {
      if (b.getTitle().equals(bookToFind)) {
        minimumRating = b.getRating();
        System.out.println(minimumRating);
      }
    }

    System.out.println("Here are the books with a rating at least that of Sky Island:");
    for (Book b : library.getChildrensBooks()) {
      if (b.getRating() >= minimumRating) {
        System.out.println("\t" + b.getTitle());
      }
    }

    

    
  }
}