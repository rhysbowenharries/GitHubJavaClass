import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RepositoryTest {

    private Repository repository;


    @Before
    public void before(){
        repository = new Repository("Jurassic Park", "Javascript website", RepositoryType.PRIVATE);
        repository.makeCommit("B2", CommitType.BUGFIX, "Typo");
    }

    @Test
    public void canGetName(){
        assertEquals("Jurassic Park", repository.getName());
    }

    @Test
    public void canGetDescription(){
        assertEquals("Javascript website", repository.getDescription());
    }

    @Test
    public void canGetRepositoryType(){
        assertEquals(RepositoryType.PRIVATE, repository.getRepositoryType());
    }
//    @Test
//    public void isArrayEmpty(){
//        assertEquals(, repository.commitsCount());
//    }

    @Test
    public void canMakeCommit(){
        assertEquals(1, repository.commitsCount());
    }

    @Test
    public void canGetCommitsByID(){
        assertEquals(repository.commitByIndex(0), repository.getCommitById("B2"));
    }

    @Test
    public void canGetCommitsByIDTwoInArray(){
        repository.makeCommit("C3", CommitType.OTHER, "note to dev");
        assertEquals(repository.commitByIndex(1), repository.getCommitById("C3"));
    }

    @Test
    public void canGetCommitByType(){
        assertEquals(repository.commitByIndex(0), repository.getCommitByType(CommitType.BUGFIX));
    }

    @Test
    public void canGetCommitByTypeTowTypes(){
        repository.makeCommit("C3", CommitType.OTHER, "note to dev");
        assertEquals(repository.commitByIndex(1), repository.getCommitByType(CommitType.OTHER));
    }

    @Test
    public void canRollBack() {
        repository.makeCommit("C3", CommitType.OTHER, "note to dev");
        repository.makeCommit("C5", CommitType.BUGFIX, "no more bugz");
        repository.rollBack("C3");
        assertEquals(2, repository.commitsCount());
    }

    @Test
    public void canRollBackWithMore(){
        repository.makeCommit("C3", CommitType.OTHER, "note to dev");
        repository.makeCommit("C5", CommitType.BUGFIX, "no more bugz");
        repository.makeCommit("C7", CommitType.OTHER, "note to dev");
        repository.makeCommit("C4", CommitType.BUGFIX, "no more bugz");
        repository.rollBack("C7");
        assertEquals(4, repository.commitsCount());
    }


    @Test
    public void canGetCommitIndexByUniqueId(){
        repository.makeCommit("C3", CommitType.OTHER, "note to dev");
        repository.makeCommit("C5", CommitType.BUGFIX, "no more bugz");
        assertEquals(1, repository.getCommitIndexByUniqueId("C3"));
    }

}

