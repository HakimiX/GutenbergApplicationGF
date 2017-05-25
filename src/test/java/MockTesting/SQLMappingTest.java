
package MockTesting;

import DTO.DTOAuthorBook;
import DTO.DTOBookLocation;
import DataAccess.DBfacade;
import DataAccess.SQLMapping;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(Parameterized.class)
public class SQLMappingTest {


    public SQLMappingTest(String _data) {
        this._data = _data;
    }

    private String _data;
    //private String _location;

    @Parameterized.Parameters
    public static Collection<String> data() {
        return Arrays.asList(new String[]{"test1", "test2", "test3", "test4", "test5"});
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of getAllBookTitleWithAuthorByCityName method, of class SQLMapping.
     */
    @Test
    public void testGetAllBookTitleWithAuthorByCityName() {
        System.out.println("getAllBookTitleWithAuthorByCityName: " + _data);
        
        List<DTOAuthorBook> listBooks = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            listBooks.add(new DTOAuthorBook("title" + i, _data));
        }
        
        DBfacade mocked = mock(DBfacade.class);
        when(mocked.getAllBookTitleWithAuthorByCityName(_data)).thenReturn(listBooks);
        
        for(int i = 0; i < 10; i++){
            assertEquals(listBooks.iterator().next().toString(), mocked.getAllBookTitleWithAuthorByCityName(_data).iterator().next().toString());
        }
    }

    /**
     * Test of getAllLocationByBookTitle method, of class SQLMapping.
     */
    @Test
    public void testGetAllLocationByBookTitle() {
        System.out.println("getAllLocationByBookTitle: " + _data);
        
        List<DTOAuthorBook> listBooks = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            listBooks.add(new DTOAuthorBook("title" + i, _data));
        }
        
        DBfacade mocked = mock(DBfacade.class);
        when(mocked.getAllBooksAndCitiesByAuthorName(_data)).thenReturn(listBooks);
        
        for(int i = 0; i < 10; i++){
            assertEquals(listBooks.iterator().next().toString(), mocked.getAllBooksAndCitiesByAuthorName(_data).iterator().next().toString());
        }
    }

    /**
     * Test of getAllBooksAndCitiesByAuthorName method, of class SQLMapping.
     */
    @Test
    public void TestGetAllBooksAndCitiesByAuthorName() {
        System.out.println("getAllBooksAndCitiesByAuthorName: " + _data);
        
        List<DTOAuthorBook> listBooks = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            listBooks.add(new DTOAuthorBook("title" + i, _data));
        }
        
        DBfacade mocked = mock(DBfacade.class);
        when(mocked.getAllBooksAndCitiesByAuthorName(_data)).thenReturn(listBooks);
        
        for(int i = 0; i < 10; i++){
            assertEquals(listBooks.iterator().next().toString(), mocked.getAllBooksAndCitiesByAuthorName(_data).iterator().next().toString());
        }
    }

    /**
     * Test of getAllBooksByGeolocation method, of class SQLMapping.
     */
    @Test
    public void testGetAllBooksByGeolocation() {
        System.out.println("getAllBooksByGeolocation: " + _data);
        
        List<DTOAuthorBook> listBooks = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            listBooks.add(new DTOAuthorBook("title" + i, _data));
        }
        
        DBfacade mocked = mock(DBfacade.class);
        when(mocked.getAllBooksByGeolocation(_data, _data)).thenReturn(listBooks);
        
        for(int i = 0; i < 10; i++){
            assertEquals(listBooks.iterator().next().toString(), mocked.getAllBooksByGeolocation(_data, _data).iterator().next().toString());
        }
    }
    
}
