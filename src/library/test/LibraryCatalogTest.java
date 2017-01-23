package library.test;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import library.api.*;

public class LibraryCatalogTest {
	
	private LibraryCatalog catalog;
	private LibraryCard card;
	
	private CatalogItem testItem;
	private int testItemId;
	
	@Before
	public void setupCatalog() {		
		// initialize the catalog and card variables
		// YOUR CODE HERE
		// catalog = new LibraryCatalogImpl();
		
		// add some items to the catalog
		// YOUR CODE HERE
		// catalog.addItem(new Book("Moby-Dick", "Herman Melville"));
		
		assertTrue("did you forget to fill in setupCatalog()?", catalog != null && card != null);
		assertTrue("did you forget to add some items to the catalog?", catalog.size() >= 3);
		
		testItem = catalog.getUniqueItems().get(0);
		testItemId = catalog.getItemId(testItem);
	}
	
	@Test
	public void testItemMembership() {
		assertEquals("getItemById() doesn't work", testItem, catalog.getItemById(testItemId));
		assertTrue("hasItemWithId() doesn't work", catalog.hasItemWithId(testItemId));
	}
	
	@Test
	public void testCatalogSize() {
		List<CatalogItem> items = catalog.getUniqueItems();
		assertEquals("catalog size isn't correct", items.size(), catalog.size());
	}
	
	@Test
	public void testUniqueItems() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		for (CatalogItem item : catalog.getUniqueItems()) {
			classes.add(item.getClass());
		}
		assertTrue("there must be at least three unique CatalogItem classes", classes.size() >= 3);
	}
	
	@Test
	public void testAddCopies() {
		int copiesToAdd = 4;
		int size = catalog.size();
		int startingCopies = testItem.getCopies();
		int totalStartingCopies = testItem.getTotalCopies();
		
		testItem.addCopies(copiesToAdd);
		
		assertEquals("catalog size should remain constant when adding copies", size, catalog.size());
		assertEquals("getCopies() should be updated by addCopies()", startingCopies + copiesToAdd, testItem.getCopies());
		assertEquals("getTotalCopies() should be updated by addCopies()", totalStartingCopies + copiesToAdd, testItem.getTotalCopies());
	}
	
	@Test
	public void testItemCheckInAndOut() {
		assertEquals("library card should have 0 checked out items to begin", 0, card.getCheckedOutItems().size());
		assertFalse("checkIn() should fail when the item wasn't checked out", testItem.checkIn(card));
		assertTrue("checkOut() should work properly", testItem.checkOut(card));
		
		catalog.removeItem(testItemId);
		
		assertTrue("removeItem() shouldn't remove checked out items", testItem.getCopies() != 0);
		assertFalse("checkOut() fails when the item has already been checked out", testItem.checkOut(card));
		assertTrue("getCheckedOutItems() should work", 
				card.getCheckedOutItems().size() == 1
				&& card.getCheckedOutItems().get(0) == testItem);
		assertTrue("checkIn() should work after checking out", testItem.checkIn(card));
		assertEquals("checking in should remove that item from the card", 0, card.getCheckedOutItems().size());
	}

}
