package library.api;

import java.util.List;

/**
 * An interface representing a library card.
 */
public interface LibraryCard {
	
	/**
	 * Get the name of the card's owner.
	 * @return the name
	 */
	public String getName();
	
	/**
	 * Get the id of this card.
	 * @return the id
	 */
	public int getId();
	
	/**
	 * Return the items checked out by this card.
	 * @return the items
	 */
	public List<CatalogItem> getCheckedOutItems();
	
}
