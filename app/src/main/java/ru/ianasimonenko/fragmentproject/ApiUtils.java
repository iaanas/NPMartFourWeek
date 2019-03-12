package ru.ianasimonenko.fragmentproject;



public class ApiUtils {

    private ApiUtils() { }

    public static final String BASE_URL = "https://naparah.olegb.ru/";

    public static PhoneAuthClient getAPIService() {
        return RetrofitClient2.getClient(BASE_URL).create(PhoneAuthClient.class);
    }

    public static ResponseTokenClient getAPIService2() {
        return RetrofitClient2.getClient(BASE_URL).create(ResponseTokenClient.class);
    }
}
