package qeqs.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "Finance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Finance.findAll", query = "SELECT f FROM Finance f")
    , @NamedQuery(name = "Finance.findById", query = "SELECT f FROM Finance f WHERE f.id = :id")
    , @NamedQuery(name = "Finance.findByValue", query = "SELECT f FROM Finance f WHERE f.value = :value")
    , @NamedQuery(name = "Finance.findByDate", query = "SELECT f FROM Finance f WHERE f.date = :date")
    , @NamedQuery(name = "Finance.findByDescription", query = "SELECT f FROM Finance f WHERE f.description = :description")})
public class Finance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "value")
    private float value;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Size(max = 2147483647)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "type", referencedColumnName = "id")
    @ManyToOne(optional = false)
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
        return financeType;
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
