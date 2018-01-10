package com.personnel.entity;

import java.io.Serializable;

/**
 * @author zhaoyangkun
 */
public class Transfer implements Serializable {
    private Long id;

    private Long empId;

    private String name;

    private Long beforeDepId;

    private Long laterDepId;

    private Long beforeJobId;

    private Long laterJobId;

    private String reason;

    private String result;

    private String auditor;

    private Long audJobId;

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

    public Long getBeforeDepId() {
        return beforeDepId;
    }

    public void setBeforeDepId(Long beforeDepId) {
        this.beforeDepId = beforeDepId;
    }

    public Long getLaterDepId() {
        return laterDepId;
    }

    public void setLaterDepId(Long laterDepId) {
        this.laterDepId = laterDepId;
    }

    public Long getBeforeJobId() {
        return beforeJobId;
    }

    public void setBeforeJobId(Long beforeJobId) {
        this.beforeJobId = beforeJobId;
    }

    public Long getLaterJobId() {
        return laterJobId;
    }

    public void setLaterJobId(Long laterJobId) {
        this.laterJobId = laterJobId;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public Long getAudJobId() {
        return audJobId;
    }

    public void setAudJobId(Long audJobId) {
        this.audJobId = audJobId;
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
        Transfer other = (Transfer) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEmpId() == null ? other.getEmpId() == null : this.getEmpId().equals(other.getEmpId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getBeforeDepId() == null ? other.getBeforeDepId() == null : this.getBeforeDepId().equals(other.getBeforeDepId()))
            && (this.getLaterDepId() == null ? other.getLaterDepId() == null : this.getLaterDepId().equals(other.getLaterDepId()))
            && (this.getBeforeJobId() == null ? other.getBeforeJobId() == null : this.getBeforeJobId().equals(other.getBeforeJobId()))
            && (this.getLaterJobId() == null ? other.getLaterJobId() == null : this.getLaterJobId().equals(other.getLaterJobId()))
            && (this.getReason() == null ? other.getReason() == null : this.getReason().equals(other.getReason()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()))
            && (this.getAuditor() == null ? other.getAuditor() == null : this.getAuditor().equals(other.getAuditor()))
            && (this.getAudJobId() == null ? other.getAudJobId() == null : this.getAudJobId().equals(other.getAudJobId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getEmpId() == null) ? 0 : getEmpId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getBeforeDepId() == null) ? 0 : getBeforeDepId().hashCode());
        result = prime * result + ((getLaterDepId() == null) ? 0 : getLaterDepId().hashCode());
        result = prime * result + ((getBeforeJobId() == null) ? 0 : getBeforeJobId().hashCode());
        result = prime * result + ((getLaterJobId() == null) ? 0 : getLaterJobId().hashCode());
        result = prime * result + ((getReason() == null) ? 0 : getReason().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        result = prime * result + ((getAuditor() == null) ? 0 : getAuditor().hashCode());
        result = prime * result + ((getAudJobId() == null) ? 0 : getAudJobId().hashCode());
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
        sb.append(", beforeDepId=").append(beforeDepId);
        sb.append(", laterDepId=").append(laterDepId);
        sb.append(", beforeJobId=").append(beforeJobId);
        sb.append(", laterJobId=").append(laterJobId);
        sb.append(", reason=").append(reason);
        sb.append(", result=").append(result);
        sb.append(", auditor=").append(auditor);
        sb.append(", audJobId=").append(audJobId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}