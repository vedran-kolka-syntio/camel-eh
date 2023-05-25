package kolka.camel.eventhubs;

import com.azure.core.credential.AccessToken;
import com.azure.core.credential.TokenCredential;
import com.azure.core.credential.TokenRequestContext;
import com.azure.identity.DefaultAzureCredentialBuilder;
import reactor.core.publisher.Mono;

public class SimpleCredential implements TokenCredential {

    private TokenCredential credential;

    public SimpleCredential() {
        this.credential = new DefaultAzureCredentialBuilder().build();
    }

    @Override
    public Mono<AccessToken> getToken(TokenRequestContext tokenRequestContext) {
        return this.credential.getToken(tokenRequestContext);
    }
}
