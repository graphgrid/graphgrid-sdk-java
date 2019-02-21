package com.graphgrid.sdk;

import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles( "test" )
@RunWith( SpringRunner.class )
@SpringBootTest( classes = App.class, properties = "server.port:0" )
@Rollback( false )
public abstract class TestBase
{

    @Rule
    public final ExpectedException thrown = ExpectedException.none();

}
