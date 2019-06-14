public class Commit {

    private String uniqueId;
    private CommitType commitType;
    private String description;

    public Commit(String uniqueId, CommitType commitType, String description){
        this.uniqueId = uniqueId;
        this.commitType = commitType;
        this.description = description;
    }

    public String getUniqueId(){
        return this.uniqueId;
    }

    public CommitType getCommitType(){
        return this.commitType;
    }
    public String getDescription(){
        return this.description;
    }
}
