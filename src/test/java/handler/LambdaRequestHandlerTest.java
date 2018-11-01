package handler;

import com.amazonaws.services.lambda.runtime.Context;
import model.LexResponse;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class LambdaRequestHandlerTest {


    @Test
    public void testHelloLambda() {
        LambdaRequestHandler handler = new LambdaRequestHandler();
        Context context = createContext() ;
        String firstName = "Ned";
        String lastName ="Stark";
        Map<String,Object> input = new HashMap<>();
        Map<String,Object> currentIntent = new HashMap<>();
        Map<String,Object> slots = new HashMap<>();
        slots.put("firstName",firstName);
        slots.put("lastName",lastName);
        currentIntent.put("slots",slots);
        input.put("currentIntent",currentIntent);

        LexResponse response =handler.handleRequest(input,context );

        assertEquals(response.getDialogAction().getMessage().getContent(),"Winter is coming"+" "+firstName+" "+lastName+"!!");
    }

    private Context createContext() {

        TestContext testContext = new TestContext();
        testContext.setFunctionName("HELLO");
        return  testContext;
    }

}