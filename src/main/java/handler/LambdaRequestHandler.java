package handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import model.DialogAction;
import model.LexResponse;
import model.Message;

import java.util.Map;

public class LambdaRequestHandler implements RequestHandler<Map<String, Object>, LexResponse> {


    @Override
    public LexResponse handleRequest(Map<String, Object> input, Context context) {

        LambdaLogger logger = context.getLogger();
        String messageText = "Anonymous";
        Map<String, Object> intentMap = (Map<String, Object>) input.get("currentIntent");

        if (intentMap != null) {

            Map<String, Object> slots = (Map<String, Object>) intentMap.get("slots");
            if (slots != null) {

                String firstName = (String) slots.get("firstName");
                String lastName = (String) slots.get("lastName");
                logger.log("***first Name" + firstName);
                logger.log("*** Last Name" + lastName);
                messageText = "Winter is coming" +" "+ firstName+" "+lastName+ "!!";

            }


        }
        Message message = new Message(Message.ContentType.PlainText, messageText);
        DialogAction dialogAction = new DialogAction(DialogAction.Type.Close, DialogAction.FulfillmentState.Fulfilled, message);
        return new LexResponse(dialogAction);

    }


}
