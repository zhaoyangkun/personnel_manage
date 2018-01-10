package com.personnel.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Attendance implements Serializable {
    private Long id;

    private Long empId;

    private Integer attendanceDay;

    private Integer vocationDay;

    private Integer vocationOvertime;

    private Integer dailyOvertime;

    private Integer leaveDay;

    private Integer monthDay;

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

    public Integer getAttendanceDay() {
        return attendanceDay;
    }

    public void setAttendanceDay(Integer attendanceDay) {
        this.attendanceDay = attendanceDay;
    }

    public Integer getVocationDay() {
        return vocationDay;
    }

    public void setVocationDay(Integer vocationDay) {
        this.vocationDay = vocationDay;
    }

    public Integer getVocationOvertime() {
        return vocationOvertime;
    }

    public void setVocationOvertime(Integer vocationOvertime) {
        this.vocationOvertime = vocationOvertime;
    }

    public Integer getDailyOvertime() {
        return dailyOvertime;
    }

    public void setDailyOvertime(Integer dailyOvertime) {
        this.dailyOvertime = dailyOvertime;
    }

    public Integer getLeaveDay() {
        return leaveDay;
    }

    public void setLeaveDay(Integer leaveDay) {
        this.leaveDay = leaveDay;
    }

    public Integer getMonthDay() {
        return monthDay;
    }

    public void setMonthDay(Integer monthDay) {
        this.monthDay = monthDay;
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
        Attendance other = (Attendance) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getEmpId() == null ? other.getEmpId() == null : this.getEmpId().equals(other.getEmpId()))
            && (this.getAttendanceDay() == null ? other.getAttendanceDay() == null : this.getAttendanceDay().equals(other.getAttendanceDay()))
            && (this.getVocationDay() == null ? other.getVocationDay() == null : this.getVocationDay().equals(other.getVocationDay()))
            && (this.getVocationOvertime() == null ? other.getVocationOvertime() == null : this.getVocationOvertime().equals(other.getVocationOvertime()))
            && (this.getDailyOvertime() == null ? other.getDailyOvertime() == null : this.getDailyOvertime().equals(other.getDailyOvertime()))
            && (this.getLeaveDay() == null ? other.getLeaveDay() == null : this.getLeaveDay().equals(other.getLeaveDay()))
            && (this.getMonthDay() == null ? other.getMonthDay() == null : this.getMonthDay().equals(other.getMonthDay()))
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
        result = prime * result + ((getAttendanceDay() == null) ? 0 : getAttendanceDay().hashCode());
        result = prime * result + ((getVocationDay() == null) ? 0 : getVocationDay().hashCode());
        result = prime * result + ((getVocationOvertime() == null) ? 0 : getVocationOvertime().hashCode());
        result = prime * result + ((getDailyOvertime() == null) ? 0 : getDailyOvertime().hashCode());
        result = prime * result + ((getLeaveDay() == null) ? 0 : getLeaveDay().hashCode());
        result = prime * result + ((getMonthDay() == null) ? 0 : getMonthDay().hashCode());
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
        sb.append(", attendanceDay=").append(attendanceDay);
        sb.append(", vocationDay=").append(vocationDay);
        sb.append(", vocationOvertime=").append(vocationOvertime);
        sb.append(", dailyOvertime=").append(dailyOvertime);
        sb.append(", leaveDay=").append(leaveDay);
        sb.append(", monthDay=").append(monthDay);
        sb.append(", gmtCreated=").append(gmtCreated);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}