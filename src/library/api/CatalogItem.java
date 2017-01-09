package library.api;

public interface CatalogItem {
	
	public void checkOut(Cardholder holder);
	public void checkIn();
	public boolean isCheckedOut();
	public Cardholder getCardholder();

}
