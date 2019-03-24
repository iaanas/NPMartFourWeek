package ru.naparahandroid.fragmentproject;



class ApiUtils {

    private ApiUtils() { }

    private static final String BASE_URL = "https://naparah.olegb.ru/";

    public static PhoneAuthClient getAPIService() {
        return RetrofitClientTwo.getClient(BASE_URL).create(PhoneAuthClient.class);
    }

    public static ResponseTokenClient getAPIService2() {
        return RetrofitClientTwo.getClient(BASE_URL).create(ResponseTokenClient.class);
    }
}
