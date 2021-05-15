package ru.mephi.reqsystem.domain.requirements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "t_verification", schema = "system_control_requirements")
public class RequirementVerification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "vrf_pk", columnDefinition = "serial")
    private Long id;

    @NotBlank(message = "Date cannot be empty")
    @Column(name = "vrf_date")
    private Date date;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "vrf_vt_fk")
    private RequirementVerificationType requirementVerificationType;

    public RequirementVerification() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public RequirementVerificationType getRequirementVerificationType() {
        return requirementVerificationType;
    }

    public void setRequirementVerificationType(RequirementVerificationType requirementVerificationType) {
        this.requirementVerificationType = requirementVerificationType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequirementVerification)) return false;
        RequirementVerification that = (RequirementVerification) o;
        return Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(requirementVerificationType, that.requirementVerificationType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, requirementVerificationType);
    }

    @Override
    public String toString() {
        return "RequirementVerification{" +
                "id=" + id +
                ", date=" + date +
                ", requirementVerificationType=" + requirementVerificationType +
                '}';
    }
}
