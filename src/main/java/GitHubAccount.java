import java.util.ArrayList;
import java.util.HashMap;

public class GitHubAccount {

    private String username;
    private String name;
    private AccountType accountType;
    private HashMap<String, Repository> repositries;
    private Repository repository;

    public GitHubAccount(String username, String name, AccountType accountType){
        this.username = username;
        this.name = name;
        this.accountType = accountType;
        this.repositries = new HashMap<String, Repository>();
    }

    public String getUsername(){
        return this.username;
    }
    public String getName(){
        return this.name;
    }

    public AccountType getAccountType(){
        return this.accountType;
    }

    public void createRepository(String name, String description,RepositoryType repositoryType) {
        repository = new Repository(name, description, repositoryType);
        this.repositries.put(name, repository);

    }

    public Boolean repositoryContainsKey(String name){
        return  this.repositries.containsKey(name);
    }

    public Repository getRepositoryByName(String name){
        return this.repositries.get(name);

    }

    public void upgradeMembership() {
        this.accountType = AccountType.PRO;
    }

    public void downgradeMembership() {
        this.accountType = AccountType.FREE;
    }

    public void makeCommitToRepository(String repositoryName, String uniqueId, CommitType commitType, String description){
        Repository repository = this.getRepositoryByName(repositoryName);
        if (repository != null) {
            repository.makeCommit(uniqueId, commitType, description);
        }

    }

    public int countRepositoryCommits(String repositoryName) {
        Repository repository = this.getRepositoryByName(repositoryName);
        return repository.commitsCount();
    }

    public int getRepositoryWithMostCommitsSize() {

         Repository repository = this.getRepositoryWithMostComits();
         return repository.commitsCount();
    }

    public Repository getRepositoryWithMostComits(){
        Repository repositoryMostCommits = null;
        for(Repository repository: this.repositries.values()){
            if(repositoryMostCommits == null){
                repositoryMostCommits = repository;
            }
            else if(repository.commitsCount() > repositoryMostCommits.commitsCount()){
                repositoryMostCommits = repository;
            }
        } return repositoryMostCommits;
    }

    public void rollBack(String uniqueId) {
       repository.rollBack(uniqueId);
    }
}
