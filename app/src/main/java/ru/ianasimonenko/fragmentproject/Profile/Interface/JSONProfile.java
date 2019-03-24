package ru.ianasimonenko.fragmentproject.Profile.Interface;


import ru.ianasimonenko.fragmentproject.Profile.Model.GET.Client;

class JSONProfile {

    private Client[] dataProfileIn;
    public Client[] getRestaurants() {
        return dataProfileIn;
    }
}
