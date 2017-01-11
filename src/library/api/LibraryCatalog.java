package library.api;

import java.util.List;

/**
 * An interface representing a virtual library catalog.
 */
public interface LibraryCatalog {
	
	/**
	 * Add a copy of an item to the catalog. If a copy of this 
	 * item already exists, add another copy and return the same id.
	 * @param item
	 * @return the id of this item
	 */
	public int addItem(CatalogItem item);
	
	/**
	 * 
	 * Add multiple copies of an item to the catalog.
	 * @param item
	 * @param copies
	 * @see #addItem(CatalogItem)
	 */
	public int addItems(CatalogItem item, int copies);
	
	/**
	 * Remove an item from the catalog if possible. Items that are currently
	 * checked out may not be removed.
	 * @param id
	 */
	public void removeItem(int id);
	
	/**
	 * Removes multiple copies (as many as possible) of an item from the catalog.
	 * @param id
	 * @param copies
	 * @see #removeItem(int)
	 */
	public void removeItems(int id, int copies);
	
	/**
	 * Test whether an item with the provided id exists in 
	 * the catalog.
	 * @param id
	 * @return true if the item is in the catalog
	 */
	public boolean hasItemWithId(int id);
	
	/**
	 * Get and return an item with a specific id.
	 * @param id
	 * @return the item
	 */
	public CatalogItem getItemById(int id);
	
	/**
	 * Get the id of an item.
	 * @param item
	 * @return the item's id
	 */
	public int getItemId(CatalogItem item);
	
	/**
	 * Get the number of copies of a particular item.
	 * @param id
	 * @return the number of copies
	 */
	public int getCopiesOfItem(int id);
	
	/**
	 * Return a list of all the unique items in the catalog.
	 * @return the items
	 */
	public List<CatalogItem> getUniqueItems();
	
	/**
	 * Return the number of unique items in the catalog.
	 * @return the number of unique items
	 */
	public int size();

}
