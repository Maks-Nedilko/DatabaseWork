package ua.itea.entity;

import java.sql.Date;
import java.util.Objects;


public class Employrr {
    
    private long id;
    private String first_name;
    private String last_name;
    private Date birthday;
    private long address;
    
    public Employrr(){
        
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public long getAddress() {
        return address;
    }

    public void setAddress(long address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Employrr{" + "id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", birthday=" + birthday + ", address=" + address + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 89 * hash + Objects.hashCode(this.first_name);
        hash = 89 * hash + Objects.hashCode(this.last_name);
        hash = 89 * hash + Objects.hashCode(this.birthday);
        hash = 89 * hash + (int) (this.address ^ (this.address >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Employrr other = (Employrr) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.address != other.address) {
            return false;
        }
        if (!Objects.equals(this.first_name, other.first_name)) {
            return false;
        }
        if (!Objects.equals(this.last_name, other.last_name)) {
            return false;
        }
        if (!Objects.equals(this.birthday, other.birthday)) {
            return false;
        }
        return true;
    }
    
    
}
