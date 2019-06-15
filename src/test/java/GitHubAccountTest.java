import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GitHubAccountTest {

    GitHubAccount gitHubAccount;

    @Before
    public void before(){
        gitHubAccount = new GitHubAccount("rbharries", "Rhys Harries", AccountType.FREE);
        gitHubAccount.createRepository("Pokemon Api", "list of Pokemon", RepositoryType.PUBLIC);

    }

    @Test
    public void canGetUsername(){
        assertEquals("rbharries", gitHubAccount.getUsername());
    }

    @Test
    public void canGetName(){
        assertEquals("Rhys Harries", gitHubAccount.getName());
    }

    @Test
    public void canGetType(){
        assertEquals(AccountType.FREE, gitHubAccount.getAccountType());
    }

    @Test
    public void canCreateRepository(){
        gitHubAccount.createRepository("Restful Petshop", "ruby project", RepositoryType.PUBLIC);
        assertEquals(true, gitHubAccount.repositoryContainsKey("Restful Petshop"));
    }

    @Test
    public void canUpgradeMembership(){
        gitHubAccount.upgradeMembership();
        assertEquals(AccountType.PRO, gitHubAccount.getAccountType());
    }

    @Test
    public void canDowngradeMembership(){
        gitHubAccount.upgradeMembership();
        gitHubAccount.downgradeMembership();
        assertEquals(AccountType.FREE, gitHubAccount.getAccountType());
    }

    @Test
    public void canMakeCommitToRepository(){
        gitHubAccount.makeCommitToRepository("Pokemon Api", "F1", CommitType.FEATURE, "Test");
        assertEquals(1, gitHubAccount.countRepositoryCommits("Pokemon Api"));
    }

    @Test
    public void canMakeCommitToRepositoryTimesFive(){
        gitHubAccount.makeCommitToRepository("Pokemon Api", "F1", CommitType.FEATURE, "Test");
        gitHubAccount.makeCommitToRepository("Pokemon Api", "F2", CommitType.FEATURE, "Testing");
        gitHubAccount.makeCommitToRepository("Pokemon Api", "F3", CommitType.FEATURE, "Test the best");
        gitHubAccount.makeCommitToRepository("Pokemon Api", "F4", CommitType.FEATURE, "Toast");
        gitHubAccount.makeCommitToRepository("Pokemon Api", "F5", CommitType.FEATURE, "Tesht");
        assertEquals(5, gitHubAccount.countRepositoryCommits("Pokemon Api"));
    }

    @Test
    public void canGetRepositoryWithMostCommits(){
        gitHubAccount.createRepository("Restful Petshop", "ruby project", RepositoryType.PUBLIC);
        gitHubAccount.makeCommitToRepository("Pokemon Api", "F1", CommitType.FEATURE, "Test");
        gitHubAccount.makeCommitToRepository("Pokemon Api", "F2", CommitType.FEATURE, "Testing");
        gitHubAccount.makeCommitToRepository("Pokemon Api", "F3", CommitType.FEATURE, "Test the best");
        gitHubAccount.makeCommitToRepository("Pokemon Api", "F4", CommitType.FEATURE, "Toast");
        gitHubAccount.makeCommitToRepository("Restful Petshop", "d3", CommitType.FEATURE, "wubaduadubdub");
        assertEquals(4, gitHubAccount.getRepositoryWithMostCommitsSize());
    }

    @Test
    public void cantMakeCommitIfNoRepository(){
        gitHubAccount.makeCommitToRepository("Restful Petshop", "d3", CommitType.FEATURE, "wubaduadubdub");
        assertEquals(false, gitHubAccount.repositoryContainsKey("Restful Petshop"));
    }
}
