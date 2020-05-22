class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        if(firstName != null){
            this.firstName = firstName;
        }else{
            this.firstName = "";
        }
    }

    public void setLastName(String lastName) {
        if(lastName != null){
            this.lastName = lastName;
        }else{
            this.lastName = "";
        }
    }

    public String getFullName() {

        if(firstName.trim().equals("") && lastName.trim().equals("")){
            return "Unknown";
        }else if(firstName.trim().equals("")){
            return lastName;
        }else if(lastName.trim().equals("")){
            return firstName;
        }

        return firstName+" "+lastName; // write your code here
    }
}