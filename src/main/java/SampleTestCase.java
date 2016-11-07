import controllers.UserController;
import models.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.*;

public class SampleTestCase {

    private UserController userController;

    @Before
    public void setUp() {
        userController = new UserController();
    }

    @Test
    public void testUserInfoResponse() {
        User remoteUser = userController.getUserByUsername("maxkolotilkin");

        assertTrue(remoteUser.getHtml_url().contains("https://github.com/maxkolotilkin"));
    }

    @Test
    public void testFollowers() {
        User[] followers = userController.getFollowersByUser("Mak0");
        assertTrue(followers.length == 0);
    }


}
