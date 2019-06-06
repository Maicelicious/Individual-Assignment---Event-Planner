package nl.hva.msi.eventplanner.data.event.model;

import com.google.gson.annotations.SerializedName;

public class Page{

	@SerializedName("number")
	private int number;

	@SerializedName("size")
	private int size;

	@SerializedName("totalPages")
	private int totalPages;

	@SerializedName("totalElements")
	private int totalElements;

	public void setNumber(int number){
		this.number = number;
	}

	public int getNumber(){
		return number;
	}

	public void setSize(int size){
		this.size = size;
	}

	public int getSize(){
		return size;
	}

	public void setTotalPages(int totalPages){
		this.totalPages = totalPages;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public void setTotalElements(int totalElements){
		this.totalElements = totalElements;
	}

	public int getTotalElements(){
		return totalElements;
	}

	@Override
 	public String toString(){
		return 
			"Page{" + 
			"number = '" + number + '\'' + 
			",size = '" + size + '\'' + 
			",totalPages = '" + totalPages + '\'' + 
			",totalElements = '" + totalElements + '\'' + 
			"}";
		}
}