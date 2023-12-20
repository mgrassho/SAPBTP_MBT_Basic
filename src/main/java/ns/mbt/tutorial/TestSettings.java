package ns.mbt.tutorial;

public abstract class TestSettings {
    private static final boolean INTERNAL_TEST_MODE = false;

    private static final boolean EXTERNAL_TEST_MODE = Boolean.getBoolean("test.mode") // Check Java system property.
        || com.sap.cloud.server.odata.core.SystemEnvironment.getBoolean("XS_TEST_MODE"); // Check system environment variable.

    public static final boolean TEST_MODE = INTERNAL_TEST_MODE | EXTERNAL_TEST_MODE;
}
