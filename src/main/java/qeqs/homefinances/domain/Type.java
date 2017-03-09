package qeqs.homefinances.domain;

import java.io.Serializable;
import java.util.List;

public class Type implements Serializable {

    private Integer id;
    private String name;
    private List<Finance> financeList;

    public Type() {
    }

    public Type(Integer id) {
        this.id = id;
    }

    public Type(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

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

    public List<Finance> getFinanceList() {
        return financeList;
    }

    public void setFinanceList(List<Finance> financeList) {
        this.financeList = financeList;
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
        if (!(object instanceof Type)) {
            return false;
        }
        Type other = (Type) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

}
