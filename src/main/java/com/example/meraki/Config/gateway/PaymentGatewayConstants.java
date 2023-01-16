package com.example.meraki.Config.gateway;

public interface PaymentGatewayConstants {
    interface AccountIdentifier {
        String MSISDN = "msisdn";
        String ACCOUNT_NAME = "accountname";

        String ACCOUNT_ID = "accountid";

        String ACCOUNT_CATEGORY = "accountcategory";
        String IDENTITY_ALIAS = "identityalias";
        String ACCOUNT_PASS_KEY = "accountpasskey";
    }

    interface MetaData{
        String NOTIFICATION_TYPE = "notification_type";
    }

    interface PaymentHeaders{
    String X_CONTENT_HASH="X-Content-Hash";
    String X_CORRELATION_ID="X-CorrelationID";
    String X_CALLBACK_URL = "X-Callback-URL";
    }
}
