package library.api;

import java.util.List;

public interface Cardholder {
	
	public String getName();
	public int getCardId();
	public List<CatalogItem> getItems();
	
}
