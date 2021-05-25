package ru.mephi.reqsystem.domain.requirements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "t_projects", schema = "system_control_requirements")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="prj_pk", columnDefinition = "serial")
    private Long id;

    @NotBlank(message = "name cannot be empty")
    @Column(name="prj_name")
    private String name;

    @NotNull(message = "date cannot be empty")
    @Column(name="prj_date")
    private Date data;

    @NotBlank(message = "founder name cannot be empty")
    @Column(name="prj_founder")
    private String  founder;

    public Project() {
    }

    public Project(@NotBlank(message = "name cannot be empty") String name
            , @NotNull(message = "date cannot be empty") Date data,
                   @NotBlank(message = "founder name cannot be empty") String founder) {
        this.name = name;
        this.data = data;
        this.founder = founder;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Project)) return false;
        Project project = (Project) o;
        return Objects.equals(id, project.id) && Objects.equals(name, project.name) && Objects.equals(data, project.data) && Objects.equals(founder, project.founder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, data, founder);
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", data=" + data +
                ", founder='" + founder + '\'' +
                '}';
    }
}
