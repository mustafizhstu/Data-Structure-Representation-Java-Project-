package searching;
public class Person implements Comparable<Person> {
    protected String name;
 
    public Person() {
    }
 
    public Person(String name) {
        setName(name);
    }
 
    public String getName() {
        return this.name;
    }
 
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
 
        this.name = name;
    }
 
    @Override
    public String toString() {
        return this.name;
    }
 
    @Override
    public int compareTo(Person another) {
        return this.name.compareTo(another.getName());
    }
 
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj instanceof Person) {
            Person another = (Person) obj;
            if (this.name.equals(another.getName())) {
                return true;
            }
        }
 
        return false;
    }
 
    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
