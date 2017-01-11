package library.api;

/**
 * An interface representing an item in a library catalog.
 */
public interface CatalogItem {
	
	/**
	 * Attempt to check out a copy of this item to card. Fails if 
	 * the card already has a copy of this item or there are no
	 * copies left.
	 * @param card
	 * @return true if successful
	 */
	public boolean checkOut(LibraryCard card);
	
	/**
	 * Check in a copy of an item checked out to card. Fails if 
	 * the card doesn't have a copy of this item.
	 * @param card
	 * @return true if successful
	 */
	public boolean checkIn(LibraryCard card);

}
