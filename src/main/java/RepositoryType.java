public enum RepositoryType {
    PRIVATE("Private"),
    PUBLIC("Public");

    private final String type;


    RepositoryType(String type) {
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
