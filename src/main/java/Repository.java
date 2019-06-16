import java.util.ArrayList;

public class Repository {

    private String name;
    private String description;
    private RepositoryType repositoryType;
    private ArrayList<Commit> commits;

    public Repository(String name, String description,RepositoryType repositoryType){
        this.name = name;
        this.description = description;
        this.repositoryType = repositoryType;
        this.commits = new ArrayList<Commit>();
    }

    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
    }
    public RepositoryType getRepositoryType(){
        return this.repositoryType;
    }

    public int commitsCount(){
        return this.commits.size();
    }
    public Commit commitByIndex(int index){
        return this.commits.get(index);
    }

    public void makeCommit(String uniqueId, CommitType commitType, String description) {
        Commit commit = new Commit(uniqueId, commitType, description);
        this.commits.add(commit);
    }
    public Commit getCommitById(String uniqueId){
        for (Commit commit: this.commits) {
            if (commit.getUniqueId() == uniqueId){
                return commit;
            }
        }
        return null;
    }

    public Commit getCommitByType(CommitType commitType){
        for (Commit commit: this.commits){
            if (commit.getCommitType() == commitType){
                return commit;
            }
        }
        return null;
    }

    public int getCommitIndexByUniqueId(String uniqueId) {
        Commit commit = getCommitById(uniqueId);
        return this.commits.indexOf(commit);
    }

    public void rollBack(String uniqueId) {
        int uniqueIdIndex = getCommitIndexByUniqueId(uniqueId);
        for (int i = uniqueIdIndex; i < this.commits.size() ; i++) {
            this.commits.remove(commitByIndex(i));

        }

    }



}
