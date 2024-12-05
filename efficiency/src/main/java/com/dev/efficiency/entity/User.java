package com.dev.efficiency.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pId;
    private String name;
    private String projectCode;
    
    @OneToMany(targetEntity = Dsr.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "name",referencedColumnName = "name")
    private List<Dsr> dsrs; 

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

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public List<Dsr> getDsrs() {
		return dsrs;
	}

	public void setDsrs(List<Dsr> dsrs) {
		this.dsrs = dsrs;
	}

	public User(Long id, String pId, String name, String projectCode, List<Dsr> dsrs) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.projectCode = projectCode;
		this.dsrs = dsrs;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pId=" + pId + ", name=" + name + ", projectCode=" + projectCode + ", dsrs=" + dsrs
				+ "]";
	}

  
}

