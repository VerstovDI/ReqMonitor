package ru.mephi.reqsystem.domain.requirements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "t_requirements", schema = "system_control_requirements")
public class Requirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "req_pk", columnDefinition = "serial")
    private Long id;

    @NotBlank(message = "title cannot be empty")
    @Column(name = "req_title")
    private String title;

    @NotBlank(message = "art_type cannot be empty")
    @Column(name = "req_art_type")
    private String artType;

    @NotBlank(message = "description cannot be empty")
    @Column(name = "req_s_desc")
    private String description;

    @NotNull
    @Column(name = "req_lim_t")
    private Time limitTime;


    @NotBlank(message = "loc cannot be empty")
    @Column(name = "req_loc")
    private String loc;

    @NotBlank(message = "origin cannot be empty")
    @Column(name = "req_origin")
    private String origin;

    @NotNull(message = "date cannot be empty")
    @Column(name = "req_date")
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "req_rel_fk")
    private Release release;

    @OneToMany(mappedBy="requirement")
    private Set<RequirementVerification> requirementVerifications;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "req_pr_fk")
    private RequirementPriority requirementPriority;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "req_st_fk")
    private RequirementStatus requirementStatus;

    public Requirement() {
    }

    public Requirement(@NotBlank(message = "title cannot be empty") String title, @NotBlank(message = "art_type cannot be empty") String artType,
                       @NotBlank(message = "description cannot be empty") String description, @NotNull Time limitTime,
                       @NotBlank(message = "loc cannot be empty") String loc, @NotBlank(message = "origin cannot be empty") String origin,
                       @NotNull(message = "date cannot be empty") Date date, Release release,
                       RequirementPriority requirementPriority, RequirementStatus requirementStatus) {
        this.title = title;
        this.artType = artType;
        this.description = description;
        this.limitTime = limitTime;
        this.loc = loc;
        this.origin = origin;
        this.date = date;
        this.release = release;
        this.requirementPriority = requirementPriority;
        this.requirementStatus = requirementStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtType() {
        return artType;
    }

    public void setArtType(String artType) {
        this.artType = artType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Time getLimitTime() {
        return limitTime;
    }

    public void setLimitTime(Time limitTime) {
        this.limitTime = limitTime;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Release getRelease() {
        return release;
    }

    public void setRelease(Release release) {
        this.release = release;
    }

    public Set<RequirementVerification> getRequirementVerification() {
        return requirementVerifications;
    }

    public void setRequirementVerification(Set<RequirementVerification> requirementVerifications) {
        this.requirementVerifications = requirementVerifications;
    }

    public RequirementPriority getRequirementPriority() {
        return requirementPriority;
    }

    public void setRequirementPriority(RequirementPriority requirementPriority) {
        this.requirementPriority = requirementPriority;
    }

    public RequirementStatus getRequirementStatus() {
        return requirementStatus;
    }

    public void setRequirementStatus(RequirementStatus requirementStatus) {
        this.requirementStatus = requirementStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Requirement)) return false;
        Requirement that = (Requirement) o;
        return Objects.equals(id, that.id) && Objects.equals(title, that.title) && Objects.equals(artType, that.artType) && Objects.equals(description, that.description) && Objects.equals(limitTime, that.limitTime) && Objects.equals(loc, that.loc) && Objects.equals(origin, that.origin) && Objects.equals(date, that.date) && Objects.equals(release, that.release) && Objects.equals(requirementVerifications, that.requirementVerifications) && Objects.equals(requirementPriority, that.requirementPriority) && Objects.equals(requirementStatus, that.requirementStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, artType, description, limitTime, loc, origin, date, release, requirementVerifications, requirementPriority, requirementStatus);
    }

    @Override
    public String toString() {
        return "Requirement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", art_type='" + artType + '\'' +
                ", description='" + description + '\'' +
                ", limitTime=" + limitTime +
                ", loc='" + loc + '\'' +
                ", origin='" + origin + '\'' +
                ", date=" + date +
                ", release=" + release +
                ", requirementVerification=" + requirementVerifications +
                ", requirementPriority=" + requirementPriority +
                ", requirementStatus=" + requirementStatus +
                '}';
    }
}
