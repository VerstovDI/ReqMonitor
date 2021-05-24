package ru.mephi.reqsystem.domain.requirements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "t_requirement_links", schema = "system_control_requirements")
public class RequirementLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rl_pk", columnDefinition = "serial")
    private Long id;

    @NotBlank(message = "description cannot be empty")
    @Column(name = "rl_desc")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rl_lt_fk")
    private RequirementLinkType requirementLinkType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rl_req_root_fk",insertable = false, updatable = false)
    private Requirement rootRequirement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rl_req_child_fk",insertable = false, updatable = false)
    private Requirement childRequirement;

    public RequirementLink() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RequirementLinkType getRequirementLinkType() {
        return requirementLinkType;
    }

    public void setRequirementLinkType(RequirementLinkType requirementLinkType) {
        this.requirementLinkType = requirementLinkType;
    }

    public Requirement getRootRequirement() {
        return rootRequirement;
    }

    public void setRootRequirement(Requirement rootRequirement) {
        this.rootRequirement = rootRequirement;
    }

    public Requirement getChildRequirement() {
        return childRequirement;
    }

    public void setChildRequirement(Requirement childRequirement) {
        this.childRequirement = childRequirement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequirementLink)) return false;
        RequirementLink that = (RequirementLink) o;
        return Objects.equals(id, that.id) && Objects.equals(description, that.description) && Objects.equals(requirementLinkType, that.requirementLinkType) && Objects.equals(rootRequirement, that.rootRequirement) && Objects.equals(childRequirement, that.childRequirement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, requirementLinkType, rootRequirement, childRequirement);
    }

    @Override
    public String toString() {
        return "RequirementLink{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", requirementLinkType=" + requirementLinkType +
                ", rootRequirement=" + rootRequirement +
                ", childRequirement=" + childRequirement +
                '}';
    }
}
