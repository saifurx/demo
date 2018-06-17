package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Author {

	@Id
	@Column(name = "AUTHOR_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int authorId;
	@Column
	private String authorName;
	@Column
	private String noOfBookPublished;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "BOOK_ID")
	private List<Book> book;

	public Author() {

	}

	public Author(int authorId, String authorName, String noOfBookPublished, List<Book> book) {

		this.authorName = authorName;
		this.noOfBookPublished = noOfBookPublished;
		this.book = book;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getNoOfBookPublished() {
		return noOfBookPublished;
	}

	public void setNoOfBookPublished(String noOfBookPublished) {
		this.noOfBookPublished = noOfBookPublished;
	}

	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", authorName=" + authorName + ", noOfBookPublished="
				+ noOfBookPublished + ", book=" + book + "]";
	}
	

}
