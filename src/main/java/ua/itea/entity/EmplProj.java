/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.itea.entity;

/**
 *
 * @author makst
 */
public class EmplProj {
    private long emplId;
    private long projId;
    
    public EmplProj(){
        
    }

    public long getEmplId() {
        return emplId;
    }

    public void setEmplId(long emplId) {
        this.emplId = emplId;
    }

    public long getProjId() {
        return projId;
    }

    public void setProjId(long projId) {
        this.projId = projId;
    }

    @Override
    public String toString() {
        return "EmplProj{" + "emplId=" + emplId + ", projId=" + projId + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + (int) (this.emplId ^ (this.emplId >>> 32));
        hash = 71 * hash + (int) (this.projId ^ (this.projId >>> 32));
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
        final EmplProj other = (EmplProj) obj;
        if (this.emplId != other.emplId) {
            return false;
        }
        if (this.projId != other.projId) {
            return false;
        }
        return true;
    }
    
}
