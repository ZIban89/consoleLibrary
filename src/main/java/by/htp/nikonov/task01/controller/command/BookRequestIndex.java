package by.htp.nikonov.task01.controller.command;

public enum BookRequestIndex {
TITLE_INDEX(1),
AUTOR_INDEX(2),
GENRE_INDEX(3),
YEAR_INDEX(4),
QUANTITY_INDEX(5),
ID_BOOK_INDEX(6);
	
	private int id;
	BookRequestIndex(int id){
		this.id=id;
	};
public  int getIndex() {return id;}
}
