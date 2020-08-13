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
public class SwaggerPetstore_updatePet_405_IT extends TestNGCitrusSupport {
    @CitrusTest
    @Test(
            enabled = false
    )
    @Parameters("runner")
    public void swaggerPetstore_updatePet_405_IT(@CitrusResource @Optional TestCaseRunner runner) {
        runner.run(echo("TODO: Code the test SwaggerPetstore_updatePet_405_IT"));

        runner.run(http().client("httpClient")
            .send()
            .put(InterceptorHandler.getPath("/v2/pet"))
            .contentType("application/json")
            .payload("{\"id\": citrus:randomNumber(10),\"category\": {\"id\": citrus:randomNumber(10),\"name\": \"citrus:randomString(10)\"},\"name\": \"citrus:randomString(10)\",\"photoUrls\": [\"citrus:randomString(10)\"],\"tags\": [{\"id\": citrus:randomNumber(10),\"name\": \"citrus:randomString(10)\"}],\"status\": \"citrus:randomEnumValue('available','pending','sold')\"}")
        );

        runner.run(http().client("httpClient")
            .receive()
            .response(HttpStatus.METHOD_NOT_ALLOWED)
        );

    }
}
