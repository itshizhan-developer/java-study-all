package com.itshizhan.iterator;

public class Main {

	public static void main(String[] args) {
		BookShelf bookShelf = new BookShelf(4);
		bookShelf.appendBook(new Book("Arround the World in 80 days"));
		bookShelf.appendBook(new Book("Bible"));
		bookShelf.appendBook(new Book("Cinderella"));
		bookShelf.appendBook(new Book("Daddy-long-legs"));

		Iterator it = bookShelf.iterator();
		while (it.hasNext()){
			Book book = (Book) it.next();
			System.out.println(book.getName());
		}
	}

}
