package models;

import javax.persistence.*;

@Entity
@Table(name ="person")

public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private int age;
    @Column(name = "city")
    private String city;

    private User() {
    }

    public User( String name, int age, String city) {

        this.name = name;
        this.age = age;
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                "} \n";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCity() {
        return city;
    }

    public static Builder newBuilder(){
        return new User().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setId (int id){
            User.this.id = id;
            return this;
        }

        public Builder setName(String name){
            User.this.name = name;
            return this;
        }

        public Builder setAge(int age){
            User.this.age = age;
            return this;
        }

        public Builder setCity(String city){
            User.this.city = city;
            return this;
        }

        public User build() {
            return User.this;
        }
    }
}
