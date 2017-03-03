package qeqs.homefinances.domain;

import java.io.Serializable;
import java.util.Date;

public class Finance implements Serializable {

    private Integer id;
    private float value;
    private Date date;
    private String description;
    private Type financeType;

    public Finance() {
    }

    public Finance(Integer id) {
        this.id = id;
    }

    public Finance(Integer id, float value, Date date) {
        this.id = id;
        this.value = value;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getFinanceType() {
        if (financeType == null) {
            Type type = new Type();
            type.setName("no type");
            return type;
        } else {
            return financeType;
        }
    }

    public void setFinanceType(Type financeType) {
        this.financeType = financeType;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Finance)) {
            return false;
        }
        Finance other = (Finance) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "qeqs.entities.Finance[ id=" + id + " ]";
    }

}
