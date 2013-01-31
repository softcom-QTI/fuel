package pro.softcom.fuel.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
 * Entity Class for a refill.
 *
 * @author  Patrick Retornaz
 */
@Entity
@Table(name = "refill")
public class Refill implements Serializable {

    private static final long serialVersionUID = -4395981416886952220L;

    @Id @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "tankerId")
    @NotNull
    private String tankerId;

    @Column(name = "machineId")
    @NotNull
    private String machineId;

    @Column(name = "liters")
    @NotNull
    private Long liters;

    @Column(name = "refill_date")
    @NotNull
    private Date date;

    public String getTankerId() {
        return tankerId;
    }

    public void setTankerId(String tankerId) {
        this.tankerId = tankerId;
    }

    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    public Long getLiters() {
        return liters;
    }

    public void setLiters(Long liters) {
        this.liters = liters;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = (prime * result) + ((date == null) ? 0 : date.hashCode());
        result = (prime * result) + ((id == null) ? 0 : id.hashCode());
        result = (prime * result) + ((liters == null) ? 0 : liters.hashCode());
        result = (prime * result) + ((machineId == null) ? 0 : machineId.hashCode());
        result = (prime * result) + ((tankerId == null) ? 0 : tankerId.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Refill other = (Refill) obj;

        if (date == null) {

            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;

        if (id == null) {

            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;

        if (liters == null) {

            if (other.liters != null)
                return false;
        } else if (!liters.equals(other.liters))
            return false;

        if (machineId == null) {

            if (other.machineId != null)
                return false;
        } else if (!machineId.equals(other.machineId))
            return false;

        if (tankerId == null) {

            if (other.tankerId != null)
                return false;
        } else if (!tankerId.equals(other.tankerId))
            return false;

        return true;
    }

    @Override
    public String toString() {
        return "Refill [id=" + id + ", tankerId=" + tankerId + ", machineId=" + machineId + ", liters="
            + liters + ", date=" + date + "]";
    }

}
