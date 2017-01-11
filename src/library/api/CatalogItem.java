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
	
	/**
	 * Return the number of currently checked-in copies.
	 * @return the number of copies
	 */
	public int getCopies();
	
	/**
	 * Return the total number of copies.
	 * @return the number of copies
	 */
	public int getTotalCopies();
	
	/**
	 * Add a copy.
	 */
	public void addCopy();
	
	/**
	 * Add multiple copies.
	 * @param copies
	 */
	public void addCopies(int copies);
	
	/**
	 * Remove a copy.
	 */
	public void removeCopy();
	
	/**
	 * Remove multiple copies.
	 * @param copies
	 */
	public void removeCopies(int copies);

}
