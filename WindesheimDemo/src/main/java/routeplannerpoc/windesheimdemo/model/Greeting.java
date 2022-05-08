package routeplannerpoc.windesheimdemo.model;


public class Greeting {

  private long id;
  private String content;
  private String cityname;

  public Greeting(){
    super();
  }
  
  public Greeting(long id, String content, String cityname){
    this.id = id;
    this.content = content;
    this.cityname = cityname;
  }
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

public String getCityname() {
    return cityname;
}

public void setCityname(String name) {
  this.cityname = name;
}

@Override
public String toString() {
    return  "{id=" + String.valueOf(this.id) + 
    ", content=" + this.content + 
    ", cityname=" + this.cityname + "}";
}

}