package 주앤;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import 주앤.mycollection.MyArrayList;

public class MyArrayListTest {

    protected List<Integer> mylist;
    protected List<Integer> list;

    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    public void setUp() throws Exception {
        list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);

        mylist = new MyArrayList<Integer>();
        mylist.add(1);
        mylist.add(2);
        mylist.add(3);
    }

    /**
     * Test method for {@link MyArrayList#MyArrayList()}.
     */
    @Test
    public void testMyList() {
        assertThat(mylist.size()).isEqualTo(3);
    }

    /**
   	 * Test method for {@link MyArrayList#indexOf(Object)}.
   	 */
   	@Test
   	public void testIndexOf() {
   		assertThat(mylist.indexOf(1)).isEqualTo(0);
   		assertThat(mylist.indexOf(2)).isEqualTo(1);
   		assertThat(mylist.indexOf(3)).isEqualTo(2);
   		assertThat(mylist.indexOf(4)).isEqualTo(-1);
   	}

    /**
   	 * Test method for {@link MyArrayList#indexOf(Object)}.
   	 */
   	@Test
   	public void testIndexOfNull() {
   		assertThat(mylist.indexOf(null)).isEqualTo(-1);
   		mylist.add(null);
   		assertThat(mylist.indexOf(null)).isEqualTo(3);
   	}

	/**
	 * Test method for {@link MyArrayList#remove(Object)}.
	 */
	@Test
	public void testRemoveObject() {
	    boolean flag = mylist.remove(new Integer(2));
	    assertTrue(flag);
	    assertEquals(2, mylist.size());
	    assertEquals(new Integer(3), mylist.get(1));

	    flag = mylist.remove(new Integer(1));
	    assertTrue(flag);
	    assertEquals(1, mylist.size());
	    assertEquals(new Integer(3), mylist.get(0));

	    flag = mylist.remove(new Integer(5));
	    assertFalse(flag);
	    assertEquals(1, mylist.size());
	    assertEquals(new Integer(3), mylist.get(0));

	    flag = mylist.remove(new Integer(3));
	    assertTrue(flag);
	    assertEquals(0, mylist.size());
	}

	/**
	 * Test method for {@link MyArrayList#remove(int)}.
	 */
	@Test
	public void testRemoveInt() {
	    Integer val = mylist.remove(1);
	    assertEquals(2, val);
	    assertEquals(2, mylist.size());
	    assertEquals(3, mylist.get(1));
	}
}
