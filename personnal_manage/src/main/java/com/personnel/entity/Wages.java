package com.personnel.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Wages implements Serializable {
    private Long id;

    private Long empId;

    private String name;

    private Integer depId;
    
    private Integer reward;

	private Integer basepay;

    private Integer jbbt;

    private Integer gjj;

    private Integer ylj;

    private Integer sds;

    private Integer yfgz;

    private Integer sjgz;

    private Date gmtCreated;

    private Date gmtModified;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public Integer getReward() {
		return reward;
	}

	public void setReward(Integer reward) {
		this.reward = reward;
	}
	
    public Integer getBasepay() {
        return basepay;
    }

    public void setBasepay(Integer basepay) {
        this.basepay = basepay;
    }

    public Integer getJbbt() {
        return jbbt;
    }

    public void setJbbt(Integer jbbt) {
        this.jbbt = jbbt;
    }

    public Integer getGjj() {
        return gjj;
    }

    public void setGjj(Integer gjj) {
        this.gjj = gjj;
    }

    public Integer getYlj() {
        return ylj;
    }

    public void setYlj(Integer ylj) {
        this.ylj = ylj;
    }

    public Integer getSds() {
        return sds;
    }

    public void setSds(Integer sds) {
        this.sds = sds;
    }

    public Integer getYfgz() {
        return yfgz;
    }

    public void setYfgz(Integer yfgz) {
        this.yfgz = yfgz;
    }

    public Integer getSjgz() {
        return sjgz;
    }

    public void setSjgz(Integer sjgz) {
        this.sjgz = sjgz;
    }

    public Date getGmtCreated() {
        return gmtCreated;
    }

    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Wages other = (Wages) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEmpId() == null ? other.getEmpId() == null : this.getEmpId().equals(other.getEmpId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getDepId() == null ? other.getDepId() == null : this.getDepId().equals(other.getDepId()))
            && (this.getReward() == null ? other.getReward() == null : this.getReward().equals(other.getReward()))
            && (this.getBasepay() == null ? other.getBasepay() == null : this.getBasepay().equals(other.getBasepay()))
            && (this.getJbbt() == null ? other.getJbbt() == null : this.getJbbt().equals(other.getJbbt()))
            && (this.getGjj() == null ? other.getGjj() == null : this.getGjj().equals(other.getGjj()))
            && (this.getYlj() == null ? other.getYlj() == null : this.getYlj().equals(other.getYlj()))
            && (this.getSds() == null ? other.getSds() == null : this.getSds().equals(other.getSds()))
            && (this.getYfgz() == null ? other.getYfgz() == null : this.getYfgz().equals(other.getYfgz()))
            && (this.getSjgz() == null ? other.getSjgz() == null : this.getSjgz().equals(other.getSjgz()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEmpId() == null) ? 0 : getEmpId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getDepId() == null) ? 0 : getDepId().hashCode());
        result = prime * result + ((getReward() == null) ? 0 : getReward().hashCode());
        result = prime * result + ((getBasepay() == null) ? 0 : getBasepay().hashCode());
        result = prime * result + ((getJbbt() == null) ? 0 : getJbbt().hashCode());
        result = prime * result + ((getGjj() == null) ? 0 : getGjj().hashCode());
        result = prime * result + ((getYlj() == null) ? 0 : getYlj().hashCode());
        result = prime * result + ((getSds() == null) ? 0 : getSds().hashCode());
        result = prime * result + ((getYfgz() == null) ? 0 : getYfgz().hashCode());
        result = prime * result + ((getSjgz() == null) ? 0 : getSjgz().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", empId=").append(empId);
        sb.append(", name=").append(name);
        sb.append(", depId=").append(depId);
        sb.append(", reward=").append(reward);
        sb.append(", basepay=").append(basepay);
        sb.append(", jbbt=").append(jbbt);
        sb.append(", gjj=").append(gjj);
        sb.append(", ylj=").append(ylj);
        sb.append(", sds=").append(sds);
        sb.append(", yfgz=").append(yfgz);
        sb.append(", sjgz=").append(sjgz);
        sb.append(", gmtCreated=").append(gmtCreated);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}