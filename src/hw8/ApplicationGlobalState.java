package hw8;

public final class ApplicationGlobalState {
    private static ApplicationGlobalState INSTANCE;
    private String selectedCity = null;
    private final String API_KEY = "p9q4jzOsKMEHGV8sAUAzTikFv2tuyDY6";
    private final String DB_FILENAME = "weather.db";

    private ApplicationGlobalState() {
    }

    // Непотокобезопасный код для упрощения
    public static ApplicationGlobalState getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ApplicationGlobalState();
        }

        return INSTANCE;
    }

    public String getDbFileName() {
        return DB_FILENAME;
    }

    public String getSelectedCity() {
        return selectedCity;
    }

    public void setSelectedCity(String selectedCity) {
        this.selectedCity = selectedCity;
    }

    public String getApiKey() {
        return this.API_KEY;
    }
}
