package MockTesting;

import DTO.DTOAuthorBook;
import DTO.DTOLocation;
import DataAccess.MongoMapping;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@RunWith(Parameterized.class)
public class MongoMappingMockTest {

    public MongoMappingMockTest(String _data) {
        this._data = _data;
    }

    private String _data;
    //private String _location;

    @Parameters
    public static Collection<String> data() {
        return Arrays.asList(new String[]{"test1", "test2", "test3", "test4", "test5"});
    }


    @Test
    public void testGetBooksByCity() {

        
        System.out.println("getBooksByCity with city: " + _data);
        List<DTOAuthorBook> listBooks = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            listBooks.add(new DTOAuthorBook("title" + i, _data));
        }
        
        MongoMapping mocked = mock(MongoMapping.class);
        when(mocked.getBooksByCity(_data)).thenReturn(listBooks);
        
        for(int i = 0; i < 10; i++){
            assertEquals(listBooks.iterator().next().toString(), mocked.getBooksByCity(_data).iterator().next().toString());
        }

    }

    /**
     * Test of getBooksByAuthor method, of class MongoMapping.
     */
    @Test
    public void testGetBooksByAuthor() {

        System.out.println("getBooksByAuthor with author: " + _data);

        List<DTOAuthorBook> listBooks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listBooks.add(new DTOAuthorBook("title" + i, _data));
        }

        MongoMapping mocked = mock(MongoMapping.class);
        when(mocked.getBooksByAuthor(_data)).thenReturn(listBooks);

        for (int i = 0; i < 10; i++) {
            assertEquals(listBooks.iterator().next().toString(), mocked.getBooksByAuthor(_data).iterator().next().toString());
        }
    }
    
    @Test
    public void testGetLocationByTitle() {

        System.out.println("getLocationBytitle with title: " + _data);

        List<DTOLocation> listBooks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listBooks.add(new DTOLocation("title" + i, _data));
        }

        MongoMapping mocked = mock(MongoMapping.class);
        when(mocked.getLocationByTitle(_data)).thenReturn(listBooks);

        for (int i = 0; i < 10; i++) {
            assertEquals(listBooks.iterator().next().toString(), mocked.getLocationByTitle(_data).iterator().next().toString());
        }
    }
    

}
