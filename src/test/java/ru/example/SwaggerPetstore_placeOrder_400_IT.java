package ru.example;

import static com.consol.citrus.actions.EchoAction.Builder.echo;
import static com.consol.citrus.actions.ReceiveMessageAction.Builder.receive;
import static com.consol.citrus.actions.SendMessageAction.Builder.send;
import static com.consol.citrus.http.actions.HttpActionBuilder.http;

import com.consol.citrus.TestCaseRunner;
import com.consol.citrus.annotations.CitrusResource;
import com.consol.citrus.annotations.CitrusTest;
import com.consol.citrus.testng.TestNGCitrusSupport;
import org.springframework.http.HttpStatus;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import ru.lanit.utils.InterceptorHandler;

/**
 * TODO: Description
 *
 * @author Unknown
 * @since 2020-08-13
 */
public class SwaggerPetstore_placeOrder_400_IT extends TestNGCitrusSupport {
    @CitrusTest
    @Test(
            enabled = false
    )
    @Parameters("runner")
    public void swaggerPetstore_placeOrder_400_IT(@CitrusResource @Optional TestCaseRunner runner) {
        runner.run(echo("TODO: Code the test SwaggerPetstore_placeOrder_400_IT"));

        runner.run(http().client("httpClient")
            .send()
            .post(InterceptorHandler.getPath("/v2/store/order"))
            .contentType("application/json")
            .payload("{\"id\": citrus:randomNumber(10),\"petId\": citrus:randomNumber(10),\"quantity\": citrus:randomNumber(10),\"shipDate\": \"citrus:currentDate('yyyy-MM-dd'T'hh:mm:ss')\",\"status\": \"citrus:randomEnumValue('placed','approved','delivered')\",\"complete\": citrus:randomEnumValue('true', 'false')}")
        );

        runner.run(http().client("httpClient")
            .receive()
            .response(HttpStatus.BAD_REQUEST)
        );

    }
}
