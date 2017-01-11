# Chapter 5 Labs

## Getting Started

Follow [these instructions](https://github.com/nuhs-apcs/chapter-4) from the Chapter 4 Labs to get started.

## Library Catalog

The goal of this exercise is to implement a simple library catalog system. My intent with this exercise is to give you experience building one large system as opposed to many little ones like the previous labs. Additionally, you will practically start from scratch.

The lab is largely contained in one package, `library.api`. It contains three interfaces which describe the behaviors of the library system. Your goal is to write some classes that implement the functionality of these interfaces in the proper way (so that the tests pass). 

The system is fairly simple (at least compared to actual library catalogs). Each of the methods should be pretty self-explanatory. The `LibraryCatalog` and `Cardholder` interfaces only really require one implementing class a piece (if you have trouble naming them, I suggest `LibraryCatalogImpl` or maybe `SimpleLibraryCatalog`). However, the `CatalogItem` interface must have at least three different classes which represent actual items found in a library (e.g. `Book`, `Magazine`, `CD`, `DVD`, etc.) along with methods that make sense.

When you're finished with the subclasses, you'll need to fill in some lines in `LibraryCatalogTest.java`. In the `setupCatalog()` method, there are spots to initialize `catalog` and `cardholder`  (think `catalog = new LibraryCatalogImpl()`) and add some items to the catalog (e.g. `catalog.addItem(new Book("Moby-Dick", "Herman Melville"))`) keeping in mind the three unique `CatalogItem` class requirement. After that, you can run the tests like usual.
