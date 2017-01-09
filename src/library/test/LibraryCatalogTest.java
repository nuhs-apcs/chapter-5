package library.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import library.api.*;
import library.core.*;

public class LibraryCatalogTest {
	
	private LibraryCatalog catalog;
	private Cardholder cardholder;
	
	@Before
	public void setupCatalog() {		
		// initialize the catalog and cardholder variables
		// catalog = new LibraryCatalogImpl();
		// YOUR CODE HERE
		
		// add some items to the catalog
		// catalog.addItem(new Book("Moby-Dick", "Herman Melville"));
		// YOUR CODE HERE
		
		assertTrue("did you forget to fill in setupCatalog()?", catalog != null && cardholder != null);
		assertTrue("did you forget to add some items to the catalog?", catalog.size() >= 3);
	}
	
	@Test
	public void testItemMembership() {
		CatalogItem firstItem = catalog.getItems().get(0);
		int id = catalog.getIdOfItem(firstItem);
		assertEquals("item id works", firstItem, catalog.getItem(id));
		assertTrue("hasItemWithId() works", catalog.hasItemWithId(id));
	}
	
	@Test
	public void testCatalogSize() {
		List<CatalogItem> items = catalog.getItems();
		assertEquals("catalog size is correct", items.size(), catalog.size());
	}
	
	@Test
	public void testUniqueItems() {
		Set<Class> classes = new HashSet<Class>();
		for (CatalogItem item : catalog.getItems()) {
			classes.add(item.getClass());
			String s = item.toString();
			assertFalse("toString() methods must be defined for CatalogItems", s.contains("@"));
		}
		assertTrue("there must be at least three unique CatalogItem classes", classes.size() >= 3);
	}
	
	@Test
	public void testAddAndRemoveItem() {
		CatalogItem firstItem = catalog.getItems().get(0);
		int sizeBefore = catalog.size();
		int id = catalog.addItem(firstItem);
		assertTrue("catalog size is updated properly", catalog.size() == (sizeBefore + 1));
		catalog.removeItem(id);
		assertTrue("catalog size is updated properly (and remove works)", catalog.size() == sizeBefore);
	}
	
	@Test
	public void testItemCheckInAndOut() {
		CatalogItem firstItem = catalog.getItems().get(0);
		assertTrue("cardholder has 0 checked out items to begin", cardholder.getItems().size() == 0);
		firstItem.checkOut(cardholder);
		assertTrue("cardholder getItems() works", cardholder.getItems().size() == 1 && cardholder.getItems().get(0) == firstItem);
		assertTrue("isCheckedOut() works", firstItem.isCheckedOut());
		assertTrue("getCardHolder() works", firstItem.getCardholder() == cardholder);
		firstItem.checkIn();
		assertTrue("checking in removes the item from the cardholder", cardholder.getItems().size() == 0);
		assertFalse("isCheckedOut() works", firstItem.isCheckedOut());
	}

}
