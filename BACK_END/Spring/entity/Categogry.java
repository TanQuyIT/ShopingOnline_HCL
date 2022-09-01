package Spring.entity;

public class Categogry {
    Integer id;
    String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Categogry(){
    }

    public Categogry(Integer id, String name){
        this.id = id;
        this.name = name;
    }

}
