public enum AccountType {
    FREE("free"),
    PRO("pro");

    private final String type;


   AccountType(String type) {
        this.type = type;
    }

    public String getType(){
        return type;
    }


}
