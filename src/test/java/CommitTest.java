import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CommitTest {

    private Commit commit;


    @Before
    public void before(){
        commit = new Commit("A1", CommitType.FEATURE, "initial commit");
    }

    @Test
    public void canGetUniqueId(){
        assertEquals("A1", commit.getUniqueId());
    }

    @Test
    public void canGetCommitType(){
        assertEquals(CommitType.FEATURE, commit.getCommitType());
    }

    @Test
    public void canGetDescription(){
        assertEquals("initial commit", commit.getDescription());
    }

}
