package com.Springboot.SAT_Application;

public class SATResult {
	private String id;
	private String name;
    private Address address;
    private int satScore;
    private String passed;
    
	
	public SATResult(String id,String name, Address address, int satScore, String passed) {
		super();
		this.id=id;
		this.name = name;
		this.address = address;
		this.satScore = satScore;
		this.passed = passed;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getSatScore() {
		return satScore;
	}
	public void setSatScore(int satScore) {
		this.satScore = satScore;
	}
	
	 public String getPassed() {
	        return passed;
	    }

	    public void setPassed(int satScore) {
	        if (satScore > 30) {
	            this.passed = "Pass";
	        } else {
	            this.passed = "Fail";
	        }
	    }

	@Override
	public String toString() {
		return "User [name=" + name + ", satScore=" + satScore + ", passed=" + passed + "]";
	}
    
    


}
