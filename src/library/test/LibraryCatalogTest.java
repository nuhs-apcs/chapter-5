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
	private LibraryCard card;
	
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
	}
	
	@Test
	public void testItemMembershipAndCopies() {
		CatalogItem firstItem = catalog.getUniqueItems().get(0);
		int id = catalog.getItemId(firstItem);
		assertEquals("item id works", firstItem, catalog.getItemById(id));
		assertTrue("hasItemWithId() works", catalog.hasItemWithId(id));
	}
	
	@Test
	public void testCatalogSize() {
		List<CatalogItem> items = catalog.getUniqueItems();
		assertEquals("catalog size is correct", items.size(), catalog.size());
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
	public void testAddAndRemoveItem() {
		int itemsToAdd = 4;
		CatalogItem firstItem = catalog.getUniqueItems().get(0);
		int size = catalog.size();
		int id = catalog.getItemId(firstItem);
		catalog.addItems(firstItem, itemsToAdd);
		int copies = catalog.getCopiesOfItem(id);
		assertTrue("catalog size is updated properly", catalog.size() == size);
		assertEquals("catalog item copies are updated properly", copies + itemsToAdd, catalog.getCopiesOfItem(id));
		catalog.removeItem(id);
		assertEquals("catalog size is updated properly (and remove works)", size, catalog.size());
		assertEquals("catalog item copies are updated properly", copies, catalog.getCopiesOfItem(id));
	}
	
	@Test
	public void testItemCheckInAndOut() {
		CatalogItem firstItem = catalog.getUniqueItems().get(0);
		assertEquals("library card has 0 checked out items to begin", 0, card.getCheckedOutItems().size());
		assertFalse("checkIn() fails properly", firstItem.checkIn(card));
		assertTrue("checkOut() works properly", firstItem.checkOut(card));
		int id = catalog.getItemId(firstItem);
		catalog.removeItems(id, catalog.getCopiesOfItem(id));
		assertEquals("removeItem() doesn't remove checked out items", 1, catalog.getCopiesOfItem(id));
		assertFalse("checkOut() fails properly", firstItem.checkOut(card));
		assertTrue("library card getCheckedOutItems() works", 
				card.getCheckedOutItems().size() == 1
				&& card.getCheckedOutItems().get(0) == firstItem);
		assertTrue("checkIn() works properly", firstItem.checkIn(card));
		assertEquals("checking in removes the item from the card", 0, card.getCheckedOutItems().size());
	}

}
