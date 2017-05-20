/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess;

import DTO.DTOAuthorBook;
import DTO.DTOBookLocation;
import DTO.DTOLocation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class SQLMapping {

    // 1. Given a city name your application returns all book titles with 
    // corresponding authors that mention this city.
    public Collection<DTOAuthorBook> getAllBookTitleWithAuthorByCityName(Connection con, String tempLocation) {

        Collection<DTOAuthorBook> books = new ArrayList<>();

//        String SQLString1 
//                = "SELECT DISTINCT b.title, a.name FROM author a, book b, "
//                + "location l, book_location bl, author_book ab"
//                + "WHERE l.name = ? AND l.UID = bl.UIDlocations AND"
//                + "bl.UIDbooks = b.UID AND b.UID = ab.UIDbook AND"
//                + "ab.UIDauthor = a.UID";
        String SQLString1
                = "SELECT DISTINCT b.title, a.name FROM author a, book b, location l, book_location bl, author_book ab"
                + " WHERE l.name = ? AND l.UID = bl.UIDlocations AND bl.UIDbooks = b.UID AND"
                + " b.UID = ab.UIDbook AND ab.UIDauthor = a.UID";

        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement(SQLString1);
            statement.setString(1, tempLocation);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                books.add(new DTOAuthorBook(rs.getString("title"), rs.getString("name")));
            }
            for (DTOAuthorBook x : books) {
                System.out.println("Book title " + x.getTitle() + " - Author: " + x.getAuthor());
            }

        } catch (Exception e) {
            System.out.println("Fail in Mapping");
            System.out.println(e.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in closing connection");
                System.out.println(e.getMessage());
            }
        }

        return books;
    }

    // Given a book title, your application plots all cities mentioned in this book onto a map.
    public Collection<DTOBookLocation> getAllLocationByBookTitle(Connection con, String title) {

        Collection<DTOBookLocation> locations = new ArrayList<>();

        String SQLString1
                = "SELECT DISTINCT book.title, l.name FROM location l"
                + " INNER JOIN book_location ON book_location.UIDlocations = l.UID"
                + " INNER JOIN author_book ON author_book.UIDbook = book_location.UIDbooks"
                + " INNER JOIN author ON author.UID = author_book.UIDauthor"
                + " INNER JOIN book ON book.UID = author_book.UIDbook"
                + " WHERE book.title = ?";

        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement(SQLString1);
            statement.setString(1, title);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                locations.add(new DTOBookLocation(rs.getString("title"), rs.getString("name")));
            }
            
            for (DTOBookLocation x : locations) {
                System.out.println("Book title: " + x.getTitle() + " Location name: " + x.getName());
            }

        } catch (Exception e) {
            System.out.println("Fail in Mapping");
            System.out.println(e.getMessage());
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                System.out.println("Fail in closing connection");
                System.out.println(e.getMessage());
            }
        }

        return locations;
    }
}
