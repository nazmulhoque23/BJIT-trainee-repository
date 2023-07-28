package org.example;

public class Movie {
    public String length = "";
    public String name = "";
    public String category = "";

    public void setLength(String length){
        this.length = length;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setCategory(String category){
        this.category = category;
    }
    public String toString(){
        return "this movie name is "+name+" which runs for "+length+" , is in "+category+" category";
    }
}
