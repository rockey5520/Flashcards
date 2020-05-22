class Employee {

    public String name;
    public String email;
    public int experience;

  public Employee(String name, String email, int experience) {
    this.name = name;
    this.email = email;
    this.experience = experience;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public int getExperience() {
    return experience;
  }
}

class Developer extends Employee {

    public String mainLanguage;
    public String[] skills;

  public Developer(String name, String email, int experience, String mainLanguage,
      String[] skills) {
    super(name, email, experience);
    this.mainLanguage = mainLanguage;
    this.skills = skills;
  }

  public String getMainLanguage() {
    return mainLanguage;
  }

  public String[] getSkills() {
    return skills;
  }

}

class DataAnalyst extends Employee {

   public boolean phd;
   public String[] methods;

  public DataAnalyst(String name, String email, int experience, boolean phd,
      String[] methods) {
    super(name, email, experience);
    this.phd = phd;
    this.methods = methods;
  }

  public boolean isPhd() {
    return phd;
  }

  public String[] getMethods() {
    return methods;
  }
}

