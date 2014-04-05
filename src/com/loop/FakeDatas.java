package com.loop;


public class FakeDatas {
	private String title[] = {"Iphone 5s","Mac book air","Mac PRO","Iphone 5s","Mac book air","Mac PRO","Iphone 5s","Mac book air","Mac PRO","Iphone 5s","Mac book air","Mac PRO"};
	private String subTitle[] = {"$21900","$34900","$128000","$21900","$34900","$128000","$21900","$34900","$128000","$21900","$34900","$128000","$21900","$34900","$128000"};
	
	public String[] getTitle() {
		return title;
	}
	
	public String[] getSubTitle() {
		return subTitle;
	}
	
	public int getDataCount(){
		return title.length < subTitle.length ? title.length : subTitle.length;
	}
}
