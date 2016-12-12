package model;

public class User {
    private int id;
    private String name;
    private int age;
    private String city;

    private User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
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
