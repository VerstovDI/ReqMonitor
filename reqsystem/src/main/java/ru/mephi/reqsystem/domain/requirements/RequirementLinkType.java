package ru.mephi.reqsystem.domain.requirements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "tcl_link_type", schema = "system_control_requirements")
public class RequirementLinkType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lt_pk", columnDefinition = "serial")
    private Long id;

    @NotBlank(message = "name cannot be empty")
    @Column(name = "co_name")
    private String name;

    public RequirementLinkType() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RequirementLinkType)) return false;
        RequirementLinkType that = (RequirementLinkType) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "RequirementLinkType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
