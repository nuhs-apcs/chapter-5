package library.api;

import java.util.List;

public interface LibraryCatalog {
	
	public int addItem(CatalogItem item);
	public void removeItem(int id);
	public boolean hasItemWithId(int id);
	public CatalogItem getItem(int id);
	public int getIdOfItem(CatalogItem item);
	public List<CatalogItem> getItems();
	public int size();

}
