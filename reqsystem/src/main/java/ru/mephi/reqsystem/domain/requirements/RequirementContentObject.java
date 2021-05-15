package ru.mephi.reqsystem.domain.requirements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "t_content_object", schema = "system_control_requirements")
public class RequirementContentObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "co_pk", columnDefinition = "serial")
    private Long id;

    @NotBlank(message = "name cannot be empty")
    @Column(name = "co_name")
    private String name;

    @NotBlank(message = "co_ref cannot be empty")
    @Column(name = "co_ref")
    private String ref;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "co_ot_fk")
    private RequirementObjectType requirementObjectType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "co_req_fk")
    private Requirement requirement;

    public RequirementContentObject() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public RequirementObjectType getRequirementObjectType() {
        return requirementObjectType;
    }

    public void setRequirementObjectType(RequirementObjectType requirementObjectType) {
        this.requirementObjectType = requirementObjectType;
    }

    public Requirement getRequirement() {
        return requirement;
    }

    public void setRequirement(Requirement requirement) {
        this.requirement = requirement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequirementContentObject)) return false;
        RequirementContentObject that = (RequirementContentObject) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(ref, that.ref) && Objects.equals(requirementObjectType, that.requirementObjectType) && Objects.equals(requirement, that.requirement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ref, requirementObjectType, requirement);
    }

    @Override
    public String toString() {
        return "RequirementContentObject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ref='" + ref + '\'' +
                ", requirementObjectType=" + requirementObjectType +
                ", requirement=" + requirement +
                '}';
    }
}
