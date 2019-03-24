package ru.naparahandroid.fragmentproject.BasketModel;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Times {

    @SerializedName("9")
    @Expose
    private List<NineTime> NineTime = null;
    @SerializedName("10")
    @Expose
    private List<TenTime> TenTime = null;
    @SerializedName("11")
    @Expose
    private List<ElevenTime> ElevenTime = null;
    @SerializedName("12")
    @Expose
    private List<TwelveTime> TwelveTime = null;
    @SerializedName("13")
    @Expose
    private List<ThirteenTime> ThirteenTime = null;
    @SerializedName("14")
    @Expose
    private List<FourteenTime> FourteenTime = null;
    @SerializedName("15")
    @Expose
    private List<FifteenTime> FifteenTime = null;
    @SerializedName("16")
    @Expose
    private List<SixteenTime> SixteenTime = null;

    public List<NineTime> get9() {
        return NineTime;
    }

    public void set9(List<NineTime> NineTime) {
        this.NineTime = NineTime;
    }

    public List<TenTime> get10() {
        return TenTime;
    }

    public void set10(List<TenTime> TenTime) {
        this.TenTime = TenTime;
    }

    public List<ElevenTime> get11() {
        return ElevenTime;
    }

    public void set11(List<ElevenTime> ElevenTime) {
        this.ElevenTime = ElevenTime;
    }

    public List<TwelveTime> get12() {
        return TwelveTime;
    }

    public void set12(List<TwelveTime> TwelveTime) {
        this.TwelveTime = TwelveTime;
    }

    public List<ThirteenTime> get13() {
        return ThirteenTime;
    }

    public void set13(List<ThirteenTime> ThirteenTime) {
        this.ThirteenTime = ThirteenTime;
    }

    public List<FourteenTime> get14() {
        return FourteenTime;
    }

    public void set14(List<FourteenTime> FourteenTime) {
        this.FourteenTime = FourteenTime;
    }

    public List<FifteenTime> get15() {
        return FifteenTime;
    }

    public void set15(List<FifteenTime> FifteenTime) {
        this.FifteenTime = FifteenTime;
    }

    public List<SixteenTime> get16() {
        return SixteenTime;
    }

    public void set16(List<SixteenTime> SixteenTime) {
        this.SixteenTime = SixteenTime;
    }

}
