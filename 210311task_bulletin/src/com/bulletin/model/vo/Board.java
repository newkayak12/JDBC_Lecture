package com.bulletin.model.vo;

public class Board {
//	IDX	NUMBER
//	DIV	VARCHAR2(10 BYTE)
//	TITLE	VARCHAR2(50 BYTE)
//	CONTENTS	VARCHAR2(3000 BYTE)
//	WRITER	NUMBER
//	WRITE_DATE	DATE
	private int idx;
	private String div, title, cotents;
	private int writer;
	private String writeDate;
	
	public Board(int idx, String div, String title, String cotents, int writer, String writeDate) {
		this.idx = idx;
		this.div = div;
		this.title = title;
		this.cotents = cotents;
		this.writer = writer;
		this.writeDate = writeDate;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getDiv() {
		return div;
	}

	public void setDiv(String div) {
		this.div = div;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCotents() {
		return cotents;
	}

	public void setCotents(String cotents) {
		this.cotents = cotents;
	}

	public int getWriter() {
		return writer;
	}

	public void setWriter(int writer) {
		this.writer = writer;
	}

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return  idx+" "+div + " " + title + " " + cotents + " " + writer + " "
				+ writeDate;
	}
	
	
	
	
}
